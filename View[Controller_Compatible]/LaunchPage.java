import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage{
    RoundedButton chButton;
    RoundedButton vhButton;
    RoundedButton mhButton;
    RoundedButton brButton;
    RoundedButton exButton;
    Color darkBlue = new Color(0x15, 0x68, 0xB3);
    Color darkGreen = new Color(0x006937);
    ImageIcon bgImage = new ImageIcon("images/Background.png");
    ImageIcon logoImage = new ImageIcon("images/Logo.png");
   

    public void launchLaunchPage(JFrame mainFrame) {
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
         chButton = new RoundedButton("Create Hotel");
         chButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         chButton.setForeground(Color.WHITE);
         chButton.setBackground(darkBlue);
         chButton.setBounds(235, 205, 180, 40); 
         chButton.setOpaque(true); 
         chButton.setBorder(null);
         chButton.setContentAreaFilled(true); 
         chButton.setCustomBorderColor(Color.WHITE); 
         chButton.setCustomBorderThickness(2);    
 
         vhButton = new RoundedButton("View Hotel");
         vhButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         vhButton.setForeground(Color.WHITE);
         vhButton.setBackground(darkBlue);
         vhButton.setBounds(235, 255, 180, 40); 
         vhButton.setOpaque(true); 
         vhButton.setBorder(null);
         vhButton.setContentAreaFilled(true); 
         vhButton.setCustomBorderColor(Color.WHITE); 
         vhButton.setCustomBorderThickness(2);   
 
         mhButton = new RoundedButton("Manage Hotel");
         mhButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         mhButton.setForeground(Color.WHITE);
         mhButton.setBackground(darkBlue);
         mhButton.setBounds(235, 305, 180, 40); 
         mhButton.setOpaque(true); 
         mhButton.setBorder(null);
         mhButton.setContentAreaFilled(true); 
         mhButton.setCustomBorderColor(Color.WHITE); 
         mhButton.setCustomBorderThickness(2);   
 
         brButton = new RoundedButton("Book a Reservation");
         brButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         brButton.setForeground(Color.WHITE);
         brButton.setBackground(darkBlue);
         brButton.setBounds(235, 355, 180, 40); 
         brButton.setOpaque(true); 
         brButton.setBorder(null);
         brButton.setContentAreaFilled(true); 
         brButton.setCustomBorderColor(Color.WHITE); 
         brButton.setCustomBorderThickness(2);  
 
         exButton = new RoundedButton("Exit");
         exButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
         exButton.setForeground(Color.WHITE);
         exButton.setBackground(Color.RED);
         exButton.setBounds(235, 405, 180, 40); 
         exButton.setOpaque(true); 
         exButton.setBorder(null);
         exButton.setContentAreaFilled(true); 
         exButton.setCustomBorderColor(Color.WHITE); 
         exButton.setCustomBorderThickness(2);  
 
         
         //Label for Menu label
         JLabel menuLabel = new JLabel("Welcome to HotelRS!");
         menuLabel.setHorizontalTextPosition(JLabel.RIGHT);
         menuLabel.setVerticalTextPosition(JLabel.TOP);
         menuLabel.setForeground(Color.WHITE);
         menuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
         menuLabel.setBounds(160, -115, bgImage.getIconWidth(), bgImage.getIconHeight());
 
         //Layers
         layeredPane.add(menuLabel, JLayeredPane.PALETTE_LAYER); 
         layeredPane.add(chButton, JLayeredPane.POPUP_LAYER); 
         layeredPane.add(vhButton, JLayeredPane.POPUP_LAYER);
         layeredPane.add(mhButton, JLayeredPane.POPUP_LAYER);
         layeredPane.add(brButton, JLayeredPane.POPUP_LAYER);
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
        chButton.addActionListener(listener);
        vhButton.addActionListener(listener);
        mhButton.addActionListener(listener);
        brButton.addActionListener(listener);
        exButton.addActionListener(listener);
    }

    public RoundedButton getChButton() {
        return chButton;
    }
    public RoundedButton getVhButton() {
        return vhButton;
    }
    public RoundedButton getMhButton() {
        return mhButton;
    }
    public RoundedButton getBrButton() {
        return brButton;
    }
    public RoundedButton getExButton() {
        return exButton;
    }

}
