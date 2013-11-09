package com.github.mateuszwenus.lf_org_chart.service_builder.service;

/**
 * <p>
 * This class is a wrapper for {@link SessionCustomActionLocalService}.
 * </p>
 *
 * @author    Mateusz Wenus
 * @see       SessionCustomActionLocalService
 * @generated
 */
public class SessionCustomActionLocalServiceWrapper
    implements SessionCustomActionLocalService {
    private SessionCustomActionLocalService _sessionCustomActionLocalService;

    public SessionCustomActionLocalServiceWrapper(
        SessionCustomActionLocalService sessionCustomActionLocalService) {
        _sessionCustomActionLocalService = sessionCustomActionLocalService;
    }

    public java.lang.Object execute(
        com.github.mateuszwenus.lf_org_chart.service_builder.service.SessionCallback callback) {
        return _sessionCustomActionLocalService.execute(callback);
    }

    public SessionCustomActionLocalService getWrappedSessionCustomActionLocalService() {
        return _sessionCustomActionLocalService;
    }
}
