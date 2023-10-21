# fr_review
Review my skill for rest assured, selenium, java. 
Improve this skills

Review the studies to improve my skills

# Phases

1) Understanding requeriments
    - Functional specifications
    - Swagger ( ref and doc ) https://petstore.swagger.io/
2) Choose the automation tool / Libs
    - Rest Assured ( Mainly focus of the review )
3) Desing
4) Development
5) Excution + CI 
   

# API Test
https://petstore.swagger.io/

# Test Cases 
|TCID |Model|Title|HTTPRequest|URL|RequestBody|Response|Authentication|StatusCode|
|-----|-----|-----|-----------|---|-----------|--------|--------------|----------|
|TC001|USER|Create User|POST|https://petstore.swagger.io/v2/user|{"id": 0,"username": "string","firstName": "string","lastName": "string","email": "string","password": "string","phone": "string","userStatus": 0}| sucessfull operation|NA|200| 
|TC002|USER|Get User|GET|https://petstore.swagger.io/v2/user/{username}|Path Param: UserName|{"id": 0,"username": "string","password": "string","userStatus": 0}|NA|200|
|TC003|USER|Update User|PUT|https://petstore.swagger.io/v2/user/{username}|{"id": 0,"username": "string","firstName": "string","lastName": "string","email": "string","password": "string","phone": "string","userStatus": 0}|NA|200|
|TC004|USER|Delete USER|Delete|https://petstore.swagger.io/v2/user/{username}|Path Param: UserName|{"id": 0,"username": "string","password": "string","userStatus": 0}|NA|200|

