
import operations.BookOperations; //import bookoperations class package to library Menu
import operations.LoanOperations;
import operations.MemberOperations; //import Memberoperations class package to library Menu
import java.util.InputMismatchException; //import Memberoperations package to library Menu
import java.util.NoSuchElementException; ///import NoSuchElementException; class
import java.util.Scanner; //import get user input class


public class library_menu {
    public static void run() {
        Scanner scanner = new Scanner(System.in); // create scanner new object


        // create loop for user can choose choice
        while (true) {
            try {
                System.out.println("Welcome To Library Management System");
                System.out.println("1.Add a New Book");
                System.out.println("2.Update Book Details");
                System.out.println("3.Delete a book");
                System.out.println("4.Search a book");
                System.out.println("5.Add a new member");
                System.out.println("6.Update Member Details");
                System.out.println("7.Search a Member");
                System.out.println("8.Loan a Book");
                System.out.println("9.Return a book");
                System.out.println("10.Exit");
                System.out.print("Enter Your Choice: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 10.");
                    scanner.next(); // invalid input
                    continue;
                }

                int choice = scanner.nextInt();//user choice save

            // select funtions according user choice using switch statements


            switch(choice){
                case 1:
                    BookOperations.addBook();
                    break;
                case 2:
                    BookOperations.updateBook();
                    break;
                case 3:
                    BookOperations.deleteBook();
                    break;
                case 4:
                    BookOperations.searchBook();
                    break;

                case 5:
                    MemberOperations.addMember();
                    break;
                case 6:
                    MemberOperations.updateMdetails();
                    break;
                case 7:
                    MemberOperations.searchMember();
                    break;
                case 8:
                    LoanOperations.loanBook();
                    break;
                case 9:
                    LoanOperations.returnbook();
                    break;
                case 10:
                    System.out.println(".......");
                    break;
                default:
                    System.out.println("Invalid Choice");



            }


        }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); //  invalid input
            } catch (NoSuchElementException e) {
                System.out.println("No more input available.");
                break; // Exit the loop if no more input is available
            } catch (Exception e) {
                e.printStackTrace();

    }


}
        scanner.close();}}