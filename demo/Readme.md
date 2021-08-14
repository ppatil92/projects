## Setup and run
Build :- mvn clean install

Run :- mvn spring-boot:run

## add person 
http://localhost:8080/person/add
```
{
    "id": 1,
    "firstName": "pp",
    "lastName": "pp"
}
```
## add Address
http://localhost:8080/address/add
```
{
    "addressList": [
        {
            "city": "mumbai",
            "street": "",
            "state": "",
            "postalCode": "",
            "person": null
        }
        
    ],
    "personId":"1"
    }

```

## Person edit
http://localhost:8080/person/edit
```
{
    "id": 1,
    "firstName": "pp22",
    "lastName": "pp"
}
```


## Other apis 
See Person And Address Controller for full list of apis <br>
http://localhost:8080/address/getAllAddress <br>
http://localhost:8080/person/getCount