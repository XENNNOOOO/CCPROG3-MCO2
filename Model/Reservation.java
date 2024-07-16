/**
 * Represents a reservation with guest information, room price, and check-in/check-out dates.
 */
public class Reservation {
    private String guestName;
    private double reservationPrice;
    private int checkIn;
    private int checkOut;
    private double[] modifiers;

    /**
     * Constructs a Reservation object with the specified guest name, check-in date, and check-out date.
     *
     * @param guestName The name of the guest for the reservation.
     * @param checkIn   The check-in date for the reservation.
     * @param checkOut  The check-out date for the reservation.
     * @param reservationPrice The price per night of the room for the reservation.
     */
    public Reservation(String guestName, int checkIn, int checkOut, double reservationPrice, double[] modifiers) {
        this.guestName = guestName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.reservationPrice = reservationPrice;
        this.modifiers = modifiers;
    }

    /**
     * Retrieves the guest name for the reservation.
     *
     * @return The guest name.
     */
    public String getGuestName() {
        return this.guestName;
    }

    /**
     * Retrieves the check-out date for the reservation.
     *
     * @return The check-out date.
     */
    public int getCheckOut() {
        return this.checkOut;
    }

    /**
     * Retrieves the check-in date for the reservation.
     *
     * @return The check-in date.
     */
    public int getCheckIn() {
        return this.checkIn;
    }

    public int getDays() {
        return checkOut - checkIn;
    }

    public double getReservationPrice() {
        return this.reservationPrice;
    }

    /**
     * Calculates and retrieves the total price of the reservation.
     *
     * @return The total price of the reservation.
     */
    public double getTotalReservationPrice() {
        double sum = 0;
        for(int i = checkIn-1; i < checkOut - 1; i++) {
            sum += reservationPrice * modifiers[i];
        }

        return sum;
    }

}
