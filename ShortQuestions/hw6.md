### 1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay
GET /api/v1/customer/{id}/payments
### 2. Find the customer’s history orders from 10/10/2022 to 10/24/2022
GET /api/v1/customer/{id}/orders?startDate=10/10/2022&endDate=10/24/2022
### 3. find the customer’s delievery  addresses
GET /api/v1/costomer/{id}/address
### 4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?
GET /api/v1/customers/{id}/payments/default

GET /api/v1/customers/{id}/addresses/default
### 5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc
youtube.com/playlist?list=WL

youtube.com/feed/history

youtube.com/feed/you

youtube.com/account

### 6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
GET /api/v1/posts/{id}

GET /api/v1/profiles/{id}

POST /api/v1/posts

PUT /api/v1/posts/{id}

DELETE /api/v1/posts/{id}

### 1.
```
CREATE TABLE oms_company_address(
id bigint primary key,
address_name varchar(200),
send_status int(1),
receive_status int(1),
name varchar(64),
phone varchar(64),
province varchar(64),
city varchar(64),
region varchar(64),
detail_address(200)
);
```
### 2.
```
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES (1, 'us', 0, 0, 'Amy', '123-456-7890', 'WA', 'Seattle',  'downtown', '3rd Avenue');
```
### 3. 
```
SELECT * FROM oms_company_address;
```
### 4. 
```
SELECT * FROM oms_company_address LIMIT 3;
```
### 5.
```
UPDATE oms_company_address SET phone = '666-6666-8888';
```
### 6.
```
DELETE FROM oms_company_address
WHERE id = 1;
```

### 1.
```
use test
```
### 2.
```
db.createCollection("oms_company_address")
```
### 3.
```
db.oms_company_address.insert({
    id: 1,
    address_name: "us",
    send_status: 0,
    receive_status: 0,
    name: "Bob",
    phone: "987-654-3210",
    province: "wa",
    city: "Seattle",
    region: "downtown",
    detail_address: "4th Avenue"
})
```
### 4.
```
db.oms_company_address.findOne()
```
### 5.
```
db.oms_company_address.find()
```
### 6.
```
db.oms_company_address.updateOne({id: 1}, {$set: {name: "Tom"}})
```
### 7.
```
db.oms_company_address.remove({id: 1})
```