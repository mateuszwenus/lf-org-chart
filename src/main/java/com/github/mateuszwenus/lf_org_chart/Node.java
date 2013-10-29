package com.github.mateuszwenus.lf_org_chart;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class Node {

	private String data;
	private String state;
	private Map<String, String> attr;

	private Node(String data, String state, Map<String, String> attr) {
		this.data = data;
		this.state = state;
		this.attr = attr;
	}

	public static Node create(String name, NodeType type, Object dataId) {
		return new Node(name, "closed", ImmutableMap.of("rel", type.toString(), "data-id", String.valueOf(dataId)));
	}

	public String getData() {
		return data;
	}
	
	public String getState() {
		return state;
	}

	public Map<String, String> getAttr() {
		return attr;
	}

	public String toString() {
		return "Node [data=" + data + ", state=" + state + ", attr=" + attr + "]";
	}
}
