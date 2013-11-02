package com.github.mateuszwenus.lf_org_chart.details_loaders;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.google.common.base.Preconditions;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class DetailsLoader {

	private EnumMap<NodeType, SingleNodeDetailsLoader> loaders = new EnumMap<NodeType, SingleNodeDetailsLoader>(NodeType.class);

	public DetailsLoader() {
		for (SingleNodeDetailsLoader loader : Arrays.asList(new UserDetailsLoader())) {
			loaders.put(loader.getSupportedNodeType(), loader);
		}
	}

	public Map<String, Object> loadDetails(long nodeId, NodeType nodeType) {
		try {
			Preconditions.checkNotNull(nodeType);
			SingleNodeDetailsLoader loader = loaders.get(nodeType);
			return loader != null ? loader.loadDetails(nodeId) : Collections.<String, Object> emptyMap();
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
