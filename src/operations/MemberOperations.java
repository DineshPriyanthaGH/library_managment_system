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
            String query = "INSERT INTO members (name,email,phone) VALUES(?,?,?)"; //  QUERY TO Store in database user input

            PreparedStatement stmt = conn.prepareStatement(query); //sql statement

            stmt.setString(1, name);//name parameter in sql statement
            stmt.setString(2, email); //email parameter in sql statement
            stmt.setInt(3, phone);//phone number parameter in sql statement
            stmt.executeUpdate();

            System.out.println("Member added successfully.");//execute statement
            conn.close(); //close db connection


        } catch (SQLException e) {
            System.out.println(e);

        }//automatically close database  throw try catch statement
    }
/////////////////////////////////////////////////////////////////////////////////////////update member details

        public static void updateMdetails() {
            try (Connection conn = jdbc.getConnection();
                 Scanner scanner = new Scanner(System.in)) {







                System.out.println("Enter Member ID to Update:");
                int   member_id = scanner.nextInt(); //get member_id as input
                scanner.nextLine(); //new line
                System.out.println("Enter New Member Name:");
                String name = scanner.nextLine(); // get  new name as input
                System.out.println("Enter Member  new email:");
                String email = scanner.nextLine(); // get new email as input
                System.out.println("Enter new Phone Number");
                int phone = scanner.nextInt(); //get new phone as input

                String query = "UPDATE members SET name=?,email=?,phone=? WHERE   member_id=?"; //set query to db upadte

                PreparedStatement stmt = conn.prepareStatement(query); // set statement

                stmt.setString(1, name);//title parameter in sql statement
                stmt.setString(2, email); //author parameter in sql statement
                stmt.setInt(3, phone);//year_published parameter in sql statement
                stmt.setInt(4, member_id);


                stmt.executeUpdate();

                System.out.println("Member Details  Updated successfully.");//execute statement
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }//automatically close database  throw try catch statement


















    }//create class memberOperations
}
