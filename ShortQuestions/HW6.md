### API Design  

1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
	    GET /customers/{customerId}/payments
2. Find the customer’s history orders from 10/10/2022 to 10/24/2022
		GET /customers/{customerId}/orders?start_date=2022-10-10&end_date=2022-10-24
3. Find the customer’s delievery addresses
		GET /customers/{customerId}/addresses
4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?
		GET /customers/{customerId}/default-payment
		GET /customers/{customerId}/default-address
5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
		 Twitter API:

			**Tweets Collection:**
			    
			    - GET /tweets
			    - POST /tweets
			    - PUT /tweets/{tweetId}
			    - DELETE /tweets/{tweetId}
			**Users Collection:**
			    
			    - GET /users/{userId}
			    - POST /users
			    - PUT /users/{userId}
			    - DELETE /users/{userId}

6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
	- **Posts Collection:**
	    
	    - GET /posts
	    - GET /posts/{postId}
	    - POST /posts
	    - PUT /posts/{postId}
	    - DELETE /posts/{postId}
	- **Comments Collection:**
	    
	    - GET /posts/{postId}/comments
	    - GET /posts/{postId}/comments/{commentId}
	    - POST /posts/{postId}/comments
	    - PUT /posts/{postId}/comments/{commentId}
	    - DELETE /posts/{postId}/comments/{commentId}
	- **Users Collection:**
	    
	    - GET /users/{userId}
	    - POST /users
	    - PUT /users/{userId}
	    - DELETE /users/{userId}

## DB Practice
### MySQL
1. Create oms_company_address table

	CREATE TABLE oms_company_address (
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

2. Insert some random data to oms_company_address table
	INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
	VALUES
	('Home', 1, 1, 'aaa', '666-1234-5678', 'California', 'Los Angeles', 'Downtown', '123 Main St'),
	('Office', 0, 1, 'bbb', '555-9876-5432', 'California', 'San Jose', 'Downtown', '456 Abc St'),
	('Home', 0, 0, 'ccc', '555-2222-8888', 'California', 'San Diego', 'West', '789 Efg St');

3. Write a SQL query to fetch all data from `oms_company_address` table:
	SELECT * FROM oms_company_address;

4. Write a SQL query to fetch top 3 records from `oms_company_address` table:
	SELECT * FROM oms_company_address LIMIT 3;

5. Update oms_company_address table to set all phone to 666-6666-8888 
	UPDATE oms_company_address SET phone = '666-6666-8888';

6. Delete one entry from oms_company_address table
	DELETE FROM oms_company_address WHERE id = 1;


### Mongo DB

1. Create test DB 
	use testDB;

2. Create oms_company_address collection (method: createCollection() ) 
	db.createCollection("oms_company_address");

3. Insert few random entries to oms_company_address collection (method: insert() ) 
	db.oms_company_address.insert([
	    {
	        address_name: "Home",
	        send_status: 1,
	        receive_status: 1,
	        name: "aaa",
	        phone: "666-1234-5678",
	        province: "California",
	        city: "Los Angeles",
	        region: "Downtown",
	        detail_address: "123 Main St"
	    },
	    {
	        address_name: "Office",
	        send_status: 0,
	        receive_status: 1,
	        name: "bbb",
	        phone: "555-9876-5432",
	        province: "California",
	        city: "San Jose",
	        region: "Mid",
	        detail_address: "456 Abc St"
	    },
	    {
	        address_name: "Home",
	        send_status: 0,
	        receive_status: 0,
	        name: "ccc",
	        phone: "555-2222-8888",
	        province: "California",
	        city: "San Diego",
	        region: "West",
	        detail_address: "789 Efg St"
	    }
	]);

4. Read one entry from oms_company_address collection (method: find() ) 
	db.oms_company_address.findOne();

5. Read all entries from oms_company_address collection (method: find() ) 
	db.oms_company_address.find();

6. Update one entry from oms_company_address collection (method: update() or save() ) 
	db.oms_company_address.updateOne(
	    { name: "aaa" },  
	    {
	        $set: {
	            phone: "666-6666-8888"
	        }
	    }
	);

7. Remove one entry from oms_company_address collection (method:remove() )
	db.oms_company_address.deleteOne(
	    { name: "aaa" }  
	);
