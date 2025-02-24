package Week6.ContactManagementProgram.Controller;

import Week6.ContactManagementProgram.Model.ContactList;
import Week6.ContactManagementProgram.View.ContactListView;
import Week6.ContactManagementProgram.View.Menu;

public class ContactManagementSystem {
    private ContactList contactList = new ContactList();
    private ContactListView contactListView = new ContactListView(contactList);

    public static void main(String[] args) {
        ContactManagementSystem cms = new ContactManagementSystem();
        String[] options = {
            "Add Contact",
            "Delete Contact",
            "Display Contacts",
            "Exit"
        };

        Menu<String> menu = new Menu<>(" Contact Management System", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> cms.contactListView.addContact();
                    case 2 -> cms.contactListView.deleteContact();
                    case 3 -> cms.contactList.displayAll();
                    case 4 -> {
                        System.out.println(" Exiting the system.");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        menu.run();
    }
}
