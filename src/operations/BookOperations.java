package operations;// inside package operations

import db.jdbc; // import db connectivity packages

//import sql connection classes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner; // import user input get class

public class BookOperations {
    /////////////////////////////////////////////////////////////////////////////////////////add book
    public static void addBook() {
        try (Connection conn = jdbc.getConnection();

             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter Book Title:");
            String title = scanner.nextLine(); //get user input and store
            System.out.println("Enter Book Author:");
            String author = scanner.nextLine(); //get user input and store
            System.out.println("Enter Book publisher:");
            String publisher = scanner.nextLine(); //get user input and store
            System.out.println("Enter Book Year:");
            int year_published = scanner.nextInt(); //get user input and store

            String query = "INSERT INTO books (title,author,publisher,year_published) VALUES(?,?,?,?)"; //  QUERY TO Store in database user input

            PreparedStatement stmt = conn.prepareStatement(query); //sql statement

            stmt.setString(1, title);//title parameter in sql statement
            stmt.setString(2, author); //author parameter in sql statement
            stmt.setString(3, publisher);//publisher parameter in sql statement
            stmt.setInt(4, year_published);//year_published parameter in sql statement
            stmt.executeUpdate();

            System.out.println("Book added successfully.");//execute statement
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);

        }//automatically close database  throw try catch statement


    } //  init addBook method

    //////////////////////////////////////////////////////////////////////////////////update book
    public static void updateBook() {
        try (Connection conn = jdbc.getConnection();
             Scanner scanner = new Scanner(System.in)) {







            System.out.println("Enter Book ID to Update:");
            int   book_id = scanner.nextInt(); //get book id as input
            scanner.nextLine(); //new line
            System.out.println("Enter New Book Title:");
            String title = scanner.nextLine(); // get  new title as input
            System.out.println("Enter new author:");
            String author = scanner.nextLine(); // get new author as input
            System.out.println("Enter new Publisher:");
            String publisher = scanner.nextLine();//get new publisher as input
            System.out.println("Enter new year Published:");
            int year_published = scanner.nextInt(); //get new year as input

            String query = "UPDATE books SET title=?,author=?,publisher=?,year_published=? WHERE   book_id=?"; //set query to db upadte

            PreparedStatement stmt = conn.prepareStatement(query); // set statement

            stmt.setString(1, title);//title parameter in sql statement
            stmt.setString(2, author); //author parameter in sql statement
            stmt.setString(3, publisher);//publisher parameter in sql statement
            stmt.setInt(4, year_published);//year_published parameter in sql statement
            stmt.setInt(5, book_id);


            stmt.executeUpdate();

            System.out.println("Book Updated successfully.");//execute statement
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }//automatically close database  throw try catch statement


    } //init updateBook method

    ////////////////////////////////////////////////////////////////////////////////////////////////////delete book
    public static void deleteBook() {
        try (Connection conn = jdbc.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter book ID to delete:");
            int   book_id = scanner.nextInt(); //get user input to delete


            String query = "DELETE FROM books WHERE   book_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,   book_id);
            stmt.executeUpdate();

            System.out.println("Book deleted successfully."); //query db


            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }//automatically close database  throw try catch statement

    }// init deleteBook method

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////search book
    public static void searchBook() {
        try (Connection conn = jdbc.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Search By 1.Title | 2.Author | 3.Year: (Enter 1 ,2 or 3)");//
            int searchOption = scanner.nextInt(); //get user input book id

            scanner.nextLine(); // next line

            String query  = "";
            PreparedStatement stmt = null;

            switch (searchOption) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    query = "SELECT * FROM books WHERE title LIKE ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, "%" + title + "%");
                    break;

                case 2:
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    query = "SELECT * FROM books WHERE author LIKE ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, "%" + author + "%");
                    break;
                case 3:
                    System.out.print("Enter year: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid year.");
                        scanner.next(); // Discard invalid input
                    }
                    int year = scanner.nextInt();
                    query = "SELECT * FROM books WHERE year_published = ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setInt(1, year);
                    break;
                default:
                    System.out.println("Invalid search option.");
                    return;




            } /////////////switch statement for search book

            ResultSet rs = stmt.executeQuery();
            boolean found = false;

            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int year_published = rs.getInt("year_published");

                System.out.println("Book ID: " + book_id);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Publisher: " + publisher);
                System.out.println("Year Published: " + year_published);
                System.out.println("---------------------------------");
                found = true;
            }

            if (!found) {
                System.out.println("No books found matching the criteria.");
            }


            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }//automatically close database  throw try catch statement

    }// init searchBook method


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////create statement for search book


    } // create class BookOperations
