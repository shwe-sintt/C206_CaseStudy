/*
 *
 * 
 *I declare that this code was written by me.
 *I do not copy or allow others to copy my code.
 *I understand that copying code is considered as plagiarism.
 *
 *Student Name: Trevor Toh
 *Student ID: 21014820
 *Class: W64P
 */

/**
 * @author 21014820
 *
 */
public class TimeSlot {
	   private String id;
       private String day;
       private String time;
       private String date;

       public TimeSlot(String id, String day, String time, String date) {
           this.id = id;
           this.day = day;
           this.time = time;
           this.date = date;
       }

       public String getId() {
           return id;
       }

       public String getDay() {
           return day;
       }

       public void setDay(String day) {
           this.day = day;
       }

       public String getTime() {
           return time;
       }

       public void setTime(String time) {
           this.time = time;
       }

       public String getDate() {
           return date;
       }

       public void setDate(String date) {
           this.date = date;
       }

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
   }
