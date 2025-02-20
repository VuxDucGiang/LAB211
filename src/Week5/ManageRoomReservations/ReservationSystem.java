package Week5.ManageRoomReservations;

import java.util.*;
import java.text.*;

public class ReservationSystem {
    private static List <Reservation> reservations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add Reservation\n2. Search & Update Reservation\n3. Search & Delete Reservation\n4. Print All Reservations\n5. Print Pickup Reservations\n6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addReservation(); break;
                case 2: updateReservation(); break;
                case 3: deleteReservation(); break;
                case 4: printReservations(); break;
                case 5: printPickUpReservations(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }
    
    private static void addReservation() {
        try {
            System.out.print("Enter Booking ID (6 digits): ");
            String bookingID = scanner.nextLine();
            
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();
            
            System.out.print("Enter Phone Number (12 digits): ");
            String phoneNumber = scanner.nextLine();
            
            System.out.print("Enter Room Number (4 digits): ");
            String roomNumber = scanner.nextLine();
            
            System.out.print("Enter Booking Date (yyyy-MM-dd HH:mm): ");
            Date bookingDate = dateFormat.parse(scanner.nextLine());
            
            System.out.print("Enter Flight Number: ");
            String flightNumber = scanner.nextLine();
            
            System.out.print("Enter Seat Number: ");
            String seatNumber = scanner.nextLine();
            
            System.out.print("Enter Pick Up Time (yyyy-MM-dd HH:mm): ");
            Date timePickUp = dateFormat.parse(scanner.nextLine());
            
            FlightInformation flightInfo = new FlightInformation(flightNumber, seatNumber, timePickUp);
            Reservation reservation = new Reservation(bookingID, customerName, phoneNumber, roomNumber, bookingDate, flightInfo);
            reservations.add(reservation);
            System.out.println("Reservation added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
    
    private static void updateReservation() {
        System.out.print("Enter Booking ID to update: ");
        String bookingID = scanner.nextLine();
        for (Reservation r : reservations) {
            if (r.getBookingID().equals(bookingID)) {
                System.out.print("Enter new Phone Number: ");
                r.setPhoneNumber(scanner.nextLine());
                System.out.println("Reservation updated successfully!");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }
    
    private static void deleteReservation() {
        System.out.print("Enter Booking ID to delete: ");
        String bookingID = scanner.nextLine();
        reservations.removeIf(r -> r.getBookingID().equals(bookingID));
        System.out.println("Reservation deleted if found.");
    }
    
    private static void printReservations() {
        for (Reservation r : reservations) {
            System.out.println("Booking ID: " + r.getBookingID());
        }
    }
    
    private static void printPickUpReservations() {
        reservations.sort(Comparator.comparing(r -> r.getFlightInformation().getTimePickUp()));
        printReservations();
    }
}
