import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class for initiating the removal of a room from a hotel based on user input.
 */
public class RemoveRoomControllerFirst {
    private ChooseHotelPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute

    /**
     * Constructor to initialize the RemoveRoomControllerFirst.
     *
     * @param view      The ChooseHotelPage instance that holds the GUI.
     * @param model     The HotelReservationSystemModel instance containing the data model.
     * @param mainFrame The main JFrame of the application.
     */
    public RemoveRoomControllerFirst(ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchChooseHotelPage(this.mainFrame, this.model.getAllHotelString());
        view.addClickListener(new RemoveRoomFirstListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener class to handle button clicks in ChooseHotelPage for room removal.
     */
    class RemoveRoomFirstListener implements ActionListener {
        private ChooseHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructor to initialize the RemoveRoomFirstListener.
         *
         * @param view      The ChooseHotelPage instance that holds the GUI.
         * @param model     The HotelReservationSystemModel instance containing the data model.
         * @param mainFrame The main JFrame of the application.
         */
        public RemoveRoomFirstListener (ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles ActionEvents triggered by buttons in ChooseHotelPage for room removal.
         *
         * @param e The ActionEvent triggered by the button click.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton()) {
                int hotelNum = Integer.parseInt(this.view.getHotelNum()) - 1;

                if(hotelNum >= 0 && this.model.getHotelList().size() > hotelNum)
                {
                    RemoveRoomPage rrp = new RemoveRoomPage();
                    RemoveRoomController rrc = new RemoveRoomController(rrp, this.model, this.mainFrame, hotelNum);
                }  
            }
            else if (e.getSource() == this.view.getExButton()) {
               ManageHotelPage mhp = new ManageHotelPage();
               ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

