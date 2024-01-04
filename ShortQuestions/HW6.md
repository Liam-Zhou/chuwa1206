### API design:
1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
`/api/customers/{customerID}/payment-methods`
2. Find the customer’s history orders from 10/10/2022 to 10/24/2022
`/api/customers/{customerID}/orders?startDate=10/10/2022&endDate=10/24/2022`
3. find the customer’s delivery  addresses
`/api/cusomers/{customerID}/address`
4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?
`/api/customers/{customerId}/default-payment-and-delivery`
5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
[twitter API](https://developer.twitter.com/en/docs/twitter-api)  [chatGPT API](https://platform.openai.com/examples)
6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
```
GET /api/article
GET /api/users
POST /api/article/{articleId}/comments
DELETE /aip/article/{articleId}/comments/{commentsID}
```
### DB Exercise
#### MySQL 
1. 
```
 CREATE TABLE oms_company_address(
 id bight AUTO_INCREMENT primary key,
 address_name varchar(200),
 send_status int(1);
 receive_status int(1),
 name varchar(64),2  
```
2. 
```
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
('Office Address', 1, 1, 'John Doe', '123-456-7890', 'California', 'Los Angeles', 'Downtown', '123 Main St');
```
3. `SELECT * FROM oms_company_address;`
4. 
```
SELECT * FROM oms_company_address
ORDER BY id ASC
LIMIT 3;
```
5. 
```
UPDATE oms_company_address
SET phone = '666-6666-8888';
```
### Non-SQL
1. 
```
use test
```
2.
```
db.createCollection("oms_comapny_address")
```
3. 
```
db.oms_company_address.insert({
    id: 1,
    address_name: "Example Address 1",
    send_status: 1,
    receive_status: 1,
    name: "John Doe",
    phone: "123-456-7890",
    province: "California",
    city: "Los Angeles",
    region: "Downtown",
    detail_address: "123 Main Street"
})
```
4. 
```
db.oms_company_address.findOne()
```
5.
```
db.oms_company_address.find()
```
6.
```
db.oms_company_address.updateOne(
    { id: 1 },
    {
        $set: { 
            send_status: 2,
        }
    }
)
```
7.
```
db.collection.deleteOne({ id: 1 })
```