import java.util.Scanner;
/*
 * ==== Main ====
 * Handles user input.
 * 
 */
public class Main {
	public static void main(String [] args) {
		// Create Scanner to handle user input 
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter input file name: "); 
		// Read the file inputed by user
		FileHandler fileHandler = new FileHandler(scan.nextLine());
		fileHandler.readFile();
		// Get table name for the SQL
		System.out.print("Enter name for table: ");
		// Object to handle SQL creation, pass it the table name and array of sites
		SQLCreator sqlCreator = new SQLCreator(scan.nextLine(), fileHandler.getSites()); 
		sqlCreator.createAndPopulate();
		// Options
		System.out.println("Would you like to output to a file or the console?\n1. Output to file\n2. Output to console");
		int choice = 0;
		// Exception caught if input is not a number. Prints an error and exits program.
		try {
			choice = Integer.parseInt(scan.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Error - Incorrect input.");
			System.exit(0);
		}
		// Handles choices and directs to appropriate service.
		switch (choice) {
			case 1:
				System.out.print("Enter file name to write to: ");
				fileHandler.writeFile(scan.nextLine(), sqlCreator.getCreateQueries(), sqlCreator.getInsertQueries());
				break;
			case 2:
				System.out.print(sqlCreator.getCreateQueries());
				System.out.print(sqlCreator.getInsertQueries());
				break;
			default: 
				System.out.println("Error - Incorrect input."); // Default message if a correct option is not entered.
				break;
		}
	}
}