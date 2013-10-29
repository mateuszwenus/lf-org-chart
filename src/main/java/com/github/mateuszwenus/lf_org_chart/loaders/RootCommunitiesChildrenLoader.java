package com.github.mateuszwenus.lf_org_chart.loaders;

import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

class RootCommunitiesChildrenLoader implements SingleNodeChildrenLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.ROOT_COMMUNITIES;
	}
	
	public List<Node> loadChildren(Long nodeId, PortletRequest req) throws SystemException {
		List<Group> groups = GroupLocalServiceUtil.search(PortalUtil.getCompanyId(req), null, null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return NodeListBuilder.newInstance().addGroups(groups).build();
	}
}
