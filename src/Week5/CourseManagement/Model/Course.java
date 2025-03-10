
package Week5.CourseManagement.Model;

public class Course {
    private String courseID;
    private String courseName;
    private int credits;

    public Course(String courseID, String courseName, int credits) {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID+ 
                ", Course Name: " + courseName+
                ", Credits: " +credits;
                }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    
}
