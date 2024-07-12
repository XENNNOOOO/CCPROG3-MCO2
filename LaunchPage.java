import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage extends JFrame implements ActionListener{
    RoundedButton chButton;
    RoundedButton vhButton;
    RoundedButton mhButton;
    RoundedButton brButton;
    RoundedButton exButton;
    Color darkBlue = new Color(0x15, 0x68, 0xB3);
    Color darkGreen = new Color(0x006937);
    ImageIcon bgImage = new ImageIcon("images/Background.png");
    ImageIcon logoImage = new ImageIcon("images/Logo.png");
   

    public void launchLaunchPage() {
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
 
         //Button ActionListener
         chButton.addActionListener(this);
         vhButton.addActionListener(this);
         mhButton.addActionListener(this);
         brButton.addActionListener(this);
         exButton.addActionListener(this);
 
         
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
         this.setTitle("Hotel Reservation System");
         this.setSize(660, 530);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);
         this.setIconImage(logoImage.getImage());
 
         //backgroundPanel and layeredPane on JFrame
         this.setContentPane(backgroundPanel);
         this.getContentPane().setLayout(new BorderLayout());
         this.getContentPane().add(layeredPane, BorderLayout.CENTER);
 
         this.setLocationRelativeTo(null); // Center JFrame on screen
         this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if(click.getSource() == chButton) {
            CreateHotelPage createHotel = new CreateHotelPage();
            createHotel.launchCreateHotelPage(this);
        }
        else if (click.getSource() == vhButton) {
            ViewHotelPage viewHotel = new ViewHotelPage();
            viewHotel.launchViewHotelPage(this);
        }
        else if (click.getSource() == mhButton) {
            ManageHotelPage manageHotel = new ManageHotelPage();
            manageHotel.launchManageHotelPage(this);
        }
        else if (click.getSource() == brButton) {
            BookReservationPage brp = new BookReservationPage();
            brp.launchBookReservationPage(this);
        }
        else if (click.getSource() == exButton) {
            this.dispose(); //closes the JFrame
        }
    }

}
