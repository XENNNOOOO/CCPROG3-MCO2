import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            LaunchPage lp = new LaunchPage();
            lp.launchLaunchPage();

            //CreateHotelPage chp = new CreateHotelPage();
            //chp.launchCreateHotelPage();
            
        });
    }
}

