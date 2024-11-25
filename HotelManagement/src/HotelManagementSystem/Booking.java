package HotelManagementSystem;

import java.util.Date;

public class Booking {
    private int roomNumber;
    private String customerName;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalAmount;

    public Booking(int roomNumber, String customerName, Date checkInDate, Date checkOutDate, double totalAmount) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Booking [Room Number: " + roomNumber + ", Customer: " + customerName + ", Check-in: " + checkInDate +
               ", Check-out: " + checkOutDate + ", Total Amount: $" + totalAmount + "]";
    }
}
