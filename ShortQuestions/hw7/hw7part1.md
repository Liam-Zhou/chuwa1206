API-GET-1
API: GET https://cat-fact.herokuapp.com/facts/
RequestBody: N/A, since it is GET
Response status:  200 OK
[
    {
        "status": {
            "verified": true,
            "sentCount": 1
        },
        "_id": "58e008780aac31001185ed05",
        "user": "58e007480aac31001185ecef",
        "text": "Owning a cat can reduce the risk of stroke and heart attack by a third.",
        "__v": 0,
        "source": "user",
        "updatedAt": "2020-08-23T20:20:01.611Z",
        "type": "cat",
        "createdAt": "2018-03-29T20:20:03.844Z",
        "deleted": false,
        "used": false
    },
    {
        "status": {
            "verified": true,
            "sentCount": 1
        },
        "_id": "58e009390aac31001185ed10",
        "user": "58e007480aac31001185ecef",
        "text": "Most cats are lactose intolerant, and milk can cause painful stomach cramps and diarrhea. It's best to forego the milk and just give your cat the standard: clean, cool drinking water.",
        "__v": 0,
        "source": "user",
        "updatedAt": "2020-08-23T20:20:01.611Z",
        "type": "cat",
        "createdAt": "2018-03-04T21:20:02.979Z",
        "deleted": false,
        "used": false
    },
    {
        "status": {
            "verified": true,
            "sentCount": 1
        },
        "_id": "588e746706ac2b00110e59ff",
        "user": "588e6e8806ac2b00110e59c3",
        "text": "Domestic cats spend about 70 percent of the day sleeping and 15 percent of the day grooming.",
        "__v": 0,
        "source": "user",
        "updatedAt": "2020-08-26T20:20:02.359Z",
        "type": "cat",
        "createdAt": "2018-01-14T21:20:02.750Z",
        "deleted": false,
        "used": true
    },
    {
        "status": {
            "verified": true,
            "sentCount": 1
        },
        "_id": "58e008ad0aac31001185ed0c",
        "user": "58e007480aac31001185ecef",
        "text": "The frequency of a domestic cat's purr is the same at which muscles and bones repair themselves.",
        "__v": 0,
        "source": "user",
        "updatedAt": "2020-08-24T20:20:01.867Z",
        "type": "cat",
        "createdAt": "2018-03-15T20:20:03.281Z",
        "deleted": false,
        "used": true
    },
    {
        "status": {
            "verified": true,
            "sentCount": 1
        },
        "_id": "58e007cc0aac31001185ecf5",
        "user": "58e007480aac31001185ecef",
        "text": "Cats are the most popular pet in the United States: There are 88 million pet cats and 74 million dogs.",
        "__v": 0,
        "source": "user",
        "updatedAt": "2020-08-23T20:20:01.611Z",
        "type": "cat",
        "createdAt": "2018-03-01T21:20:02.713Z",
        "deleted": false,
        "used": false
    }
]


API-GET-2
API: GET https://cataas.com/cat
RequestBody: N/A
Response status:  200 OK
Response body is a image


API-GET-3
API: GET https://api.docker.com/containers/json
RequestBody: N/A
Response status:  503 Service Unavailable
Response body is a image


API-GET-4
API: GET https://api.cryptonator.com/api/ticker/btc-usd
RequestBody: N/A
Response status:  403 Forbidden
Response body is a image

API-GET-5
API: GET https://dog-facts-api.herokuapp.com/api/v1/resources/dogs/all
RequestBody: N/A
Response status:  404 NOT FOUND
Response body is a image



API-POST-1
https://reqres.in/api/users
Request Body:
{
    "name":"xz",
    "job":"no job"
}
Response Body:
{
    "page": 1,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
    "data": [
        {
            "id": 1,
            "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
            "avatar": "https://reqres.in/img/faces/1-image.jpg"
        },
        {
            "id": 2,
            "email": "janet.weaver@reqres.in",
            "first_name": "Janet",
            "last_name": "Weaver",
            "avatar": "https://reqres.in/img/faces/2-image.jpg"
        },
        {
            "id": 3,
            "email": "emma.wong@reqres.in",
            "first_name": "Emma",
            "last_name": "Wong",
            "avatar": "https://reqres.in/img/faces/3-image.jpg"
        },
        {
            "id": 4,
            "email": "eve.holt@reqres.in",
            "first_name": "Eve",
            "last_name": "Holt",
            "avatar": "https://reqres.in/img/faces/4-image.jpg"
        },
        {
            "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
        },
        {
            "id": 6,
            "email": "tracey.ramos@reqres.in",
            "first_name": "Tracey",
            "last_name": "Ramos",
            "avatar": "https://reqres.in/img/faces/6-image.jpg"
        }
    ],
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}

API-POST-2
https://jsonplaceholder.typicode.com/todos
Request Body:
{
      "title": "sde",
      "completed": "true",
      "userId": "1"
}
Response Body:
[
    {
        "userId": 1,
        "id": 1,
        "title": "delectus aut autem",
        "completed": false
    },
and etc. Too Long.

API-POST-3
https://jsonplaceholder.typicode.com/posts/1/comments
Request Body:
{
   "name": "xz",
      "email  ": "xz@xz.com",
      "body": "none"
      
}
Response Body:
[
    {
        "postId": 1,
        "id": 1,
        "name": "id labore ex et quam laborum",
        "email": "Eliseo@gardner.biz",
        "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
    },
    {
        "postId": 1,
        "id": 2,
        "name": "quo vero reiciendis velit similique earum",
        "email": "Jayne_Kuhic@sydney.com",
        "body": "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"
    },
    {
        "postId": 1,
        "id": 3,
        "name": "odio adipisci rerum aut animi",
        "email": "Nikita@garfield.biz",
        "body": "quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione"
    },
    {
        "postId": 1,
        "id": 4,
        "name": "alias odio sit",
        "email": "Lew@alysha.tv",
        "body": "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati"
    },
    {
        "postId": 1,
        "id": 5,
        "name": "vero eaque aliquid doloribus et culpa",
        "email": "Hayden@althea.biz",
        "body": "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et"
    }
]

API-PUT-1:
https://jsonplaceholder.typicode.com/posts/1
{
     "title": "123",
     "body  ": "none"
}

{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}

API-PUT-2:
https://reqres.in/api/users/2
{
    "name": "XZ",
    "job": "123",
    "updatedAt": "2024-01-08T08:34:43.283Z"
}


API-PUT-3:
https://reqres.in/api/users/3
{
    "name": "XZ",
    "job": "123",
    "updatedAt": "2024-01-08T08:34:43.283Z"
}

API-DELETE-12:
https://jsonplaceholder.typicode.com/posts/1

https://reqres.in/api/users/2


Error Code 
404  https://jsonplaceholder.typicode.com/posts/10000
401  https://jsonplaceholder.typicode.com/posts/10000
500  https://localhost:8080/ Since there is no openapi that has server error.