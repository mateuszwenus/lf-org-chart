package com.github.mateuszwenus.lf_org_chart.children_loaders;

import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

class UserGroupChildrenLoader implements SingleNodeChildrenLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.USER_GROUP;
	}

	public List<Node> loadChildren(Long nodeId, PortletRequest req) throws PortalException, SystemException {
		List<User> users = UserLocalServiceUtil.getUserGroupUsers(nodeId);
		return NodeListBuilder.newInstance().addUsers(users).build();
	}
}
