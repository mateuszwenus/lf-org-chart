package com.github.mateuszwenus.lf_org_chart.children_loaders;

import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

class TeamChildrenLoader implements SingleNodeChildrenLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.TEAM;
	}

	public List<Node> loadChildren(Long nodeId, PortletRequest req) throws PortalException, SystemException {
		List<User> users = findUsersInTeam(nodeId, req);
		return NodeListBuilder.newInstance().addUsers(users).build();
	}

	private List<User> findUsersInTeam(Long nodeId, PortletRequest req) throws SystemException {
		LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();
		userParams.put("usersTeams", nodeId);
		List<User> users = UserLocalServiceUtil.search(PortalUtil.getCompanyId(req), null, Boolean.TRUE, userParams, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, (OrderByComparator) null);
		return users;
	}
}
