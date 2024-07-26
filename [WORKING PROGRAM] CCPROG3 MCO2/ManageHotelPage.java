import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ManageHotelPage class provides a graphical user interface for managing hotel operations.
 * It includes buttons for various management tasks such as changing hotel name, adding/removing rooms,
 * removing reservations, updating base price, and removing the entire hotel.
 */
public class ManageHotelPage{
    Color darkBlue = new Color(0x15, 0x68, 0xB3);
    Color darkGreen = new Color(0x006937);
    RoundedButton chnButton;
    RoundedButton rrButton;
    RoundedButton resButton;
    RoundedButton arButton;
    RoundedButton ubButton;
    RoundedButton rhButton;
    RoundedButton exButton;

    /**
     * Launches the Manage Hotel Page UI on the provided JFrame.
     *
     * @param mainFrame The main JFrame where the UI will be displayed.
     */
    public void launchManageHotelPage (JFrame mainFrame) {
         //Images
         ImageIcon bgImage = new ImageIcon("images/Background.png");
         ImageIcon logoImage = new ImageIcon("images/Logo.png");
 
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
         chnButton = new RoundedButton("Change Hotel Name");
         chnButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         chnButton.setForeground(Color.WHITE);
         chnButton.setBackground(darkBlue);
         chnButton.setBounds(160, 205, 160, 40); 
         chnButton.setOpaque(true); 
         chnButton.setBorder(null);
         chnButton.setContentAreaFilled(true); 
         chnButton.setCustomBorderColor(Color.WHITE); 
         chnButton.setCustomBorderThickness(2);    
    
         rrButton = new RoundedButton("Remove Room");
         rrButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         rrButton.setForeground(Color.WHITE);
         rrButton.setBackground(darkBlue);
         rrButton.setBounds(160, 270, 160, 40); 
         rrButton.setOpaque(true); 
         rrButton.setBorder(null);
         rrButton.setContentAreaFilled(true); 
         rrButton.setCustomBorderColor(Color.WHITE); 
         rrButton.setCustomBorderThickness(2);   
 
         resButton = new RoundedButton("Remove Reservation");
         resButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         resButton.setForeground(Color.WHITE);
         resButton.setBackground(darkBlue);
         resButton.setBounds(160, 335, 160, 40); 
         resButton.setOpaque(true); 
         resButton.setBorder(null);
         resButton.setContentAreaFilled(true); 
         resButton.setCustomBorderColor(Color.WHITE); 
         resButton.setCustomBorderThickness(2);   
 
         arButton = new RoundedButton("Add Room");
         arButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         arButton.setForeground(Color.WHITE);
         arButton.setBackground(darkBlue);
         arButton.setBounds(340, 205, 160, 40); 
         arButton.setOpaque(true); 
         arButton.setBorder(null);
         arButton.setContentAreaFilled(true); 
         arButton.setCustomBorderColor(Color.WHITE); 
         arButton.setCustomBorderThickness(2);  

         ubButton = new RoundedButton("Update Base Price");
         ubButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         ubButton.setForeground(Color.WHITE);
         ubButton.setBackground(darkBlue);
         ubButton.setBounds(340, 270, 160, 40); 
         ubButton.setOpaque(true); 
         ubButton.setBorder(null);
         ubButton.setContentAreaFilled(true); 
         ubButton.setCustomBorderColor(Color.WHITE); 
         ubButton.setCustomBorderThickness(2); 

         rhButton = new RoundedButton("Remove Hotel");
         rhButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         rhButton.setForeground(Color.WHITE);
         rhButton.setBackground(darkBlue);
         rhButton.setBounds(340, 335, 160, 40); 
         rhButton.setOpaque(true); 
         rhButton.setBorder(null);
         rhButton.setContentAreaFilled(true); 
         rhButton.setCustomBorderColor(Color.WHITE); 
         rhButton.setCustomBorderThickness(2);  
 
         exButton = new RoundedButton("Exit");
         exButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         exButton.setForeground(Color.WHITE);
         exButton.setBackground(Color.RED);
         exButton.setBounds(255, 410, 160, 40); 
         exButton.setOpaque(true); 
         exButton.setBorder(null);
         exButton.setContentAreaFilled(true); 
         exButton.setCustomBorderColor(Color.WHITE); 
         exButton.setCustomBorderThickness(2);

         
         //Label for Menu label
         JLabel menuLabel = new JLabel("MANAGE HOTEL");
         menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
         menuLabel.setVerticalTextPosition(JLabel.TOP);
         menuLabel.setForeground(Color.WHITE);
         menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
         menuLabel.setBounds(200, -115, bgImage.getIconWidth(), bgImage.getIconHeight());
 
         //Layers
         layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
         layeredPane.add(chnButton, JLayeredPane.POPUP_LAYER); 
         layeredPane.add(rrButton, JLayeredPane.POPUP_LAYER);
         layeredPane.add(resButton, JLayeredPane.POPUP_LAYER);
         layeredPane.add(arButton, JLayeredPane.POPUP_LAYER);
         layeredPane.add(ubButton, JLayeredPane.POPUP_LAYER);
         layeredPane.add(rhButton, JLayeredPane.POPUP_LAYER);
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
     * Adds an ActionListener to all buttons in the Manage Hotel Page UI.
     *
     * @param listener The ActionListener to be added.
     */
    public void addClickListener(ActionListener listener) {
        chnButton.addActionListener(listener);
        rrButton.addActionListener(listener);
        resButton.addActionListener(listener);
        arButton.addActionListener(listener);
        ubButton.addActionListener(listener);
        rhButton.addActionListener(listener);
        exButton.addActionListener(listener);
    }

    /**
     * Gets the button for changing the hotel name.
     *
     * @return The button for changing the hotel name.
     */
    public RoundedButton getChnButton() {
        return chnButton;
    }

    /**
     * Gets the button for removing a room from the hotel.
     *
     * @return The button for removing a room.
     */
    public RoundedButton getRrButton() {
        return rrButton;
    }

    /**
     * Gets the button for removing a reservation from a room.
     *
     * @return The button for removing a reservation.
     */
    public RoundedButton getResButton() {
        return resButton;
    }

    /**
     * Gets the button for adding a room to the hotel.
     *
     * @return The button for adding a room.
     */
    public RoundedButton getArButton() {
        return arButton;
    }

    /**
     * Gets the button for updating the base price of rooms in the hotel.
     *
     * @return The button for updating the base price.
     */
    public RoundedButton getUbButton() {
        return ubButton;
    }

    /**
     * Gets the button for removing the entire hotel.
     *
     * @return The button for removing the hotel.
     */
    public RoundedButton getRhButton() {
        return rhButton;
    }

    /**
     * Gets the exit button to leave the Manage Hotel page.
     *
     * @return The exit button.
     */
    public RoundedButton getExButton() {
        return exButton;
    }

}