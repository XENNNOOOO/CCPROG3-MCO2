import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for managing actions on the ManageHotelPage GUI.
 */
public class ManageHotelController {
    private ManageHotelPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute

    /**
     * Constructs a ManageHotelController with the specified view, model, and main frame.
     *
     * @param view      The ManageHotelPage instance that holds the GUI.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     */
    public ManageHotelController(ManageHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchManageHotelPage(this.mainFrame); 
        view.addClickListener(new ManageHotelListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling button clicks on the ManageHotelPage.
     */
    class ManageHotelListener implements ActionListener {
        private ManageHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructs a ManageHotelListener with the specified view, model, and main frame.
         *
         * @param view      The ManageHotelPage instance that holds the GUI.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         */
        public ManageHotelListener (ManageHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles action events from GUI components on the ManageHotelPage.
         *
         * @param e The ActionEvent representing the user's action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getChnButton()) {
                ChooseHotelPage chp = new ChooseHotelPage();
                ChangeHotelNameControllerFirst chcf = new ChangeHotelNameControllerFirst(chp, this.model, this.mainFrame);
            }
            else if (e.getSource() == this.view.getArButton()) {
                ChooseHotelPage chp = new ChooseHotelPage();
                AddRoomControllerFirst arcf = new AddRoomControllerFirst(chp, this.model, this.mainFrame);
            }
            else if (e.getSource() == this.view.getRrButton()) {
                ChooseHotelPage chp = new ChooseHotelPage();
                RemoveRoomControllerFirst rrcf = new RemoveRoomControllerFirst(chp, this.model, this.mainFrame);
            }
            else if (e.getSource() == this.view.getUbButton()) {
                ChooseHotelPage chp = new ChooseHotelPage();
                UpdateBasePriceControllerFirst ubpcf = new UpdateBasePriceControllerFirst(chp, this.model, this.mainFrame);
            }
            else if (e.getSource() == this.view.getResButton()) {
                ChooseHotelPage chp = new ChooseHotelPage();
                RemoveReservationControllerFirst rrcf = new RemoveReservationControllerFirst(chp, this.model, this.mainFrame);
            }
            else if (e.getSource() == this.view.getRhButton()) { 
                RemoveHotelPage rhp = new RemoveHotelPage();
                RemoveHotelController rhc = new RemoveHotelController(rhp , this.model , this.mainFrame);
            } 
            else if (e.getSource() == view.getExButton()) {
                LaunchPage lp = new LaunchPage();
                LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
            } 
        }
    }

}

