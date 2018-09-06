# spring-examples

## spring-cloud-starter

Demo for reloading properties without restarting the server
```
cd spring-cloud-starter
mvn clean package
cp src/main/resources/application.yml target/
cd target
java -jar spring-cloud-starter-demo-0.0.1-SNAPSHOT.jar
```
1. get http://localhost:8080/app
2. make changes to target/application.yml
3. post to http://localhost:8080/actuator/refresh
4. get http://localhost:8080/app and observe the change
