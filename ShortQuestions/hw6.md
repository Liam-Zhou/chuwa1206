> [!NOTE]
> This a markdown file for hw6


## question 1

**Finding Customer's Payments:**

Method: GET

URL: `/api/customers/{customerId}/payments`

Description: Retrieves a list of payment methods associated with a customer.

## question 2

**Finding Customer’s History Orders:**

Method: GET

URL: `/api/customers/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24`

Description: Retrieves the history of orders for a customer within a specified date range.

## question 3

**Finding Customer’s Delivery Addresses:**

Method: GET

URL: `/api/customers/{customerId}/addresses`

Description: Retrieves the list of delivery addresses associated with a customer.

## question 4

**Finding Customer’s Default Payment and Default Delivery Address:**

To include the customer’s default payment method and default delivery address, the API could be structured as follows:

Method: GET

URL: `/api/customers/{customerId}/defaults`

Description: Retrieves the customer's default payment method and default delivery address.

## question 5
**Twitter API Collection:**

Get User's Tweets: `GET /2/users/{id}/tweets`

Post a Tweet: `POST /2/tweets`

Delete a Tweet: `DELETE /2/tweets/{id}`

Get User Profile: `GET /2/users/{id}`


**PayPal API Collection:**

Create Payment: `POST /v1/payments/payment`

Execute Approved Payment: `POST /v1/payments/payment/{payment_id}/execute`

Get Payment Details: `GET /v1/payments/payment/{payment_id}`

List Transactions: `GET /v1/reporting/transactions`

## question 6

**Designing a Collection of APIs for a Blog Website:**

Posts: 
1. Get All Posts:

    `GET /api/posts`
    
    Retrieves a list of all blog posts.
2. Create a Post:

    `POST /api/posts`

    Creates a new blog post.
3. Update a Post:

    `PUT /api/posts/{postId}`

    Updates a specific blog post.
4. Delete a Post:

    `DELETE /api/posts/{postId}`

    Deletes a specific blog post.

Comments:
1. Get Comments for a Post:

    `GET /api/posts/{postId}/comments`

    Retrieves comments for a specific blog post.
2. Add a Comment to a Post:

    `POST /api/posts/{postId}/comments`

    Adds a new comment to a blog post.
3. Update a Comment:

    `PUT /api/posts/{postId}/comments/{commentId}`

    Updates a specific comment on a blog post.
4. Delete a Comment:

    `DELETE /api/posts/{postId}/comments/{commentId}`

    Deletes a specific comment from a blog post.

Users
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


## MySQL database
1. Create oms_company_address Table
    ```sql
    CREATE TABLE oms_company_address (
        id INT AUTO_INCREMENT PRIMARY KEY,
        company_name VARCHAR(255),
        address_line1 VARCHAR(255),
        address_line2 VARCHAR(255),
        city VARCHAR(100),
        state VARCHAR(100),
        country VARCHAR(100),
        postal_code VARCHAR(20),
        phone VARCHAR(20)
    );
    ```
2. Insert Random Data into oms_company_address Table
    ```sql
    INSERT INTO oms_company_address (company_name, address_line1, address_line2, city, state, country, postal_code, phone) VALUES
    ('Company A', '1234 Park Ave', 'Suite 101', 'CityA', 'StateA', 'CountryA', '12345', '123-456-7890'),
    ('Company B', '2345 Oak St', '', 'CityB', 'StateB', 'CountryB', '23456', '234-567-8901'),
    ('Company C', '3456 Maple Rd', 'Building 5', 'CityC', 'StateC', 'CountryC', '34567', '345-678-9012'),
    ('Company D', '4567 Birch Dr', 'Floor 2', 'CityD', 'StateD', 'CountryD', '45678', '456-789-0123');
    
    ```
3. SQL Query to Fetch All Data from oms_company_address Table
    ```sql
    SELECT * FROM oms_company_address;
    ```
4. SQL Query to Fetch Top 3 Records from oms_company_address Table
    ```sql
    SELECT * FROM oms_company_address ORDER BY id LIMIT 3;
    ```
5. Update oms_company_address Table to Set All Phones to 666-6666-8888
    ```sql
    UPDATE oms_company_address SET phone = '666-6666-8888';
    ```
6. Delete One Entry from oms_company_address Table
    ```sql
    DELETE FROM oms_company_address WHERE id = 1;
    ```


## MongoDB database
1. Create test Database
    ```javascript
    use test
    ```
2. Create oms_company_address Collection
    ```javascript
    db.createCollection("oms_company_address")
    ```
3. Insert Few Random Entries into oms_company_address Collection
    ```javascript
    db.oms_company_address.insert([
        { company_name: "Company A", address: "1234 Park Ave", city: "CityA", phone: "123-456-7890" },
        { company_name: "Company B", address: "2345 Oak St", city: "CityB", phone: "234-567-8901" },
        { company_name: "Company C", address: "3456 Maple Rd", city: "CityC", phone: "345-678-9012" }
    ])
    ```
4. Read One Entry from oms_company_address Collection
    ```javascript
    db.oms_company_address.findOne()
    ```
5. Read All Entries from oms_company_address Collection
    ```javascript
    db.oms_company_address.find()
    ```
6. Update One Entry in oms_company_address Collection
    ```javascript
    db.oms_company_address.update(
        { company_name: "Company A" },
        { $set: { phone: "666-6666-8888" } }
    )
    ```
7. Remove One Entry from oms_company_address Collection
    ```javascript
    db.oms_company_address.remove(
        { company_name: "Company B" }
    )
    
    ```