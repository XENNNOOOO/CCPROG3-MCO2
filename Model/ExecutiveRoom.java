/**
 * Represents a executive room which is a child of base room
 */
public class ExecutiveRoom extends Room {
    public ExecutiveRoom(String name, Hotel hotelOwned) {
        super(name, hotelOwned);
    }

    @Override
    public void addReservation(String guestName, double basePrice, int checkIn, int checkOut, String discCode) {
        basePrice = basePrice * 1.35; //Deluxe room costs 35% more than a standard room
        super.addReservation(guestName, basePrice, checkIn, checkOut, discCode);
    }
}
