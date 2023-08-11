import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class C206_CaseStudy {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<User> userList = new ArrayList<User>();
		
	    userList.add(new User("admin", "admin", "admin", "Admin", "Admin","",""));
	    userList.add(new User("T123", "Lin Cin", "lincin", "lincin", "Teacher","",""));
	    userList.add(new User("student", "student", "student1", "Student", "Student","floorball",""));
		
	    userList.add(new User("22123456", "Amelia Row", "Amelia", " ", "Student", "Hockey", ""));
	    userList.add(new User("22654321", "Rachelle Lim", "Rachelle", " ", "Student", "Floorball", ""));
   
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
                adminMenu(userList);
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
    
    public static void adminMenu(ArrayList<User> userList) {
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
				manageUserAccounts(userList);
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
    
    public static void manageUserAccounts(ArrayList<User> userList) {
        Scanner scanner = new Scanner(System.in); 


	    
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n** Manage User Accounts **\n");
            System.out.println("1. View all user");
            System.out.println("2. Add a new user");
            System.out.println("3. Delete a user");
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
					System.out.println("User added successfully!");
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
                	StatusManager statusManager = new StatusManager(); // Create an instance of StatusManager
	                manageApprovalStatusMenu(statusManager);
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
                	Activities a = inputActivity();
                	addActivity(activityList, a);
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

	private static void manageApprovalStatusMenu(StatusManager statusManager) {
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
	                addApprovalStatus(statusManager);
	                break;
	            case 2:
	                deleteApprovalStatus(statusManager);
	                break;
	            case 3:
	                viewApprovalStatuses(statusManager);
	                break;
	            case 4:
	                System.out.println("Going back to the main menu...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }
	}

	private static void viewApprovalStatuses(StatusManager statusManager) {
	    List<ApprovalStatus> allStatuses = statusManager.getApprovalStatuses();
	    if (allStatuses.isEmpty()) {
	        System.out.println("No records to display.");
	    } else {
	        System.out.println("Approval Statuses:");
	        for (ApprovalStatus status : allStatuses) {
	            System.out.println("Name: " + status.getName() + ", Description: " + status.getDescription());
	        }
	    }
	}

	private static void deleteApprovalStatus(StatusManager statusManager) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter the name of the approval status to delete: ");
	    String statusToDelete = scanner.next();

	    ApprovalStatus status = findApprovalStatusByName(statusToDelete, statusManager);
	    if (status != null) {
	        System.out.print("Are you sure you want to delete '" + status.getName() + "'? (yes/no): ");
	        String confirmation = scanner.next();

	        if (confirmation.equalsIgnoreCase("yes")) {
	            statusManager.deleteApprovalStatus(statusToDelete);
	            System.out.println("Approval status deleted successfully.");
	        } else {
	            System.out.println("Deletion cancelled.");
	        }
	    } else {
	        System.out.println("Approval status not found.");
	    }
	}


	public static ApprovalStatus findApprovalStatusByName(String statusToDelete, StatusManager statusManager) {
	    List<ApprovalStatus> allStatuses = statusManager.getApprovalStatuses();
	    for (ApprovalStatus status : allStatuses) {
	        if (status.getName().equalsIgnoreCase(statusToDelete)) {
	            return status;
	        }
	    }
	    return null;
	}


	private static void addApprovalStatus(StatusManager statusManager) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter unique name for the new approval status: ");
	    String newStatusName = scanner.next();

	    System.out.print("Enter description for the new approval status: ");
	    String newStatusDescription = scanner.next();

	    if (!newStatusName.isEmpty() && !newStatusDescription.isEmpty()) {
	        if (statusManager.isApprovalStatusNameUnique(newStatusName)) {
	            statusManager.addApprovalStatus(newStatusName, newStatusDescription);
	            System.out.println("Approval status added successfully.");
	        } else {
	            System.out.println("An approval status with the same name already exists.");
	        }
	    } else {
	        System.out.println("Name and description cannot be empty.");
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
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n\n", "User Name", "User ID",
				"Chosen Activity", "Attendance Status", "Role");
		 output += retrieveAllUser(userList);	
		System.out.println(output);
	}
	
	//================================= Option 2 Add (CRUD - Create)=================================
	public static User inputUser() {
		String newUserName = Helper.readString("Enter user name > ");
		String newUserId = Helper.readString("Enter user ID > ");
		String newUserChosenAct = Helper.readString("Enter chosen activity (for students) > ");
		String newUserRole = Helper.readString("Enter user role > ");
		String newUseruName = "";
		String newUserPass = "";


		User stu = new User(newUserId, newUserName, newUseruName, newUserPass, newUserRole, newUserChosenAct);
		return stu;
		
	}
	
	public static void addUser(ArrayList<User> userList, User stu) {
		User user;
		for(int i = 0; i < userList.size(); i++) {
			user = userList.get(i);
			if (user.getName().equalsIgnoreCase(stu.getName()) )
				return;
		}
		if ((stu.getName().isEmpty()) || (stu.getId().isEmpty()) || (stu.getActivityChosen().isEmpty())) {
			return;
		}
		userList.add(stu);
		
	}
	
	//================================= Option 3 Remove (CRUD - Delete)=================================
	public static boolean removeUser(ArrayList<User> userList) {

		String removeUserId = Helper.readString("Enter user ID to remove > ");

		boolean userFound = false;
		for (int i = 0; i < userList.size(); i++) {

			if (userList.get(i).getId().equals(removeUserId)) {

				userList.remove(i);
				userFound = true;
				break;
			}
		}

		if (userFound) {
			System.out.println("User removed successfully!");
		} else {
			System.out.println("User not found!");
		}

		return userFound;
	}
	
	//========================================================================================== Teacher ============================================================================
	//================================= Option 1 View (CRUD - Read) =================================
	public static String retrieveAllActivities(ArrayList<Activities> activityList) {
	      String output = "";
	      for (int i = 0; i < activityList.size(); i++) {

	        if (activityList.get(i) != null) {

	          String activityId = activityList.get(i).getActivityId();
	          String activityName = activityList.get(i).getActivityName();
	          String activityDesc = activityList.get(i).getActivityDescription();
	          String activityCrit = activityList.get(i).getActivityCriteria();

	          output += String.format("\n%-20s %-20s %-20s %-20s", activityId, activityName, activityDesc, activityCrit);

	        }
	      }return output;  
	    }
	    public static void viewAllActivities(ArrayList<Activities> activityList) {
	      
	      String output = String.format("%-20s %-20s %-20s %-20s\n", "Activity ID", "Activity Name",
	          "Description", "Prerequisites & Restrictions");
	      output+=retrieveAllActivities(activityList);
	      System.out.println(output);
	    }
	
	//================================= Option 2 Add (CRUD - Create)=================================
	public static Activities inputActivity() {
		String newActId = Helper.readString("Enter activity id (AA----) > ");
		String newActName = Helper.readString("Enter activity name > ");
		String newDesc = Helper.readString("Enter description > ");
		String newCrit = Helper.readString("Enter prerequisites & restrictions > ");
		
		Activities a = new Activities(newActId, newActName, newDesc, newCrit);
		return a;
	}
	
	public static void addActivity(ArrayList<Activities> activityList, Activities a) {

		Activities activity;
		for (int i = 0; i < activityList.size(); i++) {
			activity = activityList.get(i);
			if (activity.getActivityId().equalsIgnoreCase(a.getActivityId())) {
				return;
			}
		}
		if ((a.getActivityId().isEmpty()) || (a.getActivityName().isEmpty()) || (a.getActivityDescription().isEmpty()) || (a.getActivityCriteria().isEmpty())) {
			return;
		}
		activityList.add(a);
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
	
	
	public static boolean doRemoveActivity(ArrayList<Activities> activityList,String removeActId) {
		boolean activityFound = false;
		for (int i = 0; i < activityList.size(); i++) {

			if (activityList.get(i).getActivityId().equals(removeActId)) {

				activityList.remove(i);
				activityFound = true;
				break;
			}
		}

		if (activityFound) {
			System.out.println("Student removed successfully!");
		} else {
			System.out.println("Student not found!");
		}

		return activityFound;
	}
	
	//========================================================================================== Student ============================================================================
	public class myTimeSlot {

	    private static final int OPTION_VIEW = 1;
	    private static final int OPTION_ADD = 2;
	    private static final int OPTION_REMOVE = 3;
	    private static final int OPTION_UPDATE = 4;
	    private static final int OPTION_QUIT = 5;

	    public static void main(String[] args) {

	        ArrayList<TimeSlot> timeSlotList = new ArrayList<>();

	        timeSlotList.add(new TimeSlot("TS001", "Monday", "13:00", "2023/08/10"));

	        int option = 0;

	        while (option != OPTION_QUIT) {

	            menu();
	            option = Helper.readInt("Enter an option > ");

	            if (option == OPTION_VIEW) {
	                // View all time slots
	                myTimeSlot.setHeader("VIEW ALL TIME SLOTS");
	                viewAllTimeSlots(timeSlotList);

	            } else if (option == OPTION_ADD) {
	                // Add a new time slot
	                myTimeSlot.setHeader("ADD NEW TIME SLOT");
	                addTimeSlot(timeSlotList);

	            } else if (option == OPTION_REMOVE) {
	                // Remove a time slot
	                myTimeSlot.setHeader("REMOVE TIME SLOT");
	                removeTimeSlot(timeSlotList);

	            } else if (option == OPTION_UPDATE) {
	                // Update a time slot
	                myTimeSlot.setHeader("UPDATE TIME SLOT");
	                updateTimeSlot(timeSlotList);

	            } else if (option == OPTION_QUIT) {
	                System.out.println("Goodbye!");
	            } else {
	                System.out.println("Invalid option");
	            }
	        }
	    }

	    public static void menu() {
	        myTimeSlot.setHeader("TIME SLOT REGISTRATION APP");
	        System.out.println("1. View all time slots");
	        System.out.println("2. Add new time slot");
	        System.out.println("3. Remove existing time slot");
	        System.out.println("4. Update existing time slot");
	        System.out.println("5. Quit");
	        Helper.line(80, "-");
	    }

	    public static void setHeader(String header) {
	        Helper.line(30, "-");
	        System.out.println(header);
	        Helper.line(30, "-");
	    }

	    // Option 1: View
	    public static void viewAllTimeSlots(ArrayList<TimeSlot> timeSlotList) {
	        System.out.printf("%-10s %-10s %-10s %-20s\n", "Slot ID", "Day", "Time", "Date");

	        for (TimeSlot timeSlot : timeSlotList) {
	            System.out.printf("%-10s %-10s %-10s %-20s\n",
	                    timeSlot.getId(), timeSlot.getDay(), timeSlot.getTime(), timeSlot.getDate());
	        }
	    }

	    // Option 2: Add
	    public static void addTimeSlot(ArrayList<TimeSlot> slots) {
	        String newSlotId = Helper.readString("Enter slot ID (TS----) > ");
	        String newDay = Helper.readString("Enter day > ");
	        String newTime = Helper.readString("Enter time > ");
	        String newDate = Helper.readString("Enter date (yyyy/mm/dd) > ");

	        TimeSlot newTimeSlot = new TimeSlot(newSlotId, newDay, newTime, newDate);
	        slots.add(newTimeSlot);

	        System.out.println("Time slot added successfully!");
	    }


	    // Option 3: Remove
	    public static boolean removeTimeSlot(ArrayList<TimeSlot> timeSlotList) {
	        String removeSlotId = Helper.readString("Enter slot ID to remove (TS---) > ");

	        boolean timeSlotFound = false;
	        for (TimeSlot timeSlot : timeSlotList) {
	            if (timeSlot.getId().equals(removeSlotId)) {
	                timeSlotList.remove(timeSlot);
	                timeSlotFound = true;
	                System.out.println("Time slot removed successfully!");
	                break;
	            }
	        }

	        if (!timeSlotFound) {
	            System.out.println("Time slot not found!");
	        }

	        return timeSlotFound;
	    }

	    // Option 4: Update
	    public static boolean updateTimeSlot(ArrayList<TimeSlot> timeSlotList) {
	        String updateSlotId = Helper.readString("Enter slot ID to update > ");

	        boolean timeSlotFound = false;
	        for (TimeSlot timeSlot : timeSlotList) {
	            if (timeSlot.getId().equals(updateSlotId)) {
	                String newDay = Helper.readString("Enter new day > ");
	                String newTime = Helper.readString("Enter new time > ");
	                String newDate = Helper.readString("Enter new date (yyyy/mm/dd) > ");

	                timeSlot.setDay(newDay);
	                timeSlot.setTime(newTime);
	                timeSlot.setDate(newDate);

	                timeSlotFound = true;
	                System.out.println("Time slot updated successfully!");
	                break;
	            }
	        }

	        if (!timeSlotFound) {
	            System.out.println("Time slot not found!");
	        }

	        return timeSlotFound;
	    }
	//========================================================================================== Student ============================================================================

}
}
