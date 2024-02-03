## 5 GET APIs with different response type

## API-GET-1
API: GET https://api.heroku.com/schema
RequestBody: N/A, since it is GET
Response type: Accept:application/vnd.heroku+json; version=3
Response status: 200 OK
```java
{
    "$schema": "http://interagent.github.io/interagent-hyper-schema",
    "type": [
        "object"
    ],
    "definitions": {
        "account-feature": {
            "description": "An account feature represents a Heroku labs capability that can be enabled or disabled for an account on Heroku.",
            "$schema": "http://json-schema.org/draft-04/hyper-schema",
            "stability": "production",
            "strictProperties": true,
            "title": "Heroku Platform API - Account Feature",
            "type": [
                "object"
	…
        },
        {
            "href": "/schema",
            "method": "GET",
            "rel": "self",
            "title": "Schema",
            "targetSchema": {
                "additionalProperties": true
            }
        }
    ],
    "title": "Heroku Platform API"
}
```

## API-GET-2
API: GET http://colormind.io/list/
RequestBody: N/A, since it is GET
Response type: text/html; charset=UTF-8
Response status: 200 OK
```java
{"result":["ui","default","only_god_forgives","water_color","game_of_thrones","flame_photography"]}
```
## API-GET-3
API: GET https://placekeanu.com/200/150
RequestBody: N/A, since it is GET
Response type: image/svg+xml
Response status: 200 OK

The body shows a young man's image.

## API-GET-4
API: GET https://www.w3.org/StyleSheets/base
RequestBody: N/A, since it is GET
Response type: text/css
Response status: 200 OK
```
/* Copyright 1997-2003 W3C (MIT, ERCIM, Keio). All Rights Reserved.
   The following software licensing rules apply:
   http://www.w3.org/Consortium/Legal/copyright-software */

/* $Id: base.css,v 1.16 2020/06/04 15:08:17 gerald Exp $ */

/* this style sheet defines the basic style for all W3C pages */
/* you can point to this by adding:

     <LINK rel="Stylesheet" href="/StyleSheets/base">


   in the HEAD of your HTML document */

body {
  font-family: sans-serif;
  color: black;
  background: white;
  line-height: 1.2;
}

a:link, a:active {
  color: #00e;
  background: transparent;
}

a:visited {
  color: #529;
  background: transparent;
}

div.intro {
  margin-left: 5%;
  margin-right: 5%;
  font-style: italic
}

pre {
  font-family: monospace
}

a:link img, a:visited img {
   border-style: none
}

a img { color: white; }        /* hide the border in Netscape 4 */
@media all {                   /* hide from Netscape 4 */
  a img { color: inherit; }    /* undo the rule above */
}

ul.toc, ol.toc {
  list-style: disc;
  list-style: none;
}

div.issue {
  padding: 0.5em;
  border: none;
  margin-right: 5%;
}

.hideme { display: none }

h1 .h1text { vertical-align: 7px; } /* align text with baseline in W3C icon */

@media print {

  table {
    page-break-inside: avoid
  }

}
```

## API-GET-5
API: GET application/json
RequestBody: N/A, since it is GET
Response type: text/plain
Response status: 200 OK
```
104.48.81.129
```
## 5 Post API with json request body, please also paste the response here

## API-Post-1
API: Post https://jsonplaceholder.typicode.com/todos/
RequestBody:
``` 
{
  "userId": 1,
  "title": "delectus aut autem",
  "completed": true
}

Response status: 201 Created
{
    "userId": 1,
    "title": "delectus aut autem",
    "completed": true,
    "id": 201
}
```

## API-Post-2
API: Post https://jsonplaceholder.typicode.com/users
RequestBody: 
```
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

Response status: 201 Created
```
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

## API-Post-3
API: Post https://jsonplaceholder.typicode.com/comments
RequestBody: 
```
{
    "postId": 1,
    "id": 1,
    "name": "id labore ex et quam laborum",
    "email": "Eliseo@gardner.biz",
    "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
}
```

Response status: 201 Created
```
{
    "postId": 1,
    "id": 501,
    "name": "id labore ex et quam laborum",
    "email": "Eliseo@gardner.biz",
    "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
}
```

## API-Post-4
API: Post https://jsonplaceholder.typicode.com/albums
RequestBody: 

```
{
    "userId": 1,
    "id": 1,
    "title": "quidem molestiae enim"
}
```
Response status: 201 Created
```
{
    "userId": 1,
    "id": 101,
    "title": "quidem molestiae enim"
}
```
## API-Post-5
API: Post https://jsonplaceholder.typicode.com/posts
RequestBody: 
```
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```

Response status: 201 Created
```
{
    "userId": 1,
    "id": 101,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```







## 3 PUT API with json request body, please also paste the response here

API-Put-1
API: Put https://jsonplaceholder.typicode.com/posts/1
RequestBody: 
```
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat providst occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```

Response status: 200 OK
```
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat providst occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```

## API-Put-2
API: Put https://fakestoreapi.com/products/1
RequestBody: 
```
{
    "userId": 1,
    "id": 1,
    "title": "update"
}
```


Response status: 200 OK
```
{
    "id": 1,
    "title": "update"
}
```

## API-Put-3
API: Put https://reqres.in/api/users/2
RequestBody: 
```
{
    "userId": 1,
    "id": 1,
    "title": "update"
}
```

Response status: 200 OK
```
{
    "userId": 1,
    "id": 1,
    "title": "update",
    "updatedAt": "2024-02-02T12:15:00.945Z"
}
```

## 2 DELETE API

## API-Delete-1
API: Delete https://jsonplaceholder.typicode.com/posts/1
RequestBody: none
Response status: 200 OK

## API-Delete-2
API: Delete https://reqres.in/api/users/1
RequestBody: none
Response status: 204 No Content




## Each example with 404, 401,500 and any http status codes you know

404 Not Found
API: GET https://emojihub.yurace.pro/api/all
RequestBody: N/A, since it is GET
Status code: 404 page not found

401 Unauthorized
API: Post https://api.dynapictures.com/designs/{UID}
RequestBody: None
Status code: 401 Unauthorized
RequestBody: 
```
{"message":"Valid API key is required. Add request header like Authorization: Bearer API_KEY"}
```

403 Forbidden
API: GET https://www.apisetu.gov.in/
RequestBody: N/A, since it is GET
Status code: 403 Forbidden

500 Internal Server Error
API: Post https://jsonplaceholder.typicode.com/users
RequestBody: 
```
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
```
Response:
```
SyntaxError: Unexpected end of JSON input
at JSON.parse (<anonymous>)
    at parse (/app/node_modules/body-parser/lib/types/json.js:89:19)
    at /app/node_modules/body-parser/lib/read.js:121:18
    at invokeCallback (/app/node_modules/body-parser/node_modules/raw-body/index.js:224:16)
    at done (/app/node_modules/body-parser/node_modules/raw-body/index.js:213:7)
    at IncomingMessage.onEnd (/app/node_modules/body-parser/node_modules/raw-body/index.js:273:7)
    at IncomingMessage.emit (node:events:525:35)
    at endReadableNT (node:internal/streams/readable:1358:12)
    at processTicksAndRejections (node:internal/process/task_queues:83:21)
```
Status code: 500 Internal Server Error

503 Service Unavailable
API: GET https://ghibliapi.herokuapp.com/locations
RequestBody: N/A, since it is GET
Status code: 503 Service Unavailable
