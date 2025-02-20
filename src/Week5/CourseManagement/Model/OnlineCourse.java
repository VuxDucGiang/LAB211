package Week5.CourseManagement.Model;

public class OnlineCourse extends Course{
    private String platform;
    private String instructor;
    private String note;

    public OnlineCourse(String courseID, String courseName, int credits,String platform, String instructor, String note) {
        super(courseID, courseName, credits);
        this.platform = "";
        this.instructor = "";
        this.note = "";
    }

    @Override
    public String toString() {
        return super.toString() + ", Platform: " + platform+ ", Instructor: " + instructor+", Note: "+ note;
    }
}
