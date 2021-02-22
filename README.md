# to-do-list-api

This repository contains the back end source code of the To do list app.

## Features

### Endpoints

#### GET /items

Returns HTTP **200 OK** and a JSON list containing all items currently added. If no item is registered, returns HTTP **204 No Content** and an empty response body.

HTTP **200 OK** response body example:

```json
[
    {
        "id": 2,
        "title": "To do item title edited",
        "text": "To do item text edited",
        "status": true
    },
    {
        "id": 3,
        "title": "To do item title",
        "text": "To do item text",
        "status": false
    },
    {
        "id": 4,
        "title": "To do item title",
        "text": "To do item text",
        "status": false
    },
    {
        "id": 5,
        "title": "To do item title",
        "text": "To do item text",
        "status": false
    }
]
```

#### POST /items

Requires an item as request body and creates it. Returns HTTP **201 Created** if everything gone correctly and a JSON object representing that item. If something gone wrong (e.g. the request body was sent incorrectly), returns HTTP **400 Bad Request** and a default JSON bad request response.

HTTP **201 Created** example:

Request body:

```json
{
    "title": "To do item title",
    "text": "To do item text",
    "status": false
}
```

Response body:

```json
{
    "id": 10,
    "title": "To do item title",
    "text": "To do item text",
    "status": false
}
```
