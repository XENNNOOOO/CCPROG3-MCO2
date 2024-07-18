import javax.swing.*;

public class MainController{
     public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        LaunchPage view = new LaunchPage();
        HotelReservationSystemModel model = new HotelReservationSystemModel();
        LaunchPageController controller = new LaunchPageController(view, model, mainFrame);
    }

}
