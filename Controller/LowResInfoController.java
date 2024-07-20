import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;

public class LowResInfoController {
    private LowLvlInfoPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    private int hotelNum;
    private int day;
    private int roomNum;
    private int resNum;
    private ImageIcon errorImage = new ImageIcon("images/InvalidInput.png");

    public LowResInfoController(LowLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum, int day, int roomNum, int resNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;
        this.day = day;
        this.roomNum = roomNum;
        
        Hotel hotel = model.getHotelList().get(this.hotelNum);
                    
        // Validate roomNum against hotel's room list size
        if (roomNum < hotel.getRoomList().size() && roomNum >= 0 ) {
            Room room = hotel.getRoomList().get(roomNum);

            // Build overall information
            StringBuilder overallInfo = new StringBuilder("Hotel Information:\n");
            overallInfo.append("Number of available rooms: ").append(hotel.getAvailableRooms(day)).append("\n");
            overallInfo.append("Number of occupied rooms: ").append(hotel.getRoomList().size() - hotel.getAvailableRooms(day)).append("\n\n");
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
            if (!view.getResNum().isEmpty() && reservationNum > 0) {
                int revNum = Integer.parseInt(view.getResNum()) - 1; // Adjust for 0-based index
                if (revNum >= 0 && revNum < reservationNum) {
                    overallInfo.append("\nReservation Information:\n");
                    overallInfo.append("Guest name: ").append(room.getReservationList().get(revNum).getGuestName()).append("\n");
                    overallInfo.append("Room name: ").append(room.getName()).append("\n");
                    overallInfo.append("Check-in: ").append(room.getReservationList().get(revNum).getCheckIn()).append("\n");
                    overallInfo.append("Check-out: ").append(room.getReservationList().get(revNum).getCheckOut());
                } else {
                    overallInfo.append("\nInvalid reservation number.");
                }
            }
        

        // Display room list in the view
        view.launchLowLvlInfoPage(mainFrame, overallInfo.toString());

        // Add ActionListener for view's buttons
        view.addClickListener(new LowInfoResListener(this.view, this.model, this.mainFrame));
    }

    

    class LowInfoResListener implements ActionListener {
        private LowLvlInfoPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        private int hotelNum;
        

        public LowInfoResListener(LowLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame) {
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

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
}

    
