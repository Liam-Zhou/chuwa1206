# 1

find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

`GET api/v1/customers/{customerID}/payments`



# 2

Find the customer's history orders from 10/10/2022 to 10/24/2022

`GET api/v1/customers/{customerID}/orders?startDate=2022-10-10&endDate=2020-10-24`



# 3

find the customer’s delievery addresses.

`GET api/v1/customers/{customerID}/addresses`



# 4

If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

`GET /customers/{customerId}/default-settings`



# 5

Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范



An example of a PayPal API endpoint is `/v2/checkout/orders/{id}`

Twitter API Collection: `GET /2/users/{id}/tweets`



# 6

Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

1. **GET (Retrieve Data):**
   - Retrieve all blog posts:
     - `GET /api/posts`
   - Retrieve a specific blog post:
     - `GET /api/posts/{postId}`
   - Retrieve comments for a specific blog post:
     - `GET /api/posts/{postId}/comments`
2. **POST (Create Data):**
   - Create a new blog post:
     - `POST /api/posts`
     - Request body contains post data (title, content, author, etc.)
   - Add a comment to a blog post:
     - `POST /api/posts/{postId}/comments`
     - Request body contains comment data (author, comment text, etc.)
3. **PUT (Update Data):**
   - Update an existing blog post:
     - `PUT /api/posts/{postId}`
     - Request body contains updated data for the post
   - Update a comment on a blog post:
     - `PUT /api/posts/{postId}/comments/{commentId}`
     - Request body contains updated comment text
4. **DELETE (Remove Data):**
   - Delete an existing blog post:
     - `DELETE /api/posts/{postId}`
   - Delete a comment from a blog post:
     - `DELETE /api/posts/{postId}/comments/{commentId}`

Others:

1. Register a User:

   `POST /api/users`

   Registers a new user.

2. User Login:

   `POST /api/users/login`

   Authenticates a user.

3. Get User Profile:

   `GET /api/users/{userId}`

   Retrieves a user's profile.

4. Update User Profile:

   `PUT /api/users/{userId}`

   Updates a user's profile.









# MySQL

Create oms_company_address table

![CleanShot 2024-01-04 at 00.41.48@2x](./assets/CleanShot%202024-01-04%20at%2000.41.48@2x.jpg)



Insert some random data to oms_company_address table

``` sql
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES
(1, 'Office Park', 0, 1, 'John Doe', '1234567890', 'Guangdong', 'Guangzhou', 'Tianhe', '123 Tianhe Road'),
(2, 'Tech Hub', 1, 0, 'Jane Smith', '0987654321', 'Zhejiang', 'Hangzhou', 'Xihu', '456 Xihu Avenue'),
(3, 'Business Plaza', 0, 1, 'Alex Johnson', '5555555555', 'Jiangsu', 'Nanjing', 'Jianye', '789 Jianye Street'),
(4, 'Warehouse', 1, 1, 'Maria Garcia', '6666666666', 'Fujian', 'Xiamen', 'Siming', '1010 Siming Blvd'),
(5, 'Distribution Center', 0, 0, 'Chen Wei', '7777777777', 'Shandong', 'Qingdao', 'Shinan', '1212 Shinan Road');

```



![CleanShot 2024-01-04 at 00.48.50@2x](./assets/CleanShot%202024-01-04%20at%2000.48.50@2x.jpg)



3. Write a SQL query to fetch all data from oms_company_address `table

![CleanShot 2024-01-04 at 00.49.35@2x](./assets/CleanShot%202024-01-04%20at%2000.49.35@2x.jpg)



3. Update oms_company_address table to set all phone to 666-6666-8888

``` mysql
UPDATE oms_company_address
SET phone = '666-6666-8888';

```





3. Delete one entry from oms_company_address table

   ``` Mysql
   DELETE FROM oms_company_address
   WHERE id = 1;
   
   ```

   



# MongoDB

Create test DB

`use test`

Create oms_company_address collection (method: createCollection() )

![CleanShot 2024-01-04 at 01.02.21@2x](./assets/CleanShot%202024-01-04%20at%2001.02.21@2x.jpg)

Insert few random entries to oms_company_address collection (method: insert() )

``` NoSQL
db.oms_company_address.insert([
    {
        address_name: "Office Park",
        send_status: 0,
        receive_status: 1,
        name: "John Doe",
        phone: "123-456-7890",
        province: "Guangdong",
        city: "Guangzhou",
        region: "Tianhe",
        detail_address: "123 Tianhe Road"
    },
    {
        address_name: "Tech Hub",
        send_status: 1,
        receive_status: 0,
        name: "Jane Smith",
        phone: "098-765-4321",
        province: "Zhejiang",
        city: "Hangzhou",
        region: "Xihu",
        detail_address: "456 Xihu Avenue"
    },
    {
        address_name: "Business Plaza",
        send_status: 0,
        receive_status: 1,
        name: "Alex Johnson",
        phone: "555-555-5555",
        province: "Jiangsu",
        city: "Nanjing",
        region: "Jianye",
        detail_address: "789 Jianye Street"
    }
]);

```



Read one entry from oms_company_address collection (method: find() )

`db.oms_company_address.findOne()`



Read all entries from oms_company_address collection (method: find() )

![CleanShot 2024-01-04 at 01.05.18@2x](./assets/CleanShot%202024-01-04%20at%2001.05.18@2x.jpg)

Update one entry from oms_company_address collection (method: update() or save() )



``` NoSQL
db.oms_company_address.update(
    { name: "John Doe" },
    { $set: { phone: "999-999-9999" } }
);

```





Remove one entry from oms_company_address collection (method: remove() )

`db.oms_company_address.remove({ name: "John Doe" }, true);`