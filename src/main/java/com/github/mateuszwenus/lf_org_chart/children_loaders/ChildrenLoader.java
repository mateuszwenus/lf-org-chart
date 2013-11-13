package com.github.mateuszwenus.lf_org_chart.children_loaders;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.google.common.base.Preconditions;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class ChildrenLoader {

	private EnumMap<NodeType, SingleNodeChildrenLoader> loaders = new EnumMap<NodeType, SingleNodeChildrenLoader>(NodeType.class);

	public ChildrenLoader() {
		for (SingleNodeChildrenLoader loader : Arrays.asList(new CommunityChildrenLoader(), new OrganisationChildrenLoader(),
				new TeamChildrenLoader(), new UserGroupChildrenLoader())) {
			loaders.put(loader.getSupportedNodeType(), loader);
		}
	}

	public List<Node> loadChildren(NodeType nodeType, Long nodeId, PortletRequest req) {
		try {
			Preconditions.checkNotNull(nodeType);
			Preconditions.checkNotNull(nodeId);
			SingleNodeChildrenLoader loader = loaders.get(nodeType);
			return loader != null ? loader.loadChildren(nodeId, req) : Collections.<Node> emptyList();
		} catch (PortalException e) {
			throw handleException(nodeType, e);
		} catch (SystemException e) {
			throw handleException(nodeType, e);
		}
	}

	private RuntimeException handleException(NodeType nodeType, Exception e) {
		return new IllegalStateException("failed to get children of " + nodeType, e);
	}
}
