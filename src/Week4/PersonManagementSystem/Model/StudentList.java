package Week4.PersonManagementSystem.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {

    private ArrayList<Student> studentLists = new ArrayList<>();
    private String filename = "src/Week4/PersonManagementSystem/Data/student.txt";

    public void loadStudent() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7) {
                    try {
                        String ID = details[0].trim();
                        String fullName = details[1].trim();
                        String phoneNumber = details[2].trim();
                        String major = details[3].trim();
                        int yearOfBirth = Integer.parseInt(details[4].trim());
                        int yearOfAdmission = Integer.parseInt(details[5].trim());
                        double entranceEnglishScore = Double.parseDouble(details[6].trim());

                        studentLists.add(new Student(ID, fullName, phoneNumber, major, yearOfBirth, yearOfAdmission, entranceEnglishScore));
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing number: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void displayStudent() {
        for (Student student : studentLists) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> getStudentLists() {
        return studentLists;
    }

    public Student searchStudentByName(String name) {
        for (Student student : studentLists) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

}
