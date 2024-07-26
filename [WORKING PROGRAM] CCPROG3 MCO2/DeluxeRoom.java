/**
 * Represents a deluxe room which is a child of base room
 */
public class DeluxeRoom extends Room {
    /**
     * Constructs a new DeluxeRoom with the specified name and associated hotel.
     *
     * @param name       The name of the deluxe room.
     * @param hotelOwned The hotel to which this deluxe room belongs.
     */
    public DeluxeRoom(String name, Hotel hotelOwned) {
        super(name, hotelOwned);
    }

    /**
     * Adds a reservation with an adjusted base price for a deluxe room.
     *
     * @param guestName The name of the guest making the reservation.
     * @param basePrice The base price of the reservation (adjusted for deluxe room).
     * @param checkIn The day number of check-in.
     * @param checkOut The day number of check-out.
     * @param discCode The discount code (if any) applied to the reservation.
     */
    @Override
    public void addReservation(String guestName, double basePrice, int checkIn, int checkOut, String discCode) {
        basePrice = basePrice * 1.2; //Deluxe room costs 20% more than a standard room
        super.addReservation(guestName, basePrice, checkIn, checkOut, discCode);
    }
}
