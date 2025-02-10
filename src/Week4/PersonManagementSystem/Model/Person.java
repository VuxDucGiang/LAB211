package Week4.PersonManagementSystem.Model;

public class Person {
    private String ID;
    private String fullName;
    private String phoneNumber;
    private String major;
    private int yearOfBirth;

    public Person(String ID, String fullName, String phoneNumber, String major, int yearOfBirth) {
        this.ID = ID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "ID: " + ID +
                ", Full Name: " + fullName +
                ", Phone Number: " + phoneNumber +
                ", Major: " + major +
                ", Year Of Birth: " + yearOfBirth;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}