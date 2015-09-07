package com.example.plugins.service.persistence;

import com.example.plugins.NoSuchPartsException;
import com.example.plugins.model.Parts;
import com.example.plugins.model.impl.PartsImpl;
import com.example.plugins.model.impl.PartsModelImpl;
import com.example.plugins.service.persistence.PartsPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the parts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PartsPersistence
 * @see PartsUtil
 * @generated
 */
public class PartsPersistenceImpl extends BasePersistenceImpl<Parts>
    implements PartsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PartsUtil} to access the parts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PartsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
            PartsModelImpl.FINDER_CACHE_ENABLED, PartsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
            PartsModelImpl.FINDER_CACHE_ENABLED, PartsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
            PartsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_PARTS = "SELECT parts FROM Parts parts";
    private static final String _SQL_COUNT_PARTS = "SELECT COUNT(parts) FROM Parts parts";
    private static final String _ORDER_BY_ENTITY_ALIAS = "parts.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Parts exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PartsPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static Parts _nullParts = new PartsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Parts> toCacheModel() {
                return _nullPartsCacheModel;
            }
        };

    private static CacheModel<Parts> _nullPartsCacheModel = new CacheModel<Parts>() {
            @Override
            public Parts toEntityModel() {
                return _nullParts;
            }
        };

    public PartsPersistenceImpl() {
        setModelClass(Parts.class);
    }

    /**
     * Caches the parts in the entity cache if it is enabled.
     *
     * @param parts the parts
     */
    @Override
    public void cacheResult(Parts parts) {
        EntityCacheUtil.putResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
            PartsImpl.class, parts.getPrimaryKey(), parts);

        parts.resetOriginalValues();
    }

    /**
     * Caches the partses in the entity cache if it is enabled.
     *
     * @param partses the partses
     */
    @Override
    public void cacheResult(List<Parts> partses) {
        for (Parts parts : partses) {
            if (EntityCacheUtil.getResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
                        PartsImpl.class, parts.getPrimaryKey()) == null) {
                cacheResult(parts);
            } else {
                parts.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all partses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PartsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PartsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the parts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Parts parts) {
        EntityCacheUtil.removeResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
            PartsImpl.class, parts.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Parts> partses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Parts parts : partses) {
            EntityCacheUtil.removeResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
                PartsImpl.class, parts.getPrimaryKey());
        }
    }

    /**
     * Creates a new parts with the primary key. Does not add the parts to the database.
     *
     * @param id the primary key for the new parts
     * @return the new parts
     */
    @Override
    public Parts create(long id) {
        Parts parts = new PartsImpl();

        parts.setNew(true);
        parts.setPrimaryKey(id);

        return parts;
    }

    /**
     * Removes the parts with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the parts
     * @return the parts that was removed
     * @throws com.example.plugins.NoSuchPartsException if a parts with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Parts remove(long id) throws NoSuchPartsException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the parts with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the parts
     * @return the parts that was removed
     * @throws com.example.plugins.NoSuchPartsException if a parts with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Parts remove(Serializable primaryKey)
        throws NoSuchPartsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Parts parts = (Parts) session.get(PartsImpl.class, primaryKey);

            if (parts == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPartsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(parts);
        } catch (NoSuchPartsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Parts removeImpl(Parts parts) throws SystemException {
        parts = toUnwrappedModel(parts);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(parts)) {
                parts = (Parts) session.get(PartsImpl.class,
                        parts.getPrimaryKeyObj());
            }

            if (parts != null) {
                session.delete(parts);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (parts != null) {
            clearCache(parts);
        }

        return parts;
    }

    @Override
    public Parts updateImpl(com.example.plugins.model.Parts parts)
        throws SystemException {
        parts = toUnwrappedModel(parts);

        boolean isNew = parts.isNew();

        Session session = null;

        try {
            session = openSession();

            if (parts.isNew()) {
                session.save(parts);

                parts.setNew(false);
            } else {
                session.merge(parts);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
            PartsImpl.class, parts.getPrimaryKey(), parts);

        return parts;
    }

    protected Parts toUnwrappedModel(Parts parts) {
        if (parts instanceof PartsImpl) {
            return parts;
        }

        PartsImpl partsImpl = new PartsImpl();

        partsImpl.setNew(parts.isNew());
        partsImpl.setPrimaryKey(parts.getPrimaryKey());

        partsImpl.setId(parts.getId());
        partsImpl.setPart_number(parts.getPart_number());
        partsImpl.setDescription(parts.getDescription());
        partsImpl.setItem_type(parts.getItem_type());
        partsImpl.setStatus(parts.getStatus());
        partsImpl.setStatus_description(parts.getStatus_description());
        partsImpl.setLegacy_part_number(parts.getLegacy_part_number());
        partsImpl.setAlternate_item(parts.getAlternate_item());
        partsImpl.setUnit_cost_material_cost(parts.getUnit_cost_material_cost());
        partsImpl.setRoyalty_cost(parts.getRoyalty_cost());
        partsImpl.setProduct_code(parts.getProduct_code());
        partsImpl.setProduct_code_description(parts.getProduct_code_description());
        partsImpl.setProduct_group(parts.getProduct_group());
        partsImpl.setProduct_group_description(parts.getProduct_group_description());
        partsImpl.setDiscount_group(parts.getDiscount_group());
        partsImpl.setDiscount_group_description(parts.getDiscount_group_description());
        partsImpl.setUs_price_msrp(parts.getUs_price_msrp());

        return partsImpl;
    }

    /**
     * Returns the parts with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the parts
     * @return the parts
     * @throws com.example.plugins.NoSuchPartsException if a parts with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Parts findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPartsException, SystemException {
        Parts parts = fetchByPrimaryKey(primaryKey);

        if (parts == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPartsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return parts;
    }

    /**
     * Returns the parts with the primary key or throws a {@link com.example.plugins.NoSuchPartsException} if it could not be found.
     *
     * @param id the primary key of the parts
     * @return the parts
     * @throws com.example.plugins.NoSuchPartsException if a parts with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Parts findByPrimaryKey(long id)
        throws NoSuchPartsException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the parts with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the parts
     * @return the parts, or <code>null</code> if a parts with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Parts fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Parts parts = (Parts) EntityCacheUtil.getResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
                PartsImpl.class, primaryKey);

        if (parts == _nullParts) {
            return null;
        }

        if (parts == null) {
            Session session = null;

            try {
                session = openSession();

                parts = (Parts) session.get(PartsImpl.class, primaryKey);

                if (parts != null) {
                    cacheResult(parts);
                } else {
                    EntityCacheUtil.putResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
                        PartsImpl.class, primaryKey, _nullParts);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
                    PartsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return parts;
    }

    /**
     * Returns the parts with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the parts
     * @return the parts, or <code>null</code> if a parts with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Parts fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the partses.
     *
     * @return the partses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Parts> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Parts> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Parts> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Parts> list = (List<Parts>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PARTS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PARTS;

                if (pagination) {
                    sql = sql.concat(PartsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Parts>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Parts>(list);
                } else {
                    list = (List<Parts>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the partses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Parts parts : findAll()) {
            remove(parts);
        }
    }

    /**
     * Returns the number of partses.
     *
     * @return the number of partses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PARTS);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the parts persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.example.plugins.model.Parts")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Parts>> listenersList = new ArrayList<ModelListener<Parts>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Parts>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PartsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
