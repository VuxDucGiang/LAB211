package Week6.ManageWorkerInformation.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    private Date updateDay;

    public Worker(String id, String name, int age, double salary, String workLocation, Date updateDay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.updateDay = updateDay;
    }
@Override
public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return String.format(
        "----------------------------------\n" +
        " Worker Information \n" +
        "----------------------------------\n" +
        " Code          : %s\n" +
        " Name          : %s\n" +
        " Age           : %d\n" +
        " Salary        : %.2f\n" +
        " Work Location : %s\n" +
        " Update Date   : %s\n" +
        "----------------------------------",
        id, name, age, salary, workLocation, sdf.format(updateDay)
    );
}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public Date getUpdateDay() {
        return updateDay;
    }

    public void setUpdateDay(Date updateDay) {
        this.updateDay = updateDay;
    }
    
    
    
}
