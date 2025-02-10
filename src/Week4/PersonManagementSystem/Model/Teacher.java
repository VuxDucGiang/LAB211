package Week4.PersonManagementSystem.Model;

public class Teacher extends Person{
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher( String ID, String fullName, String phoneNumber, String major, int yearOfBirth,int yearInProfession, String contractType, double salaryCoefficient) {
        super(ID, fullName, phoneNumber, major, yearOfBirth);
        this.yearInProfession = yearInProfession;
        this.contractType = contractType;
        this.salaryCoefficient = salaryCoefficient;
    }

    @Override
    public String toString() {
        return super.toString() + ", Years In Proffession: " + yearInProfession+
                ", Contract Type: " +contractType+
                ", Salary Coefficient: " + salaryCoefficient;
    }
    public int getYearInProfesstion(){
        return yearInProfession;
    }
    
}
