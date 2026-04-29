
**Overview**
Student CRUD application using Spring Boot backend and Vite frontend with PostgreSQL database. Uses JDBC for direct SQL operations without ORM.

**Tech Stack**
Backend uses Spring Boot and JdbcTemplate
Database uses PostgreSQL
Frontend uses Vite with JavaScript or React

**Features**
Create new student record
Get all students
Get student by id
Update student details
Delete student

**Backend Structure**
Controller handles API requests
Service contains business logic
Repository runs SQL queries using JDBC

**Database**
Table name is student
Fields are id name email course
Id is primary key and auto increment

**API Endpoints**
POST students create student
GET students get all students
GET students id get one student
PUT students id update student
DELETE students id delete student

**Configuration**
Database url username password in application properties

**Frontend**
Form to add and update student
List to show all students
Buttons for edit and delete
API calls using fetch or axios

**Flow**
Frontend sends request
Backend processes using JDBC
Data stored in PostgreSQL
Response shown on frontend

**Conclusion**
Simple project to learn JDBC CRUD with Spring Boot and frontend integration using Vite
