import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BookReservationPage {
    //lorem is a placeholder, make sure to add a String hotelNames in the parameters
    public String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    Color darkGray = new Color(0x20, 0x24, 0x25);
    Color lighterBlue = new Color(0x38B6FF);
    Color darkBlue = new Color(0x004AAD);
    Color lightBlue = new Color(0x15, 0x68, 0xB3);

    
    public void launchBookReservationPage(JFrame mainFrame) {
        //Images
         ImageIcon bgImage = new ImageIcon("images/Background2.png");
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
         textHolder.setBounds(180, 180, 300, 150);
         textHolder.setBackground(darkBlue);
         textHolder.add(hotelListText);
         textHolder.add(vertScroll);

         //Text Field (Hotel Name)
        JLabel hNameLbl = new JLabel();
        hNameLbl.setText("Hotel Name: ");
        hNameLbl.setForeground(Color.WHITE);
        hNameLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        hNameLbl.setBounds(180, 80, bgImage.getIconWidth(), bgImage.getIconHeight());

        JTextField hotelNameField = new JTextField();
        hotelNameField.setColumns(15);
        hotelNameField.setBounds(270, 328, 210, 30);

        //Text Field (Guest Name)
        JLabel gNameLbl = new JLabel();
        gNameLbl.setText("Guest Name: ");
        gNameLbl.setForeground(Color.WHITE);
        gNameLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        gNameLbl.setBounds(180, 105, bgImage.getIconWidth(), bgImage.getIconHeight());

        JTextField guestNameField = new JTextField();
        guestNameField.setColumns(15);
        guestNameField.setBounds(270, 353, 210, 30);

        //Text Field (Days)
        JLabel daysLbl = new JLabel();
        daysLbl.setText("Days: ");
        daysLbl.setForeground(Color.WHITE);
        daysLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        daysLbl.setBounds(180, 130, bgImage.getIconWidth(), bgImage.getIconHeight());

        JTextField dayFromField = new JTextField();
        dayFromField.setColumns(15);
        dayFromField.setBounds(270, 378, 40, 30);

        JLabel hyphen = new JLabel();
        hyphen.setText(" - ");
        hyphen.setForeground(Color.WHITE);
        hyphen.setFont(new Font("Helvetica", Font.BOLD, 15));
        hyphen.setBounds(310, 128, bgImage.getIconWidth(), bgImage.getIconHeight());

        JTextField dayToField = new JTextField();
        dayToField.setColumns(15);
        dayToField.setBounds(325, 378, 40, 30);

        //Text Field (Discount Code)
        JLabel discCode = new JLabel();
        discCode.setText("Discount Code: ");
        discCode.setForeground(Color.WHITE);
        discCode.setFont(new Font("Helvetica", Font.BOLD, 15));
        discCode.setBounds(180, 155, bgImage.getIconWidth(), bgImage.getIconHeight());

        JTextField codeField = new JTextField();
        codeField.setColumns(15);
        codeField.setBounds(290, 403, 190, 30);

        //JLabel RoomType
        JLabel roomType = new JLabel();
        roomType.setText("Room Type: ");
        roomType.setForeground(Color.WHITE);
        roomType.setFont(new Font("Helvetica", Font.BOLD, 15));
        roomType.setBounds(180, 180, bgImage.getIconWidth(), bgImage.getIconHeight());



         //Buttons
         RoundedButton stnButton = new RoundedButton("Standard");
         stnButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
         stnButton.setForeground(Color.WHITE);
         stnButton.setBackground(lighterBlue);
         stnButton.setBounds(180, 460, 90, 29); 
         stnButton.setOpaque(true); 
         stnButton.setBorder(null);
         stnButton.setContentAreaFilled(true); 
         stnButton.setCustomBorderColor(Color.WHITE); 
         stnButton.setCustomBorderThickness(2);

         RoundedButton dlxButton = new RoundedButton("Deluxe");
         dlxButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
         dlxButton.setForeground(Color.WHITE);
         dlxButton.setBackground(lightBlue);
         dlxButton.setBounds(285, 460, 90, 29); 
         dlxButton.setOpaque(true); 
         dlxButton.setBorder(null);
         dlxButton.setContentAreaFilled(true); 
         dlxButton.setCustomBorderColor(Color.WHITE); 
         dlxButton.setCustomBorderThickness(2);

         RoundedButton excButton = new RoundedButton("Executive");
         excButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
         excButton.setForeground(Color.WHITE);
         excButton.setBackground(darkBlue);
         excButton.setBounds(390, 460, 90, 29); 
         excButton.setOpaque(true); 
         excButton.setBorder(null);
         excButton.setContentAreaFilled(true); 
         excButton.setCustomBorderColor(Color.WHITE); 
         excButton.setCustomBorderThickness(2);

         RoundedButton exButton = new RoundedButton("Exit");
         exButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
         exButton.setForeground(Color.WHITE);
         exButton.setBackground(Color.RED);
         exButton.setBounds(475, 75, 90, 29); 
         exButton.setOpaque(true); 
         exButton.setBorder(null);
         exButton.setContentAreaFilled(true); 
         exButton.setCustomBorderColor(Color.WHITE); 
         exButton.setCustomBorderThickness(2);
        
         //Button ActionListener
         
         stnButton.addActionListener(e -> {
            System.out.println("Standard!");
         });
         dlxButton.addActionListener(e -> {
            System.out.println("Deluxe!");
        });
         excButton.addActionListener(e -> {
            System.out.println("Executive!");
        });
         exButton.addActionListener(e -> {
            mainFrame.dispose();
            LaunchPage lp = new LaunchPage();
            lp.launchLaunchPage();
         });
         
         //Label for Menu label
         JLabel menuLabel = new JLabel("BOOK A RESERVATION");
         menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
         menuLabel.setVerticalTextPosition(JLabel.TOP);
         menuLabel.setForeground(Color.WHITE);
         menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
         menuLabel.setBounds(150, -115, bgImage.getIconWidth(), bgImage.getIconHeight());

         //Layers
         layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
         layeredPane.add(textHolder, JLayeredPane.POPUP_LAYER);
         layeredPane.add(hNameLbl, JLayeredPane.POPUP_LAYER);
         layeredPane.add(hotelNameField, JLayeredPane.POPUP_LAYER);
         layeredPane.add(gNameLbl, JLayeredPane.POPUP_LAYER);
         layeredPane.add(guestNameField, JLayeredPane.POPUP_LAYER);
         layeredPane.add(daysLbl, JLayeredPane.POPUP_LAYER);
         layeredPane.add(dayFromField, JLayeredPane.POPUP_LAYER);
         layeredPane.add(hyphen, JLayeredPane.POPUP_LAYER);
         layeredPane.add(dayToField, JLayeredPane.POPUP_LAYER);
         layeredPane.add(discCode, JLayeredPane.POPUP_LAYER);
         layeredPane.add(codeField, JLayeredPane.POPUP_LAYER);
         layeredPane.add(roomType, JLayeredPane.POPUP_LAYER);
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
}
