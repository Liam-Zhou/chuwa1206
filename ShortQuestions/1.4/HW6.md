# 1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
GET customers/{customer-id}/payments
GET customers/{customer-id}/payments/credit-card/1
GET customers/{customer-id}/payments/credit-card/2
GET customers/{customer-id}/payments/paypal
GET customers/{customer-id}/payments/apple-pay

# 2. Find the customer’s history orders from 10/10/2022 to 10/24/2022
GET customers/{customer-id}/orders?start-date=20221010&end-date=20221024

# 3. find the customer’s delievery addresses
GET customers/{customer-id}/addresses

# 4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?
GET customers/{customer-id}/payments/default
GET customers/{customer-id}/addresses/default

# 5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.
https://www.youtube.com/channel/UCZIAk6dWAjQHOSUYfsiprrw

channel/{channel-id}

https://twitter.com/NikTekOfficial/status/1742895546157658552

{user-id}/status/{post-id}

# 6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

1. get a specific article of a specific user GET users/{user-id}/articles/{article-id}  
2. post an article for a specific user POST users/{user-id}/articles
3. replace a specific article for a specific user PUT GET users/{user-id}/articles/{article-id}
4. delete a specific article of a specific userDELETE GET users/{user-id}/articles/{article-id}

1. get the avatar of a specific user GET users/{user-id}/avatar
2. post a self intro of a specific user POST users/{user-id}/self-intro
3. replace the avatar of a specific user PUT users/{user-id}/avatar
4. delete user DELETE users/{user-id}

# MySQL Homework
1.
    ```
    CREATE TABLE oms_company_address (
    id BIGINT,
    address_name VARCHAR(200),
    send_status INT,
    receive_status INT,
    `name` VARCHAR(64),
    phone VARCHAR(64),
    province VARCHAR(64),
    city VARCHAR(64),
    region VARCHAR(64),
    detail_address VARCHAR(200),
    PRIMARY KEY (id),
    CHECK (send_status IN (0,1)),
    CHECK (receive_status IN (0,1))
    );
    ```
2. 
    ```
    INSERT INTO oms_company_address VALUES 
    (1, 'My House', 1, 0, 'Zhaokuan Chen', '123-456-789', 'Beijing', 'Beijing', 'Haidian', 'XXX'),
    (2, 'Branch Office', 0, 1, 'Jane Smith', '234-567-8901', 'New York', 'New York City', 'Manhattan', '456 Park Ave'),
    (3, 'Warehouse', 1, 1, 'Mike Johnson', '345-678-9012', 'Texas', 'Houston', 'Downtown', '789 Warehouse Rd'),
    (4, 'Regional Office', 0, 0, 'Sara Lee', '456-789-0123', 'Florida', 'Miami', 'South Beach', '101 Ocean Dr'),
    (5, 'Factory', 1, 0, 'Alex Martinez', '567-890-1234', 'Illinois', 'Chicago', 'North Side', '202 Industrial Park');
    ```
3. `SELECT * FROM oms_company_address;`
4. 
    ```
    SELECT * 
    FROM oms_company_address
    ORDER BY id
    LIMIT 3;
    ```
5. 
    ```
    UPDATE oms_company_address
    SET phone = '666-6666-8888';
    ```
6. 
    ```
    DELETE FROM oms_company_address WHERE id = 1;
    SELECT * FROM oms_company_address;
    ```


# MongoDB Homework
1. `use test;`

2. `db.createCollection("oms_company_address");`

3.  insert() is deprecated. 
    ```
    db.oms_company_address.insertMany(
        [
            {
                address_name: 'My House', 
                send_status: 1, 
                receive_status: 0, 
                name: 'Zhaokuan Chen', 
                phone: '123-456-789', 
                province: 'Beijing', 
                city: 'Beijing', 
                region: 'Haidian', 
                detail_address: 'XXX'
            },
            {
                address_name: 'Branch Office', 
                send_status: 0, 
                receive_status: 1, 
                name: 'Jane Smith', 
                phone: '234-567-8901', 
                province: 'New York', 
                city: 'New York City', 
                region: 'Manhattan', 
                detail_address: '456 Park Ave'
            },
            {
                address_name: 'Warehouse', 
                send_status: 1, 
                receive_status: 1, 
                name: 'Mike Johnson', 
                phone: '345-678-9012', 
                province: 'Texas', 
                city: 'Houston', 
                region: 'Downtown', 
                detail_address: '789 Warehouse Rd'
            }
        ]
    );
    ```
4. `db.oms_company_address.find().limit(1);`
5. `db.oms_company_address.find();`
6. update() is deprecated.
    ```
    db.oms_company_address.updateOne( 
            { name: 'Zhaokuan Chen' }, 
            { $set: { phone: '111-111-111' } }
        );
    ```
7. delete() is deprecated. `db.oms_company_address.deleteOne({name: 'Zhaokuan Chen'});`
