package HotelManagementSystem;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        Payment payment = new Payment();

        System.out.println("Welcome to the Hotel Reservation System!");
        while (true) {
            System.out.println("\n1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter room category (Single, Double, Suite): ");
                    String category = scanner.nextLine();
                    List<Room> availableRooms = hotel.searchRooms(category);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No rooms available in this category.");
                    } else {
                        System.out.println("Available rooms:");
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    boolean isReserved = hotel.reserveRoom(roomNumber);
                    if (isReserved) {
                        System.out.print("Enter check-in date (yyyy-mm-dd): ");
                        String checkInDate = scanner.nextLine();
                        System.out.print("Enter check-out date (yyyy-mm-dd): ");
                        String checkOutDate = scanner.nextLine();

                        // Simulating date conversion
                        Date checkIn = new Date(checkInDate);
                        Date checkOut = new Date(checkOutDate);

                        // Find the room price
                        double roomPrice = 0;
                        for (Room room : hotel.getRooms()) {
                            if (room.getRoomNumber() == roomNumber) {
                                roomPrice = room.getPrice();
                            }
                        }

                        // Create a booking
                        double totalAmount = roomPrice;  // Assume the total is just the room price for simplicity
                        Booking booking = new Booking(roomNumber, customerName, checkIn, checkOut, totalAmount);

                        // Process payment
                        boolean paymentSuccess = payment.processPayment(totalAmount);
                        if (paymentSuccess) {
                            System.out.println("Reservation confirmed: " + booking);
                        } else {
                            System.out.println("Payment failed, please try again.");
                        }
                    } else {
                        System.out.println("Room not available.");
                    }
                    break;

                case 3:
                    // Placeholder for viewing reservations (can be implemented later)
                    System.out.println("Viewing reservations is not implemented yet.");
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
