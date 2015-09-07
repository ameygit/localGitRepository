package com.example.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.example.plugins.service.http.PartsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.example.plugins.service.http.PartsServiceSoap
 * @generated
 */
public class PartsSoap implements Serializable {
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

    public PartsSoap() {
    }

    public static PartsSoap toSoapModel(Parts model) {
        PartsSoap soapModel = new PartsSoap();

        soapModel.setId(model.getId());
        soapModel.setPart_number(model.getPart_number());
        soapModel.setDescription(model.getDescription());
        soapModel.setItem_type(model.getItem_type());
        soapModel.setStatus(model.getStatus());
        soapModel.setStatus_description(model.getStatus_description());
        soapModel.setLegacy_part_number(model.getLegacy_part_number());
        soapModel.setAlternate_item(model.getAlternate_item());
        soapModel.setUnit_cost_material_cost(model.getUnit_cost_material_cost());
        soapModel.setRoyalty_cost(model.getRoyalty_cost());
        soapModel.setProduct_code(model.getProduct_code());
        soapModel.setProduct_code_description(model.getProduct_code_description());
        soapModel.setProduct_group(model.getProduct_group());
        soapModel.setProduct_group_description(model.getProduct_group_description());
        soapModel.setDiscount_group(model.getDiscount_group());
        soapModel.setDiscount_group_description(model.getDiscount_group_description());
        soapModel.setUs_price_msrp(model.getUs_price_msrp());

        return soapModel;
    }

    public static PartsSoap[] toSoapModels(Parts[] models) {
        PartsSoap[] soapModels = new PartsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PartsSoap[][] toSoapModels(Parts[][] models) {
        PartsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PartsSoap[models.length][models[0].length];
        } else {
            soapModels = new PartsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PartsSoap[] toSoapModels(List<Parts> models) {
        List<PartsSoap> soapModels = new ArrayList<PartsSoap>(models.size());

        for (Parts model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PartsSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getPart_number() {
        return _part_number;
    }

    public void setPart_number(String part_number) {
        _part_number = part_number;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getItem_type() {
        return _item_type;
    }

    public void setItem_type(String item_type) {
        _item_type = item_type;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public String getStatus_description() {
        return _status_description;
    }

    public void setStatus_description(String status_description) {
        _status_description = status_description;
    }

    public String getLegacy_part_number() {
        return _legacy_part_number;
    }

    public void setLegacy_part_number(String legacy_part_number) {
        _legacy_part_number = legacy_part_number;
    }

    public String getAlternate_item() {
        return _alternate_item;
    }

    public void setAlternate_item(String alternate_item) {
        _alternate_item = alternate_item;
    }

    public double getUnit_cost_material_cost() {
        return _unit_cost_material_cost;
    }

    public void setUnit_cost_material_cost(double unit_cost_material_cost) {
        _unit_cost_material_cost = unit_cost_material_cost;
    }

    public double getRoyalty_cost() {
        return _royalty_cost;
    }

    public void setRoyalty_cost(double royalty_cost) {
        _royalty_cost = royalty_cost;
    }

    public String getProduct_code() {
        return _product_code;
    }

    public void setProduct_code(String product_code) {
        _product_code = product_code;
    }

    public String getProduct_code_description() {
        return _product_code_description;
    }

    public void setProduct_code_description(String product_code_description) {
        _product_code_description = product_code_description;
    }

    public String getProduct_group() {
        return _product_group;
    }

    public void setProduct_group(String product_group) {
        _product_group = product_group;
    }

    public String getProduct_group_description() {
        return _product_group_description;
    }

    public void setProduct_group_description(String product_group_description) {
        _product_group_description = product_group_description;
    }

    public String getDiscount_group() {
        return _discount_group;
    }

    public void setDiscount_group(String discount_group) {
        _discount_group = discount_group;
    }

    public String getDiscount_group_description() {
        return _discount_group_description;
    }

    public void setDiscount_group_description(String discount_group_description) {
        _discount_group_description = discount_group_description;
    }

    public double getUs_price_msrp() {
        return _us_price_msrp;
    }

    public void setUs_price_msrp(double us_price_msrp) {
        _us_price_msrp = us_price_msrp;
    }
}
