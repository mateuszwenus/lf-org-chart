package com.github.mateuszwenus.lf_org_chart.details_loaders;

import java.util.Collections;
import java.util.Map;

import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.UserGroupLocalServiceUtil;

class UserGroupDetailsLoader implements SingleNodeDetailsLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.USER_GROUP;
	}

	public Map<String, ?> loadDetails(long nodeId) throws PortalException, SystemException {
		UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(nodeId);
		return Collections.singletonMap("userGroup", userGroup);
	}
}
