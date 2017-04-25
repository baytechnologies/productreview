# Product Review
Developed by Dinesh Metkari dineshmetkari@gmail.com
The service is product review REST service. It uses an in-memory database to store the data.

### How to Run 

Minimum requirements:
Tomcat 7 embedded. 
JDK 1.7 
Maven 3.x

mvn clean package spring-boot:run -Drun.arguments="spring.profiles.active=test"



### Returns the  information about system health, configurations, etc.

http://localhost:8091/env
http://localhost:8091/health
http://localhost:8091/info
http://localhost:8091/metrics


### Create a product resource

POST /example/v1/products
Accept: application/json
Content-Type: application/json

{
"name" : "Samsung Galaxy S8",
"description" : "Good RAM, Size, Sleek Design",
"city" : "Bangalore",
"rating" : 5
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8090/example/v1/products/1


### Retrieve a paginated list of products
http://localhost:8090/example/v1/products?page=0&size=10

Response: HTTP 200
Content: paginated list 






