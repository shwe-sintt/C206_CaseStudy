public class User {

		private String id;
		private String name;
		private String username;
		private String password;
		private String role;
		private String activityChosen;
		private String attendanceStatus;
		
		public User(String id, String name, String username, String password, String role) {
			this.id=id;
			this.name=name;
			this.username=username;
			this.password=password;
			this.role=role;
			
		}
		
		public User(String id, String name, String username, String password, String role, String activityChosen, String attendanceStatus) {
			this.id=id;
			this.name=name;
			this.username=username;
			this.password=password;
			this.role=role;
			this.activityChosen=activityChosen;
			this.attendanceStatus= attendanceStatus;
			
		}
		
		public User(String id, String name, String username, String password, String role, String activityChosen) {
			this.id=id;
			this.name=name;
			this.username=username;
			this.password=password;
			this.role=role;
			this.activityChosen=activityChosen;
			
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getRole() {
			return role;
		}
		
		public void setRole(String role) {
			this.role=role;
		}
		
		public String getActivityChosen() {
			return activityChosen;
		}
		
		public void setActivityChosen(String activityChosen) {
			this.activityChosen=activityChosen;
		}
		
		public String getAttendanceStatus() {
			return attendanceStatus;
		}
		
		public void setAttendanceStatus(String attendanceStatus) {
			this.attendanceStatus=attendanceStatus;
		}
		
		public String toString() {
			
			// Write your codes here
			String userInfo = String.format("%-20s %-20s %-20s %-20s %-20s", 
					name, 
					id,
					activityChosen,
					attendanceStatus,
					role);
			
			return userInfo;
		}

 
}

