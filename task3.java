import java.util.*;

class Room {
    int number;
    String category;
    boolean available;

    public Room(int number, String category) {
        this.number = number;
        this.category = category;
        this.available = true;
    }
}

public class HotelReservationSystem {
    private List<Room> rooms;
    private Map<Integer, String> bookings;

    public HotelReservationSystem() {
        this.rooms = new ArrayList<>();
        this.bookings = new HashMap<>();

        // Initialize rooms
        rooms.add(new Room(1, "Single"));
        rooms.add(new Room(2, "Double"));
        rooms.add(new Room(3, "Suite"));
    }

    public void searchRooms(String category) {
        for (Room room : rooms) {
            if (room.category.equals(category) && room.available) {
                System.out.println("Room " + room.number + " is available.");
            }
        }
    }

    public void makeReservation(int roomNumber, String guestName) {
        for (Room room : rooms) {
            if (room.number == roomNumber && room.available) {
                room.available = false;
                bookings.put(roomNumber, guestName);
                System.out.println("Room " + roomNumber + " booked successfully for " + guestName + ".");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not available.");
    }

    public void viewBookingDetails(int roomNumber) {
        if (bookings.containsKey(roomNumber)) {
            System.out.println("Room " + roomNumber + " is booked by " + bookings.get(roomNumber) + ".");
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Search rooms");
            System.out.println("2. Make reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter room category: ");
                    String category = scanner.next();
                    system.searchRooms(category);
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.next();
                    system.makeReservation(roomNumber, guestName);
                    break;
                case 3:
                    System.out.print("Enter room number: ");
                    int roomNumber1 = scanner.nextInt();
                    system.viewBookingDetails(roomNumber1);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
