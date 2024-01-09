# HW7

5 GET API

1. API: https://jsonplaceholder.typicode.com/posts
   Request Body: N/A
   Response: 

   ```json
    {
           "userId": 1,
           "id": 1,
           "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
           "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
       },
       {
           "userId": 1,
           "id": 2,
           "title": "qui est esse",
           "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
       },
   ```

   Response status: 200

2. API:https://jsonplaceholder.typicode.com/albums/1
   Request Body: N/A
   Response:

   ```JSON
   {
       "userId": 1,
       "id": 1,
       "title": "quidem molestiae enim"
   }
   ```

   Response status: 200

3. API: https://jsonplaceholder.typicode.com/users/1
   Request Body: N/A
   Response: 

   ```json
   {
       "id": 1,
       "name": "Leanne Graham",
       "username": "Bret",
       "email": "Sincere@april.biz",
       "address": {
           "street": "Kulas Light",
           "suite": "Apt. 556",
           "city": "Gwenborough",
           "zipcode": "92998-3874",
           "geo": {
               "lat": "-37.3159",
               "lng": "81.1496"
           }
       },
       "phone": "1-770-736-8031 x56442",
       "website": "hildegard.org",
       "company": {
           "name": "Romaguera-Crona",
           "catchPhrase": "Multi-layered client-server neural-net",
           "bs": "harness real-time e-markets"
       }
   }
   ```

   Response status: 200

4. API: https://jsonplaceholder.typicode.com/users/101
   Request Body: N/A
   Response: {}
   Response status: 404

5. API: https://jsonplaceholder.typicode.com/u
   Request Body: N/A
   Response: {}
   Response status: 404

5 POST API

1. API: https://jsonplaceholder.typicode.com/posts
   Request Body: 

   ```json
   {
       "useeId":1,
       "id":1,
       "title": "test post",
       "body": "test body"
   }
   ```

   Response:

   ```json
   {
       "useeId": 1,
       "id": 101,
       "title": "test post",
       "body": "test body"
   }
   ```

   Response status: 201

2. API:https://jsonplaceholder.typicode.com/posts
   Request Body:

   ```json
   {
       "useeId":2,
       "id":102,
       "title": "test post2",
       "body": "test body2"
   }
   ```

   Response:

   ```json
   {
       "useeId":2,
       "id":101,
       "title": "test post2",
       "body": "test body2"
   }
   ```

   Response status: 201

3. API:https://jsonplaceholder.typicode.com/posts
   Request Body:

   ```json
   {
       "useeId":100,
       "id":1,
       "title": "test post2",
       "body": "test body2"
   }
   ```

   Response:

   ```json
   {
       "useeId": 100,
       "id": 101,
       "title": "test post2",
       "body": "test body2"
   }
   ```

   Response status:201

4. API:https://jsonplaceholder.typicode.com/user
   Request Body:

   ```json
   {
       "id": 11,
       "name": "Leanne Graham",
       "username": "Bret",
       "email": "Sincere@april.biz",
       "address": {
         "street": "Kulas Light",
         "suite": "Apt. 556",
         "city": "Gwenborough",
         "zipcode": "92998-3874",
         "geo": {
           "lat": "-37.3159",
           "lng": "81.1496"
         }
       }
       
     }
   ```

   Response:{}
   Response status: 404

5. API:http://localhost:8080/api/v1/posts
   Request Body:

   ```json
   {"title": "This is title2", "description": "this is description2", "content": "This is content2"}
   ```

   Response:

   ```json
   {
       "id": 5,
       "title": "This is title2",
       "description": "this is description2",
       "content": "This is content2"
   }
   ```

   Response status: 201

3 PUT API

1. API:https://jsonplaceholder.typicode.com/posts/1
   Request Body:

   ```json
   {
       "userId": 1,
       "id": 1,
       "title": "test"
   }
      
   ```

   Response:

   ```json
   {
       "userId": 1,
       "id": 1,
       "title": "test"
   }
   ```

   Response status: 200

2. API:https://jsonplaceholder.typicode.com/posts/1
   Request Body:

   ```json
   {
       "userId": 1,
       "id": 1,
       "body": "body"
   }
      
   ```

   Response:

   ```json
   {
       "userId": 1,
       "id": 1,
       "body": "body"
   }
   ```

   Response status:200

3. API:https://jsonplaceholder.typicode.com/posts/111
   Request Body:

   ```json
   {
       "userId": 1,
       "id": 1,
       "body": "body"
   }
      
   ```

   Response:TypeError: Cannot read properties of undefined (reading 'id')

   at update (/app/node_modules/json-server/lib/server/router/plural.js:262:24)

   at Layer.handle [as handle_request] (/app/node_modules/express/lib/router/layer.js:95:5)

   at next (/app/node_modules/express/lib/router/route.js:137:13)

   at next (/app/node_modules/express/lib/router/route.js:131:14)

   at Route.dispatch (/app/node_modules/express/lib/router/route.js:112:3)

   at Layer.handle [as handle_request] (/app/node_modules/express/lib/router/layer.js:95:5)

   at /app/node_modules/express/lib/router/index.js:281:22

   at param (/app/node_modules/express/lib/router/index.js:354:14)

   at param (/app/node_modules/express/lib/router/index.js:365:14)

   at Function.process_params (/app/node_modules/express/lib/router/index.js:410:3)

   Response status: 500

2 DELETE API

1. API:https://jsonplaceholder.typicode.com/posts/1
   Request Body: NA
   Response: {}
   Response status: 200
2. API:https://jsonplaceholder.typicode.com/posts/1011
   Request Body: NA
   Response: {}
   Response status: 200