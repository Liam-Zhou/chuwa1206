# HW6

## 1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

```
GET api/customers/{customer_id}/payments
```

## 2. Find the customer’s history orders from 10/10/2022 to 10/24/2022

```
GET api/customers/{customer_id}/orders?startDate=2022-10-10&endDate=2022-10-24
```

## 3. find the customer’s delivery address

```
GET api/customers/{customer_id}/delivery-address
```

## 4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

```
GET api/customers/{customer_id}/payments/default
```

## 5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.

PayPal Payment

```
// Create payment
POST /v1/payments/payment

// List payments
GET /v1/payments/payment

// Show payment details
GET /v1/payments/payment/{payment_id}

// Partially upate payment
PATCH /v1/payments/payment/{paymenyt_id}
```

PayPal Orders

```
// Create order
POST /v1/checkout/orders

// Show order details
GET /v1/checkout/orders/{order_id}

// Cancel order
DELETE /v1/checkout/orders/{order_id}

// Pay for order
POST /v1/checkout/orders/{order_id}/pay
```

## 6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

1. Retrieve All Blog Posts

```
GET api/posts
```

2. Retrieve a Single Blog Post

```
GET api/posts/{post_id}
```

3. Create a New Blog Post

```
POST api/posts
```

4. Update an Existing Blog Post

```
PUT api/posts/{post_id}
```

5. Delete a Blog Post

```
DELETE api/posts/{post_id}
```

## 7. DataBase Exercise

### MySQL

1. Create oms_company_address table

```sql
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

2.  Insert some random data to oms_company_address table

```sql
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES
(1, 'Main Office', 0, 1, 'John Doe', '123-456-7890', 'Guangdong', 'Shenzhen', 'Nanshan', 'Technology Park'),
(2, 'Branch Office', 1, 0, 'Jane Smith', '098-765-4321', 'Zhejiang', 'Hangzhou', 'Xihu', 'West Lake Ave'),
(3, 'Warehouse', 0, 1, 'Mike Chen', '456-789-0123', 'Jiangsu', 'Nanjing', 'Jianye', 'Longemont YESDZ'),
(4, 'Distribution Center', 1, 1, 'Lily Zhang', '789-012-3456', 'Shanghai', 'Shanghai', 'Pudong', 'Century Avenue'),
(5, 'Sales Office', 0, 0, 'Wang Wei', '321-654-0987', 'Beijing', 'Beijing', 'Chaoyang', 'Olympic Park');
```

3. Write a SQL query to fetch all data from oms_company_addres  table

```sql
SELECT * FROM oms_company_address;
```

4. Write a SQL query to fetch top 3 records from  oms_company_address  table

```sql
SELECT * FROM oms_company_address ORDER BY id ASC LIMIT 3;
```

5.  Update  oms_company_address  table to set all  phone to 666-6666-8888

```sql
UPDATE oms_company_address SET phone = '666-6666-8888';
```

6. Delete one entry from  oms_company_address  table

```sql
DELETE FROM oms_company_address WHERE id = 1;
```

### MongoDB

1. Create oms_company_address table

   ```
   db.createCollection("oms_company_address")
   ```

2.  Insert some random data to oms_company_address table

   ```
   db.oms_company_address.insertMany([
     { _id: 1, address_name: 'Main Office', send_status: 0, receive_status: 1, name: 'John Doe', phone: '123-456-7890', province: 'Guangdong', city: 'Shenzhen', region: 'Nanshan', detail_address: 'Technology Park' },
     { _id: 2, address_name: 'Branch Office', send_status: 1, receive_status: 0, name: 'Jane Smith', phone: '098-765-4321', province: 'Zhejiang', city: 'Hangzhou', region: 'Xihu', detail_address: 'West Lake Ave' },
   ])
   ```

3. Write a SQL query to fetch all data from oms_company_addres  table

   ```
   db.oms_company_address.find({})
   ```

4. Write a SQL query to fetch top 3 records from  oms_company_address  table

   ```
   db.oms_company_address.find({}).limit(3)
   ```

5.  Update  oms_company_address  table to set all  phone to 666-6666-8888

   ```
   db.oms_company_address.updateMany(
     {}, 
     { $set: { phone: '666-6666-8888' } }
   )
   ```

6. Delete one entry from  oms_company_address  table

   ```
   db.oms_company_address.deleteOne({ _id: 1 })
   ```