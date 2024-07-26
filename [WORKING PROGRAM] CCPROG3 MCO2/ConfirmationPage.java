import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a graphical user interface for confirming an action.
 * It displays a confirmation message and provides options to proceed or cancel.
 */
public class ConfirmationPage{
    Color darkGreen = new Color(0x006937);
    ImageIcon bgImage = new ImageIcon("images/Background.png");
    ImageIcon logoImage = new ImageIcon("images/Logo.png");
    RoundedButton exButton;
    RoundedButton subButton;

    /**
     * Launches the confirmation page within a specified JFrame.
     *
     * @param mainFrame The main JFrame where the page will be displayed.
     */
    public void launchConfirmationPage(JFrame mainFrame) {
        //Panel for bgImage
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));

        //Layeredpane for texts and buttons
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));

        //Buttons
        subButton = new RoundedButton("YES");
        subButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        subButton.setForeground(Color.WHITE);
        subButton.setBackground(darkGreen);
        subButton.setBounds(375, 260, 100, 35); 
        subButton.setOpaque(true); 
        subButton.setBorder(null);
        subButton.setContentAreaFilled(true); 
        subButton.setCustomBorderColor(Color.WHITE); 
        subButton.setCustomBorderThickness(2);

        exButton = new RoundedButton("NO");
        exButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        exButton.setForeground(Color.WHITE);
        exButton.setBackground(Color.RED);
        exButton.setBounds(185, 260, 100, 35); 
        exButton.setOpaque(true); 
        exButton.setBorder(null);
        exButton.setContentAreaFilled(true); 
        exButton.setCustomBorderColor(Color.WHITE); 
        exButton.setCustomBorderThickness(2);
        
        //Label for Menu label
        JLabel menuLabel = new JLabel("CONFIRM ACTION?");
        menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
        menuLabel.setVerticalTextPosition(JLabel.TOP);
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
        menuLabel.setBounds(200, -115, bgImage.getIconWidth(), bgImage.getIconHeight());

        //Layers
        layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
        layeredPane.add(subButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(exButton, JLayeredPane.POPUP_LAYER);

        //JFrame
        mainFrame.setTitle("Hotel Reservation System");
        mainFrame.setSize(660, 530);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setIconImage(logoImage.getImage());

        //backgroundPanel and layeredPane on JFrame
        mainFrame.setContentPane(backgroundPanel);
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.getContentPane().add(layeredPane, BorderLayout.CENTER);

        mainFrame.setLocationRelativeTo(null); // Center JFrame on screen
        mainFrame.setVisible(true);
    }

     /**
     * Adds an ActionListener to the buttons for handling user clicks.
     *
     * @param listener The ActionListener to be added.
     */
    public void addClickListener(ActionListener listener) {
        subButton.addActionListener(listener);
        exButton.addActionListener(listener);
    }

}