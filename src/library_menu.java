
import operations.BookOperations; //import operations package to library Menu

import java.util.Scanner; //import get user input class

public class library_menu {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in); // create scanner new object
         int choice; //  "choice" variable declare to store user input

        // create loop for user can choose choice
        do{
            //library menu option
            System.out.println("Welcome To Library Management System");
            System.out.println("1.Add a New Book");
            System.out.println("2.Update Book Details");
            System.out.println("3.Delete a book");
            System.out.println("4.Search a book");
            System.out.println("5.Add a new member");
            System.out.println("6.Loan a Book");
            System.out.println("7.Return a book");
            System.out.println("8.Exit");
            System.out.println("Enter Your Choice:");

            choice = scanner.nextInt(); //user choice save

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

                case 8:
                    System.out.println(".......");
                    break;
                default:
                    System.out.println("Invalid Choice");



            }


        }while(choice !=8);

    }


}
