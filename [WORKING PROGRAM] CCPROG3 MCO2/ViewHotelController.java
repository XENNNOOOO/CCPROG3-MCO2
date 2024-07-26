import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ViewHotelController class manages the interaction between the ViewHotelPage,
 * HotelReservationSystemModel, and the main JFrame in the hotel reservation system GUI.
 * It handles button clicks and navigation between different pages based on user actions.
 */
public class ViewHotelController {
    private ViewHotelPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;

     /**
     * Constructs a ViewHotelController with references to ViewHotelPage, HotelReservationSystemModel,
     * and the main JFrame.
     *
     * @param view      The ViewHotelPage instance for displaying hotel information.
     * @param model     The HotelReservationSystemModel instance for accessing hotel data.
     * @param mainFrame The main JFrame of the application.
     */
    public ViewHotelController(ViewHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchViewHotelPage(this.mainFrame, this.model.getAllHotelString()); 
        view.addClickListener(new ViewHotelListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling button clicks in the ViewHotelPage.
     */
    class ViewHotelListener implements ActionListener {
        private ViewHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructs a ViewHotelListener with references to ViewHotelPage, HotelReservationSystemModel,
         * and the main JFrame.
         *
         * @param view      The ViewHotelPage instance for accessing GUI components.
         * @param model     The HotelReservationSystemModel instance for accessing hotel data.
         * @param mainFrame The main JFrame of the application.
         */
        public ViewHotelListener (ViewHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;

            
        }

        /**
         * Handles action events from buttons in the ViewHotelPage.
         *
         * @param e The ActionEvent representing the button click.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getLowButton() && Integer.valueOf(this.view.getHotelNum()) > 0 && this.model.getHotelList().size() >= Integer.valueOf(this.view.getHotelNum())) {
                int hotelNum = Integer.parseInt(this.view.getHotelNum()) - 1;

                LowLvlInfoPage lip = new LowLvlInfoPage();
                LowInfoController lic = new LowInfoController(lip, this.model, this.mainFrame, hotelNum);
            } 
            else if (e.getSource() == view.getHiButton() && Integer.valueOf(this.view.getHotelNum()) > 0 && this.model.getHotelList().size() >= Integer.valueOf(this.view.getHotelNum())) {
                int hotelNum = Integer.valueOf(this.view.getHotelNum()) - 1;
                
                HighLvlInfoPage hip = new HighLvlInfoPage();
                HighInfoController hic = new HighInfoController(hip, this.model, this.mainFrame, hotelNum);
            } 
            else if (e.getSource() == view.getExButton()) {
                LaunchPage lp = new LaunchPage();
                LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
            } 
        }
    }

}
 