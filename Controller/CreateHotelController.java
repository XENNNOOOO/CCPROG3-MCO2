import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateHotelController {
    private CreateHotelPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;

    public CreateHotelController(CreateHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchCreateHotelPage(this.mainFrame); 
        view.addClickListener(new CreateHotelListener(this.view, this.model, this.mainFrame)); 
    }

    class CreateHotelListener implements ActionListener {
        private CreateHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        public CreateHotelListener (CreateHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getSubButton()) {
                String hotelName = this.view.getHotelName();
                boolean isSuccess = this.model.createHotel(hotelName);
                JLabel status = this.view.showUpdateStatus(this.mainFrame, isSuccess);
                JLayeredPane layeredPane = this.view.getLayeredPane();
                layeredPane.add(status, JLayeredPane.POPUP_LAYER);
                this.view.getSubButton().setEnabled(false);
            } 
            else if (e.getSource() == view.getExButton()) {
                LaunchPage lp = new LaunchPage();
                LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
            } 
        }
    }

}
