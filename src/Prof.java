/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prof {
	private String name;
	private Date midtermDate;
	private List<CourseAnnouncementListener> courseAnnouncementListeners;

	public Prof(String aName) {
		this.name = aName;
		this.courseAnnouncementListeners = new ArrayList<>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		for(CourseAnnouncementListener cal : courseAnnouncementListeners) cal.handleMidtermDateSet(date);

	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		for(CourseAnnouncementListener cal : courseAnnouncementListeners) cal.handleMidtermPostponed(date);
	}

	public void postAssignment(String text, Date deadline) {
		for(CourseAnnouncementListener cal : courseAnnouncementListeners)
			cal.handleAssignmentPosted(new CourseEvent(this, text, deadline));
	}

	public void addCourseAnnouncementListener(CourseAnnouncementListener cal){
		this.courseAnnouncementListeners.add(cal);
	}

	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addCourseAnnouncementListener(s);
		p.addCourseAnnouncementListener(s2);
		p.addCourseAnnouncementListener(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
