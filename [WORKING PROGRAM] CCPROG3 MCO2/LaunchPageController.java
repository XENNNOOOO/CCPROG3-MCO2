import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Controller class for the LaunchPage in the hotel reservation system.
 * Manages actions triggered from the LaunchPage.
 */
public class LaunchPageController {
    private LaunchPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    ImageIcon errorImage = new ImageIcon("images/ErrorBG.png");

    /**
     * Constructs a LaunchPageController.
     *
     * @param view      The LaunchPage view to control.
     * @param model     The HotelReservationSystemModel containing data and business logic.
     * @param mainFrame The main JFrame of the application.
     */
    public LaunchPageController(LaunchPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchLaunchPage(this.mainFrame); 
        view.addClickListener(new LaunchListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling button clicks on LaunchPage.
     * Determines the action based on the button clicked and interacts with the model.
     */
    class LaunchListener implements ActionListener {
        private LaunchPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructs a LaunchListener.
         *
         * @param view      The LaunchPage view associated with the listener.
         * @param model     The HotelReservationSystemModel containing data and business logic.
         * @param mainFrame The main JFrame of the application.
         */
        public LaunchListener (LaunchPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles actions performed on buttons in the LaunchPage.
         *
         * @param e The ActionEvent that occurred.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getChButton()) {
                CreateHotelPage chp = new CreateHotelPage();
                CreateHotelController chc = new CreateHotelController(chp, this.model, this.mainFrame);

            } else if (e.getSource() == view.getVhButton()) {
                if (this.model.getHotelList().size() > 0) {
                    ViewHotelPage vhp = new ViewHotelPage();
                    ViewHotelController vhc = new ViewHotelController(vhp, this.model, this.mainFrame);
                }
                else {
                    ErrorPopup ep = new ErrorPopup();
                    ep.launchErrorPopup(errorImage);
                }

            } else if (e.getSource() == view.getMhButton()) {
                if (this.model.getHotelList().size() > 0) {
                    ManageHotelPage mhp = new ManageHotelPage();
                    ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
                }
                else {
                    ErrorPopup ep = new ErrorPopup();
                    ep.launchErrorPopup(errorImage);
                }
            
            } else if (e.getSource() == view.getBrButton()) {
                if (this.model.getHotelList().size() > 0) {
                    BookReservationPage brp = new BookReservationPage();
                    BookReservationController brc = new BookReservationController(brp, this.model, this.mainFrame);
                }
                else {
                    ErrorPopup ep = new ErrorPopup();
                    ep.launchErrorPopup(errorImage);
                }
            } else if (e.getSource() == view.getExButton()) {
                this.mainFrame.dispose(); 
            }
        }
    }

}
