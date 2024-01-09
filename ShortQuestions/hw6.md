### API Design

> **find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.**
>
> GET /api/customers/{customerId}/payments
>
> **Find the customer’s history orders from 10/10/2022 to 10/24/2022**
>
> GET /api/customers/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24
>
> **find the customer’s delievery  addresses**
>
> GET /api/customers/{customerId}/addresses
>
> **If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?**
>
> GET /api/customers/{customerId}/payments?type=default
>
> GET /api/customers/{customerId}/addresses?type=default

### Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范

> **Youtube**
>
> /feed/subscriptions
>
> /feed/you
>
> /shorts/{id}
>
> **Netflix**
>
> /browse/genre/{genreId}
>
> /browse/my-list
>
> /search?q={}
>
> 

### Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

> GET /api/posts
>
> POST /api/posts
>
> PUT /api/posts/{postId}
>
> DELETE /api/posts/{postId}
>
> GET /api/posts/{postId}/comments
>
> PUT /api/posts/{postId}/comments/{commentId}
>
> DELETE /api/posts/{postId}/comments/{commentId}

### SQL Exercise

> Create oms_company_address table
>
>```sql
>CREATE TABLE oms_company_address (
>    id BIGINT PRIMARY KEY,
>    address_name VARCHAR(200),
>    send_status INT(1),
>    receive_status INT(1),
>    name VARCHAR(64),
>    phone VARCHAR(64),
>    province VARCHAR(64),
>    city VARCHAR(64),
>    region VARCHAR(64),
>    detail_address VARCHAR(200)
>);
>
>```
>
> Insert some random data to oms_company_address table
>
>```sql
>INSERT INTO oms_company_address (id, address_name, send_status, receive_status,name,phone,province,city,region,detail_address) VALUES
>(1, Green St, 1,0, apple,333-333-3333,Beijing,beijing,North, 245 Green St )
>```
>
>Write a SQL query to fetch all data from oms_company_address `table
>
>```sql
>SELECT * FROM oms_company_address;
>```
>
>Write a SQL query to fetch top 3 records from oms_company_address table
>
>```sql
>SELECT * FROM oms_company_address LIMIT 3;
>```
>
>Update oms_company_address table to set all phone to 666-6666-8888
>
>```sql
>UPDATE oms_company_address SET phone = '666-6666-8888';
>```
>
>Delete one entry from oms_company_address table
>
>```sql
>DELETE FROM oms_company_address
>WHERE id = 1
>```
>
>

### NoSQL Exercise

>  Create test DB
>
> ```
> use test
> ```
>
>  Create oms_company_address collection (method: createCollection() 
>
> ```
> db.createCollection("oms_company_address")
> ```
>
> Insert few random entries to oms_company_address collection (method: insert() )
>
> ```
> db.oms_company_address.insert([  {
>     company_name: "Company A",
>     street: "123 Main Street",
>     city: "City A",
>     country: "Country A",
>     postal_code: "12345",
>   },
>   {
>     company_name: "Company B",
>     street: "456 Oak Avenue",
>     city: "City B",
>     country: "Country B",
>     postal_code: "67890",
>   },
>   {
>     company_name: "Company C",
>     street: "789 Pine Lane",
>     city: "City C",
>     country: "Country C",
>     postal_code: "54321",
>   }]);
> ```
>
> Read one entry from oms_company_address collection (method: find() )
>
> ```
> db.oms_company_address.findOne()
> ```
>
>  Read all entries from oms_company_address collection (method: find() )
>
> ```
> db.oms_company_address.find()
> ```
>
> Update one entry from oms_company_address collection (method: update() or save() )
>
> ```'
> db.oms_company_address.updateOne{
> { company_name: "Company A",
> {
> 	$set: {
> 		city: "update City A"
> 	}
> }
> }
> }
> ```
>
> Remove one entry from oms_company_address collection (method: remove() )
>
> ```
> db.oms_company_address.deleteOne({ id: 1 });
> ```
>
> 