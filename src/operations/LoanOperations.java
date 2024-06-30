package operations;
import db.jdbc; // import db connectivity packages

//import sql connection classes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date; // import dates class to handling sql dates
import java.util.Scanner;

public class LoanOperations {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Loan book
    public static void loanBook(){

        try (Connection conn = jdbc.getConnection();

             Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter book ID to loan: ");
            int book_id = scanner.nextInt(); //get user input and store
            System.out.print("Enter member ID: ");
            int member_id = scanner.nextInt(); //get user input and store
            System.out.print("Enter loan date (YYYY-MM-DD): ");
            Date loan_date = Date.valueOf(scanner.next()); //get user input and store
            System.out.print("Enter due date (YYYY-MM-DD): ");
            Date return_date = Date.valueOf(scanner.next()); //get user input and store

            String query = "INSERT INTO loons (book_id,member_id,loan_date,return_date) VALUES(?,?,?,?)"; //  QUERY TO Store in database user input

            PreparedStatement stmt = conn.prepareStatement(query); //sql statement

            stmt.setInt(1, book_id);//book_id parameter in sql statement
            stmt.setInt(2, member_id); //member_id parameter in sql statement
            stmt.setDate(3,loan_date); //loan_date parameter in sql statement
            stmt.setDate(4,return_date);//return_date parameter in sql statement

            stmt.executeUpdate();

            System.out.println("Book Issued successfully.");

            conn.close(); //close db connection


        }catch (SQLException e) {
            System.out.println(e);

        }//automatically close database  throw try catch statement

    } //init loanbook class
///////////////////////////////////////////////////////////////////////////////////////////////////////////////return book
    public static void returnbook(){
        try (Connection conn = jdbc.getConnection();
             Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter loan ID to return: ");
            int loan_id = scanner.nextInt();//get user input and store
            System.out.print("Enter return date (YYYY-MM-DD): ");
            Date return_date = Date.valueOf(scanner.next());//get user input and store



        }catch (SQLException e) {
            System.out.println(e);
        }//automatically close database  throw try catch statement




    }// init deleteBook method
}
