## API Design
# 1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
GET /api/v1/customer/{id}/payments
# 2. Find the customer’s history orders from 10/10/2022 to 10/24/2022
GET /api/v1/customer/{id}/order-history?start-date=10-10-2022&end-date=10-24-2022

# 3. find the customer’s delievery  addresses
GET /api/v1/customer/{id}/address

# 4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?
GET /api/v1/customer/{id}/payments/default
GET /api/v1/customer/{id}/address/default

# 5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
**Twitter**
1. Curate a collection of Tweets
- GET collections/entries
- GET collections/list
- GET collections/show
- POST collections/entries/curate
- POST collections/entries/remove
- POST collections/create
- POST collections/destroy
- POST collections/entries/add
- POST collections/entries/move
- POST collections/update

2. Filter realtime Tweets
- POST statuses/filter

3. Post, retrieve, and engage with Tweets
- GET favorites/list
- GET statuses/lookup
- GET statuses/oembed
- GET statuses/retweeters/ids
- GET statuses/retweets/:id
- GET statuses/retweets_of_me
- GET statuses/show/:id
- POST statuses/update_with_media (deprecated)
- POST favorites/create
- POST favorites/destroy
- POST statuses/destroy/:id
- POST statuses/retweet/:id
- POST statuses/unretweet/:id
- POST statuses/update

**Youtube**
- GET /activities
- POST /activities
- GET /captions/{id}
- GET /channelSections
- POST /channelSections	
- PUT /channelSections	
- DELETE /channelSections

# 6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
1. Blog Posts
- GET /posts: get a list of all blog posts
- GET /posts/{postId}: get a specific post
- POST /posts: create a post
- PUT /posts/{postId}: update a post
- DELETE /posts/{postId}: delete a post

2. Comments
- GET /posts/{postId}/comments: get all comments for a specific post
- POST /posts/{postId}/comments: create a new comment to a post
- PUT /comments/{commentId}: update a comment
- DELETE /comments/{commentId}: delete a comment

3. Users
- GET /users: get all users
- GET /users/{userId}: get a specific user
- POST /users: create a user
- PUT /users/{userId}: update user info
- DELETE /users/{userId}: delete a user

## DB practice
# mySQL
# 1. Create oms_company_address table
```
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

# 2. Insert some random data to oms_company_address table
```
INSERT INTO oms_company_address (id, address_name, send_statue, receive_status, name, phone, province, city, region, detail_address) 
VALUES 
    (1, '1 street', 1, 0, 'a', '111', 'a', 'aa', 'aaa', '123123'),
    (2, '2 street', 0, 0, 'b', '222', 'b', 'bb', 'bbb', '234234'),
    (3, '3 street', 1, 1, 'c', '333', 'c', 'cc', 'ccc', '345345'),
    (4, '4 street', 0, 1, 'd', '444', 'd', 'dd', 'ddd', '456456');
```
# 3. Write a SQL query to fetch all data from oms_company_address table
```
SELECT * FROM oms_company_address;
```
# 4. Write a SQL query to fetch top 3 records from oms_company_address table 
```
SELECT * FROM oms_company_address
LIMIT 3;
```
# 5. Update oms_company_address table to set all phone to 666-6666-8888
```
UPDATE oms_company_address
SET phone = '666-6666-8888';
```
# 6. Delete one entry from oms_company_address table
```
DELETE FROM oms_company_address
WHERE id = 1;
```
# MangoDB
# 1. Create test DB 
```
CREATE DATABASE test
```
# 2. Create oms_company_address  collection  (method: createCollection() )
```
db.createCollection("oms_company_address);
```
# 3. Insert few random entries to  oms_company_address  collection (method: insert() )
```
db.oms_company_address.insertMany([
    {
        company_id: 1,
        street_address: "1 street",
        city: "a",
        state_province: "aa",
        postal_code: "11111",
        country: "USA",
        is_primary_address: true
    },
    {
        company_id: 2,
        street_address: "2 street",
        city: "b",
        state_province: "bb",
        postal_code: "22222",
        country: "USA",
        is_primary_address: true
    }
```
# 4. Read one entry from  oms_company_address  collection (method: find() )
```
db.oms_company_address.findOne({company_id: 1});
```
# 5. Read all entries from  oms_company_address  collection (method: find() )
```
db.oms_company_address.find();
```
# 6. Update one entry from  oms_company_address collection (method: update() or save() )
```
db.oms_company_address.updateOne({company_id: 1},
{
$ set: {
street_address: "1 road"}
}
);
```
# 7. Remove one entry from  oms_company_address collection (method: remove() )
```
db.oms_company_address.deleteOne({company_id: 1});
```
