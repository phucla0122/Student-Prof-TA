import java.util.Date;
import java.util.EventObject;

public class CourseEvent extends EventObject {
    private Date midtermDate, assignmentDeadLine;
    private String assignmentText;



    public CourseEvent(Prof p, Date midtermDate){
        super(p);
        this.midtermDate = midtermDate;
    }
    public  CourseEvent(Object source, String text, Date assignmentDeadLine){
        super(source);
        this.assignmentDeadLine = assignmentDeadLine;
        this.assignmentText = text;
    }

    public Date getMidtermDate() {
        return midtermDate;
    }

    public Date getAssignmentDeadLine() {
        return assignmentDeadLine;
    }

    public String getAssignmentText() {
        return assignmentText;
    }

}
