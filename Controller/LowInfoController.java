import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;

public class LowInfoController {
    private LowLvlInfoPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    private int hotelNum;
    private ImageIcon errorImage = new ImageIcon("images/InvalidInput.png");

    public LowInfoController(LowLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;

        // Build room list information
        String roomList = buildRoomListInfo();

        // Display room list in the view
        view.launchLowLvlInfoPage(mainFrame, roomList);

        // Add ActionListener for view's buttons
        view.addClickListener(new LowInfoListener(this.view, this.model, this.mainFrame, this.hotelNum));
    }

    private String buildRoomListInfo() {
        StringBuilder roomListInfo = new StringBuilder("Room list:\n");
        
        // Ensure model and hotel list are not null and hotelNum is valid
        if (model != null && hotelNum >= 0 && hotelNum < model.getHotelList().size()) {
            Hotel hotel = model.getHotelList().get(hotelNum);
            if (hotel != null) {
                for (int i = 0; i < hotel.getRoomList().size(); i++) {
                    roomListInfo.append("[").append(i + 1).append("] ").append(hotel.getRoomList().get(i).getName()).append("\n");
                }
            } else {
                roomListInfo.append("No rooms available for this hotel.");
            }
        } 
        return roomListInfo.toString();
    }

    class LowInfoListener implements ActionListener {
        private LowLvlInfoPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        private int hotelNum;

        public LowInfoListener(LowLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum) {
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
            this.hotelNum = hotelNum;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getSubButton()) {
                int day = Integer.parseInt(this.view.getDay());
                int roomNum = Integer.parseInt(this.view.getRoomNum()) - 1;
                int resNum = Integer.parseInt(this.view.getResNum()) - 1;
                
                if (day > 0 && day <= 31 && roomNum >= 0 && roomNum < this.model.getHotelList().get(this.hotelNum).getRoomList().size()) {
                    LowLvlInfoPage vhp2 = new LowLvlInfoPage();
                    LowResInfoController lirc = new LowResInfoController(vhp2, this.model, this.mainFrame, this.hotelNum, day, roomNum, resNum);
                }
            } else if (e.getSource() == view.getExButton()) {
                LaunchPage lp = new LaunchPage();
                LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
            }
        }
        
    }
}


    
