Drop table if exists oms_company_address;

CREATE TABLE oms_company_address (
    company_id INT PRIMARY KEY,
    company_name VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(15)
);

INSERT INTO oms_company_address (company_id, company_name, address, phone)
VALUES
    (1, 'Company A', '123 Main St', '555-1234-5678'),
    (2, 'Company B', '456 WestLake St', '555-9876-5432'),
    (3, 'Company C', '789 Pine St', '555-1111-2222');
-- Add more rows as needed

-- fetch all data
SELECT * FROM oms_company_address;

-- fetch top 3 records
SELECT * FROM oms_company_address LIMIT 3;

-- update table to set all phone numbers to 666-6666-8888
UPDATE oms_company_address SET phone = '666-6666-8888';

-- delete one row with id = 1
DELETE FROM oms_company_address WHERE company_id = 1 LIMIT 1;
