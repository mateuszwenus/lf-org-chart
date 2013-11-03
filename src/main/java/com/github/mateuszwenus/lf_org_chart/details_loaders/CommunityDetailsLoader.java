package com.github.mateuszwenus.lf_org_chart.details_loaders;

import java.util.Collections;
import java.util.Map;

import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;

class CommunityDetailsLoader implements SingleNodeDetailsLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.COMMUNITY;
	}

	public Map<String, ?> loadDetails(long nodeId) throws PortalException, SystemException {
		Group community = GroupLocalServiceUtil.getGroup(nodeId);
		return Collections.singletonMap("community", community);
	}
}
