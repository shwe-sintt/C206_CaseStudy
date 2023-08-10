

import java.util.ArrayList;

public class Activity {
	
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_REMOVE = 3;
	private static final int OPTION_UPDATE = 4;
	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {

		ArrayList<Activities> activityList = new ArrayList<Activities>();

		activityList.add(new Activities("AA001", "Basketball", "Orange ball", "Must like orange"));

		int option = 0;

		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all items
				Activity.setHeader("VIEW ALL ACTIVITIES");
				Activity.viewAllActivities(activityList);

			} else if (option == OPTION_ADD) {
				// Add a new item
				Activity.setHeader("ADD NEW ACTIVITY");			
				addActivity(activityList);

			} else if (option == OPTION_REMOVE) {
				// Loan item
				Activity.setHeader("REMOVE ACTIVITY");				
				removeActivity(activityList);
				
			} else if (option == OPTION_UPDATE) {
				// Return item
				Activity.setHeader("RETURN");				
				//studentFound = updateStudent(studentList);

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		Activity.setHeader("CCA REGISTRATION APP");
		System.out.println("1. View all activities");
		System.out.println("2. Add new activity");
		System.out.println("3. Remove existing activity");
		System.out.println("4. Update existing activity");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//================================= Option 1 View (CRUD - Read) =================================
	public static void viewAllActivities(ArrayList<Activities> activityList) {
		
		String output = String.format("%-20s %-20s %-20s\n", "Activity Name", "Description",
				"Prerequisites & Restrictions");

		for (int i = 0; i < activityList.size(); i++) {

			if (activityList.get(i) != null) {

				String activityName = activityList.get(i).getName();
				String activityDesc = activityList.get(i).getDescription();
				String activityCrit = activityList.get(i).getCriteria();

				output += String.format("\n%-20s %-20s %-20s", activityName, activityDesc, activityCrit);

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

		Activities newActivity = new Activities(newActId, newActName, newDesc, newCrit);
		activityList.add(newActivity);

		System.out.println("Activity added successfully!");
	}
	
	//================================= Option 3 Remove (CRUD - Delete)=================================
	public static boolean removeActivity(ArrayList<Activities> activityList) {

		String removeActId = Helper.readString("Enter activity ID to remove (AA----) > ");

		boolean activityFound = false;
		for (int i = 0; i < activityList.size(); i++) {

			if (activityList.get(i).getId().equals(removeActId)) {

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
	
	
	//================================= Option 4 Update (CRUD - Update)=================================
	public static boolean updateActivity(ArrayList<Activities> activityList) {
		
		String updActId = Helper.readString("Enter activity ID to update > ");

		boolean activityFound = false;
		for (int i = 0; i < activityList.size(); i++) {

			if (activityList.get(i).getId().equals(updActId)) {

				String updActName = Helper.readString("Enter activity name to update > ");

				String updActDesc = Helper.readString("Enter description to update > ");
				
				String updActCrit = Helper.readString("Enter prerequisites & restrictions to update > ");

				activityList.get(i).setName(updActName);
				activityList.get(i).setDescription(updActDesc);
				activityList.get(i).setCriteria(updActCrit);

				activityFound = true;
				break;
			}
		}

		if (activityFound) {
			System.out.println("Activity updated successfully!");
		} else {
			System.out.println("Activity not found!");
		}

		return activityFound;
	}

}
