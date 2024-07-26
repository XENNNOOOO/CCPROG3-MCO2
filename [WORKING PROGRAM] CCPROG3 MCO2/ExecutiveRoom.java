/**
 * Represents a executive room which is a child of base room
 */
public class ExecutiveRoom extends Room {

    /**
     * Constructs a new ExecutiveRoom with the specified name and associated hotel.
     *
     * @param name       The name of the executive room.
     * @param hotelOwned The hotel to which this executive room belongs.
     */
    public ExecutiveRoom(String name, Hotel hotelOwned) {
        super(name, hotelOwned);
    }

    /**
     * Overrides the addReservation method to adjust the base price for executive rooms,
     * which costs 35% more than a standard room.
     *
     * @param guestName  The name of the guest making the reservation.
     * @param basePrice  The base price of the reservation.
     * @param checkIn    The check-in date of the reservation.
     * @param checkOut   The check-out date of the reservation.
     * @param discCode   The discount code (if any) applied to the reservation.
     */
    @Override
    public void addReservation(String guestName, double basePrice, int checkIn, int checkOut, String discCode) {
        basePrice = basePrice * 1.35; //Deluxe room costs 35% more than a standard room
        super.addReservation(guestName, basePrice, checkIn, checkOut, discCode);
    }
}
