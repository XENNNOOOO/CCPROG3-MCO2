import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for managing actions on the RemoveHotelPage GUI.
 */
public class RemoveHotelController {
    private RemoveHotelPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute

    /**
     * Constructs a RemoveHotelController with the specified view, model, and main frame.
     *
     * @param view      The RemoveHotelPage instance that holds the GUI.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     */
    public RemoveHotelController(RemoveHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchRemoveHotelPage(this.mainFrame, this.model.getAllHotelString()); 
        view.addClickListener(new RemoveHotelListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling button clicks on the RemoveHotelPage.
     */
    class RemoveHotelListener implements ActionListener {
        private RemoveHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructs a RemoveHotelListener with the specified view, model, and main frame.
         *
         * @param view      The RemoveHotelPage instance that holds the GUI.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         */
        public RemoveHotelListener (RemoveHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles action events from GUI components on the RemoveHotelPage.
         *
         * @param e The ActionEvent representing the user's action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton() && Integer.valueOf(this.view.getHotelNum()) > 0 && this.model.getHotelList().size() >= Integer.valueOf(this.view.getHotelNum())) {
                int hotelNum = Integer.parseInt(this.view.getHotelNum()) - 1;

                this.model.getHotelList().remove(hotelNum);
                
                if(this.model.getHotelList().isEmpty()) {
                    LaunchPage lp = new LaunchPage();
                    LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
                }
                else {
                    ManageHotelPage mhp = new ManageHotelPage();
                    ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
                }
            } 
            else if (e.getSource() == view.getExButton()) {
               ManageHotelPage mhp = new ManageHotelPage();
               ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

