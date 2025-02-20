package Week5.CourseManagement.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OfflineCourseList {

    private ArrayList<OfflineCourse> offlineCourseList = new ArrayList<>();
    private String filename = "abc.txt"; 
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void loadOfflineCourse() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 6) {
                    try {
                        String courseID = details[0].trim();
                        String courseName = details[1].trim();
                        int credits = Integer.parseInt(details[2].trim());
                        Date beginDate = sdf.parse(details[3].trim());
                        Date endDate = sdf.parse(details[4].trim());
                        String campus = details[5].trim();

          
                        if (beginDate.after(endDate)) {
                            System.err.println("Error: beginDate must be before endDate for course " + courseID);
                            continue; 
                        }

                        offlineCourseList.add(new OfflineCourse(courseID, courseName, credits, beginDate, endDate, campus));
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing number: " + e.getMessage());
                    } catch (ParseException e) {
                        System.err.println("Error parsing date: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    public void displayOfflineCourse(){
        for(OfflineCourse offlineCourse: offlineCourseList){
            System.out.println(offlineCourse);
        }
    }

    public ArrayList<OfflineCourse> getOfflineCourseList() {
        return offlineCourseList;
    }
    
}


