### Building project
Run maven command to build war package: `mvn package` (or use one of the wrappers: `mvnw` or `mvnw.bat`).

### Running application
Run generated war file passing spring datasource properties, eg.:
```
java -jar target/suncode-demo-1.0.0.war \
--spring.datasource.url="jdbc:postgresql://host:port/db_name" \
--spring.datasource.username="user" \
--spring.datasource.password="pass"
```
You can also use another method for passing parameters (listed here: https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)

### Open applciation
Use following address: `http://localhost:8080/index.xhtml`
