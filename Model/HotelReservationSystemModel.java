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

    public Hotel getHotel(String hotelName) {
        Hotel hotelWanted = null;

        for(Hotel hotel : this.hotelList) {
            if(hotelName.equals(hotel.getName())) {
                hotelWanted = hotel;
            }
        }

        return hotelWanted;
    }

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
        if(getHotel(hotelName) != null) {
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
     * Displays a list of all hotels currently in the system.
     */
    public void displayAllHotel() {
        System.out.println("           Hotel List         ");
        System.out.println("==============================");

        if(this.hotelList.isEmpty())
            System.out.println("No Existing Hotels");
        else
        {
            for(int i = 0; i < this.hotelList.size(); i++) {
                System.out.println("[" + (i+1) + "] " + this.hotelList.get(i).getName()); //display [<number>] <hotelname>
            }
        }
        System.out.println();
    }

    public String getAllHotelString() {
        String result = "";

        for (Hotel hotel : hotelList) {
            result += hotel.getName() + "\n";
        }

        return result;
    }


    public boolean changeHotelName(String hotelName, String newName) {
        if(getHotel(newName) == null) {
            this.getHotel(hotelName).setName(newName);
            return true;
        }
        else
            return false;
    }

    public boolean changeHotelName(Hotel hotel, String newName) {
        if(getHotel(newName) == null) {
            hotel.setName(newName);
            return true;
        }
        else
            return false;
    }

    public ArrayList<Hotel> getHotelList() {
        return this.hotelList;
    }

}