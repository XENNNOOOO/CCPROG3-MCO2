import java.awt.*;
import javax.swing.*;

public class RoundedButton extends JButton {
    Color darkBlue = new Color(0x15, 0x68, 0xB3);
    private Color customBorderColor;
    private int customBorderThickness;

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false); // Remove default fill
        setFocusPainted(false); // Remove default focus painting
        setOpaque(false); // Make sure button is not opaque
        customBorderColor = Color.WHITE; // Default border color
        customBorderThickness = 2;
    }

    public void setCustomBorderColor(Color color) {
        this.customBorderColor = color;
    }

    public void setCustomBorderThickness(int thickness) {
        this.customBorderThickness = thickness;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(darkBlue); // Set pressed color
        } else {
            g.setColor(getBackground()); // Set default color
        }
        // Draw rounded rectangle
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);

        // Call super method at the end to paint the text
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Draw custom border with specified color and thickness
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(new BasicStroke(customBorderThickness));
        g2.setColor(customBorderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
        g2.dispose();
    }

}
