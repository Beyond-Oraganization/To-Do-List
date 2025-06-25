package GUI;

import javax.swing.*;
import java.awt.*;

public class SidePanelLable extends JLabel {
    Color color = new Color(Color.WHITE.getRGB());

    public SidePanelLable(String text) {
        super(text);
        setForeground(color);
        setFont(new Font("Poppins", Font.BOLD, 20));
        setVerticalAlignment(JLabel.TOP);
    }

    public SidePanelLable() {
        super();
        setForeground(color);
        setFont(new Font("Poppins", Font.PLAIN, 20));
        setVerticalAlignment(JLabel.TOP);
    }
}
