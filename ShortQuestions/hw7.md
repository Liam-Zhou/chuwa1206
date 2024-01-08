**5 GET APIs with different response type**

1. 
```json
GET http://api.zippopotam.us/us/98121 
{
    "post code": "98121",
    "country": "United States",
    "country abbreviation": "US",
    "places": [
        {
            "place name": "Seattle",
            "longitude": "-122.3447",
            "state": "Washington",
            "state abbreviation": "WA",
            "latitude": "47.6151"
        }
    ]
}
```

2. 
```json
GET: https://openlibrary.org/api/books?bibkeys=ISBN:0201558025,LCCN:93005405&format=json

{
    "ISBN:0201558025": {
        "bib_key": "ISBN:0201558025",
        "info_url": "https://openlibrary.org/books/OL1429049M/Concrete_mathematics",
        "preview": "full",
        "preview_url": "https://archive.org/details/concretemathemat00grah_444",
        "thumbnail_url": "https://covers.openlibrary.org/b/id/135182-S.jpg"
    },
    "LCCN:93005405": {
        "bib_key": "LCCN:93005405",
        "info_url": "https://openlibrary.org/books/OL1397864M/Zen_speaks",
        "preview": "borrow",
        "preview_url": "https://archive.org/details/zenspeaksshoutso0000caiz",
        "thumbnail_url": "https://covers.openlibrary.org/b/id/240726-S.jpg"
    }
}
```

3. 
```json
GET: https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json
{
    "Count": 11128,
    "Message": "Response returned successfully",
    "SearchCriteria": null,
    "Results": [
        {
            "Make_ID": 4877,
            "Make_Name": "1/OFF KUSTOMS, LLC"
        },
        {
            "Make_ID": 11257,
            "Make_Name": "102 IRONWORKS, INC."
        },
        {
            "Make_ID": 12255,
            "Make_Name": "12832429 CANADA INC."
        },
        .
        .
        .
    ]
}
```

4. 
```json
GET: https://ron-swanson-quotes.herokuapp.com/v2/quotes
[
    "I believe luck is a concept invented by the weak to explain their failures."
]
```

5. 
```json
GET: http://universities.hipolabs.com/
{
    "author": {
        "website": "http://hipolabs.com",
        "name": "hipo"
    },
    "example": "http://universities.hipolabs.com/search?name=middle&country=Turkey",
    "github": "https://github.com/Hipo/university-domains-list"
}
```