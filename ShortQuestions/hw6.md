API Design
1.find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

GET /api/v1/customers/{customerId}/payments

2.find the customer’s history orders from 10/10/2022 to 10/24/2022

GET /api/v1/customers/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24

3.find the customer’s delievery  addresses

GET /api/v1/customers/{customerId}/addresses

4.If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

GET /api/v1/customers/{customerId}/payments/default

Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范

Youtube APIs collection (https://developers.google.com/youtube/v3/docs?hl=zh-cn)
方法	HTTP 请求	说明
相对于 https://www.googleapis.com/youtube/v3 的 URI
delete	DELETE /channelSections	删除频道版块。
insert	POST /channelSections	向经过身份验证的用户的渠道添加渠道部分。一个频道最多可以创建 10 个搁架。
list	GET /channelSections	返回符合 API 请求条件的 channelSection 资源列表。
update	PUT /channelSections	更新频道版块。

Paypal APIs collection (https://developer.paypal.com/docs/api/orders/v2/)
https://api-m.paypal.com/v2/checkout/orders Create order
https://api-m.paypal.com/v2/checkout/orders/{id} Show order details
https://api-m.paypal.com/v2/checkout/orders/{id} Update order
https://api-m.paypal.com/v2/checkout/orders/{id}/confirm-payment-source Confirm the Order
https://api-m.paypal.com/v2/checkout/orders/{id}/authorize Authorize payment for order
https://api-m.paypal.com/v2/checkout/orders/{id}/capture Capture payment for order
https://api-m.paypal.com/v2/checkout/orders/{id}/track Add tracking information for an Order.
https://api-m.paypal.com/v2/checkout/orders/{id}/trackers/{tracker_id} Update or cancel tracking information for a PayPal order

Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

GET /api/v1/posts - Retrieve all blog posts.
POST /api/v1/posts - Create a new blog post.
PUT /api/v1/posts/{postId} - Update an existing blog post.
DELETE /api/v1/posts/{postId} - Delete a blog post.
GET /api/v1/posts/{postId}/comments - Retrieve comments for a blog post.
POST /api/v1/posts/{postId}/comments - Add a comment to a blog post.

MySQL
Exercise
Q1: Create oms_company_address Table:

CREATE TABLE oms_company_address (
    id BIGINT PRIMARY KEY,
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

Q2: Insert some random data to oms_company_address table:

INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES
(1, 'Warehouse 1', 1, 0, 'John Doe', '951-555-1234', 'State A', 'City B', 'Region C', '123 Street Lane'),
(2, 'Warehouse 2', 0, 1, 'Jane Smith', '951-555-5678', 'State X', 'City Y', 'Region Z', '456 Avenue Road'),
(3, 'Warehouse 3', 1, 1, 'Mike Johnson', '951-555-9012', 'State M', 'City N', 'Region O', '789 Boulevard Drive');

Q3: Write a SQL query to fetch all data from oms_company_address `table:

SELECT * FROM oms_company_address;

Q4: Write a SQL query to fetch top 3 records from oms_company_address table:

SELECT * FROM oms_company_address ORDER BY id ASC LIMIT 3;

Q5: Update oms_company_address table to set all phone to 666-6666-8888

UPDATE oms_company_address SET phone = 666-6666-8888';

Q6: Delete one entry from oms_company_address table:

DELETE FROM oms_company_address WHERE id =1;

MongoDB
Exercise

Q1: Create Test Database:

use testDB

Q2: Create oms_company_address collection (method: createCollection() )

db.createCollection("oms_company_address")

Q3: Insert few random entries to oms_company_address collection (method: insert() )

db.oms_company_address.insert([
    { id: 1, address_name: "Head Office", send_status: 1, receive_status: 0, name: "John Doe", phone: "123-456-7890", province: "ProvinceA", city: "CityX", region: "RegionI", detail_address: "123 ABC Street" },
    { id: 2, address_name: "Warehouse", send_status: 0, receive_status: 1, name: "Jane Smith", phone: "987-654-3210", province: "ProvinceB", city: "CityY", region: "RegionII", detail_address: "456 DEF Street" },
    { id: 3, address_name: "Branch", send_status: 1, receive_status: 1, name: "Mike Johnson", phone: "555-123-4567", province: "ProvinceC", city: "CityZ", region: "RegionIII", detail_address: "789 GHI Street" }
])

Q4: Read one entry from oms_company_address collection (method: find() )

db.oms_company_address.find({ id: 1 })

Q5: Read all entries from oms_company_address collection (method: find() )

db.oms_company_address.find()

Q6: Update one entry from oms_company_address collection (method: update() or save() )

db.oms_company_address.update(
    { id: 2 },
    { $set: { name: "Alice Johnson", phone: "666-777-8888" } }
)

Q7: Remove one entry from oms_company_address collection (method: remove() )

db.oms_company_address.remove({ id: 3 })
