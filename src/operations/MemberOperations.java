package operations;
import db.jdbc; // import db connectivity packages

//import sql connection classes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
                int member_id = scanner.nextInt(); //get member_id as input
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
        }

            public static void searchMember() {
                try (Connection conn = jdbc.getConnection();
                     Scanner scanner = new Scanner(System.in)) {

                    // Display search options
                    System.out.println("Search Member By 1.Name | 2.Email | 3.Phone Number: (Enter 1, 2 or 3)");
                    int choice = scanner.nextInt();//get user input book id
                    scanner.nextLine(); //  newline

                    String query = "";
                    PreparedStatement stmt = null;

                    switch (choice) {
                        case 1:
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            query = "SELECT * FROM members WHERE name LIKE ?";
                            stmt = conn.prepareStatement(query);
                            stmt.setString(1, "%" + name + "%");
                            break;
                        case 2:
                            System.out.print("Enter email: ");
                            String email = scanner.nextLine();
                            query = "SELECT * FROM members WHERE email LIKE ?";
                            stmt = conn.prepareStatement(query);
                            stmt.setString(1, "%" + email + "%");
                            break;
                        case 3:
                            System.out.print("Enter phone number: ");
                            String phone = scanner.nextLine();
                            query = "SELECT * FROM members WHERE phone LIKE ?";
                            stmt = conn.prepareStatement(query);
                            stmt.setString(1, "%" + phone + "%");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            return;
                    }/////////////switch statement for search book

                    /////////////////////////////////////////////////////////////////////////////////////////////////////statements of print for the results
                    ResultSet rs = stmt.executeQuery();
                    boolean found = false;

                    while (rs.next()) {
                        int member_id = rs.getInt("member_id");
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        String phone = rs.getString("phone");

                        System.out.println("Member ID: " + member_id);
                        System.out.println("Name: " + name);
                        System.out.println("Email: " + email);
                        System.out.println("Phone Number: " + phone);
                        System.out.println("Books Borrowed:");

                        //////////////////////////////////////////////////////////////check book according member
                        String loanQuery = "SELECT books.book_id, books.title, loans.loan_date, loans.return_date " +
                                "FROM loans " +
                                "JOIN books ON loans.book_id = books.book_id " +
                                "WHERE loans.member_id = ? AND loans.return_date IS NULL";
                        PreparedStatement loanStmt = conn.prepareStatement(loanQuery);
                        loanStmt.setInt(1, member_id);
                        ResultSet loanRs = loanStmt.executeQuery();

                        while (loanRs.next()) {
                            int book_id = loanRs.getInt("book_id");
                            String title = loanRs.getString("title");
                            Date loan_date = loanRs.getDate("loan_date");
                            Date return_date = loanRs.getDate("due_date");

                            System.out.println("\tBook ID: " + book_id);
                            System.out.println("\tTitle: " + title);
                            System.out.println("\tLoan Date: " + loan_date);
                            System.out.println("\tDue Date: " + return_date);
                            System.out.println("---------------------------------");
                        }

                        loanRs.close();
                        loanStmt.close();

                        found = true;
                    }

                    if (!found) {
                        System.out.println("No member found matching the criteria.");
                    }

                } catch (SQLException e) {
                    System.out.println(e);
                }//automatically close database  throw try catch statement
            }// init searchmember method


















}//create class memberOperations

