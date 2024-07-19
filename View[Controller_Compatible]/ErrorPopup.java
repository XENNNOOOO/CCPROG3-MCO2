import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorPopup extends JFrame{
    RoundedButton okButton;
    Color darkGreen = new Color(0x006937);
    ImageIcon logoImage = new ImageIcon("images/Logo.png");
   

    public void launchErrorPopup(ImageIcon errorImage) {
         //Panel for errorImage
         JPanel backgroundPanel = new JPanel() {
             @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 g.drawImage(errorImage.getImage(), 0, 0, getWidth(), getHeight(), this);
             }
         };
         backgroundPanel.setPreferredSize(new Dimension(errorImage.getIconWidth(), errorImage.getIconHeight()));
 
         //Layeredpane for texts and buttons
         JLayeredPane layeredPane = new JLayeredPane();
         layeredPane.setPreferredSize(new Dimension(errorImage.getIconWidth(), errorImage.getIconHeight()));
 
         //Buttons
         okButton = new RoundedButton("Okay");
         okButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
         okButton.setForeground(Color.WHITE);
         okButton.setBackground(darkGreen);
         okButton.setBounds(170, 130, 70, 20); 
         okButton.setOpaque(true); 
         okButton.setBorder(null);
         okButton.setContentAreaFilled(true); 
         okButton.setCustomBorderColor(Color.WHITE); 
         okButton.setCustomBorderThickness(2);    
         
         
         //Layers
         layeredPane.add(okButton, JLayeredPane.POPUP_LAYER); 
         
         okButton.addActionListener(e -> {
            this.dispose();
        });

 
         //JFrame
         this.setTitle("Error");
         this.setSize(280, 200);
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

    

}
