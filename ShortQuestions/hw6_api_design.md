# hw6: API Design

### 1. Finding Customer Payments
**Question:** Find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
`GET /api/v1/{customerId}/payments`

### 2. Finding Customer's History Orders
**Question:** Find the customer’s history orders from 10/10/2022 to 10/24/2022.
`GET /api/v1/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24`

### 3. Finding Customer's Delivery Addresses
**Question:** Find the customer’s delivery addresses.
`GET /api/v1/{customerId}/addresses`

### 4. Finding Default Payment
**Question:** If I also want to get customer’s default payment and default delivery address, what kind of the API (URL) should be?
`GET /api/v1/{customerId}/payments/default`

### 5. API Collection Examples
**Question:** Find 2 collection of APIs example.

API Reference Examples:

#### Twitter API:
Twitter API reference: [https://developer.twitter.com/en/docs/api-reference-index](https://developer.twitter.com/en/docs/api-reference-index)

- **Get User's Timeline:** `GET https://api.twitter.com/2/users/:id/tweets`
- **Retrieve Single User with Username:** `GET https://api.twitter.com/2/users/by/username/:username`
- **Get Tweets Liked by User:** `GET https://api.twitter.com/2/users/:id/liked_tweets`
- **Tweets Liking Users:** `GET https://api.twitter.com/2/tweets/:id/liking_users`
- **Retweets Information:** `GET https://api.twitter.com/2/tweets/:id/retweeted_by`

#### PayPal API:
Paypal API reference: [https://developer.paypal.com/docs/api/orders/v2/](https://developer.paypal.com/docs/api/orders/v2/)

- **Create a Payment:** `POST https://api-m.paypal.com/v2/payments`
- **Get Payment Details:** `GET https://api-m.paypal.com/v2/payments/{payment_id}`
- **Capture Payment:** `POST https://api-m.paypal.com/v2/payments/authorizations/{authorization_id}/capture`
- **Void Payment:** `POST https://api-m.paypal.com/v2/payments/authorizations/{authorization_id}/void`

- **Create Invoice:** `POST https://api-m.paypal.com/v2/invoicing/invoices`
- **Send Invoice:** `POST https://api-m.paypal.com/v2/invoicing/invoices/{invoice_id}/send`
- **Get Invoice Details:** `GET https://api-m.paypal.com/v2/invoicing/invoices/{invoice_id}`

#### YouTube API:Youtube API reference: [https://developers.google.com/youtube/v3/docs](https://developers.google.com/youtube/v3/docs)

- **Retrieve Videos:** `GET https://www.googleapis.com/youtube/v3/videos`
- **Upload Video:** `POST https://www.googleapis.com/youtube/v3/videos`
- **Update Video:** `PUT https://www.googleapis.com/youtube/v3/videos`

- **Create Playlist:** `POST https://www.googleapis.com/youtube/v3/playlists`
- **List Playlists:** `GET https://www.googleapis.com/youtube/v3/playlists`

- **Fetch Comments:** `GET https://www.googleapis.com/youtube/v3/commentThreads`
- **Post Comment:** `POST https://www.googleapis.com/youtube/v3/comments`
- **Update Comment:** `PUT https://www.googleapis.com/youtube/v3/comments`


### 6. Blog Website API Collection
**Question:** Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE. Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

- GET /api/v1/blogs (Retrieve all blogs)
- POST /api/v1/blogs (Create a new blog)
- GET /api/v1/blogs/{blogId} (Retrieve a specific blog)
- PUT /api/v1/blogs/{blogId} (Update an existing blog)
- DELETE /api/v1/blogs/{blogId} (Delete a blog)
- GET /api/v1/blogs/{blogId}/comments (Retrieve comments for a blog)
- POST /api/v1/blogs/{blogId}/comments (Add a comment to a blog)
- PUT /api/v1/blogs/{blogId}/comments/{commentId} (Update a specific comment)
- DELETE /api/v1/blogs/{blogId}/comments/{commentId} (Delete a specific comment)
- GET /api/v1/blogs/{blogId}/comments/{commentId}/replies (Retrieve replies for a comment)
- POST /api/v1/blogs/{blogId}/comments/{commentId}/replies (Add a reply to a comment)
- PUT /api/v1/blogs/{blogId}/comments/{commentId}/replies/{replyId} (Update a specific reply)
- DELETE /api/v1/blogs/{blogId}/comments/{commentId}/replies/{replyId} (Delete a specific reply)


