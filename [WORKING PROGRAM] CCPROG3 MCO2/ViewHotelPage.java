import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ViewHotelPage class represents the GUI for viewing hotel information.
 * It displays a list of hotels, allows the user to enter a hotel number,
 * and provides buttons for accessing high-level and low-level information
 * about the selected hotel.
 */
public class ViewHotelPage {
    Color darkGray = new Color(0x20, 0x24, 0x25);
    Color darkBlue = new Color(0x15, 0x68, 0xB3);
    Color lightBlue = new Color(0x15, 0x68, 0xB3);
    RoundedButton exButton;
    RoundedButton lowButton;
    RoundedButton hiButton;
    JTextField hotelNumField;

    /**
     * Launches the ViewHotelPage GUI with specified JFrame and hotel list.
     *
     * @param mainFrame The main JFrame of the application.
     * @param hotelList The string representation of the hotel list to display.
     */
    public void launchViewHotelPage(JFrame mainFrame, String lorem) {
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

         //Font for JTextArea
         Font font = new Font("Helvetica", Font.PLAIN, 12);

         //JTextArea (Hotel List)
         JTextArea hotelList = new JTextArea(8, 27);
         hotelList.setFont(font);
         hotelList.setForeground(darkGray);
         hotelList.setText(lorem);
         hotelList.setEditable(false);
         hotelList.setWrapStyleWord(true);
         hotelList.setLineWrap(true);
         hotelList.setBounds(200, 200, 150, 100);
         
         //Border for JScrollPane
         Border textBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
         
         //JScrollPane for JTextArea
         JScrollPane vertScroll = new JScrollPane(hotelList);
         vertScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         vertScroll.setBorder(textBorder);

         //JLabel (Hotel List text label) in JPanel
         JLabel hotelListText = new JLabel("HOTEL LIST");
         hotelListText.setVerticalTextPosition(JLabel.TOP);
         hotelListText.setHorizontalTextPosition(JLabel.CENTER);
         hotelListText.setForeground(darkGray);
         hotelListText.setFont(new Font("Helvetica", Font.BOLD, 13));

         //JPanel for JLabel and JTextArea
         RoundedPanel textHolder = new RoundedPanel();
         textHolder.setBounds(200, 180, 300, 150);
         textHolder.setBackground(darkBlue);
         textHolder.add(hotelListText);
         textHolder.add(vertScroll);

         //Text Field
        JLabel promptLbl = new JLabel();
        promptLbl.setText("Visit Hotel # ");
        promptLbl.setForeground(Color.WHITE);
        promptLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        promptLbl.setBounds(200, 100, bgImage.getIconWidth(), bgImage.getIconHeight());

        hotelNumField = new JTextField();
        hotelNumField.setColumns(15);
        hotelNumField.setBounds(290, 348, 210, 30);

         //Buttons
        hiButton = new RoundedButton("High-level Information");
        hiButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        hiButton.setForeground(Color.WHITE);
        hiButton.setBackground(darkBlue);
        hiButton.setBounds(360, 400, 170, 35); 
        hiButton.setOpaque(true); 
        hiButton.setBorder(null);
        hiButton.setContentAreaFilled(true); 
        hiButton.setCustomBorderColor(Color.WHITE); 
        hiButton.setCustomBorderThickness(2);

        lowButton = new RoundedButton("Low-level Information");
        lowButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lowButton.setForeground(Color.WHITE);
        lowButton.setBackground(lightBlue);
        lowButton.setBounds(170, 400, 170, 35); 
        lowButton.setOpaque(true); 
        lowButton.setBorder(null);
        lowButton.setContentAreaFilled(true); 
        lowButton.setCustomBorderColor(Color.WHITE); 
        lowButton.setCustomBorderThickness(2);

        exButton = new RoundedButton("Exit");
        exButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        exButton.setForeground(Color.WHITE);
        exButton.setBackground(Color.RED);
        exButton.setBounds(170, 450, 100, 35); 
        exButton.setOpaque(true); 
        exButton.setBorder(null);
        exButton.setContentAreaFilled(true); 
        exButton.setCustomBorderColor(Color.WHITE); 
        exButton.setCustomBorderThickness(2);
        
         
         //Label for Menu label
         JLabel menuLabel = new JLabel("VIEW HOTEL");
         menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
         menuLabel.setVerticalTextPosition(JLabel.TOP);
         menuLabel.setForeground(Color.WHITE);
         menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
         menuLabel.setBounds(250, -115, bgImage.getIconWidth(), bgImage.getIconHeight());
 
         //Layers
         layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
         layeredPane.add(textHolder, JLayeredPane.POPUP_LAYER);
         layeredPane.add(promptLbl, JLayeredPane.POPUP_LAYER);
         layeredPane.add(hotelNumField, JLayeredPane.POPUP_LAYER);
         layeredPane.add(hiButton, JLayeredPane.POPUP_LAYER);
         layeredPane.add(lowButton, JLayeredPane.POPUP_LAYER);
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
     * Adds ActionListener to the buttons on the ViewHotelPage.
     *
     * @param listener The ActionListener to be added.
     */
    public void addClickListener(ActionListener listener) {
        hiButton.addActionListener(listener);
        lowButton.addActionListener(listener);
        exButton.addActionListener(listener);
    }

     /**
     * Retrieves the "High-level Information" button.
     *
     * @return The RoundedButton object representing the "High-level Information" button.
     */
    public RoundedButton getHiButton() {
        return hiButton;
    }

    /**
     * Retrieves the "Low-level Information" button.
     *
     * @return The RoundedButton object representing the "Low-level Information" button.
     */
    public RoundedButton getLowButton() {
        return lowButton;
    }

    /**
     * Retrieves the "Exit" button.
     *
     * @return The RoundedButton object representing the "Exit" button.
     */
    public RoundedButton getExButton() {
        return exButton;
    }

     /**
     * Retrieves the text entered into the hotel number field.
     *
     * @return A String representing the hotel number entered by the user.
     */
    public String getHotelNum() {
        return hotelNumField.getText();
    }
}
