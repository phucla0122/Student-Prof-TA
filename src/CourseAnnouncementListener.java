import java.util.Date;

public interface CourseAnnouncementListener {

    void handleMidtermDateSet(Date date);
    void handleMidtermPostponed(Date date);
    void handleAssignmentPosted(CourseEvent ce);
}
