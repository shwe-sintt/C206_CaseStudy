import java.util.ArrayList;
import java.util.Scanner;

public class C206_CaseStudy {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<User> userList = new ArrayList<>();
	    userList.add(new User("admin", "admin", "admin", "Admin", "Admin"));
	    userList.add(new User("teacher", "teacher", "teacher1", "Teacher", "Teacher"));
	    userList.add(new User("student", "student", "student1", "Student", "Student"));

	    Scanner scanner = new Scanner(System.in);

	    int choice = 0;
	    while (choice != 4) {
	        System.out.println("** School Co-Curriculum Activities (CCA) Registration System **\n");
	        System.out.println("1. Login as Admin");
	        System.out.println("2. Login as Teacher");
	        System.out.println("3. Login as Student");
	        System.out.println("4. Exit");

	        System.out.print("Enter your choice: ");
	        choice = scanner.nextInt();

	        switch (choice) {
	            case 1:
	                loginAdmin(userList);
	                break;
	            case 2:
	                loginTeacher(userList);
	                break;
	            case 3:
	                loginStudent(userList);
	                break;
	            case 4:
	                System.out.println("Exiting the system...");
	                break;
	            default:
	                System.out.println("Invalid choice!");
	        }
	        
	    }
	    
	}
	
	private static void loginAdmin(ArrayList<User> userList) {
		Scanner scanner = new Scanner(System.in);

        String username, password;

        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase("admin")) {
                System.out.println("\nWelcome, Admin!\n");
                adminMenu();
                return;
            }
        }
        
        System.out.println("Invalid username, password, or role!");
    }

    private static void loginTeacher(ArrayList<User> userList) {
    	Scanner scanner = new Scanner(System.in);

        String username, password;

        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase("teacher")) {
                System.out.println("\nWelcome, Teacher!\n");
                teacherMenu();
                return;
            }
        }
        
        System.out.println("Invalid username, password, or role!");
    	
    }

    private static void loginStudent(ArrayList<User> userList) {
    	Scanner scanner = new Scanner(System.in);

        String username, password;

        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase("student")) {
                System.out.println("\nWelcome, Student!\n");
                studentMenu();
                return;
            }
        }
        
        System.out.println("Invalid username, password, or role!");
        
    }
    
    private static void adminMenu() {
		Scanner scanner = new Scanner(System.in);

		int choice = 0;
		while (choice != 7) {
			System.out.println("** Admin Menu **\n");
			System.out.println("1. Add a new student");
			System.out.println("2. Update a student's information");
			System.out.println("3. Delete a student");
			System.out.println("4. View all students");
			System.out.println("5. Log out");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				//addStudent();
				break;
			case 2:
				// updateStudent();
				break;
			case 3:
				// deleteStudent();
				break;
			case 4:
				// viewAllStudents();
				break;
			case 5:
				System.out.println("Logging out...");

			}
		}
	}

    private static void teacherMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            System.out.println("** Teacher Menu **\n");
            System.out.println("1. Manage Activity");
            System.out.println("2. Manage Registration");
            System.out.println("3. Manage Approval Status");
            System.out.println("4. Log out");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageActivityMenu();
                    break;
                case 2:
                    manageRegistrationMenu();
                    break;
                case 3:
                    manageApprovalStatusMenu();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageActivityMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            System.out.println("** Manage Activity **\n");
            System.out.println("1. Add Activity");
            System.out.println("2. Delete Activity");
            System.out.println("3. View All Activities");
            System.out.println("4. Back");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implement Add Activity functionality
                    break;
                case 2:
                    // Implement Delete Activity functionality
                    break;
                case 3:
                    // Implement View All Activities functionality
                    break;
                case 4:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageRegistrationMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            System.out.println("** Manage Registration **\n");
            System.out.println("1. Add Registration");
            System.out.println("2. Delete Registration");
            System.out.println("3. View All Registrations");
            System.out.println("4. Back");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implement Add Registration functionality
                    break;
                case 2:
                    // Implement Delete Registration functionality
                    break;
                case 3:
                    // Implement View All Registrations functionality
                    break;
                case 4:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageApprovalStatusMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            System.out.println("** Manage Approval Status **\n");
            System.out.println("1. Add Approval Status");
            System.out.println("2. Delete Approval Status");
            System.out.println("3. View Approval Status");
            System.out.println("4. Back");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //addStatus
                case 2:
                    //deleteStatus
                    break;
                case 3:
                    //viewAllStatus
                    break;
                case 4:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

	
	private static void studentMenu() {
		Scanner scanner = new Scanner(System.in);

		int choice = 0;
		while (choice != 7) {
			System.out.println("** Student Menu **\n");
			System.out.println("1. Apply for an activity");
			System.out.println("2. View all activity");
			System.out.println("3. Log out");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// addStudent();
				break;
			case 2:
				// deleteStudent();
				break;
			case 3:
				// viewAllStudents();
				break;
			case 4:
				System.out.println("Logging out...");
			}
			
		}
	}
}