package Week4.PersonManagementSystem.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TeacherList {

    private ArrayList<Teacher> teacherLists = new ArrayList<>();
    private String filename = "src/Week4/PersonManagementSystem/Data/teacher.txt";

    public void loadTeacher() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Week4/PersonManagementSystem/Data/teacher.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 8) {
                    try {
                        String ID = details[0].trim();
                        String fullName = details[1].trim();
                        String phoneNumber = details[2].trim();
                        String major = details[3].trim();
                        int yearOfBirth = Integer.parseInt(details[4].trim());
                        int yearInProfession = Integer.parseInt(details[5].trim());
                        String contractType = details[6].trim();
                        double salaryCoefficient = Double.parseDouble(details[7].trim());
                         
                        teacherLists.add(new Teacher(ID, fullName, phoneNumber, major, yearOfBirth, yearInProfession, contractType, salaryCoefficient));
                       
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing number: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("Teacher Added Succesfully");
    }

    public void displayTeacher() {
        for (Teacher teacher : teacherLists) {
            System.out.println(teacher);
        }
    }

    public ArrayList<Teacher> getTeacherLists() {
        return teacherLists;
    }
public Teacher searchTeacherByName(String name) {
    for (Teacher teacher : teacherLists) {
        if (teacher.getFullName().equalsIgnoreCase(name)) {
            return teacher; 
        }
    }
    return null; 
}

}
