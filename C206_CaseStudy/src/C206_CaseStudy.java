import java.util.ArrayList;
import java.util.Scanner;

public class C206_CaseStudy {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<User> userList = new ArrayList<User>();
		
	    userList.add(new User("admin", "admin", "admin", "Admin", "Admin","",""));
	    userList.add(new User("teacher", "teacher", "teacher1", "Teacher", "Teacher","",""));
	    userList.add(new User("student", "student", "student1", "Student", "Student","floorball",""));

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
                teacherMenu(userList);
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
    
    public static void adminMenu() {
		Scanner scanner = new Scanner(System.in); 

		int choice = 0;
		while (choice != 4) {
			System.out.println("** Admin Menu **\n");
			System.out.println("1. Manage User Account");
			System.out.println("2. Manage User Activities");
			System.out.println("3. Manage User Registration");
			System.out.println("4. Log out");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				manageUserAccounts();
				break;
			case 2:
				//
				break;
			case 3:
				//
				break;
			case 4:
				//
				break;
			case 5:
				System.out.println("Logging out...");

			}
		}
	}
    
    public static void manageUserAccounts() {
        Scanner scanner = new Scanner(System.in); 

		ArrayList<User> userList = new ArrayList<User>();
		
	    userList.add(new User("22123456", "Amelia Row", "Amelia", " ", "Student", "Hockey",""));
	    userList.add(new User("22654321", "Rachelle Lim", "Rachelle", " ", "Student", "Floorball",""));
	    
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n** Manage User Accounts **\n");
            System.out.println("1. View all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Delete a student");
            System.out.println("4. Back");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
//                	viewAllStudent(userList);
                	C206_CaseStudy.viewAllUser(userList);
                    break;
                case 2:
//                	addUserAccount(userList);
                	User stu = inputUser();
					C206_CaseStudy.addUser(userList, stu);
					System.out.println("Student added successfully!");
                    break;
                case 3:
                	removeUser(userList);
                    break;
                case 4:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void teacherMenu(ArrayList<User> userList) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 5) {
            System.out.println("** Teacher Menu **\n");
            System.out.println("1. Manage Activity");
            System.out.println("2. Manage Registration");
            System.out.println("3. Manage Approval Status");
            System.out.println("4. Manage Attendance");
            System.out.println("5. Log out");

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
                    manageAttendanceMenu(userList);
                    break;
                case 5:
                    System.out.println("Logging out...\n");
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

    private static void manageAttendanceMenu(ArrayList<User> userList) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n** Manage Attendance **\n");
            System.out.println("1. View Attendance");
            System.out.println("2. Add Attendance");
            System.out.println("3. Delete Attendance");
            System.out.println("4. Back");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAttendance(userList);
                    break;
                case 2:
                    addAttendance(userList);
                    break;
                case 3:
                    deleteAttendance(userList);
                    break;
                case 4:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAttendance(ArrayList<User> userList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter activity code: ");
        String activityCode = scanner.nextLine();

        boolean foundAttendance = false;

        for (User user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && activityCode.equals(user.getActivityChosen()) && !user.getAttendanceStatus().isEmpty()) {
                System.out.println("\n** View Attendance **");
                System.out.println("Attendance Records:");
                System.out.println("+----+-----------------+-----------+----------------+");
                System.out.printf("| %-2s | %-15s | %-10s | %-14s |%n", "ID", "Name", "Username", "Attendance");
                System.out.println("+----+-----------------+-----------+----------------+");
                System.out.printf("| %-2s | %-15s | %-10s | %-14s |%n", user.getId(), user.getName(), user.getUsername(), user.getAttendanceStatus());
                System.out.println("+----+-----------------+-----------+----------------+");
                foundAttendance = true;
            }
        }

        if (!foundAttendance) {
            System.out.println("No attendance records found.");
        }
    }

    private static void addAttendance(ArrayList<User> userList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter activity code: ");
        String activityCode = scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter attendance status (Present/Absent): ");
        String attendanceStatus = scanner.nextLine();

        for (User user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && user.getActivityChosen().equals(activityCode) && user.getName().equalsIgnoreCase(name)) {
                user.setAttendanceStatus(attendanceStatus);
                System.out.println("\nAttendance added for " + name + ": " + attendanceStatus);
                return;
            }
        }

        System.out.println("\nStudent not found or not associated with the specified activity.");
    }

    private static void deleteAttendance(ArrayList<User> userList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter activity code: ");
        String activityCode = scanner.nextLine();

        System.out.print("Enter student name to delete attendance: ");
        String name = scanner.nextLine();

        for (User user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && user.getActivityChosen().equals(activityCode) && user.getName().equalsIgnoreCase(name)) {
                user.setAttendanceStatus("");
                System.out.println("Attendance record for " + name + " deleted.");
                return;
            }
        }

        System.out.println("Attendance record for " + name + " not found or not associated with the specified activity.");
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
	
	//========================================================================================== Admin ============================================================================
	
	//================================= Option 1 View (CRUD - Read) =================================
	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";

		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-60s\n", userList.get(i).toString());
		}
		return output;
	}
	
	public static void viewAllUser(ArrayList<User> userList) {
		String output = String.format("%-20s %-20s %-20s\n\n", "Student Name", "Student ID",
				"Chosen Activity");
		 output += retrieveAllUser(userList);	
		System.out.println(output);
	}
	
	//================================= Option 2 Add (CRUD - Create)=================================
	public static User inputUser() {
		String newUserName = Helper.readString("Enter student name > ");
		String newUserId = Helper.readString("Enter student ID > ");
		String newUserChosenAct = Helper.readString("Enter chosen activity > ");
		String newUseruName = "";
		String newUserPass = "";
		String newUserRole = "Student";
		String newAttendance = "";
		


		User stu = new User(newUserId, newUserName, newUseruName, newUserPass, newUserRole, newUserChosenAct, newAttendance);
		return stu;
		
	}
	
	public static void addUser(ArrayList<User> userList, User stu) {
		User student;
		for(int i = 0; i < userList.size(); i++) {
			student = userList.get(i);
			if (student.getName().equalsIgnoreCase(stu.getName()) )
				return;
		}
		if ((stu.getName().isEmpty()) || (stu.getId().isEmpty()) || (stu.getActivityChosen().isEmpty())) {
			return;
		}
		userList.add(stu);
		
	}
	
	//================================= Option 3 Remove (CRUD - Delete)=================================
	public static boolean removeUser(ArrayList<User> userList) {

		String removeStuID = Helper.readString("Enter student ID to remove > ");

		boolean studentFound = false;
		for (int i = 0; i < userList.size(); i++) {

			if (userList.get(i).getId().equals(removeStuID)) {

				userList.remove(i);
				studentFound = true;
				break;
			}
		}

		if (studentFound) {
			System.out.println("Student removed successfully!");
		} else {
			System.out.println("Student not found!");
		}

		return studentFound;
	}
	

	
	//========================================================================================== Teacher ============================================================================
	
	
	
	
	
	
	
	//========================================================================================== Student ============================================================================
	
	
}