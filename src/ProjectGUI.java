import javax.swing.*;
import java.awt.*;

public class ProjectGUI extends JFrame {
    private JList ListTask;

    public ProjectGUI() {
        this.setTitle("To Do List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        ImageIcon image = new ImageIcon("res/logo.png");
        this.setIconImage(image.getImage());

        this.getContentPane().setBackground(new Color(107, 107, 107));

        JLabel label = new JLabel("To Do List");
        JPanel panel = new JPanel();
        panel.add(label);
        this.add(panel);

        this.setVisible(true);
    }
}
