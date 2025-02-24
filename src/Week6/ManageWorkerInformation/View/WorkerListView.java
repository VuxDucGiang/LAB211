package Week6.ManageWorkerInformation.View;

import Week6.ManageWorkerInformation.Model.WorkerList;
import Week6.ManageWorkerInformation.Model.Worker;
import java.util.Date;

public class WorkerListView {

    private WorkerList workerList;
    private Worker worker;

    public WorkerListView(WorkerList workerList) {
        this.workerList = workerList;
    }

    public void addWorker() {
        String id;
        String name;
        int age;
        double salary;
        String workLocation;
        Date updateDate;

        while (true) {
            System.out.println("Enter Worker ID: ");
            id = DataInput.inputString().trim();
            if (workerList.isWorkerIdDulicated(id)) {
                name = workerList.getWorkerNameByID(id);
                System.out.println("Worker with ID " + id + " found. Name" + name);
                break;
            } else {
                System.out.println("Enter Worker Name: ");
                name = DataInput.inputString().trim();
                break;
            }
        }
        while (true) {
            try {
                System.out.print("Enter Worker Age (18-50): ");
                age = Integer.parseInt(DataInput.inputString().trim());
                if (age >= 18 && age <= 50) {
                    break;
                } else {
                    System.out.println("Age must be between 18 and 50.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid age.");
            }
        }
        while (true) {
            try {
                System.out.print("Enter Worker Salary: ");
                salary = Double.parseDouble(DataInput.inputString().trim());
                if (salary > 0) {
                    break;
                } else {
                    System.out.println("Salary must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid salary.");
            }
        }
        System.out.println("Enter Work Location");
        workLocation = DataInput.inputString().trim();
        updateDate = new Date();
        Worker newWorker = new Worker(id, name, age, salary, workLocation, updateDate);
        workerList.getWorkerList().add(newWorker);

        System.out.println("Worker added successfully!");
    }

    public void updateSalary() {
        System.out.print("Enter Worker Code: ");
        String code = DataInput.inputString().trim();

        Worker worker = workerList.findWorkerById(code);

        if (worker != null) {
            double newSalary;
            while (true) {
                try {
                    System.out.print("Enter New Salary: ");
                    newSalary = Double.parseDouble(DataInput.inputString().trim());
                    if (newSalary > 0) {
                        break;
                    } else {
                        System.out.println("Salary must be greater than 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid salary.");
                }
            }

            worker.setSalary(newSalary);
            worker.setUpdateDay(new Date());
            System.out.println("Salary updated successfully!");
        } else {
            System.out.println("Worker with code " + code + " not found.");
        }
    }

}
