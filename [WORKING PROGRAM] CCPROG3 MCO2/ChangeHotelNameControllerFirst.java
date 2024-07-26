import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for handling actions related to selecting a hotel for changing its name.
 */
public class ChangeHotelNameControllerFirst {
    private ChooseHotelPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute

    /**
     * Constructor for ChangeHotelNameControllerFirst.
     *
     * @param view      The view (GUI) for choosing a hotel.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     */
    public ChangeHotelNameControllerFirst(ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchChooseHotelPage(this.mainFrame, this.model.getAllHotelString());
        view.addClickListener(new ChangeHotelNameFirstListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling hotel selection actions for changing name.
     */
    class ChangeHotelNameFirstListener implements ActionListener {
        private ChooseHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructor for ChangeHotelNameFirstListener.
         *
         * @param view      The view (GUI) for choosing a hotel.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         */
        public ChangeHotelNameFirstListener (ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles action events from GUI components.
         *
         * @param e The ActionEvent representing the user's action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton()) {
                int hotelNum = Integer.parseInt(this.view.getHotelNum()) - 1;

                if(hotelNum >= 0 && this.model.getHotelList().size() > hotelNum)
                {
                    ChangeHotelNamePage chnp = new ChangeHotelNamePage();
                    ChangeHotelNameController chnc = new ChangeHotelNameController(chnp, this.model, this.mainFrame, hotelNum);
                }  
            }
            else if (e.getSource() == this.view.getExButton()) {
               ManageHotelPage mhp = new ManageHotelPage();
               ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

