import java.util.ArrayList;

/**
 * Represents a Hotel with rooms and reservation management.
 */
public class Hotel {
    private final int ROOMLIMIT = 50;
    private String name;
    private ArrayList<Room> roomList = new ArrayList<Room>();
    private double basePrice;
    private double[] datePriceModifierList = new double[31];

    /**
     * Constructs a Hotel object with a specified name and base price for rooms.
     *
     * @param name      The name of the hotel.
     * @param basePrice The base price for rooms in the hotel.
     */
    public Hotel(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;

        //create a room, as hotel should have at least one room
        Room newRoom = new Room("THE FIRST ONE", this); 
        this.roomList.add(newRoom);

        //set all datePriceModifier to 100%
        for (double elem : datePriceModifierList) {
            elem = 1.00;
        }
    }

    /**
     * Retrieves the name of the hotel.
     *
     * @return The name of the hotel.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the hotel.
     *
     * @param newName The new name of the hotel.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Retrieves the list of rooms in the hotel.
     *
     * @return An ArrayList containing all rooms in the hotel.
     */
    public ArrayList<Room> getRoomList() {
        return this.roomList;
    }

    public Room getRoom(String roomName) {
        Room roomWanted = null;

        for(Room room : this.roomList) {
            if(roomName.equals(room.getName())) {
                roomWanted = room;
            }
        }

        return roomWanted;
    }

    /**
     * Retrieves the list of date price modifiers in the hotel.
     *
     * @return An double array containing all date price modifiers.
     */
    public double[] getModifierList() {
        return this.datePriceModifierList;
    }

    /**
     * Sets the date price modifier for a certain day.
     *
     * @param day   The day which the modifier is to be changed
     * @param decimalPercent    The decimal form of the modifier 
     * @return The boolean value of true if properly executed, else false
     */
    public boolean setModifier(int day, double decimalPercent) {
        if(1<=day && day<=31) {
            this.datePriceModifierList[day-1] = decimalPercent;
            return true;
        }
        else
            return false;
    }

    /**
     * Gets the date price modifier for a certain day.
     *
     * @param day   The day which the modifier is to be obtained
     * @return The modifier of the day specified, else negative value 
     */
    public double getModifier(int day) {
        if(1<=day && day<=31) {
            return this.datePriceModifierList[day-1];
        }
        else
            return -999
    }

    /**
     * Sets the base price for rooms in the hotel.
     *
     * @param newPrice The new base price to set for rooms.
     */
    public void setBasePrice(double newPrice) {
        boolean canChange = true;
        
        //check every room is empty
        for(int i = 0; i < this.roomList.size(); i++) {
            if (!this.roomList.get(i).getReservationList().isEmpty()) {
                canChange = false;
            }
        }
        if (canChange) {
            this.basePrice = newPrice;
        }
    }

    /**
     * Retrieves the base price for rooms in the hotel.
     *
     * @return The base price for rooms.
     */
    public double getBasePrice() {
        return this.basePrice;
    }

    //ADD ROOM METHODS
    /**
     * Adds a new Standard room to the hotel with the specified name, if the name is unique and room limit is not exceeded.
     *
     * @param roomName The name of the new room to add.
     */
    public void addStandardRoom(String roomName) {
        boolean nameTaken = false;

        //if hotel roomlist isn't full yet
        if (this.roomList.size() < ROOMLIMIT) {
            //check for the name if it is unique
            for(Room r : this.roomList) {
                if(roomName.equals(r.getName())) {
                    nameTaken = true;
                    break;
                }
            }
            //if it is unique, add the room
            if (nameTaken == false) {
                Room newRoom = new Room(roomName, this);
                this.roomList.add(newRoom);
            }
        }
        else
            System.out.println("Unable to add Room!");
    } 
    
    /**
     * Adds a new Deluxe room to the hotel with the specified name, if the name is unique and room limit is not exceeded.
     *
     * @param roomName The name of the new room to add.
     */
    public void addDeluxeRoom(String roomName) {
        boolean nameTaken = false;

        //if hotel roomlist isn't full yet
        if (this.roomList.size() < ROOMLIMIT) {
            //check for the name if it is unique
            for(Room r : this.roomList) {
                if(roomName.equals(r.getName())) {
                    nameTaken = true;
                    break;
                }
            }
            //if it is unique, add the room
            if (nameTaken == false) {
                Room newRoom = new DeluxeRoom(roomName, this);
                this.roomList.add(newRoom);
            }
        }
        else
            System.out.println("Unable to add Room!");
    }
    
    /**
     * Adds a new Standard room to the hotel with the specified name, if the name is unique and room limit is not exceeded.
     *
     * @param roomName The name of the new room to add.
     */
    public void addExecutiveRoom(String roomName) {
        boolean nameTaken = false;

        //if hotel roomlist isn't full yet
        if (this.roomList.size() < ROOMLIMIT) {
            //check for the name if it is unique
            for(Room r : this.roomList) {
                if(roomName.equals(r.getName())) {
                    nameTaken = true;
                    break;
                }
            }
            //if it is unique, add the room
            if (nameTaken == false) {
                Room newRoom = new ExecutiveRoom(roomName, this);
                this.roomList.add(newRoom);
            }
        }
        else
            System.out.println("Unable to add Room!");
    } 




    /**
     * Removes the specified room from the hotel, if it has no reservations associated with it.
     *
     * @param room The room to be removed.
     * @return true if the room was successfully removed, false otherwise (if reservations exist).
     */                                                
    public boolean removeRoom(Room room) {
        if(!room.getReservationList().isEmpty()) //if reservations exist
            return false;
        else
            return this.roomList.remove(room); //remove specified room
    }

    /**
     * Checks the availability of a specific room on a given day.
     *
     * @param roomIndex The index of the room in the room list.
     * @param day       The day to check availability.
     * @return 1 if the room is available on the given day, 0 otherwise.
     */
    public int checkAvailability(int roomIndex, int day) { //if 1 true, 0 false
        int maxRes = this.roomList.get(roomIndex).getAllReservation().size();
        int countDays = 1; //assume room is available

        //if room has reservations
        if(!this.roomList.get(roomIndex).getAllReservation().isEmpty()) {
            //check each reservation
            for(int i = 0; i < maxRes; i++) {
                //if check-in date is before or same as the day, and day is before the check-out date (checkIn <= day < checkOut), then room is not available on that day
                if (this.roomList.get(roomIndex).getSpecificReservation(i).getCheckIn() <= day && day < this.roomList.get(roomIndex).getSpecificReservation(i).getCheckOut() ) {
                    countDays = 0;
                }
            }
        }
        return countDays;
    }

    //GET ROOM METHODS
    /**
     * Finds and retrieves a room that is available for the specified check-in and check-out dates.
     *
     * @param checkIn  The check-in date.
     * @param checkOut The check-out date.
     * @return A Room object that is available for the specified dates, or null if no room is available.
     */
    public Room getRoom(int checkIn, int checkOut) {
        int requiredDays = checkOut - checkIn; // Calculate the number of days required for the stay
        Room availableRoom = null;
        
        int countAvailableDays, day;
        int roomIndex = 0;

        for (Room room : this.roomList) { // Iterate through each room in the room list
            countAvailableDays = 0;

            // Check availability for each day in the specified date range
            for (day = checkIn; day < checkOut; day++) {
                // Check if the room is available on the day, increment by 1
                countAvailableDays+= checkAvailability(roomIndex, day);   
            }

            // If the room has enough available days for the required stay, assign it and break
            if (countAvailableDays >= requiredDays) {
                availableRoom = room;
                break;
            }
            
            
            roomIndex++;
        }

        return availableRoom; // Return the available room or null if no room meets the criteria
    }

    /**
     * Finds and retrieves a Standard room that is available for the specified check-in and check-out dates.
     *
     * @param checkIn  The check-in date.
     * @param checkOut The check-out date.
     * @return A Room object that is available for the specified dates, or null if no room is available.
     */
    public Room getStandardRoom(int checkIn, int checkOut) {
        int requiredDays = checkOut - checkIn; // Calculate the number of days required for the stay
        Room availableRoom = null;
        
        int countAvailableDays, day;
        int roomIndex = 0;

        for (Room room : this.roomList) { // Iterate through each room in the room list
            countAvailableDays = 0;

            //if it is a Standard room aka not a deluxe or executive room
            if(!(room instanceof DeluxeRoom) && !(room instanceof ExecutiveRoom)) {
                // Check availability for each day in the specified date range
                for (day = checkIn; day < checkOut; day++) {
                    // Check if the room is available on the day, increment by 1
                    countAvailableDays+= checkAvailability(roomIndex, day);   
                }

                // If the room has enough available days for the required stay, assign it and break
                if (countAvailableDays >= requiredDays) {
                    availableRoom = room;
                    break;
                }
            }
            
            roomIndex++;
        }

        return availableRoom; // Return the available room or null if no room meets the criteria
    }

    /**
     * Finds and retrieves a Deluxe room that is available for the specified check-in and check-out dates.
     *
     * @param checkIn  The check-in date.
     * @param checkOut The check-out date.
     * @return A Room object that is available for the specified dates, or null if no room is available.
     */
    public Room getDeluxeRoom(int checkIn, int checkOut) {
        int requiredDays = checkOut - checkIn; // Calculate the number of days required for the stay
        Room availableRoom = null;
        
        int countAvailableDays, day;
        int roomIndex = 0;

        for (Room room : this.roomList) { // Iterate through each room in the room list
            countAvailableDays = 0;

            //if it is a Deluxe room
            if(room instanceof DeluxeRoom) {
                // Check availability for each day in the specified date range
                for (day = checkIn; day < checkOut; day++) {
                    // Check if the room is available on the day, increment by 1
                    countAvailableDays+= checkAvailability(roomIndex, day);   
                }

                // If the room has enough available days for the required stay, assign it and break
                if (countAvailableDays >= requiredDays) {
                    availableRoom = room;
                    break;
                }
            }
            
            roomIndex++;
        }

        return availableRoom; // Return the available room or null if no room meets the criteria
    }

    /**
     * Finds and retrieves a Executive room that is available for the specified check-in and check-out dates.
     *
     * @param checkIn  The check-in date.
     * @param checkOut The check-out date.
     * @return A Room object that is available for the specified dates, or null if no room is available.
     */
    public Room getExecutiveRoom(int checkIn, int checkOut) {
        int requiredDays = checkOut - checkIn; // Calculate the number of days required for the stay
        Room availableRoom = null;
        
        int countAvailableDays, day;
        int roomIndex = 0;

        for (Room room : this.roomList) { // Iterate through each room in the room list
            countAvailableDays = 0;

            //if it is a Executive room
            if(room instanceof ExecutiveRoom) {
                // Check availability for each day in the specified date range
                for (day = checkIn; day < checkOut; day++) {
                    // Check if the room is available on the day, increment by 1
                    countAvailableDays+= checkAvailability(roomIndex, day);   
                }

                // If the room has enough available days for the required stay, assign it and break
                if (countAvailableDays >= requiredDays) {
                    availableRoom = room;
                    break;
                }
            }
            
            roomIndex++;
        }

        return availableRoom; // Return the available room or null if no room meets the criteria
    }

    /**
     * Calculates the total monthly earnings from all reservations in the hotel.
     *
     * @return The total monthly earnings.
     */
    public double getTotalMonthlyEarnings() {
        double totalMonthlyEarnings = 0.0;

        for (int i = 0; i < this.roomList.size(); i++) {
            for (int j = 0; j < this.roomList.get(i).getReservationList().size(); j++) {
                totalMonthlyEarnings += this.roomList.get(i).getReservationList().get(j).getTotalReservationPrice();
            }
        }
        return totalMonthlyEarnings;
    }

    /**
     * Retrieves the number of available rooms on a specific day in the hotel.
     *
     * @param day The day to check for availability.
     * @return The number of available rooms on the specified day.
     */
    public int getAvailableRooms(int day) {
        int availableRooms = 0;

        //if roomlist isn't empty
        if(!this.roomList.isEmpty())
        {
            for(int i = 0; i < this.roomList.size(); i++) {
                availableRooms += checkAvailability(i, day); //increment by 1 if it is available
                
            }
        }
        return availableRooms;
    }

    public String getAllRoomString() {
        String result = "";
        int i = 1;

        for (Room room : roomList) {
            result += "[" + i + "] " + room.getName();
            if (room instanceof DeluxeRoom)
                result+= " [DELUXE]\n";
            else if (room instanceof ExecutiveRoom)
                result+= " [EXECUTIVE]\n";
            else
                result+= " [STANDARD]\n";
            i++;
        }

        return result;
    }

}
