import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for managing actions on the RemoveReservationPage GUI.
 */
public class RemoveReservationController {
    private RemoveReservationPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;  //JFrame attribute
    private int hotelNum;   
    private int roomNum;              

    /**
     * Constructs a RemoveReservationController with the specified view, model, main frame, hotel number, and room number.
     *
     * @param view      The RemoveReservationPage instance that holds the GUI.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     * @param hotelNum  The index of the hotel in the list.
     * @param roomNum   The index of the room in the hotel's room list.
     */
    public RemoveReservationController(RemoveReservationPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum, int roomNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;
        this.roomNum = roomNum;

        view.launchRemoveReservationPage(this.mainFrame, this.model.getHotelList().get(hotelNum).getRoomList().get(roomNum).getAllReservationString()); 
        view.addClickListener(new RemoveReservationSecondListener(this.view, this.model, this.mainFrame, this.hotelNum, this.roomNum)); 
    }

    /**
     * ActionListener implementation for handling button clicks on the RemoveReservationPage.
     */
    class RemoveReservationSecondListener implements ActionListener {
        private RemoveReservationPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        private int hotelNum;  
        private int roomNum;

        /**
         * Constructs a RemoveReservationSecondListener with the specified view, model, main frame, hotel number, and room number.
         *
         * @param view      The RemoveReservationPage instance that holds the GUI.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         * @param hotelNum  The index of the hotel in the list.
         * @param roomNum   The index of the room in the hotel's room list.
         */
        public RemoveReservationSecondListener (RemoveReservationPage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum, int roomNum){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
            this.hotelNum = hotelNum;
            this.roomNum = roomNum;
        }

        /**
         * Handles action events from GUI components on the RemoveReservationPage.
         *
         * @param e The ActionEvent representing the user's action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton() && !this.model.getHotelList().get(hotelNum).getRoomList().get(roomNum).getReservationList().isEmpty())
            {
                int resNum = Integer.parseInt(this.view.getResNum()) - 1;
                if(resNum >= 0 && this.model.getHotelList().get(hotelNum).getRoomList().get(roomNum).getReservationList().size() > resNum)
                {
                    this.model.getHotelList().get(hotelNum).getRoomList().get(roomNum).getReservationList().remove(resNum);
                    
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

