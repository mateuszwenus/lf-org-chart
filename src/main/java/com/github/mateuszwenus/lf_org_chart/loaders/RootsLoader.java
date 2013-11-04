package com.github.mateuszwenus.lf_org_chart.loaders;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class RootsLoader {

	public List<Node> loadTreeRoots(PortletRequest req) throws SystemException {
		List<Group> communities = GroupLocalServiceUtil.search(PortalUtil.getCompanyId(req), null, null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Organization> list = findTopLevelOrganizations(communities);
		return NodeListBuilder.newInstance().addGroups(communities).addOrganizations(list).build();
	}

	@SuppressWarnings("unchecked")
	private List<Organization> findTopLevelOrganizations(List<Group> communities) throws SystemException {
		// TODO load using one query
		Collection<Object> ids = new HashSet<Object>();
		for (Group community : communities) {
			List<Organization> communityOrganizations = OrganizationLocalServiceUtil.getGroupOrganizations(community.getPrimaryKey());
			for (Organization org : communityOrganizations) {
				ids.add(org.getPrimaryKey());
			}
		}
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Organization.class, PortalClassLoaderUtil.getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("parentOrganizationId", Long.valueOf(OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID)));
		query.add(RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.in("id", ids)));
		return OrganizationLocalServiceUtil.dynamicQuery(query);
	}
}
