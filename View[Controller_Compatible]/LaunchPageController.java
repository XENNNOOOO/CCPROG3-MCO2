import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class LaunchPageController {
    private LaunchPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;
    ImageIcon errorImage = new ImageIcon("images/ErrorBG.png");


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
                CreateHotelPage chp = new CreateHotelPage();
                CreateHotelController chc = new CreateHotelController(chp, this.model, this.mainFrame);

            } else if (e.getSource() == view.getVhButton()) {
                if (this.model.getHotelList().size() > 0) {
                    String hotelList = model.getAllHotelString();
                    ViewHotelPage vh = new ViewHotelPage();
                    vh.launchViewHotelPage(this.mainFrame, hotelList); 
                }
                else {
                    ErrorPopup ep = new ErrorPopup();
                    ep.launchErrorPopup(errorImage);
                }

            } else if (e.getSource() == view.getMhButton()) {
                if (this.model.getHotelList().size() > 0) {
                    ManageHotelPage mh = new ManageHotelPage();
                    mh.launchManageHotelPage(this.mainFrame); 
                }
                else {
                    ErrorPopup ep = new ErrorPopup();
                    ep.launchErrorPopup(errorImage);
                }
            
            } else if (e.getSource() == view.getBrButton()) {
                if (this.model.getHotelList().size() > 0) {
                    String hotelList = model.getAllHotelString();
                    BookReservationPage br = new BookReservationPage();
                    br.launchBookReservationPage(this.mainFrame, hotelList); 
                }
                else {
                    ErrorPopup ep = new ErrorPopup();
                    ep.launchErrorPopup(errorImage);
                }
            } else if (e.getSource() == view.getExButton()) {
                this.mainFrame.dispose(); 
            }
        }
    }

}