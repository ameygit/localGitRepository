package com.example.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PartsService}.
 *
 * @author Brian Wing Shun Chan
 * @see PartsService
 * @generated
 */
public class PartsServiceWrapper implements PartsService,
    ServiceWrapper<PartsService> {
    private PartsService _partsService;

    public PartsServiceWrapper(PartsService partsService) {
        _partsService = partsService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _partsService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _partsService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _partsService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PartsService getWrappedPartsService() {
        return _partsService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPartsService(PartsService partsService) {
        _partsService = partsService;
    }

    @Override
    public PartsService getWrappedService() {
        return _partsService;
    }

    @Override
    public void setWrappedService(PartsService partsService) {
        _partsService = partsService;
    }
}
