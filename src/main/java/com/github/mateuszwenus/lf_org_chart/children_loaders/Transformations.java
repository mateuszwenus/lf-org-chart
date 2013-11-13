package com.github.mateuszwenus.lf_org_chart.children_loaders;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.NodeType;
import com.google.common.base.Function;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Team;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;

interface Transformations {

	Function<Group, Node> GROUP_TO_NODE = new Function<Group, Node>() {
		public Node apply(Group input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getPrimaryKey(), input.getName(), NodeType.COMMUNITY);
		}
	};

	Function<Organization, Node> ORGANIZATION_TO_NODE = new Function<Organization, Node>() {
		public Node apply(Organization input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getPrimaryKey(), input.getName(), NodeType.ORGANIZATION);
		}
	};

	Function<UserGroup, Node> USER_GROUP_TO_NODE = new Function<UserGroup, Node>() {
		public Node apply(UserGroup input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getPrimaryKey(), input.getName(), NodeType.USER_GROUP);
		}
	};

	Function<Team, Node> TEAM_TO_NODE = new Function<Team, Node>() {
		public Node apply(Team input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getPrimaryKey(), input.getName(), NodeType.TEAM);
		}
	};

	Function<User, Node> USER_TO_NODE = new Function<User, Node>() {
		public Node apply(User input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getPrimaryKey(), input.getFullName(), NodeType.USER);
		}
	};
}
