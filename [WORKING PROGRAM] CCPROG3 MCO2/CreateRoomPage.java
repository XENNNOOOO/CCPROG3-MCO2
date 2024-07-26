import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Represents a graphical user interface for creating a hotel room.
 * It allows users to input room details and select room types.
 */
public class CreateRoomPage{
    Color darkGreen = new Color(0x006937);
    Color darkGray = new Color(0x20, 0x24, 0x25);
    Color lighterBlue = new Color(0x38B6FF);
    Color darkBlue = new Color(0x004AAD);
    Color lightBlue = new Color(0x15, 0x68, 0xB3);
    ImageIcon bgImage = new ImageIcon("images/Background.png");
    ImageIcon logoImage = new ImageIcon("images/Logo.png");
    RoundedButton exButton;
    RoundedButton excButton;
    RoundedButton dlxButton;
    RoundedButton stnButton;
    JTextField roomNameField;
    JLayeredPane layeredPane;

    /**
     * Launches the create room page within a specified JFrame.
     *
     * @param mainFrame The main JFrame where the page will be displayed.
     */
    public void launchCreateRoomPage(JFrame mainFrame) {
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
        stnButton = new RoundedButton("Standard");
        stnButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        stnButton.setForeground(Color.WHITE);
        stnButton.setBackground(lighterBlue);
        stnButton.setBounds(180, 260, 90, 29); 
        stnButton.setOpaque(true); 
        stnButton.setBorder(null);
        stnButton.setContentAreaFilled(true); 
        stnButton.setCustomBorderColor(Color.WHITE); 
        stnButton.setCustomBorderThickness(2);

        dlxButton = new RoundedButton("Deluxe");
        dlxButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        dlxButton.setForeground(Color.WHITE);
        dlxButton.setBackground(lightBlue);
        dlxButton.setBounds(285, 260, 90, 29); 
        dlxButton.setOpaque(true); 
        dlxButton.setBorder(null);
        dlxButton.setContentAreaFilled(true); 
        dlxButton.setCustomBorderColor(Color.WHITE); 
        dlxButton.setCustomBorderThickness(2);

        excButton = new RoundedButton("Executive");
        excButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        excButton.setForeground(Color.WHITE);
        excButton.setBackground(darkBlue);
        excButton.setBounds(390, 260, 90, 29); 
        excButton.setOpaque(true); 
        excButton.setBorder(null);
        excButton.setContentAreaFilled(true); 
        excButton.setCustomBorderColor(Color.WHITE); 
        excButton.setCustomBorderThickness(2);

        exButton = new RoundedButton("Exit");
        exButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        exButton.setForeground(Color.WHITE);
        exButton.setBackground(Color.RED);
        exButton.setBounds(390, 400, 90, 29); 
        exButton.setOpaque(true); 
        exButton.setBorder(null);
        exButton.setContentAreaFilled(true); 
        exButton.setCustomBorderColor(Color.WHITE); 
        exButton.setCustomBorderThickness(2);

        
        //Label for Menu label
        JLabel menuLabel = new JLabel("ROOM CREATOR");
        menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
        menuLabel.setVerticalTextPosition(JLabel.TOP);
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
        menuLabel.setBounds(200, -115, bgImage.getIconWidth(), bgImage.getIconHeight());

        //Layers
        layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
        layeredPane.add(promptLbl, JLayeredPane.POPUP_LAYER); 
        layeredPane.add(roomNameField, JLayeredPane.POPUP_LAYER); 
        layeredPane.add(stnButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(dlxButton, JLayeredPane.POPUP_LAYER);
        layeredPane.add(excButton, JLayeredPane.POPUP_LAYER);
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
     * Displays a status label indicating the result of room creation.
     *
     * @param mainFrame The main JFrame where the status label will be displayed.
     * @param isValid   Indicates whether the room name input is valid or not.
     * @return A JLabel displaying the update status.
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
     * Adds an ActionListener to the buttons for handling user clicks.
     *
     * @param listener The ActionListener to be added.
     */
    public void addClickListener(ActionListener listener) {
        stnButton.addActionListener(listener);
        dlxButton.addActionListener(listener);
        excButton.addActionListener(listener);
        exButton.addActionListener(listener);
    }

    /**
     * Retrieves the Standard button used in the UI.
     *
     * @return The Standard button.
     */
    public RoundedButton getStnButton() {
        return stnButton;
    }

    /**
     * Retrieves the Deluxe button used in the UI.
     *
     * @return The Deluxe button.
     */
    public RoundedButton getDlxButton() {
        return dlxButton;
    }

    /**
     * Retrieves the Executive button used in the UI.
     *
     * @return The Executive button.
     */
    public RoundedButton getExcButton() {
        return excButton;
    }
    
    /**
     * Retrieves the Exit button used in the UI.
     *
     * @return The Exit button.
     */
    public RoundedButton getExButton() {
        return exButton;
    }

    /**
     * Retrieves the room name entered by the user.
     *
     * @return The room name as a String.
     */
    public String getRoomName(){
        return roomNameField.getText();
    }

    /**
     * Retrieves the layered pane containing UI elements.
     *
     * @return The JLayeredPane instance.
     */
    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

}
