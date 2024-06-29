package operations;
import db.jdbc; // import db connectivity packages

//import sql connection classes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner; // import user input get class

public class MemberOperations {
   /////////////////////////////////////////////////////////////////////////add member

    public static void addMember() {
        try (Connection conn = jdbc.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter Member Name:");
            String name = scanner.nextLine(); //get user input and store
            System.out.println("Enter Member Email:");
            String email = scanner.nextLine(); //get user input and store
            System.out.println("Enter Member Phone Number:");
            int phone = scanner.nextInt(); //get user input and store
            String query = "INSERT INTO members (name,email,phone,) VALUES(?,?,?,?)"; //  QUERY TO Store in database user input

            PreparedStatement stmt = conn.prepareStatement(query); //sql statement

            stmt.setString(1, name);//name parameter in sql statement






        }  catch (SQLException e) {
        System.out.println(e);

    }//automatically close database  throw try catch statement



















    }//create class memberOperations
}
