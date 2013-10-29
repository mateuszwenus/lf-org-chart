package com.github.mateuszwenus.lf_org_chart;

public enum NodeType {

	ROOT_COMMUNITIES(false), COMMUNITY(true), ORGANISATION(true), USER_GROUP(true), TEAM(true), USER(true);
	
	private final boolean idRequired;

	private NodeType(boolean idRequired) {
		this.idRequired = idRequired;
	}

	public boolean isIdRequired() {
		return idRequired;
	}
}
