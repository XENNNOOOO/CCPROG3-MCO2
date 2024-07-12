import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewHotelPage {
    //lorem is a placeholder, make sure to add a String hotelNames in the parameters
    public String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    Color darkGray = new Color(0x20, 0x24, 0x25);
    Color darkBlue = new Color(0x15, 0x68, 0xB3);
    Color lightBlue = new Color(0x15, 0x68, 0xB3);

    
    public void launchViewHotelPage(JFrame mainFrame) {
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

        JTextField hotelNumField = new JTextField();
        hotelNumField.setColumns(15);
        hotelNumField.setBounds(290, 348, 210, 30);

         //Buttons
         RoundedButton hiButton = new RoundedButton("High-level Information");
        hiButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        hiButton.setForeground(Color.WHITE);
        hiButton.setBackground(darkBlue);
        hiButton.setBounds(360, 400, 170, 35); 
        hiButton.setOpaque(true); 
        hiButton.setBorder(null);
        hiButton.setContentAreaFilled(true); 
        hiButton.setCustomBorderColor(Color.WHITE); 
        hiButton.setCustomBorderThickness(2);

        RoundedButton lowButton = new RoundedButton("Low-level Information");
        lowButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lowButton.setForeground(Color.WHITE);
        lowButton.setBackground(lightBlue);
        lowButton.setBounds(170, 400, 170, 35); 
        lowButton.setOpaque(true); 
        lowButton.setBorder(null);
        lowButton.setContentAreaFilled(true); 
        lowButton.setCustomBorderColor(Color.WHITE); 
        lowButton.setCustomBorderThickness(2);

        RoundedButton exButton = new RoundedButton("Exit");
        exButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        exButton.setForeground(Color.WHITE);
        exButton.setBackground(Color.RED);
        exButton.setBounds(170, 450, 100, 35); 
        exButton.setOpaque(true); 
        exButton.setBorder(null);
        exButton.setContentAreaFilled(true); 
        exButton.setCustomBorderColor(Color.WHITE); 
        exButton.setCustomBorderThickness(2);
        
         //Button ActionListener
         hiButton.addActionListener(e -> {
            HighLvlInfoPage highLvl = new HighLvlInfoPage();
            highLvl.launchHighLvlInfoPage(mainFrame);
         });
         lowButton.addActionListener(e -> {
            LowLvlInfoPage lowLvl = new LowLvlInfoPage();
            lowLvl.launchLowLvlInfoPage(mainFrame);
        });
         exButton.addActionListener(e -> {
            mainFrame.dispose();
            LaunchPage lp = new LaunchPage();
            lp.launchLaunchPage();
         });
         
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
}
