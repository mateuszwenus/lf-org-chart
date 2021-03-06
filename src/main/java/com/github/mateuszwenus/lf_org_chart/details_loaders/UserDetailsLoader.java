package com.github.mateuszwenus.lf_org_chart.details_loaders;

import java.util.Collections;
import java.util.Map;

import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

class UserDetailsLoader implements SingleNodeDetailsLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.USER;
	}

	public Map<String, ?> loadDetails(long nodeId) throws PortalException, SystemException {
		User user = UserLocalServiceUtil.getUser(nodeId);
		return Collections.singletonMap("user", user);
	}
}
