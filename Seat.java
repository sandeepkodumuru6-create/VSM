public class Seat {
    private String seatNumber;
    private String type; // VIP, Executive, Normal
    private double price;
    private boolean isBooked;

    public Seat(String seatNumber, String type, double price) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }

    public String getSeatNumber() { return seatNumber; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }
}