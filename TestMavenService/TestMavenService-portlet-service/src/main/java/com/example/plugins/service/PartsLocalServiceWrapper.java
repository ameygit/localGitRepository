package com.example.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PartsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PartsLocalService
 * @generated
 */
public class PartsLocalServiceWrapper implements PartsLocalService,
    ServiceWrapper<PartsLocalService> {
    private PartsLocalService _partsLocalService;

    public PartsLocalServiceWrapper(PartsLocalService partsLocalService) {
        _partsLocalService = partsLocalService;
    }

    /**
    * Adds the parts to the database. Also notifies the appropriate model listeners.
    *
    * @param parts the parts
    * @return the parts that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.plugins.model.Parts addParts(
        com.example.plugins.model.Parts parts)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.addParts(parts);
    }

    /**
    * Creates a new parts with the primary key. Does not add the parts to the database.
    *
    * @param id the primary key for the new parts
    * @return the new parts
    */
    @Override
    public com.example.plugins.model.Parts createParts(long id) {
        return _partsLocalService.createParts(id);
    }

    /**
    * Deletes the parts with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the parts
    * @return the parts that was removed
    * @throws PortalException if a parts with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.plugins.model.Parts deleteParts(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.deleteParts(id);
    }

    /**
    * Deletes the parts from the database. Also notifies the appropriate model listeners.
    *
    * @param parts the parts
    * @return the parts that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.plugins.model.Parts deleteParts(
        com.example.plugins.model.Parts parts)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.deleteParts(parts);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _partsLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.plugins.model.impl.PartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.plugins.model.impl.PartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.example.plugins.model.Parts fetchParts(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.fetchParts(id);
    }

    /**
    * Returns the parts with the primary key.
    *
    * @param id the primary key of the parts
    * @return the parts
    * @throws PortalException if a parts with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.plugins.model.Parts getParts(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.getParts(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the partses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.plugins.model.impl.PartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of partses
    * @param end the upper bound of the range of partses (not inclusive)
    * @return the range of partses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.example.plugins.model.Parts> getPartses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.getPartses(start, end);
    }

    /**
    * Returns the number of partses.
    *
    * @return the number of partses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPartsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.getPartsesCount();
    }

    /**
    * Updates the parts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param parts the parts
    * @return the parts that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.example.plugins.model.Parts updateParts(
        com.example.plugins.model.Parts parts)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _partsLocalService.updateParts(parts);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _partsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _partsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _partsLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PartsLocalService getWrappedPartsLocalService() {
        return _partsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPartsLocalService(PartsLocalService partsLocalService) {
        _partsLocalService = partsLocalService;
    }

    @Override
    public PartsLocalService getWrappedService() {
        return _partsLocalService;
    }

    @Override
    public void setWrappedService(PartsLocalService partsLocalService) {
        _partsLocalService = partsLocalService;
    }
}
