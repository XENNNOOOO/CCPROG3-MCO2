import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {
    Color darkBlue = new Color(0x15, 0x68, 0xB3);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int arcSize = 20; // Adjust the curve radius here

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create rounded rectangle shape
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, arcSize, arcSize);
        g2d.setColor(Color.WHITE);
        g2d.fill(roundedRectangle);

        g2d.setColor(darkBlue);
        g2d.draw(roundedRectangle);

        g2d.dispose();
    }
}
