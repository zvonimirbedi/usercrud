### Tech stack:
* Java 16 
* Spring Boot
* Gradle
* MySql (Dockerized)

### Docker MySQL create image
#### Docker remove image and container if already exists
* sudo docker rmi mysql-image -f
* sudo docker rm mysql-container -f
* sudo docker build -f ./deploy/mysql/Dockerfile . -t "mysql-image"
#### Docker create run Mariadb Container From Image
* sudo docker run --name mysql-container --restart always -p 3306:3306 mysql-image

### Swagger url
* http://localhost:8080/swagger-ui/

### H2 url
* http://localhost:8080/h2-console/