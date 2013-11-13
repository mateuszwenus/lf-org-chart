package com.github.mateuszwenus.lf_org_chart.children_loaders;

import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.TeamLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

class CommunityChildrenLoader implements SingleNodeChildrenLoader{

	public NodeType getSupportedNodeType() {
		return NodeType.COMMUNITY;
	}

	public List<Node> loadChildren(Long nodeId, PortletRequest req) throws PortalException, SystemException {
		return NodeListBuilder.newInstance()
			.addOrganizations(OrganizationLocalServiceUtil.getGroupOrganizations(nodeId))
			.addUserGroups(findUserGroupsInCommunity(nodeId, req))
			.addTeams(TeamLocalServiceUtil.getGroupTeams(nodeId))
			.addUsers(UserLocalServiceUtil.getGroupUsers(nodeId))
			.build();
	}

	private List<UserGroup> findUserGroupsInCommunity(Long nodeId, PortletRequest req) throws SystemException {
		LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("userGroupsGroups", nodeId);
		List<UserGroup> userGroups = UserGroupLocalServiceUtil.search(PortalUtil.getCompanyId(req), null, null, params, -1, -1, null);
		return userGroups;
	}
}
