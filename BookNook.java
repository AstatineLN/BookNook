import java.util.Scanner;


class Library
{
    //attributes
    

    //getters

    //setters

    //constructors(not sure if needed)

    //methods
}
class Book
{
    //attributes

    //getters

    //setters

    //constructors

    //methods
}
class User
{
    //attributes

    //getters

    //setters

    //constructors

    //methods
}
 class LibraryOwner extends User 
{
    //attributes

    //getters

    //setters

    //constructors

    //methods

}
class Request
{
    //attributes

    //getters

    //setters

    //constructors

    //methods

}
     class ScreenManager
     {

        private Scanner scanner;
        private User currentUser;
        private final String CREDENTIALS_FILE = "Users.txt"; 

        public ScreenManager() {
            scanner = new Scanner(System.in);
        }

        public void start() {
            int choice;
            do 
            {
                displayMainMenu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        handleLogin();
                        break;
                    case 2:
                        handleCreateAccount();
                        break;
                    case -1:
                        System.out.println("Exiting application...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != -1);
        }

        private void displayMainMenu() {
            System.out.println("\nWelcome to Library Management System");
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("-1. Quit");
            System.out.print("Enter your choice: ");
        }

        private void handleLogin() {
            System.out.println("\nEnter username: ");
            String username = scanner.next();
            System.out.println("Enter password: ");
            String password = scanner.next();
            int choice;
           //Call method from User class to verify if they enter correct login info
                //test
                System.out.println("TEST: 1 to login 2 to invalid account");
                choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("\nLogin successful!");
                displayLoggedInMenu();
            } else {
                System.out.println("Invalid username or password. Try again.");
                start(); // Ask to try again or create account
            }
        }

        private void handleCreateAccount() {
            System.out.println("\nEnter username: ");
            String username = scanner.next();
            System.out.println("Enter email: ");
            String email = scanner.next();
            System.out.println("Enter password: ");
            String password = scanner.next();

            System.out.println("Would you like to become an owner?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int choice = scanner.nextInt();
            String libraryName = null;
            String zipcode = null;
            String description = null;
            if (choice == 1) {
                System.out.println("Enter Library Name: ");
                libraryName = scanner.next();
                System.out.println("Enter zipcode of location: ");
                zipcode = scanner.next();
                System.out.println("Enter description (location details): ");
                scanner.nextLine(); // Consume newline character
                description = scanner.nextLine();
                //get method from library class
                
            }

            // call method that returns true or false if the account was created successfully
            /*if (success) {
                System.out.println("Account created successfully!");
            } else {
                System.out.println("Failed to create account. Please try again.");
                handleCreateAccount();
            }*/
        }

        private void displayLoggedInMenu() {
                int choice;
                //call method from user that verifies if the user is owner and if else for testing
                System.out.println("TEST:1.Owner");//TEST
                System.out.println("TEST:2.basic");//TEST
                choice = scanner.nextInt();
                if (choice==1) 
                {
                    displayOwnerMenu();
                } 
                else if(choice ==2)
                {
                    displayBasicMenu();
                }
                
                // Implement logic for each menu option based on user type
            
        }

        private void displayOwnerMenu() 
        {
            int choice;
            // Implement menu options for owners (Search, Request, Location management etc.)
            System.out.println("\nOwner Menu");
            System.out.println("1. Search Libraries");
            System.out.println("2. Search For Book");
            System.out.println("3. Make Request");
            System.out.println("4. View Requests");
            System.out.println("5. I'm at a location"); // Functionality for owner to update location
            System.out.println("6. Fulfill Request");
            System.out.println("7. Edit Location");
            System.out.println("8. Delete Location");
            System.out.println("-1. Logout");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            
            switch(choice)
            {
                case -1:
                    System.out.println("You are now logging out-Successful");
                    break;
                case 1:
                    System.out.println("1. Search Libraries-Successful");
                    displayOwnerMenu();
                    break;
                case 2:
                    System.out.println("2. Search For Book-Successful");
                    displayOwnerMenu();
                    break;
                case 3:
                    System.out.println("3. Make Request-Successful");
                    displayOwnerMenu();
                    break;  
                case 4:
                    System.out.println("4. View Requests-Successful");
                    displayOwnerMenu();
                    break;  
                case 5:
                    System.out.println("5. I'm at a location-Successful"); 
                    displayOwnerMenu();
                    break;
                case 6:
                    System.out.println("6. Fulfill Request-Successful");
                    displayOwnerMenu();
                    break;
                case 7:
                    System.out.println("7. Edit Location-Successful");
                    displayOwnerMenu();
                    break;
                case 8:
                    System.out.println("8. Delete Location-Successful");
                    displayOwnerMenu();
                    break;
                default:
                    System.out.println("Invalid input please try again");
                    displayOwnerMenu();

                }
            

        }

        private void displayBasicMenu() 
        {
            // Implement menu options for basic users (Search, Request, View requests etc.)
            System.out.println("\nBasic Menu");
            System.out.println("1. Search Libraries");
            System.out.println("2. Search For Book");
            System.out.println("3. Make Request");
            System.out.println("4. View Requests");
            System.out.println("5. I'm at a location"); 
            System.out.println("6. Fulfill Request");
            System.out.println("-1. Logout");
            System.out.print("Enter your choice: ");
            int choice;
            choice = scanner.nextInt();

            switch(choice)
            {
                case -1:
                    System.out.println("You are now logging out-Successful");
                    break;
                case 1:
                    System.out.println("1. Search Libraries-Successful");
                    displayBasicMenu();
                    break;
                case 2:
                    System.out.println("2. Search For Book-Successful");
                    displayBasicMenu();
                    break;
                case 3:
                    System.out.println("3. Make Request-Successful");
                    displayBasicMenu();
                    break;  
                case 4:
                    System.out.println("4. View Requests");
                    displayBasicMenu();
                    break;  
                case 5:
                    System.out.println("5. I'm at a location"); 
                    displayBasicMenu();
                    break;
                case 6:
                    System.out.println("6. Fulfill Request");
                    displayBasicMenu();
                    break;
                default:
                    System.out.println("Invalid input please try again");
                    displayOwnerMenu();

            }
            
        }
    }

public class BookNook 
{
    public static void main(String args[])
    {
        ScreenManager screenManager = new ScreenManager();
        screenManager.start();
    }
}

