package com.github.mateuszwenus.lf_org_chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.github.mateuszwenus.lf_org_chart.loaders.ChildrenLoader;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class LfOrgChartController extends MVCPortlet {

	private final Log log = LogFactoryUtil.getLog(getClass());

	private final Gson gson = new Gson();
	private final ChildrenLoader childrenLoader = new ChildrenLoader();

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		resourceResponse.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resourceResponse.getWriter();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		String resourceId = httpRequest.getParameter("p_p_resource_id");
		if ("loadChildren".equals(resourceId)) {
			loadChildren(resourceRequest, httpRequest, out);
		}
		out.flush();
	}

	private void loadChildren(PortletRequest request, HttpServletRequest httpRequest, PrintWriter out) {
		String typeStr = httpRequest.getParameter("type");
		NodeType nodeType = NodeType.valueOf(typeStr);
		List<Node> nodes = childrenLoader.loadChildren(nodeType, getNodeId(httpRequest), request);
		log.info("nodes = " + nodes);
		sendResponse(nodes, out);
	}

	private Long getNodeId(HttpServletRequest httpRequest) {
		String id = httpRequest.getParameter("id");
		Long result = null;
		if (id != null) {
			try {
				result = Long.parseLong(id);
			} catch (NumberFormatException ignored) {
			}
		}
		return result;
	}

	private void sendResponse(List<Node> nodes, PrintWriter out) {
		Type typeOfSrc = new TypeToken<List<Node>>() {
		}.getType();
		String json = gson.toJson(nodes, typeOfSrc);
		out.write(json);
	}
}
