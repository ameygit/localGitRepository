package com.example.plugins.model;

import com.example.plugins.service.ClpSerializer;
import com.example.plugins.service.PartsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class PartsClp extends BaseModelImpl<Parts> implements Parts {
    private long _id;
    private String _part_number;
    private String _description;
    private String _item_type;
    private String _status;
    private String _status_description;
    private String _legacy_part_number;
    private String _alternate_item;
    private double _unit_cost_material_cost;
    private double _royalty_cost;
    private String _product_code;
    private String _product_code_description;
    private String _product_group;
    private String _product_group_description;
    private String _discount_group;
    private String _discount_group_description;
    private double _us_price_msrp;
    private BaseModel<?> _partsRemoteModel;
    private Class<?> _clpSerializerClass = com.example.plugins.service.ClpSerializer.class;

    public PartsClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Parts.class;
    }

    @Override
    public String getModelClassName() {
        return Parts.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("part_number", getPart_number());
        attributes.put("description", getDescription());
        attributes.put("item_type", getItem_type());
        attributes.put("status", getStatus());
        attributes.put("status_description", getStatus_description());
        attributes.put("legacy_part_number", getLegacy_part_number());
        attributes.put("alternate_item", getAlternate_item());
        attributes.put("unit_cost_material_cost", getUnit_cost_material_cost());
        attributes.put("royalty_cost", getRoyalty_cost());
        attributes.put("product_code", getProduct_code());
        attributes.put("product_code_description", getProduct_code_description());
        attributes.put("product_group", getProduct_group());
        attributes.put("product_group_description",
            getProduct_group_description());
        attributes.put("discount_group", getDiscount_group());
        attributes.put("discount_group_description",
            getDiscount_group_description());
        attributes.put("us_price_msrp", getUs_price_msrp());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String part_number = (String) attributes.get("part_number");

        if (part_number != null) {
            setPart_number(part_number);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String item_type = (String) attributes.get("item_type");

        if (item_type != null) {
            setItem_type(item_type);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String status_description = (String) attributes.get(
                "status_description");

        if (status_description != null) {
            setStatus_description(status_description);
        }

        String legacy_part_number = (String) attributes.get(
                "legacy_part_number");

        if (legacy_part_number != null) {
            setLegacy_part_number(legacy_part_number);
        }

        String alternate_item = (String) attributes.get("alternate_item");

        if (alternate_item != null) {
            setAlternate_item(alternate_item);
        }

        Double unit_cost_material_cost = (Double) attributes.get(
                "unit_cost_material_cost");

        if (unit_cost_material_cost != null) {
            setUnit_cost_material_cost(unit_cost_material_cost);
        }

        Double royalty_cost = (Double) attributes.get("royalty_cost");

        if (royalty_cost != null) {
            setRoyalty_cost(royalty_cost);
        }

        String product_code = (String) attributes.get("product_code");

        if (product_code != null) {
            setProduct_code(product_code);
        }

        String product_code_description = (String) attributes.get(
                "product_code_description");

        if (product_code_description != null) {
            setProduct_code_description(product_code_description);
        }

        String product_group = (String) attributes.get("product_group");

        if (product_group != null) {
            setProduct_group(product_group);
        }

        String product_group_description = (String) attributes.get(
                "product_group_description");

        if (product_group_description != null) {
            setProduct_group_description(product_group_description);
        }

        String discount_group = (String) attributes.get("discount_group");

        if (discount_group != null) {
            setDiscount_group(discount_group);
        }

        String discount_group_description = (String) attributes.get(
                "discount_group_description");

        if (discount_group_description != null) {
            setDiscount_group_description(discount_group_description);
        }

        Double us_price_msrp = (Double) attributes.get("us_price_msrp");

        if (us_price_msrp != null) {
            setUs_price_msrp(us_price_msrp);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_partsRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPart_number() {
        return _part_number;
    }

    @Override
    public void setPart_number(String part_number) {
        _part_number = part_number;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setPart_number", String.class);

                method.invoke(_partsRemoteModel, part_number);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_partsRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getItem_type() {
        return _item_type;
    }

    @Override
    public void setItem_type(String item_type) {
        _item_type = item_type;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setItem_type", String.class);

                method.invoke(_partsRemoteModel, item_type);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        _status = status;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_partsRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus_description() {
        return _status_description;
    }

    @Override
    public void setStatus_description(String status_description) {
        _status_description = status_description;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus_description",
                        String.class);

                method.invoke(_partsRemoteModel, status_description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLegacy_part_number() {
        return _legacy_part_number;
    }

    @Override
    public void setLegacy_part_number(String legacy_part_number) {
        _legacy_part_number = legacy_part_number;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setLegacy_part_number",
                        String.class);

                method.invoke(_partsRemoteModel, legacy_part_number);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAlternate_item() {
        return _alternate_item;
    }

    @Override
    public void setAlternate_item(String alternate_item) {
        _alternate_item = alternate_item;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setAlternate_item",
                        String.class);

                method.invoke(_partsRemoteModel, alternate_item);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getUnit_cost_material_cost() {
        return _unit_cost_material_cost;
    }

    @Override
    public void setUnit_cost_material_cost(double unit_cost_material_cost) {
        _unit_cost_material_cost = unit_cost_material_cost;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setUnit_cost_material_cost",
                        double.class);

                method.invoke(_partsRemoteModel, unit_cost_material_cost);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getRoyalty_cost() {
        return _royalty_cost;
    }

    @Override
    public void setRoyalty_cost(double royalty_cost) {
        _royalty_cost = royalty_cost;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setRoyalty_cost", double.class);

                method.invoke(_partsRemoteModel, royalty_cost);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProduct_code() {
        return _product_code;
    }

    @Override
    public void setProduct_code(String product_code) {
        _product_code = product_code;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setProduct_code", String.class);

                method.invoke(_partsRemoteModel, product_code);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProduct_code_description() {
        return _product_code_description;
    }

    @Override
    public void setProduct_code_description(String product_code_description) {
        _product_code_description = product_code_description;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setProduct_code_description",
                        String.class);

                method.invoke(_partsRemoteModel, product_code_description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProduct_group() {
        return _product_group;
    }

    @Override
    public void setProduct_group(String product_group) {
        _product_group = product_group;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setProduct_group", String.class);

                method.invoke(_partsRemoteModel, product_group);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProduct_group_description() {
        return _product_group_description;
    }

    @Override
    public void setProduct_group_description(String product_group_description) {
        _product_group_description = product_group_description;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setProduct_group_description",
                        String.class);

                method.invoke(_partsRemoteModel, product_group_description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDiscount_group() {
        return _discount_group;
    }

    @Override
    public void setDiscount_group(String discount_group) {
        _discount_group = discount_group;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setDiscount_group",
                        String.class);

                method.invoke(_partsRemoteModel, discount_group);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDiscount_group_description() {
        return _discount_group_description;
    }

    @Override
    public void setDiscount_group_description(String discount_group_description) {
        _discount_group_description = discount_group_description;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setDiscount_group_description",
                        String.class);

                method.invoke(_partsRemoteModel, discount_group_description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getUs_price_msrp() {
        return _us_price_msrp;
    }

    @Override
    public void setUs_price_msrp(double us_price_msrp) {
        _us_price_msrp = us_price_msrp;

        if (_partsRemoteModel != null) {
            try {
                Class<?> clazz = _partsRemoteModel.getClass();

                Method method = clazz.getMethod("setUs_price_msrp", double.class);

                method.invoke(_partsRemoteModel, us_price_msrp);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getPartsRemoteModel() {
        return _partsRemoteModel;
    }

    public void setPartsRemoteModel(BaseModel<?> partsRemoteModel) {
        _partsRemoteModel = partsRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _partsRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_partsRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PartsLocalServiceUtil.addParts(this);
        } else {
            PartsLocalServiceUtil.updateParts(this);
        }
    }

    @Override
    public Parts toEscapedModel() {
        return (Parts) ProxyUtil.newProxyInstance(Parts.class.getClassLoader(),
            new Class[] { Parts.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PartsClp clone = new PartsClp();

        clone.setId(getId());
        clone.setPart_number(getPart_number());
        clone.setDescription(getDescription());
        clone.setItem_type(getItem_type());
        clone.setStatus(getStatus());
        clone.setStatus_description(getStatus_description());
        clone.setLegacy_part_number(getLegacy_part_number());
        clone.setAlternate_item(getAlternate_item());
        clone.setUnit_cost_material_cost(getUnit_cost_material_cost());
        clone.setRoyalty_cost(getRoyalty_cost());
        clone.setProduct_code(getProduct_code());
        clone.setProduct_code_description(getProduct_code_description());
        clone.setProduct_group(getProduct_group());
        clone.setProduct_group_description(getProduct_group_description());
        clone.setDiscount_group(getDiscount_group());
        clone.setDiscount_group_description(getDiscount_group_description());
        clone.setUs_price_msrp(getUs_price_msrp());

        return clone;
    }

    @Override
    public int compareTo(Parts parts) {
        long primaryKey = parts.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PartsClp)) {
            return false;
        }

        PartsClp parts = (PartsClp) obj;

        long primaryKey = parts.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", part_number=");
        sb.append(getPart_number());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", item_type=");
        sb.append(getItem_type());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", status_description=");
        sb.append(getStatus_description());
        sb.append(", legacy_part_number=");
        sb.append(getLegacy_part_number());
        sb.append(", alternate_item=");
        sb.append(getAlternate_item());
        sb.append(", unit_cost_material_cost=");
        sb.append(getUnit_cost_material_cost());
        sb.append(", royalty_cost=");
        sb.append(getRoyalty_cost());
        sb.append(", product_code=");
        sb.append(getProduct_code());
        sb.append(", product_code_description=");
        sb.append(getProduct_code_description());
        sb.append(", product_group=");
        sb.append(getProduct_group());
        sb.append(", product_group_description=");
        sb.append(getProduct_group_description());
        sb.append(", discount_group=");
        sb.append(getDiscount_group());
        sb.append(", discount_group_description=");
        sb.append(getDiscount_group_description());
        sb.append(", us_price_msrp=");
        sb.append(getUs_price_msrp());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(55);

        sb.append("<model><model-name>");
        sb.append("com.example.plugins.model.Parts");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>part_number</column-name><column-value><![CDATA[");
        sb.append(getPart_number());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>item_type</column-name><column-value><![CDATA[");
        sb.append(getItem_type());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status_description</column-name><column-value><![CDATA[");
        sb.append(getStatus_description());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>legacy_part_number</column-name><column-value><![CDATA[");
        sb.append(getLegacy_part_number());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>alternate_item</column-name><column-value><![CDATA[");
        sb.append(getAlternate_item());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>unit_cost_material_cost</column-name><column-value><![CDATA[");
        sb.append(getUnit_cost_material_cost());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>royalty_cost</column-name><column-value><![CDATA[");
        sb.append(getRoyalty_cost());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>product_code</column-name><column-value><![CDATA[");
        sb.append(getProduct_code());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>product_code_description</column-name><column-value><![CDATA[");
        sb.append(getProduct_code_description());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>product_group</column-name><column-value><![CDATA[");
        sb.append(getProduct_group());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>product_group_description</column-name><column-value><![CDATA[");
        sb.append(getProduct_group_description());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>discount_group</column-name><column-value><![CDATA[");
        sb.append(getDiscount_group());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>discount_group_description</column-name><column-value><![CDATA[");
        sb.append(getDiscount_group_description());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>us_price_msrp</column-name><column-value><![CDATA[");
        sb.append(getUs_price_msrp());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
