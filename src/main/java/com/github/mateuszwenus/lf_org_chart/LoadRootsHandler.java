package com.github.mateuszwenus.lf_org_chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.github.mateuszwenus.lf_org_chart.loaders.RootsLoader;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.SystemException;

public class LoadRootsHandler {

	private final Gson gson = new Gson();
	private RootsLoader rootsLoader = new RootsLoader();

	public void handle(ResourceRequest req, ResourceResponse resp) throws IOException {
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			List<Node> nodes = rootsLoader.loadTreeRoots(req);
			sendResponse(nodes, out);
			out.flush();
		} catch (SystemException e) {
			throw new IllegalStateException(e);
		}
	}

	@SuppressWarnings("serial")
	private <T> void sendResponse(List<T> nodes, PrintWriter out) {
		Type typeOfSrc = new TypeToken<List<T>>() {
		}.getType();
		String json = gson.toJson(nodes, typeOfSrc);
		out.write(json);
	}
}
