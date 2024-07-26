import javax.swing.*;

/**
 * This class serves as the entry point for the Hotel Reservation System application.
 * It initializes the main components and starts the application.
 */
public class MainController{
     public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        LaunchPage view = new LaunchPage();
        HotelReservationSystemModel model = new HotelReservationSystemModel();
        LaunchPageController controller = new LaunchPageController(view, model, mainFrame);
    }

}
