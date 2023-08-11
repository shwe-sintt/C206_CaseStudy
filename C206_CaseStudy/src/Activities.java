

public class Activities{
	
		private String activityId;
		private String activityName;
		private String activityDescription;
		private String activityCriteria;

//		public Activities(String id,String name, String description, String criteria) {
//			this.id = id;
//			this.name = name;
//			this.description = description;
//			this.criteria = criteria;
//		}
		
		public Activities(String activityId,String activityName, String activityDescription, String activityCriteria) {
//			super(id, activityId, activityName, activityDescription, activityCriteria);
			this.activityId = activityId;
			this.activityName = activityName;
			this.activityDescription = activityDescription;
			this.activityCriteria = activityCriteria;
		}

		public String getActivityId() {
			return activityId;
		}

		public void setActivityId(String activityId) {
			this.activityId = activityId;
		}

		public String getActivityName() {
			return activityName;
		}

		public void setActivityName(String activityName) {
			this.activityName = activityName;
		}

		public String getActivityDescription() {
			return activityDescription;
		}

		public void setActivityDescription(String activityDescription) {
			this.activityDescription = activityDescription;
		}

		public String getActivityCriteria() {
			return activityCriteria;
		}

		public void setActivityCriteria(String activityCriteria) {
			this.activityCriteria = activityCriteria;
		}
	
}
