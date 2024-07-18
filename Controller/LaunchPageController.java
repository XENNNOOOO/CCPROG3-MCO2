import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LaunchPageController {
    private LaunchPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;

    public LaunchPageController(LaunchPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchLaunchPage(this.mainFrame); 
        view.addClickListener(new LaunchListener(this.view, this.model, this.mainFrame)); 
    }

    class LaunchListener implements ActionListener {
        private LaunchPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        public LaunchListener (LaunchPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getChButton()) {
                CreateHotelPage ch = new CreateHotelPage();
                ch.launchCreateHotelPage(this.mainFrame); 

            } else if (e.getSource() == view.getVhButton()) {
                String hotelList = model.getAllHotelString();
                ViewHotelPage vh = new ViewHotelPage();
                vh.launchViewHotelPage(this.mainFrame, hotelList); 

            } else if (e.getSource() == view.getMhButton()) {
                ManageHotelPage mh = new ManageHotelPage();
                mh.launchManageHotelPage(this.mainFrame); 

            } else if (e.getSource() == view.getBrButton()) {
                String hotelList = model.getAllHotelString();
                BookReservationPage br = new BookReservationPage();
                br.launchBookReservationPage(this.mainFrame, hotelList); 
            } else if (e.getSource() == view.getExButton()) {
                this.mainFrame.dispose(); 
            }
        }
    }

}
