import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LowLvlInfoPage {
    ImageIcon bgImage = new ImageIcon("images/Background.png");
    ImageIcon logoImage = new ImageIcon("images/Logo.png");
 
    //lorem is a placeholder, make sure to add a String hotelNames in the parameters
    public String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    Color darkGray = new Color(0x20, 0x24, 0x25);
    Color darkBlue = new Color(0x15, 0x68, 0xB3);
    Color lightBlue = new Color(0x15, 0x68, 0xB3);
    Color darkGreen = new Color(0x006937);


    public void launchLowLvlInfoPage(JFrame mainFrame) {
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

         //JTextArea
         JTextArea roomInfo = new JTextArea(8, 27);
         roomInfo.setFont(font);
         roomInfo.setForeground(darkGray);
         roomInfo.setText(lorem);
         roomInfo.setEditable(false);
         roomInfo.setWrapStyleWord(true);
         roomInfo.setLineWrap(true);
         roomInfo.setBounds(200, 200, 150, 100);
         
         //Border for JScrollPane
         Border textBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
         
         //JScrollPane for roomInfo
         JScrollPane vertScroll = new JScrollPane(roomInfo);
         vertScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         vertScroll.setBorder(textBorder);

         //JLabel in JPanel
         JLabel roomInfoTxt = new JLabel("ROOM INFORMATION");
         roomInfoTxt.setVerticalTextPosition(JLabel.TOP);
         roomInfoTxt.setHorizontalTextPosition(JLabel.CENTER);
         roomInfoTxt.setForeground(darkGray);
         roomInfoTxt.setFont(new Font("Helvetica", Font.BOLD, 13));

         //JPanel for JLabel and JTextArea
         RoundedPanel textHolder = new RoundedPanel();
         textHolder.setBounds(200, 295, 300, 150);
         textHolder.setBackground(darkBlue);
         textHolder.add(roomInfoTxt);
         textHolder.add(vertScroll);

         //Text Field
        JLabel dayLbl = new JLabel();
        dayLbl.setText("Day  # ");
        dayLbl.setForeground(Color.WHITE);
        dayLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        dayLbl.setBounds(200, -80, bgImage.getIconWidth(), bgImage.getIconHeight());

        JTextField dayField = new JTextField();
        dayField.setColumns(15);
        dayField.setBounds(260, 170, 210, 30);

        JLabel roomLbl = new JLabel();
        roomLbl.setText("Room # ");
        roomLbl.setForeground(Color.WHITE);
        roomLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        roomLbl.setBounds(200, -50, bgImage.getIconWidth(), bgImage.getIconHeight());

        JTextField roomField = new JTextField();
        roomField.setColumns(15);
        roomField.setBounds(260, 200, 210, 30);

         //Buttons
        RoundedButton subButton = new RoundedButton("Submit");
        subButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        subButton.setForeground(Color.WHITE);
        subButton.setBackground(darkGreen);
        subButton.setBounds(290, 250, 100, 35); 
        subButton.setOpaque(true); 
        subButton.setBorder(null);
        subButton.setContentAreaFilled(true); 
        subButton.setCustomBorderColor(Color.WHITE); 
        subButton.setCustomBorderThickness(2);

        RoundedButton exButton = new RoundedButton("Exit");
        exButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        exButton.setForeground(Color.WHITE);
        exButton.setBackground(Color.RED);
        exButton.setBounds(170, 450, 100, 35); 
        exButton.setOpaque(true); 
        exButton.setBorder(null);
        exButton.setContentAreaFilled(true); 
        exButton.setCustomBorderColor(Color.WHITE); 
        exButton.setCustomBorderThickness(2);
        
         //Button ActionListener
         subButton.addActionListener(e -> System.out.println("Submit button clicked!"));

         exButton.addActionListener(e -> {
                    ViewHotelPage mh = new ViewHotelPage();
                    mh.launchViewHotelPage(mainFrame);
                });
         
         //Label for Menu label
         JLabel menuLabel = new JLabel("HOTEL INFO");
         menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
         menuLabel.setVerticalTextPosition(JLabel.TOP);
         menuLabel.setForeground(Color.WHITE);
         menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
         menuLabel.setBounds(250, -115, bgImage.getIconWidth(), bgImage.getIconHeight());
 
         //Layers
         layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
         layeredPane.add(textHolder, JLayeredPane.POPUP_LAYER);
         layeredPane.add(dayLbl, JLayeredPane.POPUP_LAYER);
         layeredPane.add(roomLbl, JLayeredPane.POPUP_LAYER);
         layeredPane.add(dayField, JLayeredPane.POPUP_LAYER);
         layeredPane.add(roomField, JLayeredPane.POPUP_LAYER);
         layeredPane.add(subButton, JLayeredPane.POPUP_LAYER);
         layeredPane.add(exButton, JLayeredPane.POPUP_LAYER);

         //Add conditions for the invalid input warning (if invalid, show error)
         layeredPane.add(isInvalidInput(mainFrame, true), JLayeredPane.POPUP_LAYER);

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

    //Invalid input method
    public JLabel isInvalidInput(JFrame mainFrame, boolean isInvalid) {
        JLabel invalidLbl =  null;

        if (isInvalid == true) {
            invalidLbl = new JLabel();
            invalidLbl.setText("Invalid input. Please try again!");
            invalidLbl.setForeground(Color.WHITE);
            invalidLbl.setFont(new Font("Helvetica", Font.BOLD, 10));
            invalidLbl.setBounds(290, -30, bgImage.getIconWidth(), bgImage.getIconHeight());
        }

        return invalidLbl;
    }
}
