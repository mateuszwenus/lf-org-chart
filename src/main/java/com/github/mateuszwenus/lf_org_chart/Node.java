package com.github.mateuszwenus.lf_org_chart;

public class Node {

	private long pk;
	private String name;
	private NodeType type;

	public Node(long pk, String name, NodeType type) {
		super();
		this.pk = pk;
		this.name = name;
		this.type = type;
	}

	public static Node create(long pk, String name, NodeType type) {
		return new Node(pk, name, type);
	}

	public long getPk() {
		return pk;
	}

	public String getName() {
		return name;
	}

	public NodeType getType() {
		return type;
	}
}
