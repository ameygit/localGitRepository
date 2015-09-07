package com.example.plugins.service.persistence;

import com.example.plugins.model.Parts;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the parts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PartsPersistenceImpl
 * @see PartsUtil
 * @generated
 */
public interface PartsPersistence extends BasePersistence<Parts> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PartsUtil} to access the parts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the parts in the entity cache if it is enabled.
    *
    * @param parts the parts
    */
    public void cacheResult(com.example.plugins.model.Parts parts);

    /**
    * Caches the partses in the entity cache if it is enabled.
    *
    * @param partses the partses
    */
    public void cacheResult(
        java.util.List<com.example.plugins.model.Parts> partses);

    /**
    * Creates a new parts with the primary key. Does not add the parts to the database.
    *
    * @param id the primary key for the new parts
    * @return the new parts
    */
    public com.example.plugins.model.Parts create(long id);

    /**
    * Removes the parts with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the parts
    * @return the parts that was removed
    * @throws com.example.plugins.NoSuchPartsException if a parts with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.plugins.model.Parts remove(long id)
        throws com.example.plugins.NoSuchPartsException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.example.plugins.model.Parts updateImpl(
        com.example.plugins.model.Parts parts)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the parts with the primary key or throws a {@link com.example.plugins.NoSuchPartsException} if it could not be found.
    *
    * @param id the primary key of the parts
    * @return the parts
    * @throws com.example.plugins.NoSuchPartsException if a parts with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.plugins.model.Parts findByPrimaryKey(long id)
        throws com.example.plugins.NoSuchPartsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the parts with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the parts
    * @return the parts, or <code>null</code> if a parts with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.example.plugins.model.Parts fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the partses.
    *
    * @return the partses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.plugins.model.Parts> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.example.plugins.model.Parts> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the partses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.plugins.model.impl.PartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of partses
    * @param end the upper bound of the range of partses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of partses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.example.plugins.model.Parts> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the partses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of partses.
    *
    * @return the number of partses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
