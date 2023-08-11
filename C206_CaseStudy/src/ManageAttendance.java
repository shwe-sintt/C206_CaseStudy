import java.util.List;
import java.util.Scanner;

public class ManageAttendance {
	public static void main(String[] args) {
	    public static void manageAttendanceMenu(List<User> userList) {
	        Scanner scanner = new Scanner(System.in);
	
	        int choice;
	        do {
	            System.out.println("\n** Manage Attendance **\n");
	            System.out.println("1. View Attendance");
	            System.out.println("2. Add Attendance");
	            System.out.println("3. Delete Attendance");
	            System.out.println("4. Back");
	
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine();
	
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
	        } while (choice != 4);
	    }
	
	    private static boolean isValidActivityCode(String activityCode, List<User> userList) {
	        return userList.stream().anyMatch(user ->
	                "student".equalsIgnoreCase(user.getRole()) && activityCode.equals(user.getActivityChosen()));
	    }
	
	    private static boolean isValidStudent(String name, String activityCode, List<User> userList) {
	        return userList.stream().anyMatch(user ->
	                "student".equalsIgnoreCase(user.getRole()) &&
	                activityCode.equals(user.getActivityChosen()) &&
	                user.getName().equalsIgnoreCase(name));
	    }
	
	    private static User findUser(String name, String activityCode, List<User> userList) {
	        return userList.stream().filter(user ->
	                "student".equalsIgnoreCase(user.getRole()) &&
	                activityCode.equals(user.getActivityChosen()) &&
	                user.getName().equalsIgnoreCase(name))
	                .findFirst()
	                .orElse(null);
	    }
	
	    private static void viewAttendance(List<User> userList) {
	        Scanner scanner = new Scanner(System.in);
	
	        System.out.print("Enter activity code: ");
	        String activityCode = scanner.nextLine();
	
	        if (!isValidActivityCode(activityCode, userList)) {
	            System.out.println("\nInvalid activity code.");
	            return;
	        }
	
	        boolean foundAttendance = false;
	
	        for (User user : userList) {
	            if ("student".equalsIgnoreCase(user.getRole()) &&
	                    activityCode.equals(user.getActivityChosen()) &&
	                    !user.getAttendanceStatus().isEmpty()) {
	                displayAttendance(user);
	                foundAttendance = true;
	            }
	        }
	
	        if (!foundAttendance) {
	            System.out.println("No attendance records yet.");
	        }
	    }
	
	    private static void displayAttendance(User user) {
	        System.out.println("\n** View Attendance **");
	        System.out.println("Attendance Records:");
	        System.out.println("+----+-----------------+-----------+----------------+");
	        System.out.printf("| %-2s | %-15s | %-10s | %-14s |%n", "ID", "Name", "Username", "Attendance");
	        System.out.println("+----+-----------------+-----------+----------------+");
	        System.out.printf("| %-2s | %-15s | %-10s | %-14s |%n",
	                user.getId(), user.getName(), user.getUsername(), user.getAttendanceStatus());
	        System.out.println("+----+-----------------+-----------+----------------+");
	    }
	
	    private static void addAttendance(List<User> userList) {
	        Scanner scanner = new Scanner(System.in);
	
	        System.out.print("Enter activity code: ");
	        String activityCode = scanner.nextLine();
	
	        if (!isValidActivityCode(activityCode, userList)) {
	            System.out.println("\nInvalid activity code.");
	            return;
	        }
	
	        System.out.print("Enter student name: ");
	        String name = scanner.nextLine();
	
	        if (!isValidStudent(name, activityCode, userList)) {
	            System.out.println("\nStudent not found or not associated with the specified activity.");
	            return;
	        }
	
	        User user = findUser(name, activityCode, userList);
	
	        System.out.print("Enter attendance status (Present/Absent): ");
	        String attendanceStatus = scanner.nextLine();
	
	        if ("Present".equalsIgnoreCase(attendanceStatus) || "Absent".equalsIgnoreCase(attendanceStatus)) {
	            user.setAttendanceStatus(attendanceStatus);
	            System.out.println("\nAttendance added for " + name + ": " + attendanceStatus);
	        } else {
	            System.out.println("\nInvalid attendance status. Please enter 'Present' or 'Absent'.");
	        }
	    }
	
	    private static void deleteAttendance(List<User> userList) {
	        Scanner scanner = new Scanner(System.in);
	
	        System.out.print("Enter activity code: ");
	        String activityCode = scanner.nextLine();
	
	        if (!isValidActivityCode(activityCode, userList)) {
	            System.out.println("\nInvalid activity code.");
	            return;
	        }
	
	        System.out.print("Enter student name to delete attendance: ");
	        String name = scanner.nextLine();
	
	        if (!isValidStudent(name, activityCode, userList)) {
	            System.out.println("\nStudent not found or not associated with the specified activity.");
	            return;
	        }
	
	        User user = findUser(name, activityCode, userList);
	
	        if (!user.getAttendanceStatus().isEmpty()) {
	            user.setAttendanceStatus("");
	            System.out.println("Attendance record for " + name + " deleted.");
	        } else {
	            System.out.println("Attendance for " + name + " does not exist.");
	        }
	    }
	}
}
