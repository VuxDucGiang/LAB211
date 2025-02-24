package Week6.ContactManagementProgram.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class ContactList {
    private ArrayList<Contact> contactList = new ArrayList<>();

    public void displayAll() {
        if (contactList.isEmpty()) {
            System.out.println(" Contact list is empty.");
        } else {
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
        }
    }

    public boolean isContactIDDulicated(String id) {
        for (Contact contact : contactList) {
            if (contact.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void deleteContact(String id) {
        Iterator<Contact> iterator = contactList.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getId().equalsIgnoreCase(id)) {
                iterator.remove();
                System.out.println(" Contact removed successfully!");
                return;
            }
        }
        System.out.println(" Contact not found.");
    }

    public ArrayList<Contact> getContactList() { return contactList; }
}
