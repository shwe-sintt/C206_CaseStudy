import java.util.ArrayList;
import java.util.Scanner;

public class myRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<registration> rlist= new ArrayList<registration>();
		rlist.add(new registration("22002200","Barbie Malibu","basketball",""));
		
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
                	addRegistration(rlist);
                	break;
                case 2:
                	deleteRegistration(rlist);
                    break;
                case 3:
                    viewAllRegistration(rlist);
                    break;
                case 4:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}
	
		public static void addRegistration(ArrayList<registration> rlist) {

			String newStuName = Helper.readString("Enter your name > ");
			String newStuID = Helper.readString("Enter your student ID > ");
			String newAct = Helper.readString("Enter your chosen activity > ");

			registration newRegistration = new registration(newStuID, newStuName, newAct);
			rlist.add(newRegistration);

			System.out.println("Registration added successfully!");
		
		
	}
		public static boolean deleteRegistration(ArrayList<registration> rlist) {

			String removeStuID = Helper.readString("Enter student ID to remove > ");

			boolean studentFound = false;
			for (int i = 0; i < rlist.size(); i++) {

				if (rlist.get(i).getStudentId().equals(removeStuID)) {

					rlist.remove(i);
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
		public static void viewAllRegistration(ArrayList<registration> rlist) {

			
			String output = String.format("%-20s %-20s %-20s\n", "Student Name", "Student ID",
					"Chosen Activity");

			for (int i = 0; i < rlist.size(); i++) {

				if (rlist.get(i) != null) {

					String studentName = rlist.get(i).getName();
					String studentId = rlist.get(i).getStudentId();
					String activityChosen = rlist.get(i).getActivityChosen();

					output += String.format("\n%-20s %-20s %-20s", studentName, studentId, activityChosen);

				}
			}
			System.out.println(output);
		}

}
