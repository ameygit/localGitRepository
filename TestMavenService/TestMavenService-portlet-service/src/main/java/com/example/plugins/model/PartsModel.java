package com.example.plugins.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Parts service. Represents a row in the &quot;nec_Parts&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.example.plugins.model.impl.PartsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.example.plugins.model.impl.PartsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Parts
 * @see com.example.plugins.model.impl.PartsImpl
 * @see com.example.plugins.model.impl.PartsModelImpl
 * @generated
 */
public interface PartsModel extends BaseModel<Parts> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a parts model instance should use the {@link Parts} interface instead.
     */

    /**
     * Returns the primary key of this parts.
     *
     * @return the primary key of this parts
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this parts.
     *
     * @param primaryKey the primary key of this parts
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this parts.
     *
     * @return the ID of this parts
     */
    public long getId();

    /**
     * Sets the ID of this parts.
     *
     * @param id the ID of this parts
     */
    public void setId(long id);

    /**
     * Returns the part_number of this parts.
     *
     * @return the part_number of this parts
     */
    @AutoEscape
    public String getPart_number();

    /**
     * Sets the part_number of this parts.
     *
     * @param part_number the part_number of this parts
     */
    public void setPart_number(String part_number);

    /**
     * Returns the description of this parts.
     *
     * @return the description of this parts
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this parts.
     *
     * @param description the description of this parts
     */
    public void setDescription(String description);

    /**
     * Returns the item_type of this parts.
     *
     * @return the item_type of this parts
     */
    @AutoEscape
    public String getItem_type();

    /**
     * Sets the item_type of this parts.
     *
     * @param item_type the item_type of this parts
     */
    public void setItem_type(String item_type);

    /**
     * Returns the status of this parts.
     *
     * @return the status of this parts
     */
    @AutoEscape
    public String getStatus();

    /**
     * Sets the status of this parts.
     *
     * @param status the status of this parts
     */
    public void setStatus(String status);

    /**
     * Returns the status_description of this parts.
     *
     * @return the status_description of this parts
     */
    @AutoEscape
    public String getStatus_description();

    /**
     * Sets the status_description of this parts.
     *
     * @param status_description the status_description of this parts
     */
    public void setStatus_description(String status_description);

    /**
     * Returns the legacy_part_number of this parts.
     *
     * @return the legacy_part_number of this parts
     */
    @AutoEscape
    public String getLegacy_part_number();

    /**
     * Sets the legacy_part_number of this parts.
     *
     * @param legacy_part_number the legacy_part_number of this parts
     */
    public void setLegacy_part_number(String legacy_part_number);

    /**
     * Returns the alternate_item of this parts.
     *
     * @return the alternate_item of this parts
     */
    @AutoEscape
    public String getAlternate_item();

    /**
     * Sets the alternate_item of this parts.
     *
     * @param alternate_item the alternate_item of this parts
     */
    public void setAlternate_item(String alternate_item);

    /**
     * Returns the unit_cost_material_cost of this parts.
     *
     * @return the unit_cost_material_cost of this parts
     */
    public double getUnit_cost_material_cost();

    /**
     * Sets the unit_cost_material_cost of this parts.
     *
     * @param unit_cost_material_cost the unit_cost_material_cost of this parts
     */
    public void setUnit_cost_material_cost(double unit_cost_material_cost);

    /**
     * Returns the royalty_cost of this parts.
     *
     * @return the royalty_cost of this parts
     */
    public double getRoyalty_cost();

    /**
     * Sets the royalty_cost of this parts.
     *
     * @param royalty_cost the royalty_cost of this parts
     */
    public void setRoyalty_cost(double royalty_cost);

    /**
     * Returns the product_code of this parts.
     *
     * @return the product_code of this parts
     */
    @AutoEscape
    public String getProduct_code();

    /**
     * Sets the product_code of this parts.
     *
     * @param product_code the product_code of this parts
     */
    public void setProduct_code(String product_code);

    /**
     * Returns the product_code_description of this parts.
     *
     * @return the product_code_description of this parts
     */
    @AutoEscape
    public String getProduct_code_description();

    /**
     * Sets the product_code_description of this parts.
     *
     * @param product_code_description the product_code_description of this parts
     */
    public void setProduct_code_description(String product_code_description);

    /**
     * Returns the product_group of this parts.
     *
     * @return the product_group of this parts
     */
    @AutoEscape
    public String getProduct_group();

    /**
     * Sets the product_group of this parts.
     *
     * @param product_group the product_group of this parts
     */
    public void setProduct_group(String product_group);

    /**
     * Returns the product_group_description of this parts.
     *
     * @return the product_group_description of this parts
     */
    @AutoEscape
    public String getProduct_group_description();

    /**
     * Sets the product_group_description of this parts.
     *
     * @param product_group_description the product_group_description of this parts
     */
    public void setProduct_group_description(String product_group_description);

    /**
     * Returns the discount_group of this parts.
     *
     * @return the discount_group of this parts
     */
    @AutoEscape
    public String getDiscount_group();

    /**
     * Sets the discount_group of this parts.
     *
     * @param discount_group the discount_group of this parts
     */
    public void setDiscount_group(String discount_group);

    /**
     * Returns the discount_group_description of this parts.
     *
     * @return the discount_group_description of this parts
     */
    @AutoEscape
    public String getDiscount_group_description();

    /**
     * Sets the discount_group_description of this parts.
     *
     * @param discount_group_description the discount_group_description of this parts
     */
    public void setDiscount_group_description(String discount_group_description);

    /**
     * Returns the us_price_msrp of this parts.
     *
     * @return the us_price_msrp of this parts
     */
    public double getUs_price_msrp();

    /**
     * Sets the us_price_msrp of this parts.
     *
     * @param us_price_msrp the us_price_msrp of this parts
     */
    public void setUs_price_msrp(double us_price_msrp);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(com.example.plugins.model.Parts parts);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.example.plugins.model.Parts> toCacheModel();

    @Override
    public com.example.plugins.model.Parts toEscapedModel();

    @Override
    public com.example.plugins.model.Parts toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
