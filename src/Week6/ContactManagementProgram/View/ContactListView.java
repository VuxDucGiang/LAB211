package Week6.ContactManagementProgram.View;

import Week6.ContactManagementProgram.Model.ContactList;
import Week6.ContactManagementProgram.Model.Contact;

public class ContactListView {
    private ContactList contactList;

    public ContactListView(ContactList contactList) {
        this.contactList = contactList;
    }

    public void addContact() {
        String id, firstName, lastName, group, address, phone;

        while (true) {
            System.out.print("Enter Contact ID: ");
            id = DataInput.inputString().trim();
            if (contactList.isContactIDDulicated(id)) {
                System.out.println("Contact with ID: " + id + " already exists!");
                return;
            }
            break;
        }

        System.out.print("Enter First Name: ");
        firstName = DataInput.inputString().trim();
        System.out.print("Enter Last Name: ");
        lastName = DataInput.inputString().trim();
        System.out.print("Enter Group: ");
        group = DataInput.inputString().trim();
        System.out.print("Enter Address: ");
        address = DataInput.inputString().trim();

        while (true) {
            System.out.print("Enter Phone Number: ");
            phone = DataInput.inputString().trim();

            if (phone.matches("^(\\d{10}|\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}|\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4} (x|ext)\\d{4})$")) {
                break;
            } else {
                System.out.println(" Invalid phone number format! Please enter again.");
            }
        }

        Contact newContact = new Contact(id, firstName, lastName, group, address, phone);
        contactList.getContactList().add(newContact);
        System.out.println(" Contact added successfully!");
    }

    public void deleteContact() {
        System.out.print("Enter the ID of the contact to delete: ");
        String id = DataInput.inputString().trim();
        contactList.deleteContact(id);
    }
}
