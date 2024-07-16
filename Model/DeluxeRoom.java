/**
 * Represents a deluxe room which is a child of base room
 */
public class DeluxeRoom extends Room {
    public DeluxeRoom(String name, Hotel hotelOwned) {
        super(name, hotelOwned);
    }

    @Override
    public void addReservation(String guestName, double basePrice, int checkIn, int checkOut, String discCode) {
        basePrice = basePrice * 1.2; //Deluxe room costs 20% more than a standard room
        super.addReservation(guestName, basePrice, checkIn, checkOut, discCode);
    }
}
