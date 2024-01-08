USE test;

SELECT * 
FROM oms_company_address;

SELECT * 
FROM oms_company_address LIMIT 3;

UPDATE oms_company_address
SET phone = '666-6666-8888';

DELETE 
FROM oms_company_address
WHERE id = 1;

