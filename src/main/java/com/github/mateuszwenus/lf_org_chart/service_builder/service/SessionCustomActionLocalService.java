package com.github.mateuszwenus.lf_org_chart.service_builder.service;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the session custom action local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link SessionCustomActionLocalServiceUtil} to access the session custom action local service. Add custom service methods to {@link com.github.mateuszwenus.lf_org_chart.service_builder.service.impl.SessionCustomActionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mateusz Wenus
 * @see SessionCustomActionLocalServiceUtil
 * @see com.github.mateuszwenus.lf_org_chart.service_builder.service.base.SessionCustomActionLocalServiceBaseImpl
 * @see com.github.mateuszwenus.lf_org_chart.service_builder.service.impl.SessionCustomActionLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface SessionCustomActionLocalService {
    public java.lang.Object execute(
        com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCallback callback);
}
