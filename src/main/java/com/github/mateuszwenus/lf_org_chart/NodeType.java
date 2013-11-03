package com.github.mateuszwenus.lf_org_chart;

public enum NodeType {

	COMMUNITY, ORGANISATION, USER_GROUP, TEAM, USER;

	public static NodeType forString(String str) {
		for (NodeType type : values()) {
			if (type.toString().equals(str)) {
				return type;
			}
		}
		return null;
	}
}
