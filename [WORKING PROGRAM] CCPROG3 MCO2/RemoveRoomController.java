import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class for managing the removal of rooms from a hotel.
 */
public class RemoveRoomController {
    private RemoveRoomPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;  //JFrame attribute
    private int hotelNum;                 

    /**
     * Constructor to initialize the RemoveRoomController.
     *
     * @param view      The RemoveRoomPage instance that holds the GUI.
     * @param model     The HotelReservationSystemModel instance containing the data model.
     * @param mainFrame The main JFrame of the application.
     * @param hotelNum  The index of the hotel in the hotel list.
     */
    public RemoveRoomController(RemoveRoomPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;

        view.launchRemoveRoomPage(this.mainFrame, this.model.getHotelList().get(hotelNum).getAllRoomString()); 
        view.addClickListener(new RemoveRoomListener(this.view, this.model, this.mainFrame, this.hotelNum)); 
    }

    /**
     * ActionListener class to handle button clicks in RemoveRoomPage.
     */
    class RemoveRoomListener implements ActionListener {
        private RemoveRoomPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        private int hotelNum;  

        /**
         * Constructor to initialize the RemoveRoomListener.
         *
         * @param view      The RemoveRoomPage instance that holds the GUI.
         * @param model     The HotelReservationSystemModel instance containing the data model.
         * @param mainFrame The main JFrame of the application.
         * @param hotelNum  The index of the hotel in the hotel list.
         */
        public RemoveRoomListener (RemoveRoomPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
            this.hotelNum = hotelNum;
        }

        /**
         * Handles ActionEvents triggered by buttons in the RemoveRoomPage.
         *
         * @param e The ActionEvent triggered by the button click.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton() && this.model.getHotelList().get(hotelNum).getRoomList().size() > 1) //minimum 1 room needed
            {
                int roomNum = Integer.parseInt(this.view.getRoomNum()) - 1;
                if(roomNum >= 0 && this.model.getHotelList().get(hotelNum).getRoomList().size() > roomNum)
                {
                    this.model.getHotelList().get(hotelNum).getRoomList().remove(roomNum);
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

