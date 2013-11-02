package com.github.mateuszwenus.lf_org_chart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class LoadNodeDetailsHandler {

	public void handle(ResourceRequest req, ResourceResponse resp) throws IOException {
		resp.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("id = " + req.getParameter("id") + ", type = " + req.getParameter("type"));
		out.flush();
	}
}
