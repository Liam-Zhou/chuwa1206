## API Design
### 1
GET/api/v1/customers/{customer_id}/payments
### 2
/customer/{id}/orders?startDate=10/10/2020&endDate=10/24/2022
### 3
GET customer/{userID}/delivery-addresses
### 4
GET/api/v1/customers/{customer_id}/payments?type=default
### 5
PayPal
- create: POST /v1/payments/payment
- execute: POST /v1/payments/payment/{paymentId}/execute
- refund: POST /v1/payments/sale/{saleId}/refund

YouTube
- search: GET /youtube/v3/search
- details: GET /youtube/v3/videos
- upload: POST /youtube/v3/videos
### 6
- Get all/specific blog post
  - GET /api/posts
  - GET /api/posts/{postId}
- Create
  - POST /api/posts
- Update
  - PUT /api/posts/{postId}
- Delete
  - DELETE /api/posts/{postId}
- Get comments
  - GET /api/posts/{postId}/comments
- Delete
  - DELETE /api/posts/{postId}/comments/{commentId}

## MySQL
### 1
```sql
CREATE TABLE oms_company_address (
  `id` INT PRIMARY KEY AUTO_INCREMENT, 
  `address_name` VARCHAR(200), 
  `send_status` INT(1),
  `receive_status` INT(1),
  `name` VARCHAR(64),
  `phone` VARCHAR(64),
  `city` VARCHAR(64),
  `region` VARCHAR(64),
  `detail_address` VARCHAR(200)
);
```
### 2
```sql
INSERT INTO oms_company_address (id, address_name, send_statue, receive_status, name, phone, province, city, region, detail_address) 
VALUES 
    (1, '123 street', 1, 0, 'a', '123', 'p', 'c', 'ac', '1132A'),
    (2, '231 ave', 0, 0, 'b', '434', 'd', 'r', 'er', '3412c'),
    (3, '543 dr', 1, 1, 'd', '556', 'w', 'e', 's', '0078E'),
    (4, '976 se', 0, 1, 's', '996', 'e', 'l', 'e', '237e');
```
### 3
```sql
SELECT * FROM oms_company_address;
```
### 4
```sql
SELECT * FROM oms_company_address
LIMIT 3;
```
### 5
```sql
UPDATE oms_company_address
SET phone = '666-6666-8888';
```
### 6
```sql
DELETE FROM oms_company_address
WHERE id = 4;
```

## MongoDB
### 1
```
CREATE DATABASE test
```
### 2
```
db.createCollection("oms_company_address);
```
### 3
```
db.oms_company_address.insertMany([
    {
        company_id: 1,
        street_address: "123 Main St",
        city: "Anytown",
        state_province: "CA",
        postal_code: "12345",
        country: "USA",
        is_primary_address: true
    },
    {
        company_id: 2,
        street_address: "456 Oak Ave",
        city: "Sometown",
        state_province: "NY",
        postal_code: "54321",
        country: "USA",
        is_primary_address: true
    },
    {
        company_id: 1,
        street_address: "789 Pine Blvd",
        city: "Othercity",
        state_province: "TX",
        postal_code: "67890",
        country: "USA",
        is_primary_address: false
    },
    {
        company_id: 3,
        street_address: "101 Elm St",
        city: "Anothercity",
        state_province: "FL",
        postal_code: "98765",
        country: "USA",
        is_primary_address: true
    }
]);
```
### 4
```
db.oms_company_address.findOne({company_id: 2});
```
### 5
```
db.oms_company_address.find();
```
### 6
```
db.oms_company_address.updateOne({company_id: 1},
{
$ set: {
street_address: "1123 AVE",
city: "Banana"}
}
);
```
### 7
```
db.oms_company_address.deleteOne({company_id: 1});
```