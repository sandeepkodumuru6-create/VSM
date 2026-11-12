import java.util.List;

public class Booking {
    private String bookingId;
    private User user;
    private Movie movie;
    private List<Seat> bookedSeats;
    private double totalAmount;

    public Booking(String bookingId, User user, Movie movie, List<Seat> bookedSeats) {
        this.bookingId = bookingId;
        this.user = user;
        this.movie = movie;
        this.bookedSeats = bookedSeats;
        
        double sum = 0;
        for (Seat seat : bookedSeats) {
            sum += seat.getPrice();
        }
        this.totalAmount = sum;
    }

    public void printTicket() {
        System.out.println("\n==================================");
        System.out.println("       VSM SHOWS - E-TICKET       ");
        System.out.println("==================================");
        System.out.println("Booking ID : " + bookingId);
        System.out.println("User Name  : " + user.getName());
        System.out.println("Email      : " + user.getEmail());
        System.out.println("Movie      : " + movie.getTitle() + " (" + movie.getLanguage() + ")");
        System.out.print("Seats      : ");
        for (Seat s : bookedSeats) {
            System.out.print(s.getSeatNumber() + " (" + s.getType() + ") ");
        }
        System.out.println("\nTotal Paid : ₹" + totalAmount);
        System.out.println("==================================\n");
    }
}