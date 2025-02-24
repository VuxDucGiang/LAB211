package Week6.ContactManagementProgram.Model;

public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public Contact(String id, String firstName, String lastName, String group, String address, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n"
                + "Name: " + firstName + " " + lastName + "\n"
                + "Group: " + group + "\n"
                + "Address: " + address + "\n"
                + "Phone: " + phone + "\n"
                + "------------------------------------";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
