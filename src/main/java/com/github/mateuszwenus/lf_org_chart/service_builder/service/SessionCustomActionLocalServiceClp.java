package com.github.mateuszwenus.lf_org_chart.service_builder.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;


public class SessionCustomActionLocalServiceClp
    implements SessionCustomActionLocalService {
    private ClassLoaderProxy _classLoaderProxy;
    private MethodKey _executeMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
            "execute",
            com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCallback.class);

    public SessionCustomActionLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }

    public java.lang.Object execute(
        com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCallback callback) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_executeMethodKey0,
                callback);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.Object) ClpSerializer.translateOutput(returnObj);
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}
