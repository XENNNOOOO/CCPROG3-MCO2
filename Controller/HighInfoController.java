import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HighInfoController {
    private HighLvlInfoPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    private int hotelNum;

    public HighInfoController(HighLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;

        // Build hotelInfo string
        String hotelInfo = buildHotelInfo();

        // Pass hotelInfo to view for display
        view.launchHighLvlInfoPage(this.mainFrame, hotelInfo);

        // Attach listener to handle button click
        view.addClickListener(new HighInfoListener(this.view, this.model, this.mainFrame));
    }

    private String buildHotelInfo() {
        String hotelInfo = "";
        Hotel hotel = this.model.getHotelList().get(this.hotelNum);
        if (hotel != null) {
            hotelInfo = "Hotel Name: " + hotel.getName() + "\n" +
                        "Total number of rooms: " + hotel.getRoomList().size() + "\n" +
                        "Total monthly earnings: " + hotel.getTotalMonthlyEarnings();
        }
        return hotelInfo;
    }

    class HighInfoListener implements ActionListener {
        private HighLvlInfoPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        public HighInfoListener(HighLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame) {
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getExButton()) {
                // Handle the exit button event
                LaunchPage lp = new LaunchPage();
                LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
            }
            // Add other event handling logic as needed
        }
    }
}
