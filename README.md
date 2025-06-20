# 🧑‍💼 Job Hunt - MongoDB Backend API

This is a Spring Boot-based backend REST API designed for a **Job Hunt** application. It uses **MongoDB** for data storage and includes secure **JWT-based authentication**. Swagger UI is integrated for easy API exploration and testing with token-based authorization.

---

## 🛠️ Tech Stack

- ☕ **Java 17**
- 🌱 **Spring Boot 3.4.4**
- 🍃 **MongoDB** (via Spring Data MongoDB)
- 🛡 **Spring Security**
- 🔐 **JWT (JSON Web Tokens)**
- 📘 **Swagger/OpenAPI** (springdoc-openapi)
- 📦 **Maven**

---

## 📁 Project Structure

src/
└── main/
├── java/
│ └── com.hcltech.jobhunt_mongodb/
│ ├── controller
│ ├── model
│ ├── repository
│ ├── service
│ └── security
└── resources/
  └── application.properties


---

## 🔐 Authentication Overview

- ✅ JWT-based authentication using Spring Security
- 📌 Public Endpoints:
  - `POST /auth/register` — Register a user
  - `POST /auth/login` — Authenticate and receive a JWT token
- 🔐 Secured Endpoints:
  - Require the token in the header:  
    `Authorization: Bearer <your_token>`

---

## 🔗 API Endpoints

| Endpoint         | Method | Description              | Auth Required |
|------------------|--------|--------------------------|---------------|
| `/auth/register` | POST   | Register a new user      | ❌ No         |
| `/auth/login`    | POST   | Login and get JWT token  | ❌ No         |
| `/jobpost `      | GET    | Get current user details | ✅ Yes        |
| `/jobposts`      | GET    | Get current user details | ✅ Yes        |
| `/jobposts/{id}` | GET    | Get current user details | ✅ Yes        |
|`/jobposts/{text}`| GET    | Get current user details | ✅ Yes        |

---

## 📚 Swagger UI (API Documentation)

- URL: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### 🔓 How to Authorize:
1. Click on the **Authorize** button.
2. Paste the token in the input box like this:
(Bearer eyJhbGciOiJIUzI1NiIsIn...)
3. Now you're ready to test secured endpoints!

---

## ⚙️ Setup Instructions

### 📥 1. Clone the Repository

bash git clone: 
                https://github.com/yourname/jobhunt_mongodb.git 
                cd jobhunt_mongodb

### 🛠️ 2. Configure MongoDB

Update your application.properties: spring.data.mongodb.uri=mongodb://localhost:27017/jobhunt
✅ Ensure MongoDB is running locally on port 27017.

### 🚀 3. Build & Run the Application
Use Maven Wrapper to compile and run the Spring Boot project:
                                                              ./mvnw clean install
                                                              ./mvnw spring-boot:run

