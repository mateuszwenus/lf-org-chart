package com.github.mateuszwenus.lf_org_chart;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.github.mateuszwenus.lf_org_chart.details_loaders.DetailsLoader;
import com.liferay.portal.util.PortalUtil;

public class LoadNodeDetailsHandler {

	private static final EnumSet<NodeType> NODES_WITH_DETAILS = EnumSet.of(NodeType.COMMUNITY, NodeType.ORGANISATION, NodeType.USER_GROUP,
			NodeType.TEAM, NodeType.USER);
	private DetailsLoader detailsLoader = new DetailsLoader();
	private ParamsSupport paramsSupport = new ParamsSupport();
	
	public void handle(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {
		Long id = paramsSupport.getNodeId(req);
		NodeType type = paramsSupport.getNodeType(req);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(req));
		if (validateParams(id, type)) {
			addNodeDetailsAsAttributes(id, type, httpRequest);
		}
		RequestDispatcher rd = getRequestDispatcher(httpRequest, type);
		try {
			rd.forward(httpRequest, PortalUtil.getHttpServletResponse(resp));
		} catch (ServletException e) {
			throw new PortletException(e);
		}
	}

	private boolean validateParams(Long id, NodeType type) {
		return id != null && type != null;
	}

	private void addNodeDetailsAsAttributes(long id, NodeType type, HttpServletRequest httpRequest) {
		Map<String, Object> attrMap = detailsLoader.loadDetails(id, type);
		for (Map.Entry<String, Object> e : attrMap.entrySet()) {
			httpRequest.setAttribute(e.getKey(), e.getValue());
		}
	}

	private RequestDispatcher getRequestDispatcher(HttpServletRequest httpRequest, NodeType type) {
		String path;
		if (NODES_WITH_DETAILS.contains(type)) {
			path = "/WEB-INF/view/node-details/" + type.toString().toLowerCase() + ".jsp";
		} else {
			path = "/WEB-INF/view/node-details/empty.jsp";
		}
		return httpRequest.getRequestDispatcher(path);
	}
}
