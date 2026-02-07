# Endterm Project: Design Patterns & RESTful API

## 1. Project Overview
This project is a Spring Boot RESTful API designed to manage Users, Tasks, and System Reports. It demonstrates the migration of a legacy Java application into a modern web architecture, integrating PostgreSQL for data persistence and adhering to SOLID principles.

The core objective is to practically implement:
* Creational Design Patterns: Singleton, Factory, and DTO.
* Component Principles: REP, CCP, and CRP.
* REST Architecture: Clean endpoints for CRUD operations.

---

## 2. Design Patterns Implemented
This project successfully implements the following patterns:
1.  Singleton Pattern: Implemented in LoggerSingleton to ensure a single logging instance across the application.
2.  Factory Method Pattern: Implemented in ReportFactory to dynamically generate different report types (PDF, CSV) based on user input.
3.  DTO (Data Transfer Object) Pattern: Used to decouple the internal database entities from the API layer (visible in the dto package).

---

## 3. REST API Documentation

### 👤 Users API
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| GET | /api/users | Retrieve a list of all registered users. |
| POST | /api/users | Create a new user (JSON body required). |
| PUT | /api/users/{id} | Update an existing user's details. |
| DELETE | /api/users/{id} | Remove a user from the system. |

Sample JSON for Creating a User:
```json
{
  "username": "hamid_niazi",
  "email": "hamid@example.com",
  "role": "ADMIN"
}    
   Method  Endpoint   Description
  GET   /api/tasks   Retrieve all tasks.
  POST   /api/tasks     Create a new task.    
      
   Method   Endpoint      Description
   GET  /api/reports/pdf  Generates a PDF Report using the PdfReport class.
   GET  /api/reports/csv     Generates a CSV Report using the CsvReport class.
   
 
 4. Project Structure & Proofs
Source Code: Located in src/main/java/com/hamidniazi/endterm_project.

Documentation & Screenshots: All proof of execution (Postman tests and UML Diagrams) can be found in the docs folder.

How to Run
Clone the repository or unzip the project.

Open in IntelliJ IDEA.

Ensure PostgreSQL is running.

Run EndtermProjectApplication.java.

