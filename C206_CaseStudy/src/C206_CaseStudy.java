import java.util.ArrayList;

public class C206_CaseStudy {
	
	
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_REMOVE = 3;
	private static final int OPTION_UPDATE = 4;
	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			ArrayList<Student> studentList = new ArrayList<Student>();
			ArrayList<Admin> adminList = new ArrayList<Admin>();
			ArrayList<Teacher> teacherList = new ArrayList<Teacher>();

			studentList.add(new Student("Rachelle Lim", "22123456", "Floorball"));

			int option = 0;

			while (option != OPTION_QUIT) {

				UserRegistration.menu();
				option = Helper.readInt("Enter an option > ");

				if (option == OPTION_VIEW) {
					// View all items
					UserRegistration.setHeader("VIEW ALL STUDENTS");
					UserRegistration.viewAllStudent(studentList);

				} else if (option == OPTION_ADD) {
					// Add a new item
					UserRegistration.setHeader("ADD NEW STUDENT");			
					addStudent(studentList);

				} else if (option == OPTION_REMOVE) {
					// Loan item
					UserRegistration.setHeader("REMOVE STUDENT");				
					removeStudent(studentList);
					
				} else if (option == OPTION_UPDATE) {
					// Return item
					UserRegistration.setHeader("RETURN");				
					//studentFound = updateStudent(studentList);

				} else if (option == OPTION_QUIT) {
					System.out.println("Bye!");
				} else {
					System.out.println("Invalid option");
				}

			}

		}

		public static void menu() {
			UserRegistration.setHeader("CCA REGISTRATION APP");
			System.out.println("1. View all student");
			System.out.println("2. Add new student");
			System.out.println("3. Remove existing student");
			System.out.println("4. Update existing student");
			System.out.println("5. Quit");
			Helper.line(80, "-");

		}
		
		public static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
		}
		
		//================================= Option 1 View (CRUD - Read) =================================
		public static void viewAllStudent(ArrayList<Student> studentList) {
			
			String output = String.format("%-20s %-20s %-20s\n", "Student Name", "Student ID",
					"Chosen Activity");

			for (int i = 0; i < studentList.size(); i++) {

				if (studentList.get(i) != null) {

					String studentName = studentList.get(i).getStudentName();
					String studentId = studentList.get(i).getStudentId();
					String activityChosen = studentList.get(i).getactivityChosen();

					output += String.format("\n%-20s %-20s %-20s", studentName, studentId, activityChosen);

				}
			}
			System.out.println(output);
			// ------------------- END OF CODE

		}
		
		//================================= Option 2 Add (CRUD - Create)=================================
		public static void addStudent(ArrayList<Student> studentList) {

			String newStuName = Helper.readString("Enter student name > ");
			String newStuID = Helper.readString("Enter student ID > ");
			String newStuChosenAct = Helper.readString("Enter chosen activity > ");

			Student newStudent = new Student(newStuName, newStuID, newStuChosenAct);
			studentList.add(newStudent);

			System.out.println("Student added successfully!");
		}
		
		//================================= Option 3 Remove (CRUD - Delete)=================================
		public static boolean removeStudent(ArrayList<Student> studentList) {

			String removeStuID = Helper.readString("Enter student ID to remove > ");

			boolean studentFound = false;
			for (int i = 0; i < studentList.size(); i++) {

				if (studentList.get(i).getStudentId().equals(removeStuID)) {

					studentList.remove(i);
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
		
		
		//================================= Option 4 Update (CRUD - Update)=================================
		public static boolean updateStudent(ArrayList<Student> studentList) {
			
			String updStuID = Helper.readString("Enter student ID to update > ");

			boolean studentFound = false;
			for (int i = 0; i < studentList.size(); i++) {

				if (studentList.get(i).getStudentId().equals(updStuID)) {

					String updStuName = Helper.readString("Enter student name to update > ");

					String updStuChosenAct = Helper.readString("Enter chosen activity to update > ");

					studentList.get(i).setStudentName(updStuName);
					studentList.get(i).setactivityChosen(updStuChosenAct);

					studentFound = true;
					break;
				}
			}

			if (studentFound) {
				System.out.println("Student updated successfully!");
			} else {
				System.out.println("Student not found!");
			}

			return studentFound;
		}



	}
