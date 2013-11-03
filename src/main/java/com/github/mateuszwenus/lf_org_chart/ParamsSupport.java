package com.github.mateuszwenus.lf_org_chart;

import javax.portlet.ResourceRequest;

public class ParamsSupport {

	public Long getNodeId(ResourceRequest req) {
		String id = req.getParameter("id");
		Long result = null;
		if (id != null) {
			try {
				result = Long.parseLong(id);
			} catch (NumberFormatException ignored) {
			}
		}
		return result;
	}

	public NodeType getNodeType(ResourceRequest req) {
		return NodeType.forString(req.getParameter("type"));
	}
}
