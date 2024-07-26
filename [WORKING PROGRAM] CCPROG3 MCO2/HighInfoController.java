import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class for displaying high-level information about a hotel.
 */
public class HighInfoController {
    private HighLvlInfoPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    private int hotelNum;

    /**
     * Constructor to initialize the controller with required components.
     *
     * @param view      The HighLvlInfoPage view to be controlled.
     * @param model     The HotelReservationSystemModel for data operations.
     * @param mainFrame The main JFrame of the application.
     * @param hotelNum  The index of the hotel in the list to display information for.
     */
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

    /**
     * Builds a string containing information about the selected hotel.
     *
     * @return A string with hotel information.
     */
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

    /**
     * ActionListener implementation to handle button clicks in the view.
     */
    class HighInfoListener implements ActionListener {
        private HighLvlInfoPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        public HighInfoListener(HighLvlInfoPage view, HotelReservationSystemModel model, JFrame mainFrame) {
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles actionPerformed events from components in the view.
         *
         * @param e The ActionEvent triggered by user interaction.
         */
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
