package com.github.mateuszwenus.lf_org_chart.loaders;

import java.util.ArrayList;
import java.util.List;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.google.common.collect.Lists;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Team;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;

class NodeListBuilder {

	private List<Node> nodes = new ArrayList<Node>();
	
	private NodeListBuilder() {
	}
	
	public static NodeListBuilder newInstance() {
		return new NodeListBuilder();
	}
	
	public List<Node> build() {
		return nodes;
	}
	
	public NodeListBuilder addGroups(List<Group> groups) {
		nodes.addAll(Lists.transform(groups, Transformations.GROUP_TO_NODE));
		return this;
	}
	
	public NodeListBuilder addOrganizations(List<Organization> organizations) {
		nodes.addAll(Lists.transform(organizations, Transformations.ORGANISATION_TO_NODE));
		return this;
	}
	
	public NodeListBuilder addUserGroups(List<UserGroup> userGroups) {
		nodes.addAll(Lists.transform(userGroups, Transformations.USER_GROUP_TO_NODE));
		return this;
	}
	
	public NodeListBuilder addTeams(List<Team> teams) {
		nodes.addAll(Lists.transform(teams, Transformations.TEAM_TO_NODE));
		return this;
	}
	
	public NodeListBuilder addUsers(List<User> users) {
		nodes.addAll(Lists.transform(users, Transformations.USER_TO_NODE));
		return this;
	}
}
