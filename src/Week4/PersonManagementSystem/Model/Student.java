package Week4.PersonManagementSystem.Model;
public class Student extends Person {
    private int yearOfAdmission;
    private double entranceEnglishScore;

    public Student(String ID, String fullName, String phoneNumber, String major, int yearOfBirth, int yearOfAdmission, double entranceEnglishScore) {
        super(ID, fullName, phoneNumber, major, yearOfBirth);
        this.yearOfAdmission = yearOfAdmission;
        this.entranceEnglishScore = entranceEnglishScore;
    }

    @Override
    public String toString() {
        return super.toString() + ", Year Of Admission: " + yearOfAdmission + ", Entrance English Score: " + entranceEnglishScore;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }
}

    

