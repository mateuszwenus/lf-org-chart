package com.github.mateuszwenus.lf_org_chart.details_loaders;

import java.util.Collections;
import java.util.Map;

import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Team;
import com.liferay.portal.service.TeamLocalServiceUtil;

class TeamDetailsLoader implements SingleNodeDetailsLoader {

	public NodeType getSupportedNodeType() {
		return NodeType.TEAM;
	}

	public Map<String, ?> loadDetails(long nodeId) throws PortalException, SystemException {
		Team team = TeamLocalServiceUtil.getTeam(nodeId);
		return Collections.singletonMap("team", team);
	}
}
