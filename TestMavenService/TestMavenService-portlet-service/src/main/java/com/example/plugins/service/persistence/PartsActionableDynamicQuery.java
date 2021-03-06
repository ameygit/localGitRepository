package com.example.plugins.service.persistence;

import com.example.plugins.model.Parts;
import com.example.plugins.service.PartsLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class PartsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PartsActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PartsLocalServiceUtil.getService());
        setClass(Parts.class);

        setClassLoader(com.example.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
