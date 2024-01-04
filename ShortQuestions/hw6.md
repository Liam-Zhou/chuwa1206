API Design
1. GET api/v1/user/{id}/payments
2. GET api/v1/user/{id}/orders?startDate="2022-10-10"&endDate="2022-10-24"
3. GET api/v1/user/{id}/addresses
4. GET api/v1/user/{id}/payments?type=default

   GET api/v1/user/{id}/addresses?type=default
5. https://help.twitter.com/en/forms/ipi/dmca

   https://www.paypal.com/us/enterprise/industry-solutions
6. GET api/v1/blog?country=USA&city=Seattle

   GET api/v1/blog/posts

   GET api/v1/blog/{post_id}

   POST api/v1/blog/posts

   PUT api/v1/blog/posts/{post_id}

   DELETE api/v1/blog/posts/{post_id}

DB practice

MYSQL
1. Create oms_company_address table

    - ```CREATE TABLE `ChuwaTest`.`oms_company_address` (
      `id`    bigint NOT NULL,
      `address_name` VARCHAR(200) NULL,
      `send_status` int(1) NULL,
      `receive_status` int(1) NULL,
      `name` VARCHAR(64) NULL,
      `phone` VARCHAR(64) NULL,
      `province` VARCHAR(64) NULL,
      `city` VARCHAR(64) NULL,
      `region` VARCHAR(64) NULL,
      `detail_address` VARCHAR(200) NULL,
      PRIMARY KEY (`id`));```

2. Insert some random data to oms_company_address table

    - ```INSERT INTO `ChuwaTest`.`oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`)
      VALUES ('1', '123NE 33RD ST', '0', '1', 'zyf', '0000000000', 'Washington', 'Seattle', 'King', '333N 22RD ST, APT 601');```
   - ```INSERT INTO `ChuwaTest`.`oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`)
     VALUES ('2', '123NE 33RD ST', '0', '1', 'zyf', '0000000000', 'Washington', 'Seattle', 'King', '333N 22RD ST, APT 602');```
   - ```INSERT INTO `ChuwaTest`.`oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`)
       VALUES ('3', '123NE 33RD ST', '0', '1', 'zyf', '0000000000', 'Washington', 'Seattle', 'King', '333N 22RD ST, APT 603');```
   - ```INSERT INTO `ChuwaTest`.`oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`)
       VALUES ('4', '123NE 33RD ST', '0', '1', 'zyf', '0000000000', 'Washington', 'Seattle', 'King', '333N 22RD ST, APT 604');```
   - ```INSERT INTO `ChuwaTest`.`oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`)
       VALUES ('5', '123NE 33RD ST', '0', '1', 'zyf', '0000000000', 'Washington', 'Seattle', 'King', '333N 22RD ST, APT 605');```

3. Write a SQL query to fetch all data from oms_company_address `table

    - `SELECT * FROM chuwatest.oms_company_address`

4. Write a SQL query to fetch top 3 records from oms_company_address table

    - `SELECT * FROM chuwatest.oms_company_address
      LIMIT 3`

5. Update oms_company_address table to set all phone to 666-6666-8888

    - `UPDATE ChuwaTest.oms_company_address
      SET phone = '666-6666-8888'
      WHERE phone <> '666-666-8888';`

6. Delete one entry from oms_company_address table

    - `DELETE FROM chuwatest.oms_company_address
      ORDER BY id
      LIMIT 1;`


MongoDB

1. Create test DB

   - `use test`

2. Create oms_company_address collection (method: createCollection() )

   - `db.createCollection("oms_company_address")`

3. Insert few random entries to oms_company_address collection (method: insert() )

   - since insert() is deprecated, I use insertMany or insertOne instead.
   - `db.oms_company_address.insertMany([{"name": "zyf"},{"name": "sdf"},{"name": "sadas"},{"name": "fghf"}])`

4. Read one entry from oms_company_address collection (method: find() )

   - `db.oms_company_address.find({"name": "zyf"})`

5. Read all entries from oms_company_address collection (method: find() )

   - `db.oms_company_address.find()`

6. Update one entry from oms_company_address collection (method: update() or save() )

   - `db.oms_company_address.updateOne(
     {name: "zyf"},
     {$set: {name: "zhengyangfu"}}
     )`

7. Remove one entry from oms_company_address collection (method: remove() )

   - `db.oms_company_address.remove(
     {name: "zhengyangfu"}
   )`
