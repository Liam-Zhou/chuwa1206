# HW6

## Q1 find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
```
GET /api/v1/customers/{customer_id}/payments
```

## Q2 Find the customer's history orders from 10/10/2022 to 10/24/2022

```
GET /api/v1/customers/{customerID}/orders?startDate=2022-10-10&endDate=2020-10-24
```

## Q3 find the customer’s delievery  addresses

```
GET /api/v1/custermers/{customer_id}/addresses
```

## Q4 If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

```
GET /api/v1/custermers/{customer_id}/payments/default
```

## Q5 Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范

Youtube
```
youtube.com/feed/you

youtube.com/account_notifications

youtube.com/feed/courses
```


Paypal

```
paypal.com/myaccount/summary

paypal.com/myaccount/savings

paypal.com/myaccount/transfer/homepage
```

## Q6 Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

List all posts
```
GET /api/v1/posts
```

Create a new post

```
POST /api/v1/posts
```

Get a specific post

```
GET /api/v1/posts/{post_id}
```

Update a post

```
PUT /api/v1/posts/{post_id}
```


Delete a post

```
DELETE /api/v1/posts/{post_id}
```

## SQL

### Q1 Create oms_company_address table

```
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

```

### Q2 Insert some random data to oms_company_address table

```
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES
(1, 'Main Warehouse', 1, 0, 'Jackson', '123-456-7890', 'California', 'Los Angeles', 'Westside', '1 Blvd'),
(2, 'Secondary Warehouse', 0, 1, 'Tim', '234-567-9011', 'New York', 'New York', 'Eastside', '2 Blvd'),
(3, 'Remote Office', 0, 0, 'Alice', '987-654-3210', 'Texas', 'Dallas', 'Northside', '3 Blvd'),
(4, 'Distribution Center', 0, 0, 'Mary', '111-222-3333', 'Illinois', 'Chicago', 'Southside', '4 Blvd');
```

### Q3 Write a SQL query to fetch all data from oms_company_address table

```
SELECT * FROM oms_company_address;
```

### Q4 Write a SQL query to fetch top 3 records from oms_company_address table

```
SELECT * FROM oms_company_address LIMIT 3;
```

### Q5 Update oms_company_address table to set all phone to 666-6666-8888

```
UPDATE oms_company_address SET phone = '666-6666-8888';
```

### Q6 Delete one entry from oms_company_address table

```
DELETE FROM oms_company_address WHERE id = 1;
```

## MongoDB

### Q1 Create test DB

```
use test;
```

### Q2 Create oms_company_address collection

```
db.createCollection("oms_company_address");

```


### Q3 Insert few random entries to oms_company_address collection

```
db.oms_company_address.insertMany([
    {
        id: 1,
        address_name: "Main Warehouse",
        send_status: 1,
        receive_status: 0,
        name: "Jackson",
        phone: "123-456-7890",
        province: "California",
        city: "Los Angeles",
        region: "Westside",
        detail_address: "1 Blvd"
    },
    {
        id: 2,
        address_name: "Secondary Warehouse",
        send_status: 0,
        receive_status: 1,
        name: "Tim",
        phone: "234-567-9011",
        province: "New York",
        city: "New York",
        region: "Eastside",
        detail_address: "2 Blvd"
    },
    {
        id: 3,
        address_name: "Remote Office",
        send_status: 0,
        receive_status: 0,
        name: "Alice",
        phone: "987-654-3210",
        province: "Texas",
        city: "Dallas",
        region: "Northside",
        detail_address: "3 Blvd"
    },
    {
        id: 4,
        address_name: "Distribution Center",
        send_status: 0,
        receive_status: 0,
        name: "Mary",
        phone: "111-222-3333",
        province: "Illinois",
        city: "Chicago",
        region: "Southside",
        detail_address: "4 Blvd"
    }
]);

```

### Q4 Read one entry from oms_company_address collection

```
db.oms_company_address.findOne();
```

### Q5 Read all entries from oms_company_address collection

```
db.oms_company_address.find();
```


### Q6  Update one entry from oms_company_address collection


```
db.oms_company_address.update(
    { id: 1 },
    { $set: { phone: "666-6666-8888" } }
);

```

### Q7 Remove one entry from oms_company_address collection

```
db.oms_company_address.deleteOne({ id: 1 });
```


