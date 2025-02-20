package Week5.CourseManagement.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OfflineCourse extends Course {

    private Date beginDate;
    private Date endDate;
    private String campus;

    public OfflineCourse(String courseID, String courseName, int credits, Date beginDate, Date endDate, String campus) {
        super(courseID, courseName, credits);
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.campus = "";
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + "Begin Date: " + sdf.format(beginDate) + ", End Date: " + sdf.format(endDate) + ", Campus: " + campus;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

}
