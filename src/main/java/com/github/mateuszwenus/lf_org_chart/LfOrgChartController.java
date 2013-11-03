package com.github.mateuszwenus.lf_org_chart;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class LfOrgChartController extends MVCPortlet {

	private LoadRootsHandler loadRootsHandler = new LoadRootsHandler();
	private LoadChildrenHandler loadChildrenHandler = new LoadChildrenHandler();
	private LoadNodeDetailsHandler loadNodeDetailsHandler = new LoadNodeDetailsHandler();

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		String resourceId = httpRequest.getParameter("p_p_resource_id");
		if ("loadRoots".equals(resourceId)) {
			loadRootsHandler.handle(resourceRequest, resourceResponse);
		} else if ("loadChildren".equals(resourceId)) {
			loadChildrenHandler.handle(resourceRequest, resourceResponse);
		} else if ("nodeDetails".equals(resourceId)) {
			loadNodeDetailsHandler.handle(resourceRequest, resourceResponse);
		}
	}
}
