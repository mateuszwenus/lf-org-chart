package com.github.mateuszwenus.lf_org_chart.details_loaders;

import java.util.Collections;
import java.util.Map;

import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

class OrganizationDetailsLoader implements SingleNodeDetailsLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.ORGANIZATION;
	}

	public Map<String, ?> loadDetails(long nodeId) throws PortalException, SystemException {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(nodeId);
		return Collections.singletonMap("organization", organization);
	}
}
