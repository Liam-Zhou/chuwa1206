### API Design

## Find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

GET /api/customers/{customerId}/payments

## Find the customer’s history orders from 10/10/2022 to 10/24/2022

GET /api/customers/{customerId}/orders?startdate={10/10/2022}&enddate={10/24/2022}

## Find the customer’s delievery addresses

GET /api/customers/{customerId}/addresses

## If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

GET /api/customers/{customerId}/defaults

## Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范

Twitter:

Fetch User's Tweets:
Endpoint: GET /api/users/{userId}/tweets
Description: Retrieve all tweets posted by a specific user.

Post a New Tweet:
Endpoint: POST /api/users/{userId}/tweets
Description: Create a new tweet for the user.

Update a Tweet:
Endpoint: PUT /api/tweets/{tweetId}
Description: Update an existing tweet.

Delete a Tweet:
Endpoint: DELETE /api/tweets/{tweetId}
Description: Delete a tweet.

Paypal:

Fetch User's Transactions:
Endpoint: GET /api/users/{userId}/transactions
Description: Retrieve all transactions associated with a specific user.

Create a Payment:
Endpoint: POST /api/payments
Description: Initiate a new payment transaction.

Update Transaction Status:
Endpoint: PUT /api/transactions/{transactionId}
Description: Update the status of a transaction.

Cancel Payment:
Endpoint: DELETE /api/payments/{paymentId}
Description: Cancel a payment.

## Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

Blog Website:

Fetch Blog Posts:
Endpoint: GET /api/posts
Description: Retrieve all blog posts.

Create a New Blog Post:
Endpoint: POST /api/posts
Description: Create a new blog post.

Update a Blog Post:
Endpoint: PUT /api/posts/{postId}
Description: Update an existing blog post.

Delete a Blog Post:
Endpoint: DELETE /api/posts/{postId}
Description: Delete a blog post.

Path variable is used to specify certain post in the url.

Use plural nouns for collections when it represents multiple items.