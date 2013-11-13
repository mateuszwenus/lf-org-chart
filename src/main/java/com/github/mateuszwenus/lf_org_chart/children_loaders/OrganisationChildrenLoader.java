package com.github.mateuszwenus.lf_org_chart.children_loaders;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.TeamLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

class OrganisationChildrenLoader implements SingleNodeChildrenLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.ORGANISATION;
	}

	public List<Node> loadChildren(Long nodeId, PortletRequest req) throws PortalException, SystemException {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(nodeId);
		return NodeListBuilder.newInstance()
			.addOrganizations(OrganizationLocalServiceUtil.getSuborganizations(Collections.singletonList(organization)))
			.addTeams(TeamLocalServiceUtil.getGroupTeams(organization.getGroup().getPrimaryKey()))
			.addUsers(UserLocalServiceUtil.getOrganizationUsers(nodeId))
			.build();
	}
}
