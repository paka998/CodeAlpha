package HotelManagementSystem;
public class Room {
    private int roomNumber;
    private String category;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;  // By default, rooms are available
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        this.isAvailable = false;  // Mark room as reserved
    }

    public void cancelReservation() {
        this.isAvailable = true;  // Mark room as available
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + category + ") - Price: $" + price + " - " +
               (isAvailable ? "Available" : "Not Available");
    }
}
