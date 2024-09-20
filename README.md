# Microservices Project with Docker

This project is a demonstration of a microservices architecture using Spring Boot and Docker. 
The project consists of two main microservices: `user-service` and `company-service`. 
These services communicate with each other via RESTful APIs and use an in-memory H2 database to store data.

## Microservices Overview

### 1. **user-service**
This microservice handles all operations related to users.

#### Endpoints:
- `/api/users/{userId}` - Retrieve a user by their ID.
- `/api/users/lastname/{lastName}` - Retrieve users by their last name.
- `/api/users` - Retrieve all users.

### 2. **company-service**
This microservice manages company data and interacts with the `user-service` to fetch associated employee information.

#### Endpoints:
- `/api/companies/{companyId}` - Retrieve a company by its ID, including the list of employees.
- `/api/companies/name/{name}` - Retrieve a company by its name, including the list of employees.
- `/api/companies` - Retrieve all companies and their associated employees.

## Project Structure

- **user-service**: Handles user-related operations and stores data about users (first name, last name, phone number, etc.).
- **company-service**: Manages company information, including a list of employee IDs, which are fetched from the `user-service` to display employee details along with the company data.

## Technologies Used

- **Java 17**: The base language for the microservices.
- **Spring Boot**: Framework for building the RESTful services.
  - Spring Data JPA: For database access and management.
  - Spring Cloud OpenFeign: For communication between microservices.
- **H2 Database**: In-memory database for data persistence during runtime.
- **Docker**: For containerizing the microservices and running them together.
- **Lombok**: To reduce boilerplate code for getters, setters, and constructors.

## Installation and Startup Instructions

### Prerequisites
- **Java 17**
- **Maven**: For building the project.
- **Docker**: For running the application in containers.

### Steps to Install and Run

1. **Clone the repository**:
2. **Build the project:**: mvn clean package
3. **Run the project with Docker:**: docker-compose up --build

Access the services:
user-service: http://localhost:8081/users
company-service: http://localhost:8083/companies

H2 Database Console Access:
user-service H2 Console: http://localhost:8081/h2-console
company-service H2 Console: http://localhost:8083/h2-console

JDBC URL: jdbc:h2:mem:userdb (for user-service)
JDBC URL: jdbc:h2:mem:companydb (for company-service)
Username: sa
Password: 

