package Week6.ManageWorkerInformation.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WorkerList {

    private ArrayList<Worker> workerList = new ArrayList<>();

    public void loadFromFile(String filename) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Fixed Date Format

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) { // Fixed while loop
                String[] details = line.split(",");
                if (details.length == 6) {
                    try {
                        String id = details[0].trim();
                        String name = details[1].trim();
                        int age = Integer.parseInt(details[2].trim());
                        double salary = Double.parseDouble(details[3].trim());
                        String workLocation = details[4].trim();
                        Date updateDate = sdf.parse(details[5].trim());
                        workerList.add(new Worker(id, name, age, salary, workLocation, updateDate));

                    } catch (NumberFormatException | ParseException e) {
                        System.out.println("Error parsing line: " + line);
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Invalid format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
            e.printStackTrace();
        }
    }

    public ArrayList<Worker> getWorkerList() {
        return workerList;
    }

    public Worker findWorkerById(String id) {
        for (Worker w : workerList) {
            if (w.getId().equalsIgnoreCase(id)) {
                return w;
            }
        }
        return null;
    }

    public boolean isWorkerIdDulicated(String id) {
        for (Worker worker : workerList) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public String getWorkerNameByID(String id) {
        for (Worker worker : workerList) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker.getName();
            }
        }
        return "";
    }

    public void displayAll() {
        for (Worker worker : workerList) {
            System.out.println(worker);
        }
    }
}
