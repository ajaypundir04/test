Coding challenge: 

----
Task Description
Cindy is riding a bicycle. Cindy has a device on her which is programmed to call a service which
will store her current location. This is done to share Cindy's current and last known location with
a centralized rider tracking application and with any other internal service that finds that
information relevant.
Your task is to implement an in-memory location history service that can track Cindy, Steve or
any other rider.
The Location Service should expose the following endpoints through HTTP/REST :

- POST /location/{rider_id}/now - appends the location to the history for the specied rider
- GET /location/{rider_id}?max=<n> - retrieves at most n historical locations for the specied

rider. The most recent locations (in chronological order of insertion) should be returned rst.
API Schemas/Contracts


```
curl --location --request POST
'localhost:8080/location/steve/now' \
--header 'Content-Type: application/json' \
--data-raw '{
"lat": 12.34,
"long": 56.78
}
```

```
curl --location --request
GET
'localhost:8080/location/
steve?max=3
```

```json
{
  "rider_id": "steve",
  "history": [
    {
      "lat": 12.34,
      "long": 56.78
    },
    {
      "lat": 12.44,
      "long": 56.79
    }
  ]
}
```

-----------

``
Controller - > LocationController (apis)
Service --> LocationService (include some business logic (getting n most location))
Repository Layer-> In-memory (Map)
Entities -->(name) {lat, location}
request/response --> {JSON payload as per contract}
```