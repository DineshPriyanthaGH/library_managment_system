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

            String query = "INSERT INTO loans (book_id,member_id,loan_date,return_date) VALUES(?,?,?,?)"; //  QUERY TO Store in database user input

            PreparedStatement pstmt = conn.prepareStatement(query); //sql statement

            pstmt.setInt(1, book_id);
            pstmt.setInt(2, member_id);
            pstmt.setDate(3, java.sql.Date.valueOf(loan_date.toLocalDate()));
            pstmt.setDate(4, java.sql.Date.valueOf(return_date.toLocalDate()));
            pstmt.executeUpdate();
            System.out.println("Book Issued successfully.");

            conn.close(); //close db connection


        }catch (SQLException e) {
            System.out.println(e.getMessage());

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

            String query = "UPDATE loans SET return_date = ? WHERE loan_id = ?";//  QUERY TO Store in database user input
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, return_date);
            stmt.setInt(2, loan_id);
            stmt.executeUpdate();
            System.out.println("Book returned successfully.");

            conn.close(); //close db connection



        }catch (SQLException e) {
            System.out.println(e);
        }//automatically close database  throw try catch statement






    }// init deleteBook method
}
