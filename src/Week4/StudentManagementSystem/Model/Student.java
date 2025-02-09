package Week4.StudentManagementSystem.Model;

public class Student {
    
    private String studentID; 
    private String studentName;
    private String semester;
    private String courseName;

    public Student(String studentID, String studentName, String semester, String courseName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

   
    @Override
    public String toString() {
        return "Student ID: " +studentID+
                ", Student Name: " +studentName+
                ", Semester: " +semester+
                ", Course Name: " +courseName;
                }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    
}
