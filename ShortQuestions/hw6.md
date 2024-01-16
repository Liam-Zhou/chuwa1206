## HW6 
#### API Design
1. Find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
**GET customers/{id}/payments**
2. Find the customer’s history orders from 10/10/2022 to 10/24/2022
**GET customers/{id}/order-history?from="2022-10-10"&to="2022-10-24"**
3. find the customer’s delivery addresses
**GET customers/{id}/addresses**
4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?
**GET customers/{id}/payments?type=default**
5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
Paypal APIs:
    ```
    1. Create orders
    POST api-m.paypal.com/v2/checkout/orders

    2. Show order details
    GET api-m.paypal.com/v2/checkout/orders/{id}

    3. Update order
    PATCH api-m.paypal.com/v2/checkout/orders/{id}

    4. Confirm the order
    POST api-m.paypal.com/v2/checkout/orders/{id}/confirm-payment-source

    5. Authorize payment for order
    POST api-m.paypal.com/v2/checkout/orders/{id}/authorize

    6. Capture payment for order
    POST api-m.paypal.com/v2/checkout/orders/{id}/capture

    7. Add tracking information for an Order
    POST api-m.paypal.com/v2/checkout/orders/{id}/track

    8. Update or cancel tracking information for a PayPal order
    PATCH api-m.paypal.com/v2/checkout/orders/{id}/trackers/{tracker_id}
    ```
    Youtube APIs:
    ```
    1. Deletes the specified caption track
    DELECT www.googleapis.com/youtube/v3/captions

    2. Downloads a caption track
    GET www.googleapis.com/youtube/v3/captions/{id}

    3. Uploads a caption track
    POST www.googleapis.com/youtube/v3/captions

    4. Returns a list of caption tracks that are associated with a specified video
    GET www.googleapis.com/youtube/v3/captions

    5. Updates a caption track.
    PUT www.googleapis.com/youtube/v3/captions
    ```
6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
    ```
    1. Create a blog
    POST users/{id}/blogs

    2. Return a list of blogs
    GET users/{id}/blogs

    3. Return a blog
    GET users/{id}/blogs/{blog-id}

    4. Return a list of blogs, filtered by creation date
    GET users/{id}/blogs?from=&to=

    5. Update a blog
    PUT users/{id}/blogs/{blog-id}

    6. Delete a blog
    DELETE users/{id}/blogs/{blog-id}
    ```

#### MySQL practice
1.  Create oms_company_address table 
```SQL
CREATE TABLE oms_company_address(
id bigint AUTO_INCREMENT PRIMARY KEY, 
address_name varchar(200), 
send_status int(1), 
receive_status int(1), 
name varchar(64), 
phone varchar(64), 
province varchar(64), 
city varchar(64), 
region varchar(64), 
detail_address varchar(200));
```
2.  Insert some random data to oms_company_address table
```SQL
INSERT INTO oms_company_address(address_name, send_status, receive_status, phone, name, province, city)
VALUES("1st St", 1,1,"123456","A", "WA", "Seattle"),
("2st St", 1,0,"00000000","B", "CA", "San Jose");
```
3.  Write a SQL query to fetch all data from oms_company_address table
```SQL
SELECT * FROM oms_company_address;
```
4.  Write a SQL query to fetch top 3 records from oms_company_address table 
```SQL
SELECT * FROM oms_company_address LIMIT 3;
```
5.  Update oms_company_address table to set all phone to 666-6666-8888
```SQL
SET SQL_SAFE_UPDATES = 0;
UPDATE oms_company_address SET phone = "666-6666-888";
SET SQL_SAFE_UPDATES = 1;
```
6.  Delete one entry from oms_company_address table
```SQL
DELETE FROM oms_company_address WHERE id = 1;
```

#### Mongodb practice
1.  Create test DB 
```SQL
use test
```
2.  Create oms_company_address collection (method: createCollection() )
```SQL
db.createCollection("oms_company_address")
```

3.  Insert few random entries to oms_company_address collection (method: insert() )
```SQL
db.test.insertMany(
    [
        {_id: 1, address_name :"address 1", send_status:1, receive_status:1, name:"qq", phone:"123", provice:"WA", city:"Seattle", region:"Unknown"},
        {_id: 2, address_name :"address 2", send_status:1, receive_status:1, name:"qq", phone:"123", provice:"WA", city:"Seattle"}
    ])
```
4.  Read one entry from oms_company_address collection (method: find() )
```SQL
db.test.findOne({address_name :"address 1"})
```
5.  Read all entries from  oms_company_address collection (method: find() )
```SQL
db.test.find()
```
6.  Update one entry from oms_company_address collection (method: update() or save() )
```SQL
db.test.update(
   { _id: 1 },
   {
     $set: {
       name: "S",
       send_status: 0
     }
   }
)
```
7.  Remove one entry from oms_company_address collection (method: remove())
```SQL
db.test.remove({name: "S"})
```