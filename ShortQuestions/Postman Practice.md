### Postman practice
#### GET
- API: GET-1
    > URL: https://cat-fact.herokuapp.com/facts/

    > RequestBody: N/A, since it is GET

    > Response status: 200 OK
    ```json
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
    ```
- API: GET-2
  >   URL: https://reqres.in/api/users/23

  >   RequestBody: N/A, since it is GET

  >   Response status: 404 Not Found
    ```json
    {}
    ```

- API: GET-3
  >   URL: https://api.docker.com/containers/json

  >   RequestBody: N/A, since it is GET

  >   Response status: 503 Service Unavailable
    ```html
    <html>

    <body>
        <h1>503 Service Unavailable</h1>
        No server is available to handle this request.
    </body>
    
    </html>
    ```

- API: GET-4
  >   URL: https://api.spotify.com/v1/browse/new-releases

  >   RequestBody: N/A, since it is GET

  >   Response status: 401 Unauthorized
    ```json
    {
      "error": {
        "status": 401,
        "message": "No token provided"
      }
    }
    ```

- API: GET-5
  >   URL: https://api.cryptonator.com/api/ticker/btc-usd

  >   RequestBody: N/A, since it is GET

  >   Response status: 403 Forbidden
    ```html
    <!DOCTYPE html>
  <html lang="en-US">
  
  <head>
      <title>Just a moment...</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=Edge">
      <meta name="robots" content="noindex,nofollow">
      <meta name="viewport" content="width=device-width,initial-scale=1">
      <link href="/cdn-cgi/styles/challenges.css" rel="stylesheet">
      <meta http-equiv="refresh" content="375">
  </head>
  
  <body class="no-js">
      <div class="main-wrapper" role="main">
          <div class="main-content"><noscript>
                  <div id="challenge-error-title">
                      <div class="h2">
                          <span class="icon-wrapper"><div class="heading-icon warning-icon"></div></span><span id="challenge-error-text">Enable JavaScript and cookies to continue</span>
                      </div>
                  </div>
              </noscript></div>
      </div>
      <script>
          (function(){window._cf_chl_opt={cvId: '2',cZone: "api.cryptonator.com",cType: 'managed',cNounce: '29566',cRay: '84220bc6acb52ab0',cHash: '46f42f1fe7bc4cd',cUPMDTk: "\/api\/ticker\/btc-usd?__cf_chl_tk=ya0W6JqLKaZIHkhNgMSi8Qg2fiMNwKiGW2WA5GawkJs-1704691800-0-gaNycGzNCeU",cFPWv: 'g',cTTimeMs: '1000',cMTimeMs: '375000',cTplV: 5,cTplB: 'cf',cK: "visitor-time",fa: "\/api\/ticker\/btc-usd?__cf_chl_f_tk=ya0W6JqLKaZIHkhNgMSi8Qg2fiMNwKiGW2WA5GawkJs-1704691800-0-gaNycGzNCeU",md: "rrQWBUpkkHCGV4unDIZoCyJQPD71lUz.76UlOE244xI-1704691800-1-AR5Zs4-shkjYJwko5ZinaQrvkktuumZwR8mF_vAUy2Nras5XgwMoo3Ot07qgmUT9Lduh1q7HM_zcc-6x8LwPdBqoPdieZ1CitpJnCgXITzWt2ztx4yFasCMD9AJes0nD5tcSmVg1-GvQsMZ5oyfGdi6Gi_1yFebsKaObw4vPYCAeJ8aT4Szvskcpk1VFuZUWYMfhmPayQB0mr4f2bmxVgsl-iDLoYWd0qef71yYMaDTqoBDagWgHIdfe_5X_L3B92GEzK4frU_m4sJT9nftBNANhniKNndEvnAQCogu3R0c3ZME0hXlSIKa7gES2U_ToKu_4j-lUfKrW44QbSk8eiK2nJDutCqiaxWlVfeaCzSRIMtJCvRaXOwKqSHW6JFk9mHiWEup1x60PQGgUKlFiYForUGfWOTlkGlQ_vkSJnd3OFER2ET6fOXiHhGir-k3oC9l1ENMQVmzuZU9rdEQijm6uUYV0hfDl82ZEhVuh40BPw9m8iCttyTIhGPoCBKuExQogjUWm-fIZigeCMX9B3pTou-Ojxsuhdvw70ZJrSLy5K_mRdarx0ruXu7nQ7KkVoPnuJ1dHwWv7ZeMoV-rAnMc9cncHrKDctVZe0CTP41pbRwTlC5H8uiSjTTn0Owkm_QePp3KpWt-OcH21pbtAgUZex9pKpPbO9b1QC4V9-Zx9Wa4f7s9uogocYT2-2ihk5tazQelsC_BygDykeUUyv57XaBFNzGMq9cGnGUyYRP64YRMU9lWdkA8h9inyJJ15aWUh6zo4Gv8fqa9cyRGzyo383Ae8wIhFvlfmREyfGazXMFxaYlvQmuMMaQw4lnt0se42S-tj04wVUAGaut8GMbk-CLFzYOlEEgbOBRBMjy_Hi0doSK0ZdziLMavKU66HFlSmV5IzTnNzpncylLpgo1aZHr19uijhMobC8_yyiF1EkoM8XL_sttBIiZONhPpI4poCPIAreuhFVm8lnGtEdExeKYwn0rVcDVozapHja5B4GuY-QadqIeB_Qi1A0KNPLKWzroZh58MssENB06NwtmZLZcfQPMey24nE1apCEX6KJzIGNAnS9I8LBKuLbFiaxUszdb8UosAXQXQ3PI2Hv4EmGu7eC22fVhNEehD3lAZOSXE1zFrA1LohuUREwKtTPD6ZGMEbt-aZ7PEjKR-bOzsSILYCekS_8jnEjgwzWmui4bWB3-csZbGdWQFchH-SEQD-d1lDqLXRh-wDrfq3Bgb3IfusFLb4o6Joqo0l9ca9uD0rObTq2BQwo_1UkrWU2mjz0R8e86NwOmSc164Bzpat7-zPAFhcH1lMmv3tBFiSjxezr5NM_Gtb60A3WTcKyiWXEnchPSlPuQcEItAWdX1G91nkez89OCfksAaMGIThB5OIx2Pmw-9-qnNMfNxXaVVWfSOmIyTkuurJcblo-lk529mEFOf_BedDNzr3sBMZ0w4OF44wDQTlipxE9B4ModuPtTGRDdimbJlHmsmKw4bVBTht0ZWjWdCMFdqi1hWJ8HrkSfD2rzG3TWAWgagVFn0vGCnQjxqjgV1khkY1nnMaIK2KUgbA5ZXGFeDlqYEgcsIIU41fgn11J1KgKQ6WwUhlfOWqcgsYfC_JA8DYTRvjBK8T6sxQiHplOmGG8N8NDFDwFq9e4_3_XxVp5ZGSl0du1SFPpmjZQdrmnayASllt4qEbcrHuYJAulUnQpodgRi5ilTV7gUuZ6roSnSRTRSukB5Jl1NV2VKqwQ-O-7qG7VU8KwYRe3VFj6U1Yg5VSqvfQyZ4vk8Y--eBvhCLtQIiP0lkPSMRP9c_EEpVqSvS3mxGOaa7C0Cg5to3pmX9WQ6GZ8RcUWWveBNwLo1xbWayDzeMEb6d-zqCecEmce3_qRYei507l6Cv2_mwTqHnmTDH-6UK2IWCHOJZpvsOKJO27OOgd74Fla-4ERwoodrtrxGNwvxNLRSLrJ_JaJlmw5fW_yLNuOzTHfGd948xEJ1Psvk6JRYeT08nfl2Ez7S7EEOaohZXTGEbJXkPz7sg9ArwyMD7Zq19EmTyVpEf3NIBqzRTfjBiCOCHCzoFXOcDnZhF1Jh5RE_6YLilicXJ17edaf4y2Zwyd-n-1tyL_gk_40KShwsDHQ1pwPTBlX5C4MVXzSwP7fvnRJgLSweyczyyEJGaTldozaZih7d7PJODugeUBnYKPLrEAVfYqXoxYFYkrM7a-kLCD395i_xtYTkh25s6MIc_1gwm73DNRWutx0X8Oudu8DyE4hsbiB3xnSUv8LEmRYvzHUu76s0VKK44vbyp1ybkdsYpGyrjlXXkqmH7fC3LwS7F9j1wFFeZTFCCiEyXHuakUcHraN7VnvU0Qsui0HoFcuiBI-dpaLXl7XWEuXcu537huwMJwmqqwCxBC_huTuNofJqiSftcHOMSiUpGG0dXErhjk5p-bH-kwJhE0B76T3EMgCh0I8kQVqWWoHkS9G6nXTSqXM2Q-",cRq: {ru: 'aHR0cHM6Ly9hcGkuY3J5cHRvbmF0b3IuY29tL2FwaS90aWNrZXIvYnRjLXVzZA==',ra: 'UG9zdG1hblJ1bnRpbWUvNy4zNi4w',rm: 'R0VU',d: 'ALUC4+2btfHmwRWh7+knDL0TUJUcYDt/AK3wJc8DTHxWjDyickYAxoOMi/K3BfVwXJn51UWv4N2iYB+RVPbQCAiLoyQNIlrj54grBs4jjaRtwsqUEZc1iOnaru+ZtJuPbp2XF2jxhQRXhqwFjSIWPDpAUoAfCDebFpJWvc4B1I9vQM5RPNW7GPxWJVfTyRpETqmmb9gU23Os3e7S6AU0aNtfgZ2VpDsLZaL8+kL5FODmljQtdGnFPD0FZcwIQKhbPjoVXu1BCIoyXuMA9Gu3cLykMS0Wk3gOGYIcBEBFYNmsiQXpybFCm+iVHke4E8/ibug2CcbrhMniNmBUj+BYax6qqvpHXSelh/Hgjghl5npyKdzrLiuRPVif6+S4uO+g4+3ZWzUMho5JQbvdoTAiGKQMbSafSkoC1LVD7Yres+J5UxumTn1KEEKNcQFCL5cRj1tU/sKZtsAti1HSOLlGnbW3dP1Mi8gYlxoDeupdmZgfGvxpP4lq0gsD6RjpvQj4',t: 'MTcwNDY5MTgwMC4xMTQwMDA=',cT: Math.floor(Date.now() / 1000),m: 'WzPE5NakLTcbWDwsRESWalTc0Wo0hoPGyULrrKR0tBk=',i1: '3ORaKY8Okww9q2HyVvLbtw==',i2: '+xNUcYqtKGUN/2zufAPxfg==',zh: 'wVVge4yDkM2bNTfgmJvu9WIhnFdWgNX1LutbnrGgnto=',uh: 'fJ2afm7kenTaukRY4bJj0u3ka5A0pcuYRjJ3GY+/5E8=',hh: '9dEzqGM7vC/yBsQPS+1TbKxvwmv6j1/SXzjJLni4IUE=',}};var cpo = document.createElement('script');cpo.src = '/cdn-cgi/challenge-platform/h/g/orchestrate/chl_page/v1?ray=84220bc6acb52ab0';window._cf_chl_opt.cOgUHash = location.hash === '' && location.href.indexOf('#') !== -1 ? '#' : location.hash;window._cf_chl_opt.cOgUQuery = location.search === '' && location.href.slice(0, location.href.length - window._cf_chl_opt.cOgUHash.length).indexOf('?') !== -1 ? '?' : location.search;if (window.history && window.history.replaceState) {var ogU = location.pathname + window._cf_chl_opt.cOgUQuery + window._cf_chl_opt.cOgUHash;history.replaceState(null, null, "\/api\/ticker\/btc-usd?__cf_chl_rt_tk=ya0W6JqLKaZIHkhNgMSi8Qg2fiMNwKiGW2WA5GawkJs-1704691800-0-gaNycGzNCeU" + window._cf_chl_opt.cOgUHash);cpo.onload = function() {history.replaceState(null, null, ogU);}}document.getElementsByTagName('head')[0].appendChild(cpo);}());
      </script>
  </body>
  
  </html>
    ```
  
#### POST
- API: POST-1
  >   URL: https://reqres.in/api/users
  ```json
  RequestBody: 
  {}
  ```
  
  >   Response status: 200 OK
    ```json
    {
      "id": "31",
      "createdAt": "2024-01-08T05:46:20.357Z"
    }
    ```

- API: POST-2
  >   URL: https://reqres.in/api/register
  ```json
  RequestBody: 
  {
    "email": "eve.holt@reqres.in",
    "password": "pistol"
  }
  ```
  >   Response status: 200 OK
    ```json
    {
      "id": 4,
      "token": "QpwL5tke4Pnpja7X4"
    }
    ```

- API: POST-3
  >   URL: https://reqres.in/api/register
  ```json
  RequestBody: 
  {
    "email": "eve.holt@reqres.in"
  }
  ```

  >   Response status: 400 Bad Request
    ```json
    {
      "error": "Missing password"
    }
    ```

- API: POST-4
  >   URL: https://reqres.in/api/login
  ```json
  RequestBody: 
  {
    "email": "eve.holt@reqres.in",
    "password": "cityslicka"
  }
  ```

  >   Response status: 200 OK
    ```json
    {
      "token": "QpwL5tke4Pnpja7X4"
    }
    ```

- API: POST-5
  >   URL: https://reqres.in/api/login
  ```json
  RequestBody: 
  {
    "email": "eve.holt@reqres.in"
  }
  ```

  >   Response status: 400 Bad Request
    ```json
    {
      "error": "Missing password"
    }
    ```

#### PUT
- API: PUT-1
  >   URL: https://jsonplaceholder.typicode.com/posts/1
  ```json
  {
    "id": 1,
    "title": "foo",
    "body": "bar",
    "userId": 1
  }
  ```

  >   Response status: 200 OK
  ```json
  {
    "id": 1,
    "title": "foo",
    "body": "bar",
    "userId": 1
  }
  ```

- API: PUT-2
  >   URL: https://jsonplaceholder.typicode.com/users/150
  ```json
  {
    "id": "zzzzzzz"
  }
  ```

  >   Response status: 500 Internal Server Error
  ```
  TypeError: Cannot read properties of undefined (reading 'id')
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
  ```

- API: PUT-3
  >   URL: https://jsonplaceholder.typicode.com/users
  ```json
  {
    "": ""
  }
  ```

  >   Response status: 404 Not Found
  ```json
  {}
  ```

#### DELETE
- API: DELETE-1
  >   URL: https://jsonplaceholder.typicode.com/posts/1

  > RequestBody: N/A, since it is DELETE

  >   Response status: 200 OK
  ```json
  {}
  ```

- API: DELETE-2
  >   URL: https://jsonplaceholder.typicode.com/posts

  > RequestBody: N/A, since it is DELETE

  >   Response status: 404 Not Found
  ```json
  {}
  ```