# hw6

## mysql practice

1. Create  oms_company_address  table

    *creat and change database*

    ```sql
    create database oms;
    use oms;
    ```

    *create table*

    ```sql
   create table oms.oms_company_address
   (
       id             bigint auto_increment
           primary key,
       address_name   varchar(200) null,
       send_status    int          null,
       receive_status int          null,
       name           varchar(64)  null,
       phone          varchar(64)  null,
       province       varchar(64)  null,
       city           varchar(64)  null,
       region         varchar(64)  null,
       detail_address varchar(200) null
   );
    ```

2. Insert some random data to  oms_company_address  table

    ```sql
    insert into oms_company_address(address_name, send_status, receive_status, name, phone, province, city, region, detail_address) values ('distribution center', 1, 1, 'jason', 6666666666, 'california', 'san jose', 'north america', 'this is a test'),
                                                                                                                                       ('distribution center', 0, 1, 'john', 6666666666, 'new york', 'new york', 'north america', 'this is a test'),
                                                                                                                                       ('distribution center', 0, 0, 'machi', 6666666666, 'texas', 'dallas', 'north america', 'this is a test'),
                                                                                                                                       ('distribution center', 1, 0, 'musle', 6666666666, 'vancouver', 'vancouver', 'north america', 'this is a test');
    ```


3. Write a SQL query to fetch all data from  oms_company_address  `table`

    ```sql
    select * from oms_company_address;
    ```

4. Write a SQL query to fetch top 3 records from  oms_company_address  table

    ```sql
    select * from oms_company_address order by id limit 3;
    ```

5. Update  oms_company_address  table to set all  phone to 666-6666-8888

    ```sql
    update oms_company_address SET phone = '666-6666-8888';
    ```

6. Delete one entry from  oms_company_address  table

    ```sql
    delete from oms_company_address where id = 2;
    ```

## MongoDB practice

Certainly! Below are MongoDB commands and queries for the steps you've outlined:

### 1. Create `test` DB:

```javascript
use test
```

### 2. Create `oms_company_address` collection:

```javascript
db.createCollection("oms_company_address")
```

### 3. Insert few random entries to `oms_company_address` collection:

```javascript
db.oms_company_address.insert([
  { name: "Company1", address: "Address1", city: "City1" },
  { name: "Company2", address: "Address2", city: "City2" },
  { name: "Company3", address: "Address3", city: "City3" }
])
```

### 4. Read one entry from `oms_company_address` collection:

```javascript
db.oms_company_address.findOne({ name: "Company1" })
```

### 5. Read all entries from `oms_company_address` collection:

```javascript
db.oms_company_address.find()
```

### 6. Update one entry from `oms_company_address` collection:

```javascript
db.oms_company_address.update({ name: "Company1" }, { $set: { city: "UpdatedCity" } })
```

OR

```javascript
db.oms_company_address.save({ name: "Company1", address: "UpdatedAddress", city: "UpdatedCity" })
```

### 7. Remove one entry from `oms_company_address` collection:

```javascript
db.oms_company_address.remove({ name: "Company1" })
```


## API Design practice

### 1. Find the customer’s payments, like credit card 1, credit card 2, PayPal, Apple Pay.

```http
GET /customers/{customerId}/payments
```

### 2. Find the customer’s history orders from 10/10/2022 to 10/24/2022.

```http
GET /customers/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24
```

### 3. Find the customer’s delivery addresses.

```http
GET /customers/{customerId}/addresses
```

### 4. If I also want to get customer’s default payment and default delivery address, what kind of the API (URL) should be?

```http
GET /customers/{customerId}/defaults
```

### 5. Find 2 collections of APIs examples (naming conventions):

- **Twitter:**
  - Tweets: `/tweets`
  - Users: `/users`
  - Followers: `/users/{userId}/followers`
  - Likes: `/tweets/{tweetId}/likes`

- **PayPal:**
  - Transactions: `/transactions`
  - Accounts: `/accounts`
  - Invoices: `/invoices`
  - Payouts: `/payouts`

### 6. Design a collection of APIs for a Blog Website (GET, POST, PUT, DELETE):

- **Posts:**
  - `GET /posts`: Retrieve all posts.
  - `GET /posts/{postId}`: Retrieve a specific post.
  - `POST /posts`: Create a new post.
  - `PUT /posts/{postId}`: Update a specific post.
  - `DELETE /posts/{postId}`: Delete a specific post.

- **Comments:**
  - `GET /posts/{postId}/comments`: Retrieve all comments for a post.
  - `GET /posts/{postId}/comments/{commentId}`: Retrieve a specific comment.
  - `POST /posts/{postId}/comments`: Add a new comment to a post.
  - `PUT /posts/{postId}/comments/{commentId}`: Update a specific comment.
  - `DELETE /posts/{postId}/comments/{commentId}`: Delete a specific comment.

- **Categories:**
  - `GET /categories`: Retrieve all categories.
  - `GET /categories/{categoryId}`: Retrieve a specific category.
  - `POST /categories`: Create a new category.
  - `PUT /categories/{categoryId}`: Update a specific category.
  - `DELETE /categories/{categoryId}`: Delete a specific category.
