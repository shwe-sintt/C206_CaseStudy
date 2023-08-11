public class registration {

		private String studentId;
		private String name;
		private String activityChosen;
		private String approvalStatus;
		
		public registration(String studentId, String name, String activityChosen) {
	        this.studentId = studentId;
	        this.name = name;
	        this.activityChosen = activityChosen;
	    }

		public registration(String studentId, String name, String activityChosen, String approvalStatus) {
	        this.studentId = studentId;
	        this.name = name;
	        this.activityChosen = activityChosen;
	        this.approvalStatus = approvalStatus;
	    }
	
		// Getters and Setters
	    public String getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(String studentId) {
	        this.studentId = studentId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getActivityChosen() {
	        return activityChosen;
	    }

	    public void setActivityChosen(String activityChosen) {
	        this.activityChosen = activityChosen;
	    }

	    public String getApprovalStatus() {
	        return approvalStatus;
	    }

	    public void setApprovalStatus(String approvalStatus) {
	        this.approvalStatus = approvalStatus;
	    }
	    public String toString() {
			
			String regiInfo = String.format("%-20s %-20s %-20s %-20s", 
					studentId,name,activityChosen,approvalStatus);
			
			return regiInfo;
		}
}
