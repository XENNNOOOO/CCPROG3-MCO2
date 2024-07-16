import java.util.ArrayList;
/**
 * Represents a base room with its name, price, and reservations.
 */
public class Room {
    private String name;
    private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
    private Hotel hotelOwned;

    /**
     * Constructs a new Room object with the given name and room price.
     *
     * @param name      The name of the room.
     */
    public Room(String name, Hotel hotelOwned)    {
        this.name = name;
        this.hotelOwned = hotelOwned;
    }

    /**
     * Sets the name of the room.
     *
     * @param name The new name to set for the room.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the room.
     *
     * @return The name of the room.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the reservation at the specified index from the reservation list.
     *
     * @param index The index of the reservation to retrieve.
     * @return The reservation object at the specified index.
     */
    public Reservation getSpecificReservation(int index) {
        return this.reservationList.get(index);
    }

    /**
     * Retrieves all reservations stored in the reservation list.
     *
     * @return An ArrayList containing all reservations.
     */
    public ArrayList<Reservation> getAllReservation() {
        return this.reservationList;
    }

    /**
     * Adds a new reservation to the reservation list with the specified guest name, room price,
     * check-in date, and check-out date.
     *
     * @param guestName The name of the guest for the reservation.
     * @param basePrice The price per night of the room of the hotel for the reservation.
     * @param checkIn   The check-in date for the reservation.
     * @param checkOut  The check-out date for the reservation.
     * @param discCode  The discount code for the reservation.
     */
    public void addReservation(String guestName, double basePrice, int checkIn, int checkOut, String discCode) {
        double[] modifiers = new double[31];

        for(int i = 0; i < 31; i++) {
            modifiers[i] = this.hotelOwned.getModifier(i-1);

            if(i < checkIn - 1 || checkOut - 1 < i) //set to 0 if not part of the checkIn and checkOut dates
                modifiers[i] = 0.0;
        }

        //10% discount for code I_WORK_HERE
        if(discCode.equals("I_WORK_HERE")) 
            basePrice = basePrice * 0.9;
        // if reservation is 5 days or more, first day is free
        else if(discCode.equals("STAY4_GET1")) {
            if(checkOut - checkIn >= 5) {
                modifiers[checkIn-1] = 0;
            }
        }
        //This gives a 7% discount to the overall price if reservation covers (but not as checkout) either day 15 or 30
        else if(discCode.equals("PAYDAY")) {
            if(checkIn <= 15 && 15 < checkOut || checkIn <= 30 && 30 < checkOut ) // if in<=15<out or in<=30<out
                basePrice = basePrice * 0.93;
        }
        
        Reservation reservation = new Reservation(guestName, checkIn, checkOut, basePrice, modifiers);
        this.reservationList.add(reservation);
    }

    /**
     * Removes the specified reservation from the reservation list.
     *
     * @param reservation The reservation to be removed.
     */
    public void removeReservation(Reservation reservation) {
        this.reservationList.remove(reservation);
    }

    /**
     * Retrieves the list of reservations.
     *
     * @return An ArrayList containing all reservations.
     */
    public ArrayList<Reservation> getReservationList() {
        return this.reservationList;
    }


    /**
     * Retrieves an array representing the availability of days within a 31-day period.
     * Each element in the array represents a day, where 0 indicates the day is reserved
     * and the day number (1 to 31) indicates it is available.
     *
     * @return An array of integers representing the availability of days.
     */
    public int[] getAvailableDays() {
        int[] availableDays = new int[31];

        //setting the days from 1-31 (index 0 = day 1, 1 = day 2,...)
        for (int i = 0; i < 31; i++) {
            availableDays[i] = i+1;
        }

        //for each reservation in the list, check the check-in and check-out dates
        for (Reservation reservation : reservationList) {
            int checkIn = reservation.getCheckIn();
            int checkOut = reservation.getCheckOut();

            //for each day in-between check-in and check-out, set it to 0 (meaning unavailable)
            for (int i = checkIn - 1; i < checkOut - 1; i++) {
                availableDays[i] = 0; // Marking reserved days as unavailable
            }
        }

        return availableDays;
    }


}
