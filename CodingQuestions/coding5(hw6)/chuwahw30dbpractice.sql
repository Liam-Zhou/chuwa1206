CREATE DATABASE IF NOT EXISTS test;
USE test;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE IF NOT EXISTS oms_company_address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
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
INSERT INTO oms_company_address
	(address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
	('ADD1', 1, 1, 'chuwa1', '123', 'p1', 'c1', 'r1', 'add1'),
    ('ADD2', 1, 1, 'chuwa2', '123', 'p2', 'c2', 'r2', 'add2');
    
SELECT * FROM oms_company_address WHERE address_name = 'ADD1';
SELECT * FROM oms_company_address;

UPDATE oms_company_address SET phone = '555' WHERE id = 1;
DELETE FROM oms_company_address WHERE address_name = 'ADD2';
SELECT * FROM oms_company_address;

SELECT * FROM oms_company_address;

