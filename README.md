# User Service

A Spring Boot based User Management Service demonstrating REST API development, layered architecture, validation, exception handling, and PostgreSQL integration.

## Features

* Create User
* Get User by ID
* Get All Users
* Update User
* Delete User
* Request Validation
* Global Exception Handling
* PostgreSQL Persistence

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

## API Endpoints

| Method | Endpoint    | Description    |
| ------ | ----------- | -------------- |
| POST   | /users      | Create User    |
| GET    | /users/{id} | Get User by ID |
| GET    | /users      | Get All Users  |
| PUT    | /users/{id} | Update User    |
| DELETE | /users/{id} | Delete User    |

## Project Structure

controller → REST APIs

service → Business Logic

repository → Database Access

dto → Request/Response Objects

model → Entity Models

common → Shared Components

## Learning Objectives

This project was built to strengthen backend engineering fundamentals including REST API design, layered architecture, validation, exception handling, and database integration using Spring Boot.

