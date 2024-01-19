# hw6: DB Practice

### MySQL

```sql
-- Exercise 1: Create testDB
CREATE DATABASE testDB;

USE testDB;

-- Exercise 2: Create oms_company_address table
CREATE TABLE oms_company_address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
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

-- Exercise 3: Insert some random data to oms_company_address table
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
VALUES ('Main Office', 1, 0, 'John Doe', '123-456-7890', 'State', 'City', 'Region', '123 Main St');

-- Exercise 4: Write a SQL query to fetch all data from oms_company_address table
SELECT * FROM oms_company_address;

-- Exercise 5: Write a SQL query to fetch top 3 records from oms_company_address table
SELECT * FROM oms_company_address LIMIT 3;

-- Exercise 6: Update oms_company_address table to set all phone to 666-6666-8888
UPDATE oms_company_address SET phone = '666-6666-8888';

-- Exercise 7: Delete one entry from oms_company_address table
DELETE FROM oms_company_address WHERE id = 1; -- Assuming you want to delete the entry with id = 1

-- Exercise 8: (Optional) Create another table oms_order
CREATE TABLE oms_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
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
    bill_type INT,
    receiver_name VARCHAR(100),
    receiver_phone VARCHAR(100),
    receiver_post_code VARCHAR(20),
    receiver_province VARCHAR(100),
    receiver_city VARCHAR(100),
    receiver_region VARCHAR(100),
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
```

### MongoDB(NoSQL)

```sql
-- Exercise 1: Create test DB
use testDB;

-- Exercise 2: Create oms_company_address collection
db.createCollection("oms_company_address");

-- Exercise 3: Insert few random entries to oms_company_address collection
db.oms_company_address.insert({
    "address_name": "Main Office",
    "send_status": 1,
    "receive_status": 0,
    "name": "John Doe",
    "phone": "123-456-7890",
    "province": "State",
    "city": "City",
    "region": "Region",
    "detail_address": "123 Main St"
});

-- Exercise 4: Read one entry from oms_company_address collection
db.oms_company_address.find().limit(1);

-- Exercise 5: Read all entries from oms_company_address collection
db.oms_company_address.find({});

-- Exercise 6: Update one entry from oms_company_address collection
db.oms_company_address.update(
    { "name": "John Doe" },
    { $set: { "phone": "666-6666-8888" }}
);

-- Exercise 7: Remove one entry from oms_company_address collection
db.oms_company_address.remove({ "name": "John Doe" });

-- Exercise 8: (Optional) Create another collection oms_order
db.createCollection("oms_order");
db.oms_order.insert({
    "member_id": 12345,
    "order_sn": "A123456789",
    "create_time": new Date(),
    "member_username": "johndoe",
    "total_amount": 100.00,
    "pay_amount": 100.00,
    "freight_amount": 5.00,
    "pay_type": 1,
    "source_type": 1,
    "status": 1,
    "order_type": 1,
    "delivery_company": "DeliveryCo",
    "delivery_sn": "D123456789",
    "auto_confirm_day": 7,
    "bill_type": 1,
    "receiver_name": "John Doe",
    "receiver_phone": "123-456-7890",
    "receiver_post_code": "123456",
    "receiver_province": "State",
    "receiver_city": "City",
    "receiver_region": "Region",
    "receiver_detail_address": "123 Main St",
    "note": "Urgent",
    "confirm_status": 1,
    "delete_status": 0,
    "payment_time": new Date(),
    "delivery_time": new Date(),
    "receive_time": new Date(),
    "comment_time": new Date(),
    "modify_time": new Date()
});
```
