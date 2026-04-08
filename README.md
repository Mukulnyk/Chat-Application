# Chat-Application

# Chat Application

A real-time web-based Chat Application built with Java, MySQL, and HTML/CSS/JavaScript.

## Technologies Used
- Java (Servlets)
- MySQL (Database)
- HTML/CSS/JavaScript (Frontend)
- Apache Tomcat (Server)

## Features
- Real-time messaging (auto refresh every 2 seconds)
- WhatsApp style UI (dark theme)
- Emoji picker
- Dark/Light mode toggle
- Message timestamps
- Sent/Received message bubbles
- Multiple users can chat simultaneously

## How to Run
1. Import project in Eclipse as Dynamic Web Project
2. Create database using SQL script below
3. Add MySQL Connector JAR to:
   - WEB-INF/lib folder
   - eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/lib
4. Add servlet-api.jar to Build Path
5. Run on Apache Tomcat server
6. Open browser: http://localhost:8080/chatApp/index.html

## Database Setup
CREATE DATABASE chat_app;
USE chat_app;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender VARCHAR(50) NOT NULL,
    message TEXT NOT NULL,
    sent_at DATETIME DEFAULT NOW()
);

## Project Structure
- DBConnection.java - Database connection class
- chatServlet.java - Handles sending and fetching messages
- index.html - Frontend UI with WhatsApp style design

## Author
Mukul Nayak
