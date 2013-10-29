package com.github.mateuszwenus.lf_org_chart.loaders;

import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

interface SingleNodeChildrenLoader {

	NodeType getSupportedNodeType();
	List<Node> loadChildren(Long nodeId, PortletRequest req) throws PortalException, SystemException;
}
