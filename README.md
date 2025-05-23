# 📚 Library Management System

The **Library Management System** is a full-stack web application built with **Spring Boot** and **Thymeleaf**. It allows users to manage books, authors, and publishers, as well as handle secure user registration and authentication using JWT tokens. The UI is styled with modern tools like **Tailwind CSS**.

---

## ✨ Features

- ✅ Add, edit, and delete books
- ✅ Manage authors and publishers
- ✅ User registration and login (email/password)
- ✅ Social login with OAuth2 (e.g., Google)
- ✅ JWT-based security (access and refresh tokens)
- ✅ Server-side rendered UI using Thymeleaf
- ✅ Responsive and modern interface with Tailwind CSS

---

## 🛠 Technologies Used

- **Java 17+**
- **Spring Boot**
- **Spring Security (JWT, OAuth2)**
- **Thymeleaf (HTML templating)**
- **Tailwind CSS** (via CDN)
- **H2 Database** (in-memory for dev/testing)
- **PostgreSQL** (optional for production)
- **Maven** for build automation

---

## 🚀 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system

## APPLICATION PROPERTIES

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
