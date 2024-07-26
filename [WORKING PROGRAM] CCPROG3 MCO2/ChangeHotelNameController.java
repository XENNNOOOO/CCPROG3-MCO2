import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for handling actions related to changing a hotel's name.
 */
public class ChangeHotelNameController {
    private ChangeHotelNamePage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute
    private int hotelNum;

    /**
     * Constructor for ChangeHotelNameController.
     *
     * @param view      The view (GUI) for changing hotel name.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     * @param hotelNum  The identifier of the hotel.
     */
    public ChangeHotelNameController(ChangeHotelNamePage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;

        view.launchChangeHotelNamePage(this.mainFrame);
        view.addClickListener(new ChangeHotelNameListener(this.view, this.model, this.mainFrame, this.hotelNum)); 
    }

    /**
     * ActionListener implementation for handling hotel name change actions.
     */
    class ChangeHotelNameListener implements ActionListener {
        private ChangeHotelNamePage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        private int hotelNum;

        /**
         * Constructor for ChangeHotelNameListener.
         *
         * @param view      The view (GUI) for changing hotel name.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         * @param hotelNum  The identifier of the hotel.
         */
        public ChangeHotelNameListener (ChangeHotelNamePage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
            this.hotelNum = hotelNum;
        }

        /**
         * Handles action events from GUI components.
         *
         * @param e The ActionEvent representing the user's action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton()) {
                boolean hasSame = false;
                String newName = this.view.getHotelName();

                for (Hotel hotel : this.model.getHotelList()) {
                    if (newName.equals(hotel.getName()))
                        hasSame = true;
                }

                if(!hasSame) {
                    this.model.getHotelList().get(hotelNum).setName(newName);
                    ManageHotelPage mhp = new ManageHotelPage();
                    ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
                }
            }
            else if (e.getSource() == this.view.getExButton()) {
               ManageHotelPage mhp = new ManageHotelPage();
               ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

