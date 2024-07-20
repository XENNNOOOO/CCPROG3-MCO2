import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewHotelController {
    private ViewHotelPage view;
    private HotelReservationSystemModel model;
    private JFrame mainFrame;


    public ViewHotelController(ViewHotelPage view, HotelReservationSystemModel model, JFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.launchViewHotelPage(this.mainFrame, this.model.getAllHotelString()); 
        view.addClickListener(new ViewHotelListener(this.view, this.model, this.mainFrame)); 
    }

    class ViewHotelListener implements ActionListener {
        private ViewHotelPage view;
        private HotelReservationSystemModel model;
        private JFrame mainFrame;

        public ViewHotelListener (ViewHotelPage view, HotelReservationSystemModel model, JFrame mainFrame){
            this.view = view;
            this.model = model;
            this.mainFrame = mainFrame;

            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.view.getLowButton() && Integer.valueOf(this.view.getHotelNum()) > 0 && this.model.getHotelList().size() >= Integer.valueOf(this.view.getHotelNum())) {
                int hotelNum = Integer.parseInt(this.view.getHotelNum()) - 1;

                LowLvlInfoPage lip = new LowLvlInfoPage();
                LowInfoController lic = new LowInfoController(lip, this.model, this.mainFrame, hotelNum);
            } 
            else if (e.getSource() == view.getHiButton() && Integer.valueOf(this.view.getHotelNum()) > 0 && this.model.getHotelList().size() >= Integer.valueOf(this.view.getHotelNum())) {
                int hotelNum = Integer.valueOf(this.view.getHotelNum()) - 1;
                
                HighLvlInfoPage hip = new HighLvlInfoPage();
                HighInfoController hic = new HighInfoController(hip, this.model, this.mainFrame, hotelNum);
            } 
            else if (e.getSource() == view.getExButton()) {
                LaunchPage lp = new LaunchPage();
                LaunchPageController lpc = new LaunchPageController(lp, this.model, this.mainFrame);
            } 
        }
    }

}
 