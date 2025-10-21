# Teamwork – Employee Collaboration Platform

Teamwork is a Spring Boot web application that allows employees to share **articles** and **GIFs** in a collaborative feed.  
It helps improve communication and productivity across teams.

---

## Features
- Employee login and logout
- Create, edit, and delete articles
- Upload and view GIFs (via Cloudinary)
- Comment on posts
- Combined feed of articles and GIFs
- Admin privileges for managing content

---

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- Thymeleaf + Bootstrap 5
- Cloudinary (for file uploads)
- Maven

---

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/steverado9/Teamwork_Spring_Application.git
   cd Teamwork_Spring_Application
   ```

2. Create a MySQL database:
   ```sql
   CREATE DATABASE tw;
   ```

3. Update your `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tw
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update

   cloudinary.cloud-name=your_cloud_name
   cloudinary.api-key=your_api_key
   cloudinary.api-secret=your_api_secret
   ```

4. Run the app

5. Open [http://localhost:8080](http://localhost:8080)

---

## Author
**Isaac Stephen (@steverado9)**  
A passionate developer building full-stack applications with Spring Boot and Java.
