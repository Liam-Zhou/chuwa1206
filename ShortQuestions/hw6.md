### API Design

1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

   /customers/{id}/payments

2. Find the customer’s history orders from 10/10/2022 to 10/24/2022

   /customer/{id}/orders?startDate="10/10/2022"&endDate="10/24/2022"

3. find the customer’s delievery addresses

   /customers/{id}/addresses

4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

   GET 

   /api/v1/custermers/{customer_id}/payments/default

   GET 

   /api/v1/custermers/{customer_id}/addresses/default

5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范

   https://twitter.com/i/api/1.1/jot/ces/p2 

   https://twitter.com/i/api/1.1/dm/user_updates.json?nsfw_filtering_enabled=false&cursor=GQwA&dm_secret_conversations_enabled=false&krs_registration_enabled=true&cards_platform=Web-12&include_cards=1&include_ext_alt_text=true&include_ext_limited_action_results=true&include_quote_count=true&include_reply_count=1&tweet_mode=extended&include_ext_views=true&dm_users=false&include_groups=true&include_inbox_timelines=true&include_ext_media_color=true&supports_reactions=true&include_ext_edit_control=true&include_ext_business_affiliations_label=true&ext=mediaColor%2CaltText%2CbusinessAffiliationsLabel%2CmediaStats%2ChighlightedLabel%2ChasNftAvatar%2CvoiceInfo%2CbirdwatchPivot%2CsuperFollowMetadata%2CunmentionInfo%2CeditControl

6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

   GET

   /api/posts

   /api/posts/{post_id}

   POST

   /api/posts

   PUT

   /api/posts/{post_id}

   DELETE

   /api/posts/{post_id}

Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

### DB Exercise

#### MySQL

1. 

```sql
CREATE TABLE oms_company_address(
id bigint AUTO_INCREMENT primary key,
address_name varchar(200),
send_status int(1),
receive_status int(1),
name varchar(64),
phone varchar(64),
province varchar(64),
city varchar(64),
region varchar(64),
detail_address varchar(200)
);
```

2. 

```sql
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
('Office Address', 1, 1, 'John Doe', '123-456-7890', 'California', 'Los Angeles', 'Downtown', '123 Main St');
```

3. 

```sql
SELECT * FROM oms_company_address;
```

4. 

```sql
SELECT * FROM oms_company_address
ORDER BY id ASC
LIMIT 3;
```

5. 

```sql
UPDATE oms_company_address
SET phone = '666-6666-8888';
```

6. 

```sql
DELETE FROM oms_company_address
WHERE id = target_id;
```



#### NoSQL - MongoDB

1. 

```sql
use test
```

2. 

```sql
db.createCollection("oms_company_address")
```

3. 

```sql
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

```sql
db.oms_company_address.findOne()
```

5.

```sql
db.oms_company_address.find()
```

6.

```sql
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

```sql
db.collection.deleteOne({ id: 1 })
```











