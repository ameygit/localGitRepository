package com.example.plugins.model.impl;

import com.example.plugins.model.Parts;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Parts in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Parts
 * @generated
 */
public class PartsCacheModel implements CacheModel<Parts>, Externalizable {
    public long id;
    public String part_number;
    public String description;
    public String item_type;
    public String status;
    public String status_description;
    public String legacy_part_number;
    public String alternate_item;
    public double unit_cost_material_cost;
    public double royalty_cost;
    public String product_code;
    public String product_code_description;
    public String product_group;
    public String product_group_description;
    public String discount_group;
    public String discount_group_description;
    public double us_price_msrp;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{id=");
        sb.append(id);
        sb.append(", part_number=");
        sb.append(part_number);
        sb.append(", description=");
        sb.append(description);
        sb.append(", item_type=");
        sb.append(item_type);
        sb.append(", status=");
        sb.append(status);
        sb.append(", status_description=");
        sb.append(status_description);
        sb.append(", legacy_part_number=");
        sb.append(legacy_part_number);
        sb.append(", alternate_item=");
        sb.append(alternate_item);
        sb.append(", unit_cost_material_cost=");
        sb.append(unit_cost_material_cost);
        sb.append(", royalty_cost=");
        sb.append(royalty_cost);
        sb.append(", product_code=");
        sb.append(product_code);
        sb.append(", product_code_description=");
        sb.append(product_code_description);
        sb.append(", product_group=");
        sb.append(product_group);
        sb.append(", product_group_description=");
        sb.append(product_group_description);
        sb.append(", discount_group=");
        sb.append(discount_group);
        sb.append(", discount_group_description=");
        sb.append(discount_group_description);
        sb.append(", us_price_msrp=");
        sb.append(us_price_msrp);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Parts toEntityModel() {
        PartsImpl partsImpl = new PartsImpl();

        partsImpl.setId(id);

        if (part_number == null) {
            partsImpl.setPart_number(StringPool.BLANK);
        } else {
            partsImpl.setPart_number(part_number);
        }

        if (description == null) {
            partsImpl.setDescription(StringPool.BLANK);
        } else {
            partsImpl.setDescription(description);
        }

        if (item_type == null) {
            partsImpl.setItem_type(StringPool.BLANK);
        } else {
            partsImpl.setItem_type(item_type);
        }

        if (status == null) {
            partsImpl.setStatus(StringPool.BLANK);
        } else {
            partsImpl.setStatus(status);
        }

        if (status_description == null) {
            partsImpl.setStatus_description(StringPool.BLANK);
        } else {
            partsImpl.setStatus_description(status_description);
        }

        if (legacy_part_number == null) {
            partsImpl.setLegacy_part_number(StringPool.BLANK);
        } else {
            partsImpl.setLegacy_part_number(legacy_part_number);
        }

        if (alternate_item == null) {
            partsImpl.setAlternate_item(StringPool.BLANK);
        } else {
            partsImpl.setAlternate_item(alternate_item);
        }

        partsImpl.setUnit_cost_material_cost(unit_cost_material_cost);
        partsImpl.setRoyalty_cost(royalty_cost);

        if (product_code == null) {
            partsImpl.setProduct_code(StringPool.BLANK);
        } else {
            partsImpl.setProduct_code(product_code);
        }

        if (product_code_description == null) {
            partsImpl.setProduct_code_description(StringPool.BLANK);
        } else {
            partsImpl.setProduct_code_description(product_code_description);
        }

        if (product_group == null) {
            partsImpl.setProduct_group(StringPool.BLANK);
        } else {
            partsImpl.setProduct_group(product_group);
        }

        if (product_group_description == null) {
            partsImpl.setProduct_group_description(StringPool.BLANK);
        } else {
            partsImpl.setProduct_group_description(product_group_description);
        }

        if (discount_group == null) {
            partsImpl.setDiscount_group(StringPool.BLANK);
        } else {
            partsImpl.setDiscount_group(discount_group);
        }

        if (discount_group_description == null) {
            partsImpl.setDiscount_group_description(StringPool.BLANK);
        } else {
            partsImpl.setDiscount_group_description(discount_group_description);
        }

        partsImpl.setUs_price_msrp(us_price_msrp);

        partsImpl.resetOriginalValues();

        return partsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        part_number = objectInput.readUTF();
        description = objectInput.readUTF();
        item_type = objectInput.readUTF();
        status = objectInput.readUTF();
        status_description = objectInput.readUTF();
        legacy_part_number = objectInput.readUTF();
        alternate_item = objectInput.readUTF();
        unit_cost_material_cost = objectInput.readDouble();
        royalty_cost = objectInput.readDouble();
        product_code = objectInput.readUTF();
        product_code_description = objectInput.readUTF();
        product_group = objectInput.readUTF();
        product_group_description = objectInput.readUTF();
        discount_group = objectInput.readUTF();
        discount_group_description = objectInput.readUTF();
        us_price_msrp = objectInput.readDouble();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (part_number == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(part_number);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (item_type == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(item_type);
        }

        if (status == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status);
        }

        if (status_description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status_description);
        }

        if (legacy_part_number == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(legacy_part_number);
        }

        if (alternate_item == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(alternate_item);
        }

        objectOutput.writeDouble(unit_cost_material_cost);
        objectOutput.writeDouble(royalty_cost);

        if (product_code == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(product_code);
        }

        if (product_code_description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(product_code_description);
        }

        if (product_group == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(product_group);
        }

        if (product_group_description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(product_group_description);
        }

        if (discount_group == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(discount_group);
        }

        if (discount_group_description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(discount_group_description);
        }

        objectOutput.writeDouble(us_price_msrp);
    }
}
