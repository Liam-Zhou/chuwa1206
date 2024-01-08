# GET
http://api.weatherstack.com/current?access_key=ad4dc020dd29c0945e579e36cc8a7d80&query=New York
https://www.google.com/search?q=API
https://en.wikipedia.org/wiki/Ford_Mustang#/media/File:2018_Ford_Mustang_GT_5.0.jpg
https://leetcode.com/problems/two-sum/description/
https://github.com/frank-z-chen

# POST
https://jsonplaceholder.typicode.com/posts

{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}

https://reqres.in/api/users

{
    "name": "Frank",
    "job": "SDE",
    "id": "825",
    "createdAt": "2024-01-08T08:33:25.793Z"
}

https://httpbin.org/post

{
    "args": {},
    "data": "{\r\n  \"sample\": \"data\",\r\n  \"value\": 123\r\n}\r\n",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Cache-Control": "no-cache",
        "Content-Length": "43",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "cbe4cbca-ad72-40ff-8e41-0282e3b17902",
        "User-Agent": "PostmanRuntime/7.36.0",
        "X-Amzn-Trace-Id": "Root=1-659bb364-0d9dc40b768cf2742ae9789a"
    },
    "json": {
        "sample": "data",
        "value": 123
    },
    "origin": "153.33.147.217",
    "url": "https://httpbin.org/post"
}

https://postman-echo.com/post

{
    "args": {},
    "data": {
        "key1": "value1",
        "key2": "value2"
    },
    "files": {},
    "form": {},
    "headers": {
        "x-forwarded-proto": "https",
        "x-forwarded-port": "443",
        "host": "postman-echo.com",
        "x-amzn-trace-id": "Root=1-659bb370-39c1a9db211d575740556890",
        "content-length": "47",
        "content-type": "application/json",
        "user-agent": "PostmanRuntime/7.36.0",
        "accept": "*/*",
        "cache-control": "no-cache",
        "postman-token": "938f6a83-7279-4c50-9351-91709489f5b5",
        "accept-encoding": "gzip, deflate, br"
    },
    "json": {
        "key1": "value1",
        "key2": "value2"
    },
    "url": "https://postman-echo.com/post"
}

https://jsonplaceholder.typicode.com/comments

{
  "postId": 1,
  "name": "test",
  "email": "test@example.com",
  "body": "This is a test comment"
}


# PUT
https://jsonplaceholder.typicode.com/posts/1

{
  "id": 1,
  "title": "Updated Title",
  "body": "Updated body text",
  "userId": 1
}

https://reqres.in/api/users/2

{
    "name": "Frank",
    "job": "SDE",
    "updatedAt": "2024-01-08T08:34:43.283Z"
}

https://httpbin.org/put

{
    "args": {},
    "data": "{\r\n  \"attribute\": \"value\",\r\n  \"anotherAttribute\": 12345\r\n}\r\n",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Cache-Control": "no-cache",
        "Content-Length": "60",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "2038d334-df90-4c1f-acb2-99773e6c76de",
        "User-Agent": "PostmanRuntime/7.36.0",
        "X-Amzn-Trace-Id": "Root=1-659bb3ae-17e4d9900fcd21f0579083eb"
    },
    "json": {
        "anotherAttribute": 12345,
        "attribute": "value"
    },
    "origin": "153.33.147.217",
    "url": "https://httpbin.org/put"
}

# DELETE
https://jsonplaceholder.typicode.com/posts/1

https://reqres.in/api/users/2

# Error Code 

- 404  https://jsonplaceholder.typicode.com/posts/10000
- 401  https://jsonplaceholder.typicode.com/posts/10000
- 500  https://localhost:8080/weather?city=Champaign

