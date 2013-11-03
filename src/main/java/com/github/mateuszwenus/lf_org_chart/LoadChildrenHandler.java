package com.github.mateuszwenus.lf_org_chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.github.mateuszwenus.lf_org_chart.loaders.ChildrenLoader;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class LoadChildrenHandler {

	private final Gson gson = new Gson();
	private final ChildrenLoader childrenLoader = new ChildrenLoader();
	private ParamsSupport paramsSupport = new ParamsSupport();
	
	public void handle(ResourceRequest req, ResourceResponse resp) throws IOException {
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Long nodeId = paramsSupport.getNodeId(req);
		NodeType nodeType = paramsSupport.getNodeType(req);
		if (validateParams(nodeId, nodeType)) {
			List<Node> nodes = childrenLoader.loadChildren(nodeType, nodeId, req);
			sendResponse(nodes, out);
		} else {
			sendResponse(Collections.<Node> emptyList(), out);
		}
		out.flush();
	}
	
	private boolean validateParams(Long nodeId, NodeType nodeType) {
		return nodeType != null && (nodeId != null || !nodeType.isIdRequired());
	}
	
	@SuppressWarnings("serial")
	private <T> void sendResponse(List<T> nodes, PrintWriter out) {
		Type typeOfSrc = new TypeToken<List<T>>() {
		}.getType();
		String json = gson.toJson(nodes, typeOfSrc);
		out.write(json);
	}
}
