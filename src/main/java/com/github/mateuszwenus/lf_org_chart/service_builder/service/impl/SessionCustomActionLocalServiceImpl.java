package com.github.mateuszwenus.lf_org_chart.service_builder.service.impl;

import com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCallback;
import com.github.mateuszwenus.lf_org_chart.service_builder.service.base.SessionCustomActionLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;

/**
 * The implementation of the session custom action local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCustomActionLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCustomActionLocalServiceUtil}
 * to access the session custom action local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Mateusz Wenus
 * @see com.github.mateuszwenus.lf_org_chart.service_builder.service.base.SessionCustomActionLocalServiceBaseImpl
 * @see com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCustomActionLocalServiceUtil
 */
public class SessionCustomActionLocalServiceImpl extends SessionCustomActionLocalServiceBaseImpl {

	public Object execute(SessionCallback callback) {
		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return callback.execute(session, sessionFactory.getDialect());
		} catch (Exception e) {
			throw handleException(e);
		} finally {
			sessionFactory.closeSession(session);
		}
	}

	private RuntimeException handleException(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			throw new IllegalStateException(e);
		}
	}
}
