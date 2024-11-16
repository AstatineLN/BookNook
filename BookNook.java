

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
                    System.out.println("Enter -2 if you no longer wish to login or create an account")
                    selection = scanner.nextInt();
                    switch(selection)
                    {
                        case 1:
                            screen = 2;
                            break;
                        case 2:
                            screen = 3;
                            break;
                        default:
                        System.out.println("Please enter a valid option");
                    }
                }while(selection!=1||selection!=2||selection!= -2);
                //screen to login (2)
                if(screen == 2)
                {
                    do
                    {
                        System.out.println("Enter email:");
                        String email = scanner.nextLine();
                        System.out.println("Enter Password");
                        String password = scanner.nextLine();
                        /*
                        //Call method loginUser()
                        User user = new User();
                        int verify = user.loginUser(email, password);
                        //valid account found
                        if(verify == 1)
                        {
                            //call method basicOrOwner
                            int owner = user.basicOrOwner(email, password);
                            //verify is basic(0) or owner account(1)
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
                        else if(verify = 0)
                        {
                            System.out.println("Wrong credentials:Press 1 to try again or 2 to create account");

                        }
                        
                        

                        
                        switch 
                        */
                    }while();
                    

                }
                //option screen to make account(3)
                else if(screen == 3)
                {

                }
            }

            //option screen for basic user(4)
            else if()
            {

            }
            //option screen for library owner(5)
            else if()
            {

            }
        }
    }
}
