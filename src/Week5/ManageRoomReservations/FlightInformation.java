package Week5.ManageRoomReservations;

import java.util.Date;

public class FlightInformation {

    private String flightNumber;
    private String seatNumber;
    private Date timePickUp;

    public FlightInformation(String flightNumber, String seatNumber, Date timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = new Date();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getTimePickUp() {
        return timePickUp;
    }

    public void setTimePickUp(Date timePickUp) {
        this.timePickUp = timePickUp;
    }
}
