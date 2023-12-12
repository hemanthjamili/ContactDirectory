# Contact Directory

Contact Directory is a simple web application with CRUD operations exposed as RestFul web-services and dockerized.
Below are the technologies used: Java, Spring Boot, Spring Data JPA, H2 DB, HTML, CSS, AngularJS.

For the sake of simplicity and easy to run, I have used H2 in-memory Database. To Get Started, kindly download/clone the repository for running the application in your local system.

## Getting Started (Anyone of the below two options):
  1. ### Docker:
       ### Prerequisites:
         Docker must be installed in your machine.
       ### Run Steps:
         1. Pull this docker image using the command "docker pull hemanthjamili/contact-directory:latest
         2. To run the image using the command "docker run -p 8080:8080 hemanthjamili/contact-directory:latest"
         3. To find all the running containers, use command as "docker ps".
         4. To stop a running container, use "docker stop container_name".
       ### Docker Image Link:
         https://hub.docker.com/repository/docker/hemanthjamili/contact-directory
       
  2. ### Maven build:
       ### Prerequisites:
         Must have JRE 16 and Maven installed in your machine
       ### Run Steps:
         1. Clone the code from git to local
         2. Open the cloned code in any of the IDE of your choice.
         3. Run mvn clean install -DskipTests=true command

### Once we finish anyone of the above approaches, the application will be up and running at the below link
  #### App: http://localhost:8080
  #### Swagger link:  http://localhost:8080/swagger-ui/index.html

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

* **Naga Sai Hemanth Jamili** - *Initial work* - [hemanthjamili](https://www.linkedin.com/in/hemanthjamili/)
