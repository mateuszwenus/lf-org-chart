package com.github.mateuszwenus.lf_org_chart.service_builder.service;

import com.liferay.portal.kernel.dao.orm.Dialect;
import com.liferay.portal.kernel.dao.orm.Session;

public interface SessionCallback {

	Object execute(Session session, Dialect dialect) throws Exception;
}
