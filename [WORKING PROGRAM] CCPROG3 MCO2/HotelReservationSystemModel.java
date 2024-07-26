import java.util.ArrayList;

/**
 * The HotelReservationSystem class manages multiple hotels and provides various functionalities
 * such as creating hotels, displaying hotel information, managing hotels, and simulating bookings.
 */
public class HotelReservationSystemModel {
    private  ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

    /**
     * Constructs a new HotelReservationSystem object with an empty list of hotels.
     */
    public HotelReservationSystemModel() {

    }

    /**
     * Retrieves a hotel object by its name.
     *
     * @param hotelName The name of the hotel to retrieve.
     * @return The Hotel object corresponding to the given name, or null if no such hotel exists.
     */
    public Hotel getHotel(String hotelName) {
        Hotel hotelWanted = null;

        for(Hotel hotel : this.hotelList) {
            if(hotelName.equals(hotel.getName())) {
                hotelWanted = hotel;
            }
        }

        return hotelWanted;
    }

    /**
     * Removes a specified hotel from the system.
     *
     * @param hotel The hotel object to be removed.
     * @return true if the hotel was successfully removed, false otherwise.
     */
    public boolean removeHotel(Hotel hotel) {
        return this.hotelList.remove(hotel);
    }

    /**
     * Creates a new hotel and adds it to the list of hotels.
     * 
     * @param hotelName The name of the hotel to be created
     * @return  The boolean value true if created, false if not
     */
    public boolean createHotel(String hotelName) { 
        boolean hotelInvalid = false;
        double basePrice = 1299.0; //default base price of 1299.0

        //check if name is unique across all hotels
        if(getHotel(hotelName) != null || hotelName.equals("")) {
            hotelInvalid = true;
        }

        //if it is unique, add hotel
        if (hotelInvalid == false) {
            Hotel newHotel = new Hotel(hotelName, basePrice);
            this.hotelList.add(newHotel);
            System.out.println("Update successful!");
        }
        else
            System.out.println("Update Invalid!");

        return !hotelInvalid;
    }

    /**
     * Constructs a string listing all hotels with their indices and names.
     *
     * @return A formatted string listing all hotels in the system.
     */
    public String getAllHotelString() {
        String result = "";
        int i = 1;

        for (Hotel hotel : hotelList) {
            result += "[" + i + "] " + hotel.getName() + "\n";
            i++;
        }

        return result;
    }

    /**
     * Changes the name of a hotel identified by its current name to a new name.
     *
     * @param hotelName The current name of the hotel to be renamed.
     * @param newName   The new name to assign to the hotel.
     * @return true if the name change was successful, false if the new name is already in use by another hotel.
     */
    public boolean changeHotelName(String hotelName, String newName) {
        if(getHotel(newName) == null) {
            this.getHotel(hotelName).setName(newName);
            return true;
        }
        else
            return false;
    }

    /**
     * Changes the name of a specified hotel object to a new name.
     *
     * @param hotel   The hotel object whose name is to be changed.
     * @param newName The new name to assign to the hotel.
     * @return true if the name change was successful, false if the new name is already in use by another hotel.
     */
    public boolean changeHotelName(Hotel hotel, String newName) {
        if(getHotel(newName) == null) {
            hotel.setName(newName);
            return true;
        }
        else
            return false;
    }

    /**
     * Retrieves the list of hotels managed by the system.
     *
     * @return An ArrayList containing all hotels in the system.
     */
    public ArrayList<Hotel> getHotelList() {
        return this.hotelList;
    }

}