import java.util.Scanner;

public class LoginMenu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int choice = 0;
		while (choice != 7) {
			System.out.println("** School Co-Curriculum Activities (CCA) Registration System **\n");
			System.out.println("1. Login as Admin");
			System.out.println("2. Login as Teacher");
			System.out.println("3. Login as Student");
			System.out.println("4. Exit");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				loginAdmin();
				break;
			case 2:
				loginTeacher();
				break;
			case 3:
				loginStudent();
				break;
			case 4:
				System.out.println("Exiting the system...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	private static void loginAdmin() {
		Scanner scanner = new Scanner(System.in);

		String username, password;

		System.out.print("Enter your username: ");
		username = scanner.nextLine();

		System.out.print("Enter your password: ");
		password = scanner.nextLine();

		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("\nWelcome, Admin!\n");
			adminMenu();
		} else {
			System.out.println("Invalid username or password!");
		}
	}

	private static void loginTeacher() {
		Scanner scanner = new Scanner(System.in);

		String username, password;

		System.out.print("Enter your username: ");
		username = scanner.nextLine();

		System.out.print("Enter your password: ");
		password = scanner.nextLine();

		if (username.equals("teacher") && password.equals("teacher")) {
			System.out.println("\nWelcome, Teacher!\n");
			teacherMenu();
		} else {
			System.out.println("Invalid username or password!");
		}
	}

	private static void loginStudent() {
		Scanner scanner = new Scanner(System.in);

		String username, password;

		System.out.print("Enter your username: ");
		username = scanner.nextLine();

		System.out.print("Enter your password: ");
		password = scanner.nextLine();

		if (username.equals("student") && password.equals("student")) {
			System.out.println("\nWelcome, Student!\n");
			studentMenu();
		} else {
			System.out.println("Invalid username or password!");
		}
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
				// addStudent();
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
		while (choice != 7) {
			System.out.println("** Teacher Menu **\n");
			System.out.println("1. Add a new activity");
			System.out.println("3. Delete an activity");
			System.out.println("4. View all activity");
			System.out.println("5. Log out");

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
	
	
