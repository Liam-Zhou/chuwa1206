### API Design

#### 1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
````
   GET /api/v1/customers/{customer_id}/payments
````
#### 2. Find the customer’s history orders from 10/10/2022 to 10/24/2022
````
   GET /api/v1/customers/{customer_id}/orders?startDate=20221010&endDate=20221024
````
#### 3. find the customer’s delivery addresses
````
   GET /api/v1/customers/{customer_id}/delivery-addresses
````
#### 4. If I also want to get customer’s default payment and default delivery address, what kind of the API (URL) should be?
````
   GET /api/v1/customers/{customer_id}/payments/default\
   GET /api/v1/customers/{customer_id}/delivery-addresses/default
````
#### 5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.
##### Collection 1: Twitter-Like API
````
   1. Users
      GET /api/users - Retrieves a list of all users.
      POST /api/users - Registers a new user.
      PUT /api/users/{userId} - Updates the profile of a user.
      DELETE /api/users/{userId} - Deletes a user account.
   
   2. Tweets
      GET /api/tweets - Retrieves all tweets.
      POST /api/tweets - Creates a new tweet.
      GET /api/tweets/{tweetId} - Fetches details of a specific tweet.
      DELETE /api/tweets/{tweetId} - Deletes a specific tweet.
   
   3. Followers
      GET /api/users/{userId}/followers - Retrieves all followers of a user.
      POST /api/users/{userId}/follow - Follows another user.
      DELETE /api/users/{userId}/unfollow - Unfollows a user.
   
   4. Likes
      GET /api/tweets/{tweetId}/likes - Retrieves likes on a tweet.
      POST /api/tweets/{tweetId}/like - Likes a tweet.
      DELETE /api/tweets/{tweetId}/unlike - Unlikes a tweet.
````
##### Collection 2: Paypal-Like API
````
   1. Accounts
      GET /api/accounts/{accountId} - Retrieves account details.
      POST /api/accounts - Creates a new account.
      PUT /api/accounts/{accountId} - Updates account information.
      DELETE /api/accounts/{accountId} - Closes an account.
   
   2. Transactions
      GET /api/transactions - Retrieves a list of transactions.
      POST /api/transactions - Initiates a new transaction.
      GET /api/transactions/{transactionId} - Retrieves details of a specific transaction.
      DELETE /api/transactions/{transactionId} - Cancels a pending transaction.
   
   3. Payments
      GET /api/accounts/{accountId}/payments - Retrieves payments made by an account.
      POST /api/payments - Makes a payment.
      PUT /api/payments/{paymentId} - Updates a payment detail.
      DELETE /api/payments/{paymentId} - Cancels a scheduled payment.
   
   4. Billing
      GET /api/accounts/{accountId}/billing - Retrieves billing details.
      POST /api/accounts/{accountId}/billing - Adds or updates billing information.
      PUT /api/billing/{billingId} - Modifies billing information.
      DELETE /api/billing/{billingId} - Removes billing information.
````

#### 6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
````
   1. Blog Posts:
      GET /api/posts - Retrieves a list of all blog posts.
      POST /api/posts - Creates a new blog post.
      PUT /api/posts/{postId} - Updates a specific blog post.
      DELETE /api/posts/{postId} - Deletes a specific blog post.
   
   2. Comments:
      GET /api/posts/{postId}/comments - Retrieves comments for a specific post.
      POST /api/posts/{postId}/comments - Adds a new comment to a post.
      DELETE /api/comments/{commentId} - Deletes a specific comment.
   
   3. Users:
      GET /api/users - Retrieves a list of users.
      POST /api/users - Registers a new user.
      PUT /api/users/{userId} - Updates user details.
      DELETE /api/users/{userId} - Deletes a user account.
   
   4. Categories/Tags:
      GET /api/tags - Retrieves all tags.
      POST /api/tags - Creates a new tag.
      PUT /api/posts/{postId} - Updates a specific tag.
      DELETE /api/tags/{tagId} - Deletes a specific tag.
````


### Practice DB Relationship

#### 1. Create oms_company_address table
````
   CREATE TABLE CustomerAddresses (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
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
````

#### 2. Insert some random data to oms_company_address table
````
   INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES
   (1, 's1', 0, 1, 'x1', '1234567890', 'y1', 'z1', 'a1', 'xxxxxxxxxxxxxxxxxx'),
   (2, 's2', 1, 0, 'x2', '0987654321', 'y2', 'z2', 'a2', 'yyyyyyyyyyyyyyyyyyy'),
   (3, 's3', 0, 1, 'x3', '1122334455', 'y3', 'z3', 'a3', 'zzzzzzzzzzzzzzzzzzzzzzz'),
   (4, 's4', 1, 1, 'x4', '2233445566', 'y4', 'z4', 'a4', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaa);
````

#### 3. Write a SQL query to fetch all data from oms_company_address `table
````
   SELECT * FROM oms_company_address
````
#### 4. Write a SQL query to fetch top 3 records from oms_company_address table
````
   SELECT * FROM oms_company_address ORDER BY id ASC LIMIT 3;
````

#### 5. Update oms_company_address table to set all phone to 666-6666-8888
````
   UPDATE oms_company_address SET phone = '666-6666-8888';
````

#### 6. Delete one entry from oms_company_address table
````
   DELETE FROM oms_company_address WHERE id = 1;
````

### MongoDB - Non-SQL Database

#### 1. Create test DB
````
   use testDB
````
#### 2. Create oms_company_address collection (method: createCollection() )
````
   db.createCollection("oms_company_address")
````
#### 3. Insert few random entries to oms_company_address collection (method: insert() )
````
   db.oms_company_address.insert([
     { address_name: "s1", send_status: 0, receive_status: 1, name: "x1", phone: "123-456-7890", province: "y1", city: "z1", region: "a1", detail_address: "xxxxxxxxxx" },
     { address_name: "s2", send_status: 1, receive_status: 0, name: "x2", phone: "098-765-4321", province: "y2", city: "z2", region: "a2", detail_address: "yyyyyyyyyyyy" },
     { address_name: "s3", send_status: 0, receive_status: 1, name: "x3", phone: "112-233-4455", province: "y3", city: "z3", region: "a3", detail_address: "zzzzzzzzzzzzz" }
   ])
````
#### 4. Read one entry from oms_company_address collection (method: find() )
````
   db.oms_company_address.findOne()
````
#### 5. Read all entries from oms_company_address collection (method: find() )
````
   db.oms_company_address.find()
````
#### 6. Update one entry from oms_company_address collection (method: update() or save() )
````
   db.oms_company_address.update(
  { name: "x1" },
  { $set: { phone: "666-6666-8888" } }
   )
   
   var docToUpdate = db.oms_company_address.findOne({ name: "x1" });
   docToUpdate.phone = "666-6666-8888";
   db.oms_company_address.save(docToUpdate);
````
#### 7. Remove one entry from oms_company_address collection (method: remove() )
````
   db.oms_company_address.remove({ name: "x1" })
````