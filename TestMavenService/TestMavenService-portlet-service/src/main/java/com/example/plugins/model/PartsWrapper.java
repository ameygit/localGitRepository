package com.example.plugins.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Parts}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Parts
 * @generated
 */
public class PartsWrapper implements Parts, ModelWrapper<Parts> {
    private Parts _parts;

    public PartsWrapper(Parts parts) {
        _parts = parts;
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

    /**
    * Returns the primary key of this parts.
    *
    * @return the primary key of this parts
    */
    @Override
    public long getPrimaryKey() {
        return _parts.getPrimaryKey();
    }

    /**
    * Sets the primary key of this parts.
    *
    * @param primaryKey the primary key of this parts
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _parts.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this parts.
    *
    * @return the ID of this parts
    */
    @Override
    public long getId() {
        return _parts.getId();
    }

    /**
    * Sets the ID of this parts.
    *
    * @param id the ID of this parts
    */
    @Override
    public void setId(long id) {
        _parts.setId(id);
    }

    /**
    * Returns the part_number of this parts.
    *
    * @return the part_number of this parts
    */
    @Override
    public java.lang.String getPart_number() {
        return _parts.getPart_number();
    }

    /**
    * Sets the part_number of this parts.
    *
    * @param part_number the part_number of this parts
    */
    @Override
    public void setPart_number(java.lang.String part_number) {
        _parts.setPart_number(part_number);
    }

    /**
    * Returns the description of this parts.
    *
    * @return the description of this parts
    */
    @Override
    public java.lang.String getDescription() {
        return _parts.getDescription();
    }

    /**
    * Sets the description of this parts.
    *
    * @param description the description of this parts
    */
    @Override
    public void setDescription(java.lang.String description) {
        _parts.setDescription(description);
    }

    /**
    * Returns the item_type of this parts.
    *
    * @return the item_type of this parts
    */
    @Override
    public java.lang.String getItem_type() {
        return _parts.getItem_type();
    }

    /**
    * Sets the item_type of this parts.
    *
    * @param item_type the item_type of this parts
    */
    @Override
    public void setItem_type(java.lang.String item_type) {
        _parts.setItem_type(item_type);
    }

    /**
    * Returns the status of this parts.
    *
    * @return the status of this parts
    */
    @Override
    public java.lang.String getStatus() {
        return _parts.getStatus();
    }

    /**
    * Sets the status of this parts.
    *
    * @param status the status of this parts
    */
    @Override
    public void setStatus(java.lang.String status) {
        _parts.setStatus(status);
    }

    /**
    * Returns the status_description of this parts.
    *
    * @return the status_description of this parts
    */
    @Override
    public java.lang.String getStatus_description() {
        return _parts.getStatus_description();
    }

    /**
    * Sets the status_description of this parts.
    *
    * @param status_description the status_description of this parts
    */
    @Override
    public void setStatus_description(java.lang.String status_description) {
        _parts.setStatus_description(status_description);
    }

    /**
    * Returns the legacy_part_number of this parts.
    *
    * @return the legacy_part_number of this parts
    */
    @Override
    public java.lang.String getLegacy_part_number() {
        return _parts.getLegacy_part_number();
    }

    /**
    * Sets the legacy_part_number of this parts.
    *
    * @param legacy_part_number the legacy_part_number of this parts
    */
    @Override
    public void setLegacy_part_number(java.lang.String legacy_part_number) {
        _parts.setLegacy_part_number(legacy_part_number);
    }

    /**
    * Returns the alternate_item of this parts.
    *
    * @return the alternate_item of this parts
    */
    @Override
    public java.lang.String getAlternate_item() {
        return _parts.getAlternate_item();
    }

    /**
    * Sets the alternate_item of this parts.
    *
    * @param alternate_item the alternate_item of this parts
    */
    @Override
    public void setAlternate_item(java.lang.String alternate_item) {
        _parts.setAlternate_item(alternate_item);
    }

    /**
    * Returns the unit_cost_material_cost of this parts.
    *
    * @return the unit_cost_material_cost of this parts
    */
    @Override
    public double getUnit_cost_material_cost() {
        return _parts.getUnit_cost_material_cost();
    }

    /**
    * Sets the unit_cost_material_cost of this parts.
    *
    * @param unit_cost_material_cost the unit_cost_material_cost of this parts
    */
    @Override
    public void setUnit_cost_material_cost(double unit_cost_material_cost) {
        _parts.setUnit_cost_material_cost(unit_cost_material_cost);
    }

    /**
    * Returns the royalty_cost of this parts.
    *
    * @return the royalty_cost of this parts
    */
    @Override
    public double getRoyalty_cost() {
        return _parts.getRoyalty_cost();
    }

    /**
    * Sets the royalty_cost of this parts.
    *
    * @param royalty_cost the royalty_cost of this parts
    */
    @Override
    public void setRoyalty_cost(double royalty_cost) {
        _parts.setRoyalty_cost(royalty_cost);
    }

    /**
    * Returns the product_code of this parts.
    *
    * @return the product_code of this parts
    */
    @Override
    public java.lang.String getProduct_code() {
        return _parts.getProduct_code();
    }

    /**
    * Sets the product_code of this parts.
    *
    * @param product_code the product_code of this parts
    */
    @Override
    public void setProduct_code(java.lang.String product_code) {
        _parts.setProduct_code(product_code);
    }

    /**
    * Returns the product_code_description of this parts.
    *
    * @return the product_code_description of this parts
    */
    @Override
    public java.lang.String getProduct_code_description() {
        return _parts.getProduct_code_description();
    }

    /**
    * Sets the product_code_description of this parts.
    *
    * @param product_code_description the product_code_description of this parts
    */
    @Override
    public void setProduct_code_description(
        java.lang.String product_code_description) {
        _parts.setProduct_code_description(product_code_description);
    }

    /**
    * Returns the product_group of this parts.
    *
    * @return the product_group of this parts
    */
    @Override
    public java.lang.String getProduct_group() {
        return _parts.getProduct_group();
    }

    /**
    * Sets the product_group of this parts.
    *
    * @param product_group the product_group of this parts
    */
    @Override
    public void setProduct_group(java.lang.String product_group) {
        _parts.setProduct_group(product_group);
    }

    /**
    * Returns the product_group_description of this parts.
    *
    * @return the product_group_description of this parts
    */
    @Override
    public java.lang.String getProduct_group_description() {
        return _parts.getProduct_group_description();
    }

    /**
    * Sets the product_group_description of this parts.
    *
    * @param product_group_description the product_group_description of this parts
    */
    @Override
    public void setProduct_group_description(
        java.lang.String product_group_description) {
        _parts.setProduct_group_description(product_group_description);
    }

    /**
    * Returns the discount_group of this parts.
    *
    * @return the discount_group of this parts
    */
    @Override
    public java.lang.String getDiscount_group() {
        return _parts.getDiscount_group();
    }

    /**
    * Sets the discount_group of this parts.
    *
    * @param discount_group the discount_group of this parts
    */
    @Override
    public void setDiscount_group(java.lang.String discount_group) {
        _parts.setDiscount_group(discount_group);
    }

    /**
    * Returns the discount_group_description of this parts.
    *
    * @return the discount_group_description of this parts
    */
    @Override
    public java.lang.String getDiscount_group_description() {
        return _parts.getDiscount_group_description();
    }

    /**
    * Sets the discount_group_description of this parts.
    *
    * @param discount_group_description the discount_group_description of this parts
    */
    @Override
    public void setDiscount_group_description(
        java.lang.String discount_group_description) {
        _parts.setDiscount_group_description(discount_group_description);
    }

    /**
    * Returns the us_price_msrp of this parts.
    *
    * @return the us_price_msrp of this parts
    */
    @Override
    public double getUs_price_msrp() {
        return _parts.getUs_price_msrp();
    }

    /**
    * Sets the us_price_msrp of this parts.
    *
    * @param us_price_msrp the us_price_msrp of this parts
    */
    @Override
    public void setUs_price_msrp(double us_price_msrp) {
        _parts.setUs_price_msrp(us_price_msrp);
    }

    @Override
    public boolean isNew() {
        return _parts.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _parts.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _parts.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _parts.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _parts.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _parts.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _parts.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _parts.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _parts.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _parts.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _parts.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PartsWrapper((Parts) _parts.clone());
    }

    @Override
    public int compareTo(com.example.plugins.model.Parts parts) {
        return _parts.compareTo(parts);
    }

    @Override
    public int hashCode() {
        return _parts.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.example.plugins.model.Parts> toCacheModel() {
        return _parts.toCacheModel();
    }

    @Override
    public com.example.plugins.model.Parts toEscapedModel() {
        return new PartsWrapper(_parts.toEscapedModel());
    }

    @Override
    public com.example.plugins.model.Parts toUnescapedModel() {
        return new PartsWrapper(_parts.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _parts.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _parts.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _parts.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PartsWrapper)) {
            return false;
        }

        PartsWrapper partsWrapper = (PartsWrapper) obj;

        if (Validator.equals(_parts, partsWrapper._parts)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Parts getWrappedParts() {
        return _parts;
    }

    @Override
    public Parts getWrappedModel() {
        return _parts;
    }

    @Override
    public void resetOriginalValues() {
        _parts.resetOriginalValues();
    }
}
