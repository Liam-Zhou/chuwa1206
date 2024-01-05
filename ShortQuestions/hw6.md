1. Find the customer’s payments, like credit card 1, credit card 2, paypal, Apple Pay.
    > https://api.v1.com/cosumers/{id}/payments
2. Find the customer’s history orders from 10/10/2022 to 10/24/2022
    > https://api.v1.com/cosumers/{id}/orders/?dateFrom='10/10/2022'&dateTo='10/24/2022'
3. Find the customer’s delievery  addresses
    > https://api.v1.com/cosumers/{id}/addresses
4. If I also want to get customer’s default payment and default delievery address, what kind of the API (URL) should be?
    > https://api.v1.com/cosumers/{id}/payments/default
    
    or

    > https://api.v1.com/cosumers/{id}/payments?type=default
5. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
    - Youtube
      - Get (Home page): https://www.youtube.com/
      - Get (View a video): 
      
        https://www.youtube.com/watch?v=wYpCWwD1oz0&t=13471s
      - Get (View a channel):

        https://www.youtube.com/channel/UCfQ0lSaRTM9tU5qpU-dNg
      - Post (Reply a comments):
        https://www.youtube.com/youtubei/v1/channel/create_channel?key=AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8&prettyPrint=false
    - Twitter(do not have premium, so I cannot see update tweet API)
      - Get (Home page): 
      
        https://twitter.com/home?lang=en
      - Post (Post a tweet):
        https://twitter.com/i/api/graphql/bDE2rBtZb3uyrczSZ_pI9g/CreateTweet
      - Post (Post a reply):
        https://twitter.com/i/api/graphql/bDE2rBtZb3uyrczSZ_pI9g/CreateTweet
        > 虽然使用的API一样但是payload不一样
      - Post (Delete a tweet):
        https://twitter.com/i/api/graphql/VaenaVgh5q5ih7kvyVjgtg/DeleteTweet
      - Post (Pin a tweet):
      
        https://api.twitter.com/1.1/account/pin_tweet.json
      - Post (Like a tweet):
      
        https://twitter.com/i/api/graphql/lI07N6Otwv1PhnEgXILM7A/FavoriteTweet
      - Get (see a user's all tweets):
      
        https://twitter.com/username
      - Get (see one tweet):
      
        https://twitter.com/username/status/tweetId
     
6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
    - Get (Home Page):
      https://blog.com
    - Get (View Bolg):
      https://blog.com/username/artical-title
    - Get (A place that create post):
      https://blog.com/new-story
    - Post (Post a blog)
      https://blog.com/username/artical-title?postPublishedType=