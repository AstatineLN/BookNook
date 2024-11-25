import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class ReadFromFile
{
    public static List<ArrayList<String>> tokenizeFile(String filePath) 
    {
        List<ArrayList<String>> tokenizedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                ArrayList<String> tokens = new ArrayList<>();
                String[] splitLine = line.split("\\|"); // Split by '|' delimiter
                for (String token : splitLine) 
                {
                    tokens.add(token);
                }
                tokenizedLines.add(tokens);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tokenizedLines;
    }
}
class WriteToFile
{
    public static void writeToFile(String filePath, ArrayList<String> arrayList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) 
        {
            for (String element : arrayList) 
            {
                writer.write(element + "|");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
class IDCounter {
    private static final String COUNTER_FILE = "IDCounter.txt";

    public static int getNextID(String category) {
        List<String> counterList = readCounterFile();

        int index = -1;
        for (int i = 0; i < counterList.size(); i++) {
            String[] parts = counterList.get(i).split("\\|");
            if (parts[0].equals(category)) {
                index = i;
                break;
            }
        }

        int newID;
        if (index == -1) {
            // Category not found, add a new entry
            newID = 1;
            counterList.add(category + "|1");
        } else {
            // Increment the existing ID for the category
            String[] parts = counterList.get(index).split("\\|");
            newID = Integer.parseInt(parts[1]) + 1;
            counterList.set(index, category + "|" + newID);
        }

        writeCounterFile(counterList);
        return newID;
    }

    private static List<String> readCounterFile() {
        List<String> counterList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNTER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                counterList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counterList;
    }

    private static void writeCounterFile(List<String> counterList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COUNTER_FILE))) {
            for (String line : counterList) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Library
{
    //attributes
    

    //getters

    //setters

    //constructors(not sure if needed)

    //methods
}
class Book {
	//attributes
	public String bookTitle;
	private Scanner scan;
	
	//method to search for a book by title
	public Boolean bookSearch(){
		//creating book object and assigning bookTitle to the book
		Book book = new Book();
		scan = new Scanner(System.in);
		System.out.println("What book would you like to search for?");
		book.bookTitle = scan.nextLine();
		
		BufferedReader br; 
		try {
			File file = new File("0.txt");
			br = new BufferedReader(new FileReader(file));
			String line;
			//reading from the file line by line
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("\\|");
				//parts[1] is where the book title is stored
				String Title = parts[1].trim();
				//this checks if the requested book is found in the library (is not case sensitive)
				if (Title.toLowerCase().equals(book.bookTitle.toLowerCase())) {
					br.close();
					return true;
				}

			}
			br.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
class User
{
    //attributes
    private String userName;
    private String userEmail;
    private String userPassword;
    private boolean libraryOwnerTF;
    private ArrayList<String> userArrayList;
    //getters
    public ArrayList<String> getUserArrayList() 
    {
        return userArrayList;
    }
    //setters

    //constructors
    public User() 
    {
        // Default constructor
    }
    public User(String userName, String userEmail, String userPassword, boolean libraryOwnerTF) 
    {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.libraryOwnerTF = libraryOwnerTF;
        this.userArrayList = new ArrayList<>();
    }
    //methods
    public void addUserToArrayList(String item) {
        userArrayList.add(item);
    }
}
 class LibraryOwner extends User 
{
    private int libraryID;

    // Constructor
    public LibraryOwner(String userName, String userEmail, String userPassword, boolean libraryOwnerTF, int libraryID) 
    {
        super(userName, userEmail, userPassword, libraryOwnerTF);
        this.libraryID = libraryID;
    }

    // Getter for libraryID
    public int getLibraryID() 
    {
        return libraryID;
    }

    // Setter for libraryID (optional, depending on your needs)
    public void setLibraryID(int libraryID) 
    {
        this.libraryID = libraryID;
    }

}
class Request
{
    //attributes

    //getters

    //setters

    //constructors

    //methods

}
class Login {
	
	
	//This method creates a hashmap for the user info and sets the username as the key and the password as the value
	public static Map<String, String> HashMapForUsers(){
		Map<String, String> map = new HashMap<String, String>();
		
		BufferedReader br = null; 
		
		try {
			File file = new File("Users.txt");
			
			br = new BufferedReader(new FileReader(file));
			
			String line;
			//reading from the file line by line
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("\\|");
				//parts[0] is our convention for where the username is stored. parts[2] is password.
				String Username = parts[0].trim();
				String Password = parts[2].trim();
				if (!Username.equals("") && !Password.equals("")) {
					map.put(Username, Password);
				}
				
			}
			
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static Map<String,String> HashMapForOwnerStatus(){
		Map<String, String> OwnerMap = new HashMap<String, String>();
		BufferedReader br = null; 
		
		try {
			File file = new File("Users.txt");
			
			br = new BufferedReader(new FileReader(file));
			
			String line;
			//reading from the file line by line
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("\\|");
				//parts[0] is our convention for where the username is stored. parts[3] is owner status.
				String Username = parts[0].trim();
				String ownerStatus = parts[3].trim();

				if (!Username.equals("") && !ownerStatus.equals("")) {
					OwnerMap.put(Username, ownerStatus);
				}
			}
			
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return OwnerMap;
	}
	

	
	

	public static Boolean loginVerification(String Username, String Password) {
			Map<String, String> userMap = HashMapForUsers();
			
			for(Map.Entry<String,String> entry: userMap.entrySet()) {
				//System.out.println(entry.getKey() + " " + entry.getValue());
				if (entry.getKey().equals(Username) && entry.getValue().equals(Password)) {
					return true;
				}
			}
			return false;
	}
	
	public static Boolean ownerVerification(String Username) {
		Map<String, String> ownerMap = HashMapForOwnerStatus();
		
		for(Map.Entry<String,String> entry: ownerMap.entrySet()) {
			if (entry.getKey().equals(Username) && entry.getValue().equals("true")) {
				return true;
			}
		}
		
		return false;
		
	}
}

class ScreenManager {
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
        boolean libraryOwnerTF;
       //Call method from User class to verify if they enter correct login info
            //test
            //System.out.println("TEST: 1 to login 2 to invalid account");
            //choice = scanner.nextInt();
        if (Login.loginVerification(username, password) == true) {
            System.out.println("\nLogin successful!");
            if (Login.ownerVerification(username) == true) 
            {
                displayOwnerMenu();
            }
            else {
            	displayBasicMenu();
            }
        } 
        else {
            System.out.println("Invalid username or password. Try again.");
            start(); // Ask to try again or create account
        }
    }

    private void handleCreateAccount() {
        String filePath ="Users.txt";
        System.out.println("\nEnter username: ");
        String userName = scanner.next();
        System.out.println("Enter email: ");
        String userEmail = scanner.next();
        System.out.println("Enter password: ");
        String userPassword = scanner.next();

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

            //account creation and add to users.txt
            int nextLibraryID = IDCounter.getNextID("libraryIDCount");
            LibraryOwner newLibraryOwner = new LibraryOwner(userName, userEmail, userPassword, true, nextLibraryID);
            newLibraryOwner.addUserToArrayList(userName);
            newLibraryOwner.addUserToArrayList(userEmail);
            newLibraryOwner.addUserToArrayList(userPassword);
            newLibraryOwner.addUserToArrayList("true");
            newLibraryOwner.addUserToArrayList(String.valueOf(nextLibraryID));

            
            WriteToFile.writeToFile(filePath, newLibraryOwner.getUserArrayList());

            
        }
        else if (choice ==2)
        {
            User newUser = new User(userName, userEmail, userPassword, false);
            newUser.addUserToArrayList(userName);
            newUser.addUserToArrayList(userEmail);
            newUser.addUserToArrayList(userPassword);
            newUser.addUserToArrayList("false");

            
            WriteToFile.writeToFile(filePath, newUser.getUserArrayList());
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
            if (choice == 1) 
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
            	Book bookObj = new Book();
            	if(bookObj.bookSearch() == true) {
            		System.out.println("The book is currently available.");
                    displayOwnerMenu();
                    break;
            	}
            	else {
            		System.out.println("The book is unavailable.");
                    displayOwnerMenu();
                    break;
            	}
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
        System.out.println("2. List Books");
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
            	Book bookObj = new Book();
            	if(bookObj.bookSearch() == true) {
            		System.out.println("The book is currently available.");
                    displayBasicMenu();
                    break;
            	}
            	else {
            		System.out.println("The book is unavailable.");
                    displayBasicMenu();
                    break;
            	}
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

