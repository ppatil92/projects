## Spring Boot Docker App
### Project is to create a docker wrapper around spring boot app
Here a spring boot app is deployed inside docker 

### Install Docker
https://linuxconfig.org/how-to-install-docker-on-ubuntu-20-04-lts-focal-fossa/

### Initialize Spring boot app with web dependency
https://start.spring.io/

### Build Spring project using 
mvn clean install

### Build Docker 
docker build -t springio/gs-spring-boot-docker .

### Run Docker with Spring App in it
docker run -p 8080:8080 springio/gs-spring-boot-docker

### Hit url to see response
http://localhost:8080/getName