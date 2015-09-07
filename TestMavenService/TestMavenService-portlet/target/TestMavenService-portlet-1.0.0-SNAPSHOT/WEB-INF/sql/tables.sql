create table nec_Parts (
	id_ LONG not null primary key,
	part_number VARCHAR(75) null,
	description VARCHAR(75) null,
	item_type VARCHAR(75) null,
	status VARCHAR(75) null,
	status_description VARCHAR(75) null,
	legacy_part_number VARCHAR(75) null,
	alternate_item VARCHAR(75) null,
	unit_cost_material_cost DOUBLE,
	royalty_cost DOUBLE,
	product_code VARCHAR(75) null,
	product_code_description VARCHAR(75) null,
	product_group VARCHAR(75) null,
	product_group_description VARCHAR(75) null,
	discount_group VARCHAR(75) null,
	discount_group_description VARCHAR(75) null,
	us_price_msrp DOUBLE
);