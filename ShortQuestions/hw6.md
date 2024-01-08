# HW6 API Design

1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

   `GET /customer/{id}/profile/payment-method`

2. Find the customer’s history orders from 10/10/2022 to 10/24/2022

   `GET /customer/{id}/orders?startdate=2022-10-10&enddate=2022-10-24`

3. find the customer’s delievery addresses

   `GET /customer/{id}/profile/delivery-address`

4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

   `GET /customer/{id}/profile/delivery-address?default=true`

5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范

   ```
   GET https://www.googleapis.com/youtube/v3/activities
   GET https://www.googleapis.com/youtube/v3/captions
   GET https://www.googleapis.com/youtube/v3/channels
   ```

   

6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)





## SQL

``` sql
create table `oms_company_address`(
	id bigint primary key,
    address_name varchar(200),
    send_status int1,
    receive_status int1,
    name VARCHAR(64),
    phone VARCHAR(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address varchar(200)
);

INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES 
(2, 'Branch Office', 1, 0, 'Jane Smith', '555-5678', 'AnotherProvince', 'AnotherCity', 'AnotherRegion', '4321 Secondary St, Suite 202'),
(3, 'Warehouse', 1, 1, 'Mike Johnson', '555-8765', 'ThirdProvince', 'ThirdCity', 'ThirdRegion', '789 Industrial Rd, Dock 10'),
(4, 'Outlet', 0, 1, 'Emily Davis', '555-4321', 'FourthProvince', 'FourthCity', 'FourthRegion', '678 Market Sq, Shop 5');
-- fetch all data
SELECT * FROM oms_company_address;


INSERT ignore INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES 
(2, 'Branch Office', 1, 0, 'Jane Smith', '555-5678', 'AnotherProvince', 'AnotherCity', 'AnotherRegion', '4321 Secondary St, Suite 202'),
(3, 'Warehouse', 1, 1, 'Mike Johnson', '555-8765', 'ThirdProvince', 'ThirdCity', 'ThirdRegion', '789 Industrial Rd, Dock 10'),
(4, 'Outlet', 0, 1, 'Emily Davis', '555-4321', 'FourthProvince', 'FourthCity', 'FourthRegion', '678 Market Sq, Shop 5'),
(11, 'Office oxeGk', 0, 0, 'qhwhwlvoYf', '935-475-2756', 'JWbSrZiEQl', 'tGCjHkAuEA', 'rYTVjzhJqN', '8037 SVBJy St'),
(12, 'Office kMPyB', 1, 0, 'rpvAMjZrGK', '245-106-3528', 'jYbURFVvyK', 'fLCSqRoiKd', 'IwNsqJszVM', '7884 dxnQW St'),
(13, 'Warehouse PRdhq', 0, 1, 'eWpaHVpzUX', '747-428-8216', 'UoTgvoZpxQ', 'ZGbsZVeYRq', 'LFGkYgWTdN', '5803 FWDeB St');

-- fetch top 3
select * from `oms_company_address` order by id limit 3;

-- chagne all phone
update oms_company_address
set phone = 666-6666-8888
where id is not null; -- can not use without where keyword in safe update mode

-- delete one entry
delete from oms_company_address where id > 0 and address_name like '%warehouse%';

select * from oms_company_address;

SHOW FULL COLUMNS FROM oms_company_address; -- _ci means case insensitive and -cs otherwise
```

