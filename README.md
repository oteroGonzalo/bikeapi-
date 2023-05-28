# Readme: Bike API
A simple API that allows to create, store and retrieve bikes and bike parts. 



## Requirements

This app uses the following techonologies:

* Spring Framework
* SpringBoot

## Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

## Building the project
You will need:

*	Java JDK 17 or higher
*	Maven 3.1.1 or higher
* Docker (optional)

Clone the project and use Maven to launch the project

 `mvn clean spring-boot:run`                                                                                                                                                                      

  

## Build with Docker

In case you want to build the project using Docker introduce the following commands in your terminal after cloning the repo. 

	`docker build -t bikeapi .`
  
  `docker run -p 8080:8080 bikeapi`
  
## Accessing the API
You can access the endpoints with Postman 

	
## API Documentation
After launching the project go to: http://localhost:8080/swagger-ui/index.html to check the documentation.

The GET endpoints don't need authentication.
To use the secured endpoints you are required to create an user following these steps:
1. Send a POST request to localhost:8080/user/register with the body:
`{"username":"user",
"password": "1234"}`
2. Send another POST request to localhost:8080/auth with the same body.
3. Access the other endpoints sending the token received from /auth as a header Bearer Token. 


