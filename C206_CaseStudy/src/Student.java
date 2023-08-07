
public class Student {
	
	private String studentName;
	private String studentId;
	private String activityChosen;
	
	public Student(String studentName, String studentId, String activityChosen) {
		
		this.studentName = studentName;
		this.studentId = studentId;
		this.activityChosen = activityChosen;
		
	}
	
	public String getStudentName() {
		
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		
		this.studentName = studentName;
	}
	
	public String getStudentId() {
		
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		
		this.studentId = studentId;
	}
	
	public String getactivityChosen() {
		
		return activityChosen;
	}

	public void setactivityChosen(String activityChosen) {
		// TODO Auto-generated method stub
		this.activityChosen = activityChosen;
		
	}

}
