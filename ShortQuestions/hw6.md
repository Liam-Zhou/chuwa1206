# API Design

    - Find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

      ```
      GET /api/v1/customer/{customer_id}/payments

      ```

    - Find the customer’s history orders from 10/10/2022 to 10/24/2022

      ```
      GET /api/v1/customer/{customer_id}/orders?startDate=10/10/2022&endData=10/24/2022
      ```

    - Find the customer’s delievery addresses

      ```
      GET /api/v1/customer/{customer_id}/addresses

      ```

    - If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

      ```
      GET /api/v1/customer/{customer_id}/payments/default

      GET /api/v1/customer/{customer_id}/addresses/default
      ```

    - Find 2 collections of APIs example. ie. Twitter, Paypal, Youtube etc.

      ```
      GET /followers/list
      GET /playlist?list=WL
      ```

    - Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

      ```
      GET /blogs: Retrieve a list of all blog posts.

      GET /blogs/{id}: Retrieve a specific blog post by its unique identifier.

      POST /blogs: Create a new blog post.

      PUT /blogs/{id}: Update an existing blog post by its unique identifier.

      DELETE /blogs/{id}: Delete an existing blog post by its unique identifier.

      GET /blogs/{blogId}/comments: Retrieve all comments associated with a specific blog post.

      DELETE /blogs/{blogId}/comments/{commentId}: Retrieve a specific comment associated with a blog post.

      POST /blogs/{id}/comments: Add a new comment to a specific blog post.

      DELETE /blogs/{blogId}/comments/{commentId}:Delete a specific comment associated with a blog post.
      ```

# DB pratice

    mySQL

    1.  Create oms_company_address table

        ```
        CREATE TABLE `ChuwaTest`.`oms_company_address` (
        `id` BIGINT NOT NULL,
        `address_name` VARCHAR(200) NULL,
        `send_status` INT NULL,
        `receive_status` INT NULL,
        `name` VARCHAR(64) NULL,
        `phone` VARCHAR(64) NULL,
        `province` VARCHAR(64) NULL,
        `city` VARCHAR(64) NULL,
        `region` VARCHAR(64) NULL,
        `detail_address` VARCHAR(200) NULL,
        PRIMARY KEY (`id`));
        ```

    2.  Insert some random data to oms_company_address table

        ```
        INSERT INTO `ChuwaTest`.`oms_company_address`
        (`id`,`address_name`,`send_status`,`receive_status`,`name`,`phone`,`province`,`city`,`region`,`detail_address`)
        VALUES
        (0,0,0,0,'xyz','123','CA','SD','US','abc');

        INSERT INTO `ChuwaTest`.`oms_company_address`
        (`id`,`address_name`,`send_status`,`receive_status`,`name`,`phone`,`province`,`city`,`region`,`detail_address`)
        VALUES
        (1,1,0,0,'zyx','321','CA','SD','US','cba');

        INSERT INTO `ChuwaTest`.`oms_company_address`
        (`id`,`address_name`,`send_status`,`receive_status`,`name`,`phone`,`province`,`city`,`region`,`detail_address`)
        VALUES
        (2,2,0,0,'xzy','132','CA','SD','US','acb');

        INSERT INTO `ChuwaTest`.`oms_company_address`
        (`id`,`address_name`,`send_status`,`receive_status`,`name`,`phone`,`province`,`city`,`region`,`detail_address`)
        VALUES
        (3,3,0,0,'yxz','213','CA','SD','US','bac');

        INSERT INTO `ChuwaTest`.`oms_company_address`
        (`id`,`address_name`,`send_status`,`receive_status`,`name`,`phone`,`province`,`city`,`region`,`detail_address`)
        VALUES
        (4,4,0,0,'yzx','231','CA','SD','US','bca');
        ```

    3.  Write a SQL query to fetch all data from oms_company_address `table

        ```
        SELECT * FROM `ChuwaTest`.`oms_company_address`;
        ```

    4.  Write a SQL query to fetch top 3 records from oms_company_address table

        ```
        SELECT * FROM `ChuwaTest`.`oms_company_address` ORDER BY `id` LIMIT 3;
        ```

    5.  Update oms_company_address table to set all phone to 666-6666-8888

        ```
        UPDATE `ChuwaTest`.`oms_company_address` SET `phone` = '666-6666-8888';
        ```

    6.  Delete one entry from oms_company_address table

        ```
        DELETE FROM `ChuwaTest`.`oms_company_address` WHERE id=0;
        ```

# MongoDB

1. CreatetestDB

   ```
     use test;
   ```

2. Create oms_company_address collection (method: createCollection() )

   ```
     db.createCollection("oms_company_address");
   ```

3. Insert few random entries to oms_company_address collection (method: insert() )

   ```
    db.oms_company_address.insertMany([
      {id: 0, address_name: "0", name: "xyz"},
      {id: 1, address_name: "1", name: "yxz"},
      {id: 2, address_name: "2", name: "zyx"}
      ]);
   ```

4. Read one entry from oms_company_address collection (method: find() )

   ```
   db.oms_company_address.find({id: 1})

   ```

5. Read all entries from oms_company_address collection (method: find() )

   ```
    db.oms_company_address.find()
   ```

6. Update oneentry from oms_company_addresscollection(method:update()orsave())

   ```
   db.oms_company_address.updateOne( {id: 0}, {$set: {name: "YZ"}} )
   ```

7. Remove one entry fromoms_company_addresscollection(method:remove())
   ```
   db.oms_company_address.remove( {id: 1} )
   ```
