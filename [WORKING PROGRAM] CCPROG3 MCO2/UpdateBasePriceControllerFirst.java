import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Controller class for handling the initial update base price operations.
 */
public class UpdateBasePriceControllerFirst {
    private ChooseHotelPage view;                     //class that holds the GUI of the page 
    private HotelReservationSystemModel model;  //model attribute 
    private JFrame mainFrame;                   //JFrame attribute

    /**
     * Constructor to initialize the UpdateBasePriceControllerFirst object.
     *
     * @param view The ChooseHotelPage view associated with this controller.
     * @param model The HotelReservationSystemModel containing the application's data model.
     * @param mainFrame The JFrame to which views are attached.
     */
    public UpdateBasePriceControllerFirst(ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchChooseHotelPage(this.mainFrame, this.model.getAllHotelString());
        view.addClickListener(new UpdateBasePriceFirstListener(this.view, this.model, this.mainFrame)); 
    }

    /**
     * ActionListener implementation for handling button clicks in the ChooseHotelPage view.
     */
    class UpdateBasePriceFirstListener implements ActionListener {
        private ChooseHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        /**
         * Constructs an UpdateBasePriceFirstListener object.
         *
         * @param view The ChooseHotelPage view associated with this listener.
         * @param model The HotelReservationSystemModel containing the application's data model.
         * @param mainFrame The JFrame to which views are attached.
         */
        public UpdateBasePriceFirstListener (ChooseHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        /**
         * Handles actionPerformed events from the view's components.
         *
         * @param e The ActionEvent triggered by the user interaction.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton()) {
                int hotelNum = Integer.parseInt(this.view.getHotelNum()) - 1;

                if(hotelNum >= 0 && this.model.getHotelList().size() > hotelNum)
                {
                    UpdateBasePricePage ubpp = new UpdateBasePricePage();
                    UpdateBasePriceController ubpc = new UpdateBasePriceController(ubpp, this.model, this.mainFrame, hotelNum);
                }  
            }
            else if (e.getSource() == this.view.getExButton()) {
               ManageHotelPage mhp = new ManageHotelPage();
               ManageHotelController mhc = new ManageHotelController(mhp, this.model, this.mainFrame);
            } 
        }
    }

}

