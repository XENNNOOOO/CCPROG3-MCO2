import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveHotelPage {
    Color darkGray = new Color(0x20, 0x24, 0x25);
    Color darkBlue = new Color(0x15, 0x68, 0xB3);
    Color lightBlue = new Color(0x15, 0x68, 0xB3);
    Color darkGreen = new Color(0x006937);
    RoundedButton exButton;
    RoundedButton subButton;
    JTextField hotelNumField;


    
    public void launchRemoveHotelPage(JFrame mainFrame, String lorem) {
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

         //JTextArea 
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

         //JLabel in JPanel
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
        promptLbl.setText("Hotel # ");
        promptLbl.setForeground(Color.WHITE);
        promptLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        promptLbl.setBounds(207, 100, bgImage.getIconWidth(), bgImage.getIconHeight());

        hotelNumField = new JTextField();
        hotelNumField.setColumns(15);
        hotelNumField.setBounds(280, 348, 215, 30);

         //Buttons
        subButton = new RoundedButton("Submit");
        subButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        subButton.setForeground(Color.WHITE);
        subButton.setBackground(darkGreen);
        subButton.setBounds(400, 450, 100, 35); 
        subButton.setOpaque(true); 
        subButton.setBorder(null);
        subButton.setContentAreaFilled(true); 
        subButton.setCustomBorderColor(Color.WHITE); 
        subButton.setCustomBorderThickness(2);

        exButton = new RoundedButton("Exit");
        exButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
        exButton.setForeground(Color.WHITE);
        exButton.setBackground(Color.RED);
        exButton.setBounds(200, 450, 100, 35); 
        exButton.setOpaque(true); 
        exButton.setBorder(null);
        exButton.setContentAreaFilled(true); 
        exButton.setCustomBorderColor(Color.WHITE); 
        exButton.setCustomBorderThickness(2);

         
         //Label for Menu label
         JLabel menuLabel = new JLabel("REMOVE HOTEL");
         menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
         menuLabel.setVerticalTextPosition(JLabel.TOP);
         menuLabel.setForeground(Color.WHITE);
         menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
         menuLabel.setBounds(220, -115, bgImage.getIconWidth(), bgImage.getIconHeight());
 
         //Layers
         layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
         layeredPane.add(textHolder, JLayeredPane.POPUP_LAYER);
         layeredPane.add(promptLbl, JLayeredPane.POPUP_LAYER);
         layeredPane.add(hotelNumField, JLayeredPane.POPUP_LAYER);
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

    public void addClickListener(ActionListener listener) {
        subButton.addActionListener(listener);
        exButton.addActionListener(listener);
    }

    public RoundedButton getSubButton() {
        return subButton;
    }

    public RoundedButton getExButton() {
        return exButton;
    }

    public String getHotelNum(){
        return hotelNumField.getText();
    }
}

