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



        }catch (SQLException e) {
            System.out.println(e);

        }//automatically close database  throw try catch statement

    } //init loanbook class

}
