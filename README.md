# User Service

A Spring Boot based User Management Service demonstrating REST API development, layered architecture, request validation, global exception handling, and PostgreSQL persistence.

This is a supporting backend fundamentals project in my public portfolio. It focuses on clean API structure, validation, persistence, and standard service-layer design using Java and Spring Boot.

## Implemented Features

* Create user
* Get user by ID
* Get all users
* Update user
* Delete user
* Request validation
* Global exception handling
* PostgreSQL persistence
* DTO-based request/response handling
* Layered backend structure

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

## API Endpoints

| Method | Endpoint      | Description    |
| ------ | ------------- | -------------- |
| POST   | `/users`      | Create user    |
| GET    | `/users/{id}` | Get user by ID |
| GET    | `/users`      | Get all users  |
| PUT    | `/users/{id}` | Update user    |
| DELETE | `/users/{id}` | Delete user    |

## Project Structure

```text
controller   -> REST APIs
service      -> Business logic
repository   -> Database access
dto          -> Request/response objects
model        -> Entity models
common       -> Shared components
exception    -> Global exception handling
```

## High-Level Flow

```text
Client Request
      |
      v
Controller
      |
      v
Request Validation
      |
      v
Service Layer
      |
      v
Repository
      |
      v
PostgreSQL
```

## Design Focus

### 1. Layered architecture

The project separates API handling, business logic, persistence, and DTOs into separate layers.

### 2. Request validation

Input validation is handled before business logic execution to avoid invalid data entering the service layer.

### 3. Global exception handling

Common errors are handled in a centralized way so that API responses remain consistent.

### 4. DTO-based API design

Request and response DTOs are used instead of exposing entity objects directly.

## Learning Focus

This project demonstrates backend fundamentals such as:

* REST API development
* CRUD API design
* Spring Boot layered architecture
* PostgreSQL integration
* Spring Data JPA
* Request validation
* Exception handling
* DTO design
* Clean service/repository separation

## Portfolio Positioning

This project is intentionally simple and focuses on backend fundamentals. More advanced backend patterns are demonstrated in my other public projects:

* Mini Integration Platform — webhook ingestion, outbox pattern, retry handling, async event processing
* URL Shortener — Redis caching, expiry validation, and asynchronous analytics processing
