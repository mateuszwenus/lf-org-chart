package com.github.mateuszwenus.lf_org_chart.loaders;

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
			return Node.create(input.getName(), NodeType.COMMUNITY, input.getPrimaryKey());
		}
	};

	Function<Organization, Node> ORGANISATION_TO_NODE = new Function<Organization, Node>() {
		public Node apply(Organization input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getName(), NodeType.ORGANISATION, input.getPrimaryKey());
		}
	};

	Function<UserGroup, Node> USER_GROUP_TO_NODE = new Function<UserGroup, Node>() {
		public Node apply(UserGroup input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getName(), NodeType.USER_GROUP, input.getPrimaryKey());
		}
	};

	Function<Team, Node> TEAM_TO_NODE = new Function<Team, Node>() {
		public Node apply(Team input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getName(), NodeType.TEAM, input.getPrimaryKey());
		}
	};

	Function<User, Node> USER_TO_NODE = new Function<User, Node>() {
		public Node apply(User input) {
			if (input == null) {
				return null;
			}
			return Node.create(input.getFullName(), NodeType.USER, input.getPrimaryKey());
		}
	};
}
