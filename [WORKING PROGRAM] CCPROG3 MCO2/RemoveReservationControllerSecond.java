import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for managing actions on the RemoveReservationPageSecond GUI.
 */
public class RemoveReservationControllerSecond {
    private RemoveReservationPageSecond view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;  //JFrame attribute
    private int hotelNum;                 

    /**
     * Constructs a RemoveReservationControllerSecond with the specified view, model, main frame, and hotel number.
     *
     * @param view      The RemoveReservationPageSecond instance that holds the GUI.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     * @param hotelNum  The index of the hotel in the list.
     */
    public RemoveReservationControllerSecond(RemoveReservationPageSecond view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;

        view.launchRemoveReservationPageSecond(this.mainFrame, this.model.getHotelList().get(hotelNum).getAllRoomString()); 
        view.addClickListener(new RemoveReservationSecondListener(this.view, this.model, this.mainFrame, this.hotelNum)); 
    }

    /**
     * ActionListener implementation for handling button clicks on the RemoveReservationPageSecond.
     */
    class RemoveReservationSecondListener implements ActionListener {
        private RemoveReservationPageSecond view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        private int hotelNum;  

        /**
         * Constructs a RemoveReservationSecondListener with the specified view, model, main frame, and hotel number.
         *
         * @param view      The RemoveReservationPageSecond instance that holds the GUI.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         * @param hotelNum  The index of the hotel in the list.
         */
        public RemoveReservationSecondListener (RemoveReservationPageSecond view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
            this.hotelNum = hotelNum;
        }

        /**
         * Handles action events from GUI components on the RemoveReservationPageSecond for removing reservations.
         *
         * @param e The ActionEvent representing the user's action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton() && !this.model.getHotelList().get(hotelNum).getRoomList().isEmpty())
            {
                int roomNum = Integer.parseInt(this.view.getRoomNum()) - 1;
                if(roomNum >= 0 && this.model.getHotelList().get(hotelNum).getRoomList().size() > roomNum)
                {
                    if(!this.model.getHotelList().get(hotelNum).getRoomList().get(roomNum).getReservationList().isEmpty()) {
                        RemoveReservationPage rrep = new RemoveReservationPage(); 
                        RemoveReservationController rrc = new RemoveReservationController(rrep, this.model, this.mainFrame, this.hotelNum, roomNum);
                    }
                    else {
                        ImageIcon errorImage = new ImageIcon("images/ReservationError.png");
                        ErrorPopup ep = new ErrorPopup();
                        ep.launchErrorPopup(errorImage);
                    }
                }
            }
            else if (e.getSource() == view.getExButton()) {
                ManageHotelPage mhp = new ManageHotelPage();
                ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

