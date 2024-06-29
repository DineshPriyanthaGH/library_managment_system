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

        }  catch (SQLException e) {
        System.out.println(e);

    }//automatically close database  throw try catch statement



















    }//create class memberOperations
}
