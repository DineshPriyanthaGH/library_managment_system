# Library Management System

## Introduction

The Library Management System (LMS) is a console-based application designed to help manage and automate various tasks within a library. The system supports operations such as adding new books, updating book details, deleting books, searching for books, managing member information, and handling book loans and returns. The primary goal is to create an efficient and user-friendly interface for library staff and members to interact with the library's resources.

## Features

- **Add a New Book**
- **Update Book Details**
- **Delete a Book**
- **Search for a Book by Title, Author, or Year**
- **Add a New Member**
- **Update Member Details**
- **Search for a Member by Name, Email, or Phone Number**
- **Loan a Book**
- **Return a Book**

## Technologies Used

- **Java**: The core programming language used for developing the application logic, handling user interactions, and managing database operations.
- **JDBC (Java Database Connectivity)**: Utilized for connecting and interacting with the MySQL database, performing CRUD (Create, Read, Update, Delete) operations, and managing data transactions.
- **MySQL**: The relational database management system used to store all library data, including books, members, and loan records.
- **Exception Handling**: Implemented to ensure the robustness and reliability of the application, providing meaningful error messages and handling unexpected situations gracefully.
- **Scanner**: Used for reading user input from the console, enabling interactive command-line interface operations.

## Prerequisites

- **Java Development Kit (JDK)**
- **MySQL Database**
- **MySQL JDBC Driver**

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
   
2. Set up the MySQL database:
   - Create a new database named library_db.
   - Execute the provided SQL script to create tables and insert initial data.
    
     CREATE DATABASE library_db;
     USE library_db;

     CREATE TABLE books (
         book_id INT AUTO_INCREMENT PRIMARY KEY,
         title VARCHAR(255) NOT NULL,
         author VARCHAR(255) NOT NULL,
         year INT NOT NULL
     );

     CREATE TABLE members (
         member_id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(255) NOT NULL,
         email VARCHAR(255) NOT NULL,
         phone VARCHAR(20) NOT NULL
     );

     CREATE TABLE loans (
         loan_id INT AUTO_INCREMENT PRIMARY KEY,
         book_id INT,
         member_id INT,
         loan_date DATE,
         due_date DATE,
         FOREIGN KEY (book_id) REFERENCES books(book_id),
         FOREIGN KEY (member_id) REFERENCES members(member_id)
     );
     
3. Configure database connection:
   - Update the database connection details in the DatabaseConnection.java file.
    
     public class DatabaseConnection {
         private static final String URL = "jdbc:mysql://localhost:3306/library_db";
         private static final String USER = "root";
         private static final String PASSWORD = "your-password";

         public static Connection getConnection() throws SQLException {
             return DriverManager.getConnection(URL, USER, PASSWORD);
         }
     }
     
4. Compile and run the application:
  
   javac -d bin src/*.java
   java -cp bin:lib/mysql-connector-java-8.0.26.jar main
   
## Usage

1. Run the application:
  
   java -cp bin:lib/mysql-connector-java-8.0.26.jar main
   
2. Follow the on-screen instructions to interact with the system.

## Project Structure

- src/: Contains the Java source files.
  - main.java: The entry point of the application.
  - LibraryMenu.java: Contains the main menu and operations handling.
  - DatabaseConnection.java: Manages the database connection.
  - BookOperations.java: Handles book-related operations.
  - MemberOperations.java: Handles member-related operations.
  - LoanOperations.
  - java: Handles loan-related operations.
- lib/: Contains external libraries (e.g., MySQL JDBC driver).

## Contributions

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.
