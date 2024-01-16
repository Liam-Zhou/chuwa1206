API Design

1. find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

   GET /api/v1/customers/{customer_id}/payments

2. Find the customer’s history orders from 10/10/2022 to 10/24/2022

   GET /api/v1/customers/{customer_id}/orders?start_date=10/10/2022&end_date=10/24/2022

3. find the customer’s delievery addresses

   GET /api/v1/customers/{customer_id}/addresses

4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

   GET /api/v1/customers/{customer_id}/payment/default

   GET /api/v1/customers/{customer_id}/addresses/default

5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范

   Twitter:

   GET /api/tweets?username=johndoe&limit=10&page=1

   GET /api/tweets/{tweetId}

   POST /api/tweets

   POST /api/tweets
   Body:
   {
       "text": "Excited about learning REST API development!"
   }

   Paypal:

   POST /api/payments

   POST /api/payments
   Body:
   {
       "amount": 100.00,
       "currency": "USD",
       "description": "Purchase of electronics",
       "redirectUrl": "https://yourapp.com/success"
   }

   POST /api/payments/{paymentId}/execute

   GET /api/payments/{paymentId}

6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

   GET /api/posts

   GET /api/posts/{postId}

   POST /api/posts

   PUT /api/posts/{postId}

   DELETE /api/posts/{postId}

   