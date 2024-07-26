import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class responsible for managing actions on the RemoveReservationPage GUI from the ChooseHotelPage.
 */
public class RemoveReservationControllerFirst {
    private ChooseHotelPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute

    /**
     * Constructs a RemoveReservationControllerFirst with the specified view, model, and main frame.
     *
     * @param view      The ChooseHotelPage instance that holds the GUI.
     * @param model     The model representing the hotel reservation system.
     * @param mainFrame The main JFrame of the application.
     */
    public RemoveReservationControllerFirst(ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchChooseHotelPage(this.mainFrame, this.model.getAllHotelString());
        view.addClickListener(new RemoveReservationFirstListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling button clicks on the ChooseHotelPage for remove reservation.
     */
    class RemoveReservationFirstListener implements ActionListener {
        private ChooseHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructs a RemoveReservationFirstListener with the specified view, model, and main frame.
         *
         * @param view      The ChooseHotelPage instance that holds the GUI.
         * @param model     The model representing the hotel reservation system.
         * @param mainFrame The main JFrame of the application.
         */
        public RemoveReservationFirstListener (ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles action events from GUI components on the ChooseHotelPage for remove reservation.
         *
         * @param e The ActionEvent representing the user's action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton()) {
                int hotelNum = Integer.parseInt(this.view.getHotelNum()) - 1;

                if(hotelNum >= 0 && this.model.getHotelList().size() > hotelNum)
                {
                    RemoveReservationPageSecond rrps = new RemoveReservationPageSecond();
                    RemoveReservationControllerSecond rrcs = new RemoveReservationControllerSecond(rrps, this.model, this.mainFrame, hotelNum);
                }  
            }
            else if (e.getSource() == this.view.getExButton()) {
               ManageHotelPage mhp = new ManageHotelPage();
               ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

