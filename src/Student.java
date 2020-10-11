/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class Student implements CourseAnnouncementListener{
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	@Override
	public void handleMidtermDateSet(Date date) {
		study(date);
	}

	@Override
	public void handleMidtermPostponed(Date date) {
		party(date);
	}

	@Override
	public void handleAssignmentPosted(CourseEvent ce) {
		Object source = ce.getSource();
		Prof p;
		if(source instanceof Prof) {
			p = (Prof) source;
			System.out.println(p.getName());
		}
	}

}
