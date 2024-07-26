import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;

/**
 * Controller class for handling interactions and logic related to low-level information display.
 */
public class LowResInfoController {
    private LowLvlInfoPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    private int hotelNum;
    private int day;
    private int roomNum;
    private int resNum;

     /**
     * Constructor for initializing the controller with necessary data.
     *
     * @param view The view component for low-level information display.
     * @param model The data model containing hotel and room information.
     * @param mainFrame The main JFrame of the application.
     * @param hotelNum The index of the selected hotel.
     * @param day The selected day for room availability.
     * @param roomNum The index of the selected room within the hotel.
     * @param resNum The index of the selected reservation within the room.
     */
    public LowResInfoController(LowLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum, int day, int roomNum, int resNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;
        this.day = day;
        this.resNum = resNum;
        this.roomNum = roomNum;
        
        Hotel hotel = model.getHotelList().get(this.hotelNum);
                    
        // Validate roomNum against hotel's room list size
        if (this.roomNum < hotel.getRoomList().size() && this.roomNum >= 0 ) {
            Room room = hotel.getRoomList().get(this.roomNum);

            // Build overall information
            StringBuilder overallInfo = new StringBuilder("Hotel Information:\n");
            overallInfo.append("Number of available rooms: ").append(hotel.getAvailableRooms(this.day)).append("\n");
            overallInfo.append("Number of occupied rooms: ").append(hotel.getRoomList().size() - hotel.getAvailableRooms(this.day)).append("\n\n");
            overallInfo.append("Room Information:\n");
            overallInfo.append("Name: ").append(room.getName()).append("\n");
            overallInfo.append("Price per night: ").append(hotel.getBasePrice()).append("\n");
            overallInfo.append("Days available: ");

            int[] availableDays = room.getAvailableDays();
            for (int i = 0; i < availableDays.length; i++) {
                if (i != 0) {
                    overallInfo.append(", ");
                }
                overallInfo.append(availableDays[i]);
            }
            overallInfo.append("\n\nReservation list:\n");

            int reservationNum = room.getReservationList().size();

            if (reservationNum > 0) {
                for (int i = 0; i < reservationNum; i++) {
                    overallInfo.append("Reservation #").append(i + 1).append("\n");
                }
            } else {
                overallInfo.append("NO ACTIVE RESERVATION\n");
            }

            // Append reservation information if valid resNum is provided
            if (this.resNum != -1) {
                if (this.resNum >= 0 && this.resNum < reservationNum) {
                    overallInfo.append("\nReservation Information:\n");
                    overallInfo.append("Guest name: ").append(room.getReservationList().get(this.resNum).getGuestName()).append("\n");
                    overallInfo.append("Room name: ").append(room.getName()).append("\n");
                    overallInfo.append("Check-in: ").append(room.getReservationList().get(this.resNum).getCheckIn()).append("\n");
                    overallInfo.append("Check-out: ").append(room.getReservationList().get(this.resNum).getCheckOut());
                } else {
                    overallInfo.append("\nInvalid reservation number.");
                }
            }
        

        // Display room list in the view
        view.launchLowLvlInfoPage(mainFrame, overallInfo.toString());

        // Add ActionListener for view's buttons
        view.addClickListener(new LowInfoResListener(this.view, this.model, this.mainFrame));
    }
}

    
    /**
     * ActionListener for handling button clicks in the LowLvlInfoPage view.
     */
    class LowInfoResListener implements ActionListener {
        private LowLvlInfoPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        
        /**
         * Constructor for initializing the ActionListener with necessary components.
         *
         * @param view The view component for low-level information display.
         * @param model The data model containing hotel and room information.
         * @param mainFrame The main JFrame of the application.
         */
        public LowInfoResListener(LowLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame) {
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles actionPerformed events from the view's buttons.
         *
         * @param e The ActionEvent triggered by user interaction.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == view.getSubButton()) {
                this.view.getSubButton().setVisible(false);
                this.view.getSubButton().setEnabled(false);
                       
            } else if (e.getSource() == view.getExButton()) {
                LaunchPage lp = new LaunchPage();
                LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
            }
        }
        
    }
}


    
