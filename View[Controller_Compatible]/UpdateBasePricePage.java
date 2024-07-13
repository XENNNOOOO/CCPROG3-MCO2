import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateBasePricePage implements ActionListener{
    Color darkGreen = new Color(0x006937);
    ImageIcon bgImage = new ImageIcon("images/Background.png");
    ImageIcon logoImage = new ImageIcon("images/Logo.png");
    RoundedButton exButton;
    RoundedButton subButton;
    JLayeredPane layeredPane;
    JTextField priceField;

    public void launchUpdateBasePricePage(JFrame mainFrame, double crtPrice) {
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

        //JLabel for the current price
        JLabel currentPrice = new JLabel();
        currentPrice.setText("Current Price: " + crtPrice);
        currentPrice.setForeground(Color.WHITE);
        currentPrice.setFont(new Font("Helvetica", Font.BOLD, 15));
        currentPrice.setBounds(180, -50, bgImage.getIconWidth(), bgImage.getIconHeight());

        //Text Field
        JLabel promptLbl = new JLabel();
        promptLbl.setText("New Price: ");
        promptLbl.setForeground(Color.WHITE);
        promptLbl.setFont(new Font("Helvetica", Font.BOLD, 15));
        promptLbl.setBounds(180, -20, bgImage.getIconWidth(), bgImage.getIconHeight());

        priceField = new JTextField();
        priceField.setColumns(15);
        priceField.setBounds(270, 230, 210, 30);

        //Buttons
        subButton = new RoundedButton("Submit");
        subButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        subButton.setForeground(Color.WHITE);
        subButton.setBackground(darkGreen);
        subButton.setBounds(375, 290, 100, 35); 
        subButton.setOpaque(true); 
        subButton.setBorder(null);
        subButton.setContentAreaFilled(true); 
        subButton.setCustomBorderColor(Color.WHITE); 
        subButton.setCustomBorderThickness(2);

        exButton = new RoundedButton("Exit");
        exButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        exButton.setForeground(Color.WHITE);
        exButton.setBackground(Color.RED);
        exButton.setBounds(185, 290, 100, 35); 
        exButton.setOpaque(true); 
        exButton.setBorder(null);
        exButton.setContentAreaFilled(true); 
        exButton.setCustomBorderColor(Color.WHITE); 
        exButton.setCustomBorderThickness(2);
        
        //Label for Menu label
        JLabel menuLabel = new JLabel("UPDATE BASE PRICE");
        menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
        menuLabel.setVerticalTextPosition(JLabel.TOP);
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
        menuLabel.setBounds(180, -115, bgImage.getIconWidth(), bgImage.getIconHeight());

        //Layers
        layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
        layeredPane.add(currentPrice, JLayeredPane.POPUP_LAYER);
        layeredPane.add(promptLbl, JLayeredPane.POPUP_LAYER); 
        layeredPane.add(priceField, JLayeredPane.POPUP_LAYER); 
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

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public void addClickListener(ActionListener listener) {
        subButton.addActionListener(listener);
        exButton.addActionListener(listener);
    }

    public String getPrice() {
        return priceField.getText(); 
    }


    
}
