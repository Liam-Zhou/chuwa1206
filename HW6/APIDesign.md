# Find the customer’s payments, like credit card 1, credit card 2, PayPal, Apple Pay.
API: GET /customer/{id}/payments
# Find the customer’s history orders from 10/10/2022 to 10/24/2022
API: GET /customer/{id}/history-order?start=10/10/2022&to=10/24/2022
# Find the customer’s delivery addresses
API: GET /customer/{id}/delivery-address
# If I also want to get customer’s default payment and default delivery address, what kind of API (URL) should be?
API for Default Payment: GET /customer/{id}/default-payment
API for Default Delivery Address: GET /customer/{id}/default-delivery-address
# Example Collections of APIs:
Twitter:
Get user's tweets:

GET /users/{username}/tweets
Get user's followers:

GET /users/{username}/followers
Get user's following:

GET /users/{username}/following
Get user's liked tweets:

GET /users/{username}/liked-tweets
PayPal:
Get user's transactions:

GET /users/{id}/transactions
Get user's linked payment methods:

GET /users/{id}/payment-methods
Blog Website:
Get comments on a blog post:

GET /posts/{postId}/comments
Add a comment to a blog post:

POST /posts/{postId}/comments
Update a comment:

PUT /posts/{postId}/comments/{commentId}
Delete a comment:

DELETE /posts/{postId}/comments/{commentId}
# Design APIs for the Following Features:
# List all blog posts:
API: GET /posts
# Get a specific blog post:
API: GET /posts/{postId}
# Create a new blog post:
API: POST /posts
# Update an existing blog post:
API: PUT /posts/{postId}
# Delete a blog post:
API: DELETE /posts/{postId}
# Get comments on a blog post:
API: GET /posts/{postId}/comments
# Add a comment to a blog post:
API: POST /posts/{postId}/comments
# Update a comment:
API: PUT /posts/{postId}/comments/{commentId}
# Delete a comment:
API: DELETE /posts/{postId}/comments/{commentId}
# Get user's authored posts:
API: GET /users/{userId}/posts
# Get user's liked posts:
API: GET /users/{userId}/liked-posts
# Path Variables:
{id}, {username}, {postId}, {commentId}, {userId} are examples of path variables.
# Query Parameters:
start, end are examples of query parameters.
# Subresources:
In the Blog Website example, /posts/{postId}/comments is an example of a subresource, where comments are related to a specific blog post.