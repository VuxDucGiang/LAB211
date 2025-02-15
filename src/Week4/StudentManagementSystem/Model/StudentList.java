package Week4.StudentManagementSystem.Model;

import Week4.StudentManagementSystem.View.DataInput;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
   private Student student;
  private ArrayList<Student> studentLists = new ArrayList<>();
  
  public void loadFromFile(String filename) {
      try (BufferedReader br = new BufferedReader(new FileReader(filename))){
          String line;
          while((line = br.readLine()) != null ){
              String[] details = line.split(",");
              if (details.length == 4){
                  try {
                      String studentID = details[0].trim();
                      String studentName = details[1].trim();
                      String semester = details[2].trim();
                      String courseName = details[3].trim();
                      
                      studentLists.add(new Student(studentID, studentName, semester, courseName));
              }catch (NumberFormatException e){
                      System.out.println("Skipping invalid format line: " + line);
              }
              }else {
                  System.out.println("Invalid Format Line: " +line);
              }
          }
      }catch (IOException e){
          e.printStackTrace();
      }
  }
  public void displayAll(){
      for(Student student : studentLists){
          System.out.println(student);
      }
  }
 public String getStudentNameByID(String studentID) {
    for (Student student : studentLists) {
        if (student.getStudentID().equalsIgnoreCase(studentID)) {
            return student.getStudentName(); 
        }
    }
    return ""; 
}
 public String getStudentIDByName(String studentName) {
    for (Student student : studentLists) {
        if (student.getStudentName().equalsIgnoreCase(studentName)) {
            return student.getStudentID(); 
        }
    }
    return ""; 
}
  public boolean isStudentIDDulicated(String studentID){
      for(Student student : studentLists){
          if(student.getStudentID().equalsIgnoreCase(studentID)){
              return true;
          }
      }
      return false;
  }
  public boolean isCourseAlreadyTaken(String studentID, String semester, String courseName) {
        for (Student student : studentLists) {
            if (student.getStudentID().equalsIgnoreCase(studentID)
                    && student.getSemester().equalsIgnoreCase(semester)
                    && student.getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isValidCourse(String courseName, String[] validCourses) {
    for (String course : validCourses) {
        if (course.equalsIgnoreCase(courseName)) {
            return true;
        }
    }
    return false;
}
  public ArrayList<Student> getStudentList(){
      return studentLists;
  }
   
}

