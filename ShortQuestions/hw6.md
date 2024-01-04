**API Design**

1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

    `customers/{user_id}/payments`

2. Find the customer’s history orders from 10/10/2022 to 10/24/2022 
    
    `customers/{user_id}/orders?start_date=10/10/2022&end_date=10/24/2022`

3. find the customer’s delievery  addresses

    `customers/{user_id}/delivery_addresses`

4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

    - `customers/{user_id}/delivery_addresses?type=default`
    - `customers/{user_id}/payments?type=default`

5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
    - Paypal
        - `https://api-m.sandbox.paypal.com/v1/invoicing/invoices?page=3&page_size=4&total_count_required=true`
    
    - Youtube
        - `https://www.googleapis.com/youtube/v3/activities`
        - `https://www.googleapis.com/youtube/v3/videos`
6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE. Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

    - GET: `blog.com/blogs`
    - GET: `blog.com/blogs/{blog_id}`
    - POST: `blog.com/blogs`
    - PUT: `blog.com/blogs/{blog_id}`
    - DELETE: `blog.com/blogs/{blog_id}`

**MySQL design**

1. 
```SQL
USE oms;
DROP TABLE IF EXISTS `oms.oms_company_address`;

CREATE TABLE oms.oms_company_address ( 
    id BigInt PRIMARY KEY, 
    address_name varchar(200), 
    send_status int(1),
    receive_status int(1),
    name varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address  varchar(200));
```

2
```SQL
INSERT INTO oms_company_address 
(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
VALUES 
(1, '123 Main St', 1, 0, 'John Doe', '555-1234', 'Province1', 'City1', 'Region1', 'Detail1');
```

3. 
```SQL
SELECT * FROM oms_company_address;
```

4. 
```SQL
SELECT * FROM oms_company_address ORDER BY id ASC LIMIT 3;
```

5. 
```SQL
UPDATE oms_company_address SET phone = '666-6666-8888';
```

6. 
```SQL
DELETE FROM oms_company_address WHERE id = 1;
```

**MongoDB design**

1. 
`db.createCollection("posts")`

1. Create testDB
    `use test`

2. Create oms_company_address collection

    `db.createCollection("testDB")`

3. Insert few random entries to oms_company_address collection (method: insert() )
    ```
    db.oms_company_address.insert([
    {
        id: 1,
        address_name: "123 Main St",
        send_status: 1,
        receive_status: 0,
        name: "John Doe",
        phone: "555-1234",
        province: "Province1",
        city: "City1",
        region: "Region1",
        detail_address: "Detail1"
    },
    {
        id: 2,
        address_name: "456 Elm St",
        send_status: 1,
        receive_status: 1,
        name: "Jane Smith",
        phone: "555-5678",
        province: "Province2",
        city: "City2",
        region: "Region2",
        detail_address: "Detail2"
    },
    ]);
    ```
4. Read one entry from oms_company_address collection (method: find() )

    `db.oms_company_address.find().limit(1);` 
5. Read all entries from oms_company_address collection (method: find() )

    `db.oms_company_address.find().limit(1);`

6. Update one entry from oms_company_address collection(method:update() or save()) 
    
    `db.oms_company_address.update({_id: 1}, {$set: {city: "LA"}});`

7. Remove one entry from oms_company_address collection (method:remove())

    `db.oms_company_address.remove({_id: 2});`
