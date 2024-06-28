package operations;// inside package operations

import db.jdbc; // import db connectivity packages

//import sql connection classes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 import java.util.Scanner; // import user input get class

public class BookOperations{
    public static void addBook(){


    } //  init addBook method

    public  static void updateBook(){
        try(Connection conn= jdbc.getConnection();

        Scanner scanner= new Scanner(System.in))
        {
            System.out.println("Enter Book Title:" );
            String title=scanner.nextLine(); //get user input and store
            System.out.println("Enter Book Author:" );
            String author=scanner.nextLine(); //get user input and store
            System.out.println("Enter Book publisher:" );
            String publisher=scanner.nextLine(); //get user input and store
            System.out.println("Enter Book Year:" );
            String year_published=scanner.nextLine(); //get user input and store

            String query = "INSERT INTO books (title,author,publisher,year_published) VALUES(?,?,?,?)"; //  QUERY TO Store in database user input

            PreparedStatement stmt = conn.prepareStatement(query); //sql statement

            stmt.setString(1, title);//title parameter in sql statement






        }catch(SQLException e){
            e.printStackTrace();

        }//automatically close database  throw try catch statement


    } //init updateBook method

    public static void deleteBook(){

    }// init deleteBook method

    public static void searchBook(){

    }// init searchBook method
} // create class BookOperations
