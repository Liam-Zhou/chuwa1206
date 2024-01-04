**API Design**

1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

    `customers/{user_id}/payments`

2. Find the customer’s history orders from 10/10/2022 to 10/24/2022 
    
    `customers/{user_id}/orders?start_date=10/10/2022&end_date=10/24/2022`

3. find the customer’s delievery  addresses

    `customers/{user_id}/delivery_addresses`

4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

    - `customers/{user_id}/delivery_addresses?type=default`
    - `customers/{user_id}/payments?type=default`

5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
    - Paypal
        - `https://api-m.sandbox.paypal.com/v1/invoicing/invoices?page=3&page_size=4&total_count_required=true`
    
    - Youtube
        - `https://www.googleapis.com/youtube/v3/activities`
        - `https://www.googleapis.com/youtube/v3/videos`
6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE. Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

    - GET: `blog.com/blogs`
    - GET: `blog.com/blogs/{blog_id}`
    - POST: `blog.com/blogs`
    - PUT: `blog.com/blogs/{blog_id}`
    - DELETE: `blog.com/blogs/{blog_id}`
