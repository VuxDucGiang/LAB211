package Week5.ManageRoomReservations;

import java.util.Date;

public class Reservation {
      private String bookingID;
    private String customerName;
    private String phoneNumber;
    private String roomNumber;
    private Date bookingDate;
    private FlightInformation flightInformation;
    
    public Reservation(String bookingID, String customerName, String phoneNumber, String roomNumber, Date bookingDate, FlightInformation flightInformation) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInformation = flightInformation;
    }
    
    public Reservation() {
        this.bookingID = "";
        this.customerName = "";
        this.phoneNumber = "";
        this.roomNumber = "";
        this.bookingDate = new Date();
        this.flightInformation = new FlightInformation();
    }
    
    public String getBookingID() { return bookingID; }
    public void setBookingID(String bookingID) { this.bookingID = bookingID; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    
    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }
    
    public FlightInformation getFlightInformation() { return flightInformation; }
    public void setFlightInformation(FlightInformation flightInformation) { this.flightInformation = flightInformation; }
    
}
