package com.github.mateuszwenus.lf_org_chart;

public class AuiNode {

	private String id;
	private String label;
	private boolean expanded;
	private String type;
	private String io;

	public AuiNode(String basicURL, String parentId, Node node) {
		this.id = parentId + "-" + node.getPk();
		this.label = node.getName();
		this.expanded = false;
		this.type = "io";
		this.io = basicURL + "&uid=" + id + "&id=" + node.getPk() + "&type=" + node.getType().toString();
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public String getType() {
		return type;
	}

	public String getIo() {
		return io;
	}
}
