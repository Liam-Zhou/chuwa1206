CREATE DATABASE test;
USE test;

CREATE TABLE oms_order (
    id BIGINT PRIMARY KEY,
    member_id BIGINT,
    order_sn VARCHAR(64),
    create_time DATETIME,
    member_username VARCHAR(64),
    total_amount DECIMAL(10,2),
    pay_amount DECIMAL(10,2),
    freight_amount DECIMAL(10,2),
    pay_type INT(1),
    source_type INT(1),
    status INT(1),
    order_type INT(1),
    delivery_company VARCHAR(64),
    delivery_sn VARCHAR(64),
    auto_confirm_day INT,
    bill_type INT(1),
    receiver_name VARCHAR(100),
    receiver_phone VARCHAR(32),
    receiver_post_code VARCHAR(32),
    receiver_province VARCHAR(32),
    receiver_city VARCHAR(32),
    receiver_region VARCHAR(32),
    receiver_detail_address VARCHAR(200),
    note VARCHAR(500),
    confirm_status INT(1),
    delete_status INT(1),
    payment_time DATETIME,
    delivery_time DATETIME,
    receive_time DATETIME,
    comment_time DATETIME,
    modify_time DATETIME
);

CREATE TABLE oms_order_item (
    id BIGINT PRIMARY KEY,
    order_id BIGINT,
    order_sn VARCHAR(64),
    product_id BIGINT,
    product_pic VARCHAR(500),
    product_name VARCHAR(200),
    product_brand VARCHAR(200),
    product_sn VARCHAR(64),
    product_price DECIMAL(10,2),
    product_quantity INT,
    product_sku_id BIGINT,
    product_sku_code VARCHAR(50),
    product_category_id BIGINT,
    sp1 VARCHAR(100),
    sp2 VARCHAR(100),
    sp3 VARCHAR(100),
    product_attr VARCHAR(500)
);

CREATE TABLE oms_order_operate_history (
    id BIGINT PRIMARY KEY,
    order_id BIGINT,
    operate_man VARCHAR(100),
    create_time DATETIME,
    order_status INT(1),
    note VARCHAR(500)
);

CREATE TABLE oms_order_setting (
    id BIGINT PRIMARY KEY,
    normal_order_overtime INT,
    confirm_overtime INT,
    finish_overtime INT,
    comment_overtime INT
);

CREATE TABLE oms_order_return_apply (
    id BIGINT PRIMARY KEY,
    order_id BIGINT,
    company_address_id BIGINT,
    product_id BIGINT,
    order_sn VARCHAR(64),
    create_time DATETIME,
    member_username VARCHAR(64),
    return_amount DECIMAL(10,2),
    return_name VARCHAR(100),
    return_phone VARCHAR(100),
    status INT(1),
    handle_time DATETIME,
    product_pic VARCHAR(500),
    product_name VARCHAR(200),
    product_brand VARCHAR(200),
    product_attr VARCHAR(500),
    product_count INT,
    product_price DECIMAL(10,2),
    product_real_price DECIMAL(10,2),
    reason VARCHAR(200),
    description VARCHAR(500),
    proof_pics VARCHAR(1000),
    handle_note VARCHAR(500),
    handle_man VARCHAR(100),
    receive_man VARCHAR(100),
    receive_time DATETIME,
    receive_note VARCHAR(500)
);


CREATE TABLE oms_company_address (
    id BIGINT PRIMARY KEY,
    address_name VARCHAR(200),
    send_status INT(1),
    receive_status INT(1),
    name VARCHAR(64),
    phone VARCHAR(64),
    province VARCHAR(64),
    city VARCHAR(64),
    region VARCHAR(64),
    detail_address VARCHAR(200)
);

CREATE TABLE oms_order_return_reason (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100),
    sort INT,
    status INT(1),
    create_time DATETIME
);

CREATE TABLE oms_cart_item (
    id BIGINT PRIMARY KEY,
    product_id BIGINT,
    product_sku_id BIGINT,
    member_id BIGINT,
    quantity INT,
    price DECIMAL(10,2),
    sp1 VARCHAR(200),
    sp2 VARCHAR(200),
    sp3 VARCHAR(200),
    product_pic VARCHAR(1000),
    product_name VARCHAR(500),
    product_brand VARCHAR(200),
    product_sn VARCHAR(200),
    product_sub_title VARCHAR(500),
    product_sku_code VARCHAR(200),
    member_nickname VARCHAR(500),
    create_date DATETIME,
    modify_date DATETIME,
    delete_status INT(1),
    product_category_id BIGINT,
    product_attr VARCHAR(500)
);

INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
    (1, 'Office', 1, 0, 'John Doe', '1234567890', 'California', 'Los Angeles', 'Downtown', '123 Main St'),
    (2, 'Warehouse', 0, 1, 'Jane Smith', '9876543210', 'New York', 'New York City', 'Manhattan', '456 Broad St'),
    (3, 'Customer Home', 1, 1, 'Alice Johnson', '5551234567', 'Texas', 'Houston', 'Midtown', '789 Oak Ave'),
    (4, 'Factory', 1, 1, 'Bob Miller', '9998887777', 'Texas', 'Dallas', 'Industrial', '567 Factory Rd'),
    (5, 'Retail Store', 1, 0, 'Emily White', '4445556666', 'Florida', 'Miami', 'Shopping District', '890 Main Blvd');

SELECT * FROM oms_company_address;

SELECT * FROM oms_company_address LIMIT 3;

-- Where because of the safe mode
UPDATE oms_company_address SET phone = '666-6666-8888' WHERE id >= 0;

DELETE FROM oms_company_address WHERE id = 0;