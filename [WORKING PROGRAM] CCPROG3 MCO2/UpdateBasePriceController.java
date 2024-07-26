import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class for handling actions related to updating base prices in the GUI.
 */
public class UpdateBasePriceController {
    private UpdateBasePricePage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;       //JFrame attribute
    private int hotelNum;            

    /**
     * Constructs an UpdateBasePriceController.
     * Initializes the controller with the provided view, model, main frame, and hotel number.
     *
     * @param view The view class that holds the GUI components.
     * @param model The model that contains the application data.
     * @param mainFrame The main JFrame of the application.
     * @param hotelNum The index of the hotel in the model.
     */
    public UpdateBasePriceController(UpdateBasePricePage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;
        this.hotelNum = hotelNum;

        view.launchUpdateBasePricePage(mainFrame, this.model.getHotelList().get(hotelNum).getBasePrice());
        view.addClickListener(new UpdateBasePriceListener(this.view, this.model, this.mainFrame, this.hotelNum)); 
    }

    /**
     * ActionListener inner class to handle button clicks on the UpdateBasePricePage.
     */
    class UpdateBasePriceListener implements ActionListener {
        private UpdateBasePricePage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;
        private int hotelNum; 

        /**
         * Constructs an UpdateBasePriceListener.
         *
         * @param view The view class that holds the GUI components.
         * @param model The model that contains the application data.
         * @param mainFrame The main JFrame of the application.
         * @param hotelNum The index of the hotel in the model.
         */
        public UpdateBasePriceListener (UpdateBasePricePage view, HotelReservationSystemModel model, JFrame mainFrame, int hotelNum){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
            this.hotelNum = hotelNum;
        }

        /**
         * Handles ActionEvents from buttons on the UpdateBasePricePage.
         *
         * @param e The ActionEvent object.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton()) {
                int newPrice = Integer.parseInt(this.view.getPrice()) - 1;

                if(100 <= newPrice) {
                    this.model.getHotelList().get(hotelNum).setBasePrice(newPrice);
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

