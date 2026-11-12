import java.util.*;

public class TicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initial Movie Catalog (Tamil, Telugu, Malayalam, etc.)
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("M1", "Jailer 2", "Tamil", "Action / Thriller", "2h 45m"));
        movies.add(new Movie("M2", "Drishyam 3", "Malayalam", "Crime / Mystery", "2h 30m"));
        movies.add(new Movie("M3", "Comrade Kalyan", "Telugu", "Drama / Romance", "2h 50m"));
        movies.add(new Movie("M4", "Dhurandhar 2", "Hindi", "Action / Spy", "2h 40m"));

        System.out.println("========================================");
        System.out.println("   WELCOME TO VSM SHOWS BOOKING SYSTEM  ");
        System.out.println("========================================");
        
        // User Signup / Login simulation
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Create a password: ");
        String password = scanner.nextLine();
        
        User currentUser = new User(name, email, password);
        System.out.println("\nLogin successful! Welcome, " + currentUser.getName() + ".\n");

        // Display Movies
        System.out.println("--- NOW SHOWING MOVIES ---");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }

        System.out.print("\nSelect a movie number (1-" + movies.size() + "): ");
        int movieChoice = scanner.nextInt();
        if (movieChoice < 1 || movieChoice > movies.size()) {
            System.out.println("Invalid choice!");
            scanner.close();
            return;
        }
        Movie selectedMovie = movies.get(movieChoice - 1);

        // Setup Hall Seats with Tiers
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("A1", "VIP", 350));
        seats.add(new Seat("A2", "VIP", 350));
        seats.add(new Seat("B1", "Executive", 250));
        seats.add(new Seat("B2", "Executive", 250));
        seats.add(new Seat("C1", "Normal", 150));
        seats.add(new Seat("C2", "Normal", 150));

        System.out.println("\n--- AVAILABLE SEATS ---");
        for (Seat s : seats) {
            String status = s.isBooked() ? "[BOOKED]" : "[AVAILABLE]";
            System.out.println("Seat: " + s.getSeatNumber() + " | Type: " + s.getType() + " | Price: ₹" + s.getPrice() + " " + status);
        }

        System.out.print("\nEnter seat number to book (e.g., A1): ");
        String seatNum = scanner.next();
        
        Seat selectedSeat = null;
        for (Seat s : seats) {
            if (s.getSeatNumber().equalsIgnoreCase(seatNum)) {
                selectedSeat = s;
                break;
            }
        }

        if (selectedSeat != null && !selectedSeat.isBooked()) {
            selectedSeat.setBooked(true);
            List<Seat> bookedList = new ArrayList<>();
            bookedList.add(selectedSeat);
            
            String bookingId = "VSM-" + (1000 + new Random().nextInt(9000));
            Booking booking = new Booking(bookingId, currentUser, selectedMovie, bookedList);
            booking.printTicket();
        } else {
            System.out.println("❌ Error: Invalid seat number or seat is already booked.");
        }

        scanner.close();
    }
}