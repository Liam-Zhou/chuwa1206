-- 1
CREATE TABLE your_table_name (
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


-- 2
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES 
(1, 'Address 1', 0, 1, 'John Doe', '123-456-7890', 'Province 1', 'City 1', 'Region 1', 'Detail Address 1'),
(2, 'Address 2', 1, 0, 'Jane Smith', '234-567-8901', 'Province 2', 'City 2', 'Region 2', 'Detail Address 2'),
(3, 'Address 3', 0, 0, 'Alice Johnson', '345-678-9012', 'Province 3', 'City 3', 'Region 3', 'Detail Address 3');

-- 3
SELECT * FROM oms_company_address;


-- 4
SELECT * FROM oms_company_address
ORDER BY id ASC
LIMIT 3;


-- 5
UPDATE oms_company_address
SET phone = '666-6666-8888';

-- 6
DELETE FROM oms_company_address
WHERE id = 1;