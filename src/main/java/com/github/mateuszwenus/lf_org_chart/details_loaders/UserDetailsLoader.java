package com.github.mateuszwenus.lf_org_chart.details_loaders;

import java.util.Collections;
import java.util.Map;

import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

class UserDetailsLoader implements SingleNodeDetailsLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.USER;
	}

	public Map<String, Object> loadDetails(long nodeId) throws PortalException, SystemException {
		return Collections.emptyMap();
	}
}
