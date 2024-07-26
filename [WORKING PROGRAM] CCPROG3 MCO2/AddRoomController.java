import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for handling actions related to adding rooms in a hotel reservation system.
 */
public class AddRoomController {
    private CreateRoomPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute
    private int hotelNum;

    /**
     * Constructor for AddRoomController.
     *
     * @param view      The view (GUI) for creating rooms.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     * @param hotelNum  The identifier of the hotel.
     */
    public AddRoomController(CreateRoomPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;

        view.launchCreateRoomPage(mainFrame);
        view.addClickListener(new AddRoomListener(this.view, this.model, this.mainFrame, this.hotelNum)); 
    }

    /**
     * ActionListener implementation for handling room addition actions.
     */
    class AddRoomListener implements ActionListener {
        private CreateRoomPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        private int hotelNum;

        /**
         * Constructor for AddRoomListener.
         *
         * @param view      The view (GUI) for creating rooms.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         * @param hotelNum  The identifier of the hotel.
         */
        public AddRoomListener (CreateRoomPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum){
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
            if (e.getSource() == this.view.getDlxButton()) {
                String roomName = this.view.getRoomName();
                this.model.getHotelList().get(hotelNum).addDeluxeRoom(roomName);

                ManageHotelPage mhp = new ManageHotelPage();
                ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            }
            else if (e.getSource() == this.view.getExButton()) {
                String roomName = this.view.getRoomName();
                this.model.getHotelList().get(hotelNum).addExecutiveRoom(roomName);

                ManageHotelPage mhp = new ManageHotelPage();
                ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            }
            else if (e.getSource() == this.view.getStnButton()) {
                String roomName = this.view.getRoomName();
                this.model.getHotelList().get(hotelNum).addStandardRoom(roomName);

                ManageHotelPage mhp = new ManageHotelPage();
                ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            }
            else if (e.getSource() == this.view.getExButton()) {
               ManageHotelPage mhp = new ManageHotelPage();
               ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

