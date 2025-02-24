package Week6.ManageWorkerInformation.Controller;

import Week6.ManageWorkerInformation.Model.WorkerList;
import Week6.ManageWorkerInformation.View.Menu;
import Week6.ManageWorkerInformation.View.WorkerListView;

public class WorkerManagermentSystem {

    WorkerList workerList = new WorkerList();
    WorkerListView workerListView = new WorkerListView(workerList);

    public static void main(String[] args) {
        WorkerManagermentSystem wks = new WorkerManagermentSystem();
        wks.workerList.loadFromFile("src/Week6/ManageWorkerInformation/View/Worker.txt");
        String[] options = {
            "Add Worker",
            "Update Salary",
            "Display All",};

        Menu<String> menu = new Menu<>("\nWorker Management System", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 ->
                        wks.workerListView.addWorker();
                    case 2 ->
                        wks.workerListView.updateSalary();
                    case 3 ->
                        wks.workerList.displayAll();
                    default -> {
                        System.out.println("Exiting the system.");
                        System.exit(0);
                    }
                }
            }
        };
        menu.run();
    }
}
