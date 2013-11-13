package com.github.mateuszwenus.lf_org_chart.children_loaders;

import java.util.List;

import javax.portlet.PortletRequest;

import com.github.mateuszwenus.lf_org_chart.Node;
import com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCallback;
import com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCustomActionLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Dialect;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class RootsLoader {

	public List<Node> loadTreeRoots(PortletRequest req) throws SystemException {
		List<Group> communities = GroupLocalServiceUtil.search(PortalUtil.getCompanyId(req), null, null, null, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		List<Organization> list = findTopLevelOrganizations();
		return NodeListBuilder.newInstance().addGroups(communities).addOrganizations(list).build();
	}

	@SuppressWarnings("unchecked")
	private List<Organization> findTopLevelOrganizations() throws SystemException {
		return (List<Organization>) SessionCustomActionLocalServiceUtil.execute(new SessionCallback() {
			public Object execute(Session session, Dialect dialect) throws Exception {
				String sql = "SELECT {org.*} FROM Organization_ org WHERE org.parentOrganizationId = 0 "
						+ "and org.organizationId not in (select gr_org.organizationId from Groups_Orgs gr_org)";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("org", PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portal.model.impl.OrganizationImpl"));
				return QueryUtil.list(query, dialect, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}
		});
	}
}
