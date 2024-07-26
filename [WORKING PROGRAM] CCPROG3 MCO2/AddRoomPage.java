import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A graphical user interface for adding a new room to a hotel reservation system.
 * Allows the user to enter a room name and submit or exit the operation.
 */
public class AddRoomPage{
    Color darkGreen = new Color(0x006937);
    ImageIcon bgImage = new ImageIcon("images/Background.png");
    ImageIcon logoImage = new ImageIcon("images/Logo.png");
    RoundedButton exButton;
    RoundedButton subButton;
    JLayeredPane layeredPane;
    JTextField roomNameField;

    /**
     * Launches the Add Room page interface within the specified JFrame.
     *
     * @param mainFrame The main JFrame of the application where the page will be displayed.
     */
    public void launchAddRoomPage(JFrame mainFrame) {
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
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));

        //Text Field
        JLabel promptLbl = new JLabel();
        promptLbl.setText("Room Name: ");
        promptLbl.setForeground(Color.WHITE);
        promptLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        promptLbl.setBounds(180, -50, bgImage.getIconWidth(), bgImage.getIconHeight());

        roomNameField = new JTextField();
        roomNameField.setColumns(15);
        roomNameField.setBounds(270, 200, 210, 30);

        //Buttons
        subButton = new RoundedButton("Submit");
        subButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        subButton.setForeground(Color.WHITE);
        subButton.setBackground(darkGreen);
        subButton.setBounds(375, 260, 100, 35); 
        subButton.setOpaque(true); 
        subButton.setBorder(null);
        subButton.setContentAreaFilled(true); 
        subButton.setCustomBorderColor(Color.WHITE); 
        subButton.setCustomBorderThickness(2);

        exButton = new RoundedButton("Exit");
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
        JLabel menuLabel = new JLabel("ADD ROOM");
        menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
        menuLabel.setVerticalTextPosition(JLabel.TOP);
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
        menuLabel.setBounds(250, -115, bgImage.getIconWidth(), bgImage.getIconHeight());

        //Layers
        layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
        layeredPane.add(promptLbl, JLayeredPane.POPUP_LAYER); 
        layeredPane.add(roomNameField, JLayeredPane.POPUP_LAYER); 
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
     * Displays an update status message on the main JFrame based on the validity of the room name.
     *
     * @param mainFrame The main JFrame of the application where the status message will be displayed.
     * @param isValid   Indicates if the update operation was successful or not.
     * @return JLabel containing the status message.
     */
    public JLabel showUpdateStatus(JFrame mainFrame, boolean isValid) {
        JLabel statusLbl;

        if(isValid) {
            statusLbl = new JLabel("Update Successful!");
            statusLbl.setBounds(230, 200, bgImage.getIconWidth(), bgImage.getIconHeight());

        }
        else {
            statusLbl = new JLabel("Invalid Name!");
            statusLbl.setBounds(265, 200, bgImage.getIconWidth(), bgImage.getIconHeight());

        }

        statusLbl.setHorizontalTextPosition(JLabel.RIGHT);
        statusLbl.setVerticalTextPosition(JLabel.TOP);
        statusLbl.setForeground(Color.WHITE);
        statusLbl.setFont(new Font("Helvetica", Font.BOLD, 25));
        
        return statusLbl;
    }

    /**
     * Retrieves the layered pane containing all the graphical components.
     *
     * @return The JLayeredPane containing the graphical components of the page.
     */
    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    /**
     * Adds an ActionListener to the submit and exit buttons.
     *
     * @param listener The ActionListener to be added to the buttons.
     */
    public void addClickListener(ActionListener listener) {
        subButton.addActionListener(listener);
        exButton.addActionListener(listener);
    }

    /**
     * Retrieves the room name entered by the user in the text field.
     *
     * @return The room name entered by the user.
     */
    public String getRoomName() {
        return roomNameField.getText();
    }

    /**
     * Retrieves the submit button of the Add Room page.
     *
     * @return The submit button (RoundedButton) of the Add Room page.
     */
    public RoundedButton getSubButton() {
        return subButton;
    }

    /**
     * Retrieves the exit button of the Add Room page.
     *
     * @return The exit button (RoundedButton) of the Add Room page.
     */
    public RoundedButton getExButton() {
        return exButton;
    }
    
}
