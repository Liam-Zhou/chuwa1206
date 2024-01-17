# find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.

GET /v1/api/customers/{customerId}/payments

# Find the customer’s history orders from 10/10/2022 to 10/24/2022

GET /v1/api/customers/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24

# find the customer’s delievery addresses.

GET /v1/api/customers/{customerId}/adresses

# If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?

GET /v1/api/customers/{customerId}/default-payment

GET /v1/api/customers/{customerId}/default-address

# Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.

twitter API example:

Tweets
Bookmarks
DELETE /2/users/:id/bookmarks/:tweet_id
GET /2/users/:id/bookmarks
POST /2/users/:id/bookmarks
Filtered stream
GET /2/tweets/search/stream
GET /2/tweets/search/stream/rules
POST /2/tweets/search/stream/rules
Hide replies
PUT /2/tweets/:id/hidden
Likes
DELETE /2/users/:id/likes/:tweet_id
DELETE /2/users/:id/likes/:tweet_id
GET /2/tweets/:id/liking_users
GET /2/users/:id/liked_tweets
POST /2/users/:id/likes

youtube API examples:

URIs relative to https://www.googleapis.com/youtube/v3
delete DELETE /captions Deletes the specified caption track.
download GET /captions/id Downloads a caption track. The caption track is returned in its original format unless the request specifies a value for the tfmt parameter and in its original language unless the request specifies a value for the tlang parameter.
insert POST /captions Uploads a caption track.
list GET /captions Returns a list of caption tracks that are associated with a specified video. Note that the API response does not contain the actual captions and that the captions.download method provides the ability to retrieve a caption track.
update PUT /captions Updates a caption track. When updating a caption track, you can change the track's draft status, upload a new caption file for the track, or both.

# Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

GET /posts: Retrieve a list of blog posts.
GET /posts/{postId}: Retrieve a specific post.
POST /posts: Create a new post.
PUT /posts/{postId}: Update an existing post.
DELETE /posts/{postId}: Delete a post.
GET /categories: Retrieve a list of blog categories.
GET /tags: Retrieve a list of blog tags.
GET /comments: Retrieve a list of comments.
POST /comments: Create a new comment on a post.
