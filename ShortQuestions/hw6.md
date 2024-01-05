# Homework 6



## API Design Practice



- find the customer's payments, like credit card 1, credit card 2, paypal, ApplePay.
  - `GET /api/v1/customers/{username}/payments`
- find the customer's history orders from 10/10/2022 to 10/24/2022
  - `GET /api/v1/customers/{username}/orders?start-date="2023-9-1"&end-date="2023-9-26"`
- find the customer's delivery addresses
  - `GET /api/v1/customers/{username}/addresses`
- if I also want to get the customer's default payment and default delivery address, what kind of API(URL) should it be?
  - `GET /api/v1/customers/{username}/payments/default`
  - `GET /api/v1/customers/{username}/addresses/default`
- Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.
  - `GET https://www.youtube.com/@{username}`
  - `GET https://twitter.com/{username}`
- Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
  - fetch all blog posts: `GET /api/v1/posts`
  - find specific blog posts: `GET /api/v1/posts/{postId}`
    - `GET /api/v1/posts?user="user name"` or `GET /api/v1/posts/{username}`
    - `GET /api/v1/posts?date="2023-1-5"`
  - publish a new blog post: `POST /api/v1/posts`
  - modify a blog post: `PUT /api/v1/posts/{postId}`
  - Delete a blog post: `DELETE /api/v1/posts/{postId}`



## Database Practice



### MySQL



#### 1 Create  `oms_company_address`  table

```sql
create table oms.oms_company_address (
    id bigint not null,
    address_name varchar(200) null,
    send_status int(1) null,
    receive_status int(1) null,
    name varchar(64) null,
    phone varchar(64) null,
    province varchar(64) null,
    city varchar(64) null,
    region varchar(64) null,
    detail_address varchar(200) null,
    primary key (id)
);
```

#### 2 Insert some random data into the `oms_company_address ` table



```sql
insert into oms.oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
values (1, 'x street', 0, 0, 'abc', '123', 'CA', 'SF', 'unk', 'x st. apt 123');
```



#### 3 Write a SQL query to fetch all data from the `oms_company_address` table



```sql
select * from oms.oms_company_address;
```



#### 4 Write a SQL query to fetch the top 3 records from `oms_company_address`  table

  

```sql
select * from oms.oms_company_address limit 3;
```



#### 5 Update the `oms_company_address`  table to set all phones to 666-6666-8888



```sql
update oms.oms_company_address set phone = '666-6666-8888';
```



#### 6 Delete one entry from the `oms_company_address`  table



```sql
delete oms.oms_company_address where id = 1;
```



### MongoDB



#### 1 Create test DB



```mongodb
use test
```



#### 2 Create `oms_company_address` collection (method: createCollection() )



```mongodb
db.createCollection("oms_company_address");
```



#### 3 Insert few random entries to `oms_company_address` collection (method: insert() )



```mongodb

db.oms_company_address.insertMany([
    {id: 1, address_name: "1 st", send_status: 0, receive_status: 0, name: "1", phone: "123", province: "CA", city: "SF", region: "unk", detail_address: "1 st apt 1"},
    {id: 2, address_name: "2 st", send_status: 0, receive_status: 0, name: "2", phone: "123", province: "CA", city: "SF", region: "unk", detail_address: "2 st apt 2"}
])



db.oms_company_address.insertOne({id: 3, address_name: "3 st", send_status: 0, receive_status: 0, name: "3", phone: "123", province: "CA", city: "SF", region: "unk", detail_address: "3 st apt 3"})
```



#### 4 Read one entry from `oms_company_address collection` (method: find() )



```mongodb
db.oms_company_address.find({id:1})
db.oms_company_address.find().limit(1)
```



#### 5 Read all entries from `oms_company_address collection` (method: find() )



```mongodb
db.oms_company_address.find()
```

#### 

#### 6 Update one entry from `oms_company_address collection` (method: update() or save() )



```mongodb
db.oms_company_address.update({id: 1}, {$set: {name: "new name 1"})
```



#### 7 Remove one entry from `oms_company_address` collection (method: remove()  -> delete())



```mongodb
db.oms_company_address.deleteOne({id: 1})
```


