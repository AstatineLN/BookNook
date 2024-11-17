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

public class BookNook 
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int screen=0;
        int selection;// to save value user enters and to be used for if else
        int login;//to break from login/account creation
        boolean libraryOwner;
        while(selection!=-1)//breaks from whole program
        {
            while(login!=-2)//breaks from login/account creation
            {
                //first option screen
                do
                {
                    System.out.println("Welcome to booknook a system to manage little libraries, please make a selection");
                    System.out.println("1.I already have an account");
                    System.out.println("2.I need to create an account");
                    System.out.println("Enter -1 if you no longer wish to login or create an account");
                    selection = scanner.nextInt();
                    switch(selection)
                    {
                        case 1:
                            screen = 2;
                            break;
                        case 2:
                            screen = 3;
                            break;
                        case -1:
                            System.out.println("Thank you for visiting BookNook");
                            break;
                        default:
                        System.out.println("Please enter a valid option");
                    }
                }while(selection!=1||selection!=2||selection!= -1);
                //screen to login (2)
                if(screen == 2)
                {
                    do
                    {
                        System.out.println("Enter email:");
                        String email = scanner.nextLine();
                        System.out.println("Enter Password");
                        String password = scanner.nextLine();
                        
                        //Call method loginUser()
                        /*
                        User user = new User();
                        boolean verify = user.loginUser(email, password);*/
                        //valid account found
                        boolean verify = true;
                        if(verify == true)
                        {
                            //call method basicOrOwner
                            //int owner = user.basicOrOwner(email, password);
                            //verify is basic(0) or owner account(1)
                            int owner = 0;
                            switch(owner)
                            {
                                case 0:
                                    screen = 4;
                                    break;
                                case 1:
                                    screen = 5;
                                    break;

                            }
                        }
                        else if(verify == false)
                        {
                            System.out.println("Wrong credentials:Press 1 to try again, 2 to create account or -1 to quit");
                            selection = scanner.nextInt();
                            switch(selection)
                            {
                                case 1:
                                    break;
                                case 2:
                                    screen = 3;
                                    break;
                                case -1:
                                    System.out.println("Thank you for using BookNook");
                                    break;
                                default:
                                    System.out.println("Please enter a valid option");
                            }
                        }
                    }while(selection !=-1||screen !=3||screen!=4||screen!=5);
                    

                }
                //option screen to make account(3)
                else if(screen == 3)
                {
                    //call to initialize library class
                    do
                    {
                        System.out.println("Account creation\n");
                        System.out.println("Enter Username");
                        String username = scanner.nextLine();

                        System.out.println("Hello, "+ username + " Enter email");
                        String email = scanner.nextLine();

                        System.out.println("Enter your password");
                        String password = scanner.nextLine();

                        System.out.println("Would you like to become a little library owner, enter 1 for yes and 0 for no");
                        selection = scanner.nextInt();
                        do
                        {
                            switch(selection)
                            {
                                case 0:
                                    libraryOwner = false;
                                    break;
                                case 1:
                                    do//library creation
                                    {
                                        
                                        System.out.println("Enter Library name");
                                        String libraryName = scanner.nextLine();

                                        System.out.println("Enter zipcode of the location of your little library");
                                        int libraryLocation = scanner.nextInt();

                                        System.out.println("Enter the description for "+libraryName);
                                        String libraryDescription = scanner.nextLine();

                                        //method call to create library

                                        System.out.println("Your new library details");
                                        System.out.println("Library name: "+libraryName);
                                        System.out.println("library location: "+libraryLocation);
                                        System.out.println("Library description: "+ libraryDescription);

                                        System.out.println("Enter 1 if this details are right, 2 if they are wrong, or -1 if you want to quit BookNook");
                                        selection = scanner.nextInt();
                                        do//get right selection
                                        {
                                            switch(selection)
                                            {
                                                case 1:
                                                    libraryOwner = true;
                                                    
                                                    break;
                                                case 2:
                                                    libraryOwner = false;
                                                    break;
                                                case -1:
                                                    System.out.println("You are now exiting BookNook");
                                                    break;
                                                default:
                                                    System.out.println("Invalid input, please try again");
                                                

                                            }
                                        }while(selection!=1||selection!=2||selection!=-1);

                                    }while(selection!=1||selection!=-1);
                                    break;
                                default:
                                    System.out.println("Invalid input");
                                    
                            }
                        }while(selection!=0||selection!=1);
                        

                        System.out.println(username+", your username is: "+username+" and password is: "+password+"and library owner:"+ libraryOwner);
                        System.out.println("Enter 1 if this is right, 2 if you wish to change it and -1 to quit BookNook" );
                        selection = scanner.nextInt();
                        if(selection ==1&&libraryOwner==true)
                        {
                            //method call to create library
                            screen = 5;
                        }
                        else if(selection == 1&&libraryOwner ==false)
                        {
                            screen =4;
                        }
                    }while(selection !=-1|| selection!=1);
                }
            }

            //option screen for basic user(4)
            if(screen == 4)
            {/*
                do
                {
                    
                }while();*/
            }
            //option screen for library owner(5)
            else if(screen == 5)
            {
                /*do
                {

                }while(1);*/
            }
        }
    }
}
