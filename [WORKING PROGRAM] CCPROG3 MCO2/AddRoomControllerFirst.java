import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for handling actions related to choosing a hotel and navigating to room creation.
 */
public class AddRoomControllerFirst {
    private ChooseHotelPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute

    /**
     * Constructor for AddRoomControllerFirst.
     *
     * @param view      The view (GUI) for choosing a hotel.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     */
    public AddRoomControllerFirst(ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchChooseHotelPage(this.mainFrame, this.model.getAllHotelString());
        view.addClickListener(new AddRoomFirstListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling hotel selection actions.
     */
    class AddRoomFirstListener implements ActionListener {
        private ChooseHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructor for AddRoomFirstListener.
         *
         * @param view      The view (GUI) for choosing a hotel.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         */
        public AddRoomFirstListener (ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
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
                    CreateRoomPage crp = new CreateRoomPage();
                    AddRoomController arc = new AddRoomController(crp, this.model, this.mainFrame, hotelNum);
                }  
            }
            else if (e.getSource() == this.view.getExButton()) {
                ManageHotelPage mhp = new ManageHotelPage();
                ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

