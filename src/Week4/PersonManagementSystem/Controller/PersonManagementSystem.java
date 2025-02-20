package Week4.PersonManagementSystem.Controller;

import Week4.PersonManagementSystem.View.Menu;
import Week4.PersonManagementSystem.View.PersonListView;

public class PersonManagementSystem {

    private PersonListView plv;

    public PersonManagementSystem() {
        plv = new PersonListView();
    }

    public static void main(String[] args) {
        PersonManagementSystem pms = new PersonManagementSystem();
        pms.plv.loadFromFile();

        String[] options = {
            "Teacher",
            "Student",
            "Person",     
        };

        
        Menu<String> menu = new Menu<>("\nInformation Management", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> pms.plv.teacherManagement();
                    case 2 -> pms.plv.studentManagement();
                    case 3 -> pms.plv.personManagement();   
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        };
        menu.run();
    }
}
