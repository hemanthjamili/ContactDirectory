# ContactDirectory

Contact Directory is a simple web application with CRUD operations exposed as RestFull web-services. 
Below are the technologies used: Java, Spring Boot, Spring Data JPA, H2 DB, HTML, CSS, AngularJS.

## Getting Started

For the sake of simplicity and easy to run, I have used H2 in-memory Database. To Get Started, kindly download/clone the repository for running the application in your local system.

### Prerequisites

Your local system mush have JRE16

### REST API

There are 5 Rest-end points for this application. The context-path is set as "/". Hence for home page, kindly access http://localhost:8080

* To insert a new Contact - http://localhost:8080/api/v1/conact - POST method
* To update an existing Contact -  http://localhost:8080/api/v1/conact - PUT method
* To delete an existing Contact -  http://localhost:8080/api/v1/conact/{id} - DELETE method
* To fetch all Contacts -  http://localhost:8080/api/v1/conact - GET method
* To fetch a Contact by ID - http://localhost:8080/api/v1/conact/{id} - GET method

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Naga Sai Hemanth Jamili** - *Initial work* - [hemanthjamili](https://github.com/hemanthjamili)
