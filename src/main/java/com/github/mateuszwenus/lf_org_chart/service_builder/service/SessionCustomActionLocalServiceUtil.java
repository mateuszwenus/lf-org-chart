package com.github.mateuszwenus.lf_org_chart.service_builder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the session custom action local service. This utility wraps {@link com.github.mateuszwenus.lf_org_chart.service_builder.service.impl.SessionCustomActionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.github.mateuszwenus.lf_org_chart.service_builder.service.impl.SessionCustomActionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mateusz Wenus
 * @see SessionCustomActionLocalService
 * @see com.github.mateuszwenus.lf_org_chart.service_builder.service.base.SessionCustomActionLocalServiceBaseImpl
 * @see com.github.mateuszwenus.lf_org_chart.service_builder.service.impl.SessionCustomActionLocalServiceImpl
 * @generated
 */
public class SessionCustomActionLocalServiceUtil {
    private static SessionCustomActionLocalService _service;

    public static java.lang.Object execute(
        com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCallback callback) {
        return getService().execute(callback);
    }

    public static void clearService() {
        _service = null;
    }

    public static SessionCustomActionLocalService getService() {
        if (_service == null) {
            Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    SessionCustomActionLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
                    portletClassLoader);

            _service = new SessionCustomActionLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);
        }

        return _service;
    }

    public void setService(SessionCustomActionLocalService service) {
        _service = service;
    }
}
