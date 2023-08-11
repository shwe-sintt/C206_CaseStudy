import java.util.ArrayList;

public class ManageAttendance {

    private static final int OPTION_VIEW = 1;
    private static final int OPTION_ADD = 2;
    private static final int OPTION_DELETE = 3;
    private static final int OPTION_BACK = 4;

    public static void manageAttendanceMenu(ArrayList<User3> userList) {
        int choice = 0;
        while (choice != OPTION_BACK) {
            System.out.println("\n** Manage Attendance **\n");
            System.out.println("1. View Attendance");
            System.out.println("2. Add Attendance");
            System.out.println("3. Delete Attendance");
            System.out.println("4. Back");

            choice = Helper.readInt("Enter your choice: ");

            switch (choice) {
                case OPTION_VIEW:
                    viewAttendance(userList);
                    break;
                case OPTION_ADD:
                    addAttendance(userList);
                    break;
                case OPTION_DELETE:
                    deleteAttendance(userList);
                    break;
                case OPTION_BACK:
                    System.out.println("Going back to the main menu...\n");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void viewAttendance(ArrayList<User3> userList) {
        String activityCode = Helper.readString("Enter activity code: ");

        boolean validActivity = false;
        for (User3 user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && activityCode.equals(user.getActivityChosen())) {
                validActivity = true;
                break;
            }
        }

        if (!validActivity) {
            System.out.println("\nInvalid activity code.");
            return;
        }

        boolean foundAttendance = false;

        for (User3 user : userList) {
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
            System.out.println("No attendance records yet.");
        }
    }

    public static void addAttendance(ArrayList<User3> userList) {
        String activityCode = Helper.readString("Enter activity code: ");

        boolean validActivity = false;
        for (User3 user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && user.getActivityChosen().equals(activityCode)) {
                validActivity = true;
                break;
            }
        }

        if (!validActivity) {
            System.out.println("\nInvalid activity code.");
            return;
        }

        String name = Helper.readString("Enter student name: ");

        boolean validStudent = false;
        for (User3 user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && user.getActivityChosen().equals(activityCode) && user.getName().equalsIgnoreCase(name)) {
                validStudent = true;
                break;
            }
        }

        if (!validStudent) {
            System.out.println("\nStudent not found or not associated with the specified activity.");
            return;
        }

        for (User3 user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && user.getActivityChosen().equals(activityCode) && user.getName().equalsIgnoreCase(name)) {
                String attendanceStatus = Helper.readString("Enter attendance status (Present/Absent): ");

                if ("Present".equalsIgnoreCase(attendanceStatus) || "Absent".equalsIgnoreCase(attendanceStatus)) {
                    user.setAttendanceStatus(attendanceStatus);
                    System.out.println("\nAttendance added for " + name + ": " + attendanceStatus);
                } else {
                    System.out.println("\nInvalid attendance status. Please enter 'Present' or 'Absent'.");
                }
                return;
            }
        }
    }

    public static void deleteAttendance(ArrayList<User3> userList) {
        String activityCode = Helper.readString("Enter activity code: ");

        boolean validActivity = false;
        for (User3 user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && user.getActivityChosen().equals(activityCode)) {
                validActivity = true;
                break;
            }
        }

        if (!validActivity) {
            System.out.println("\nInvalid activity code.");
            return;
        }

        String name = Helper.readString("Enter student name to delete attendance: ");

        boolean validStudent = false;
        for (User3 user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && user.getActivityChosen().equals(activityCode) && user.getName().equalsIgnoreCase(name)) {
                validStudent = true;
                break;
            }
        }

        if (!validStudent) {
            System.out.println("\nStudent not found or not associated with the specified activity.");
            return;
        }

        for (User3 user : userList) {
            if ("student".equalsIgnoreCase(user.getRole()) && user.getActivityChosen().equals(activityCode) && user.getName().equalsIgnoreCase(name)) {
                if (!user.getAttendanceStatus().isEmpty()) {
                    user.setAttendanceStatus("");
                    System.out.println("Attendance record for " + name + " deleted.");
                } else {
                    System.out.println("Attendance for " + name + " does not exist.");
                }
                return;
            }
        }
    }
}
