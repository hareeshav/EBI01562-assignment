# EBI01562-assignment

#Cloud deployment details:

#REST API Base URL:http://hareesh-rest-api.us-east-1.elasticbeanstalk.com

#Angular App Base URL: http://hareesh-assignment-demo.s3-website-us-east-1.amazonaws.com/

#Authentication is enabled with Spring Security and Bearer Token is needed to authorize requests. 

Adminuser: hareesh/admin

#Deployment steps in Local:

#Rest API: mvn clean install

          java -jar target\java -jar spring-boot-service-0.0.1-SNAPSHOT.jar
          
          http://localhost:5000/hareesh-demo/

#Angular App: npm install

             ng serve
             
             http://localhost:4200/

#REST APi details are provided below:

#Postman Rest Client Collection : https://www.getpostman.com/collections/8355952dbcb0ce84ad74

<h4>API Details</h4>
#API Name  - Token Generation

URL - http://localhost:8080/hareesh-demo/token/generate-token

Method - POST

Header - Content-Type: application/json

Body -
<code>
{
	"username":"hareesh",
	"password":"admin"
}

Response :

{
    "status": 200,
    "message": "success",
    "result": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJlZXNoIiwic2NvcGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpc3MiOiJjb20uaGFyZWVzaCIsImlhdCI6MTU3OTMzMTI0NSwiZXhwIjoxNTc5MzQ5MjQ1fQ.AzbhGkJhtGdsvndbvp8niWFfmvaPQD6QY9TBwzXzUHE",
        "username": "hareesh"
    }
}
</code>

#API Name  - List Persons

URL - http://localhost:8080/hareesh-demo/persons

Method - Get

Header - Content-Type: application/json

</code>
    Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJlZXNoIiwic2NvcGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpc3MiOiJjb20uaGFyZWVzaCIsImlhdCI6MTU3OTMzMTI0NSwiZXhwIjoxNTc5MzQ5MjQ1fQ.AzbhGkJhtGdsvndbvp8niWFfmvaPQD6QY9TBwzXzUHE
    
Response -
{
    "status": 200,
    "message": "Person list fetched successfully.",
    "result": [
        {
            "id": 1,
            "firstName": "test",
            "lastName": "test",
            "favColour": "Orange",
            "hobbies": [
                "Football",
                "Shopping"
            ],
            "age": 25
        }
    ]
}
</code>

#API Name  - Create Person

URL - http://localhost:8080/hareesh-demo/persons

Method - POST

Header - Content-Type: application/json

<code>
     Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJlZXNoIiwic2NvcGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpc3MiOiJjb20uaGFyZWVzaCIsImlhdCI6MTU3OTMzMTI0NSwiZXhwIjoxNTc5MzQ5MjQ1fQ.AzbhGkJhtGdsvndbvp8niWFfmvaPQD6QY9TBwzXzUHE
	
Body -
{
	"firstName":"test",
	"lastName":"test",
	"favColour":"test",
	"hobbies":["shopping","football"],
	"age":23
}
Response -

{
    "status": 200,
    "message": "Person saved successfully.",
    "result": {
        "id": 2,
        "firstName": "test",
        "lastName": "test",
        "favColour": "test",
        "hobbies": [
            "shopping",
            "football"
        ],
        "age": 23
    }
}
</code>

#API Name  - Update Person

URL - http://localhost:8080/hareesh-demo/persons/1

Method - PUT

Header - Content-Type: application/json

<code>
    Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJlZXNoIiwic2NvcGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpc3MiOiJjb20uaGFyZWVzaCIsImlhdCI6MTU3OTMzMTI0NSwiZXhwIjoxNTc5MzQ5MjQ1fQ.AzbhGkJhtGdsvndbvp8niWFfmvaPQD6QY9TBwzXzUHE
	
Body -
{
	"firstName":"testupdated",
	"lastName":"test",
	"favColour":"test",
	"hobbies":["shopping","football"],
	"age":23
}

Response -

{
    "status": 200,
    "message": "Person updated successfully.",
    "result": {
        "id": 1,
        "age": 23,
        "first_name": "testupdated",
        "last_name": "test",
        "favourite_colour": "test",
        "hobby": [
            "shopping",
            "football"
        ]
    }
}
</code>

#API Name  - Delete Person

URL - http://localhost:8080/hareesh-demo/persons/1

Method - DELETE

Header - Content-Type: application/json

<code>
    Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJlZXNoIiwic2NvcGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpc3MiOiJjb20uaGFyZWVzaCIsImlhdCI6MTU3OTMzMTI0NSwiZXhwIjoxNTc5MzQ5MjQ1fQ.AzbhGkJhtGdsvndbvp8niWFfmvaPQD6QY9TBwzXzUHE

{
    "status": 200,
    "message": "Person: 1 deleted successfully.",
    "result": null
}
</code>

