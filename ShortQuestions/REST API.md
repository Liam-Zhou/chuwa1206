1. 5 GET APIs with different response type

   - JSON Response: https://jsonplaceholder.typicode.com/posts
   - XML Response: https://www.w3schools.com/xml/note.xml
   - HTML Response: https://www.google.com
   - CSV Response: https://people.sc.fsu.edu/~jburkardt/data/csv/hw_200.csv
   - Text Response: https://api.chucknorris.io/jokes/random


2. 5 Post API with json request body, please also paste the response here

    - https://reqres.in/api/users, {
      "name": "fzy",
      "job": "sde"
      }
    - https://jsonplaceholder.typicode.com/todos {
      "title": "sde",
      "completed": "true",
      "userId": "1"
      }
    - https://jsonplaceholder.typicode.com/posts/1/comments {
      "name": "fzy",
      "email  ": "zf2023@gmail.com",
      "body": "none"
      }
    - https://reqres.in/api/users, {
      "name": "abc",
      "job": "xxx"
      }
    - https://reqres.in/api/users, {
      "name": "aaa",
      "job": "bbb"
      }

3. 3 PUT API with json request body, please also paste the response here

   - https://jsonplaceholder.typicode.com//posts/1, {
     "title": "xxxxx",
     "body  ": "none"
     }, {
     "title": "xxxxx",
     "body  ": "none",
     "id": 1
     }
   - https://jsonplaceholder.typicode.com//posts/2, {
     "title": "a",
     "body  ": "none"
     }, {
     "title": "a",
     "body  ": "none",
     "id": 1
     }
   - - https://jsonplaceholder.typicode.com//posts/3, {
       "title": "abc",
       "body  ": "none"
       }, {
       "title": "abc",
       "body  ": "none",
       "id": 1
       }

4. 2 DELETE API

   - https://jsonplaceholder.typicode.com//posts/1, {}
   - https://jsonplaceholder.typicode.com//posts/2, {}

5. Each example with 404, 401,500 and any http status codes you know

   - https://reqres.in/api/users/1000, 404, {}
   - https://reqres.in/api/login, 400, {},  {
     "error": "Missing email or username"
     }
   - GET httpstat.us/500, 500 Internal Server Error
   - GET httpstat.us/401, 401 Unauthorized
