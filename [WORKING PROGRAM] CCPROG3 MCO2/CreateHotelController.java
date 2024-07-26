import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for handling actions related to creating hotels.
 */
public class CreateHotelController {
    private CreateHotelPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;

    /**
     * Constructor to initialize the controller with required components.
     *
     * @param view      The CreateHotelPage view to be controlled.
     * @param model     The HotelReservationSystemModel for data operations.
     * @param mainFrame The main JFrame of the application.
     */
    public CreateHotelController(CreateHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchCreateHotelPage(this.mainFrame); 
        view.addClickListener(new CreateHotelListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling hotel creation and navigation actions.
     */
    class CreateHotelListener implements ActionListener {
        private CreateHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructs a listener for handling hotel creation and navigation actions.
         *
         * @param view      The CreateHotelPage view associated with this listener.
         * @param model     The HotelReservationSystemModel for data operations.
         * @param mainFrame The main JFrame of the application.
         */
        public CreateHotelListener (CreateHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles actions performed by buttons on the CreateHotelPage.
         *
         * @param e The ActionEvent triggered by user interaction.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton()) {
                String hotelName = this.view.getHotelName();
                boolean isSuccess = this.model.createHotel(hotelName);
                JLabel status = this.view.showUpdateStatus(this.mainFrame, isSuccess);
                JLayeredPane layeredPane = this.view.getLayeredPane();
                layeredPane.add(status, JLayeredPane.POPUP_LAYER);
                this.view.getSubButton().setEnabled(false);
            } 
            else if (e.getSource() == view.getExButton()) {
                LaunchPage lp = new LaunchPage();
                LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
            } 
        }
    }

}
