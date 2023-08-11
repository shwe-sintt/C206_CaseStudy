import java.util.ArrayList;
import java.util.Scanner;

public class C206_CaseStudy {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<User> userList = new ArrayList<User>();
		
	    userList.add(new User("admin", "admin", "admin", "Admin", "Admin","",""));
	    userList.add(new User("teacher", "teacher", "teacher1", "Teacher", "Teacher","",""));
	    userList.add(new User("student", "student", "student1", "Student", "Student","floorball",""));
   
//	    ArrayList<Activities> activityList = new ArrayList<Activities>();
//
//		activityList.add(new Activities("", "AA001", "Basketball", "Orange ball", "Must like orange"));

		
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
		
	    userList.add(new User("22123456", "Amelia Row", "Amelia", " ", "Student", "Hockey", ""));
	    userList.add(new User("22654321", "Rachelle Lim", "Rachelle", " ", "Student", "Floorball", ""));
	    
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
                	ManageAttendance.manageAttendanceMenu(userList);
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
        
	    ArrayList<Activities> activityList = new ArrayList<Activities>();

		activityList.add(new Activities("AA0011", "Basketball", "Orange ball", "Must like orange"));

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
                	C206_CaseStudy.addActivity(activityList);
                    break;
                case 2:
                	C206_CaseStudy.removeActivity(activityList);
                    break;
                case 3:
                	C206_CaseStudy.viewAllActivities(activityList);
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
		String output = String.format("%-20s %-20s %-20s %-20s\n\n", "Student Name", "Student ID",
				"Chosen Activity", "Attendance Status");
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
		String newAttendanceStatus = "";


		User stu = new User(newUserId, newUserName, newUseruName, newUserPass, newUserRole, newUserChosenAct, newAttendanceStatus);
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
	//================================= Option 1 View (CRUD - Read) =================================
	public static void viewAllActivities(ArrayList<Activities> activityList) {
		
		String output = String.format("%-20s %-20s %-20s %-20s\n", "Activity ID", "Activity Name", "Description",
				"Prerequisites & Restrictions");

		for (int i = 0; i < activityList.size(); i++) {

			if (activityList.get(i) != null) {

				String activityID = activityList.get(i).getActivityId();
				String activityName = activityList.get(i).getActivityName();
				String activityDesc = activityList.get(i).getActivityDescription();
				String activityCrit = activityList.get(i).getActivityCriteria();

				output += String.format("\n%-20s %-20s %-20s %-20s", activityID, activityName, activityDesc, activityCrit);

			}
		}
		System.out.println(output);
		// ------------------- END OF CODE

	}
	
	//================================= Option 2 Add (CRUD - Create)=================================
	public static void addActivity(ArrayList<Activities> activityList) {

		String newActId = Helper.readString("Enter activity id (AA----) > ");
		String newActName = Helper.readString("Enter activity name > ");
		String newDesc = Helper.readString("Enter description > ");
		String newCrit = Helper.readString("Enter prerequisites & restrictions > ");
//		String stuId = "";

		Activities newActivity = new Activities(newActId, newActName, newDesc, newCrit);
		activityList.add(newActivity);

		System.out.println("Activity added successfully!");
	}
	
	//================================= Option 3 Remove (CRUD - Delete)=================================
	public static boolean removeActivity(ArrayList<Activities> activityList) {

		String removeActId = Helper.readString("Enter activity ID to remove (AA----) > ");

		boolean activityFound = false;
		for (int i = 0; i < activityList.size(); i++) {

			if (activityList.get(i).getActivityId().equals(removeActId)) {

				activityList.remove(i);
				activityFound = true;
				break;
			}
		}

		if (activityFound) {
			System.out.println("Activity removed successfully!");
		} else {
			System.out.println("Activity not found!");
		}
		return activityFound;
	}
	
	//========================================================================================== Student ============================================================================
	
	
}