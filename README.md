# DoIt Application

A simple Task Manager REST API built with Spring Boot. This app provides CRUD operations to manage tasks with the following REST endpoints:

## Endpoints

- `GET /tasks` — Retrieve all tasks
- `GET /tasks/{id}` — Retrieve a task by its ID
- `POST /tasks` — Create a new task
- `PUT /tasks/{id}` — Update an existing task by ID (replace full task)
- `PATCH /tasks/{id}` — Partially update an existing task by ID
- `DELETE /tasks/{id}` — Delete a task by ID

## Request Parameters

- **name** (string) — Required. The name/title of the task.
- **priority** (string) — Optional. One of `HIGH`, `MEDIUM`, or `LOW`. Defaults to `MEDIUM`.
- **isCompleted** (boolean) — Optional. Defaults to `false`.

Example POST request JSON body:
```json
{
    "name": "Finish API documentation",
    "priority": "HIGH",
    "isCompleted": false
}
```


## Technology Stack

- Java with Spring Boot framework
- Spring Boot Starters used:
  - `spring-boot-starter-web` for building RESTful web services
  - `spring-boot-starter-data-jpa` for database access with JPA/Hibernate
  - `spring-boot-starter-validation` for request validation
- Apache Derby database embedded for persistence

## Running the Application

Use Maven Wrapper scripts to run the application without Maven installed globally:
```shell
./mvnw spring-boot:run # Unix/macOS
mvnw.cmd spring-boot:run # Windows
```


The application starts on port 8080 by default.

---

This project demonstrates a typical Spring Boot REST API with data validation, database integration, and standard HTTP methods for resource management.


