package Week5.CourseManagement.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OnlineCourseList {

    private ArrayList<OnlineCourse> onlineCourseList = new ArrayList<>();
    private String filename = "abc.txt";

    public void loadOnlineCourse() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 6) {
                    try {
                        String courseID = details[0].trim();
                        String courseName = details[1].trim();
                        int credits = Integer.parseInt(details[2].trim());
                        String platform = details[3].trim();
                        String instructor = details[4].trim();
                        String note = details[5].trim();
                        onlineCourseList.add(new OnlineCourse(courseID, courseName, credits, platform, instructor, note));
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing number: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error Reading File: " + e.getMessage());
        }
    }

    public void displayOnlineCourse() {
        for (OnlineCourse onlineCourse : onlineCourseList) {
            System.out.println(onlineCourse);
        }
    }

    public ArrayList<OnlineCourse> getOnlineCourseList() {
        return onlineCourseList;
    }

}
