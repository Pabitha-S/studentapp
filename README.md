# Student API – beginner Spring Boot project

Requirements: Java 17+ and Maven (or open in IntelliJ / VS Code / Eclipse).

## Run
    mvn spring-boot:run

API base URL: http://localhost:8080/api/students

## Try it (curl)
    # create
    curl -X POST localhost:8080/api/students -H "Content-Type: application/json" \
      -d '{"name":"Asha","email":"asha@example.com","course":"Java"}'

    # list all / filter by course / get one
    curl localhost:8080/api/students
    curl "localhost:8080/api/students?course=Java"
    curl localhost:8080/api/students/1

    # update
    curl -X PUT localhost:8080/api/students/1 -H "Content-Type: application/json" \
      -d '{"name":"Asha K","email":"asha@example.com","course":"Spring Boot"}'

    # delete
    curl -X DELETE localhost:8080/api/students/1

H2 console: http://localhost:8080/h2-console  (JDBC URL: jdbc:h2:mem:studentdb, user: sa, no password)
