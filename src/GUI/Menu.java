package GUI;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JList ListTask;

    public Menu() {
        setTitle("To Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        ImageIcon image = new ImageIcon("res/logo.png");
        setIconImage(image.getImage());
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(0xfefae0));

        SidePanelLable sidePanelLable = new SidePanelLable("Menu");

        SidePanel sidePanel = new SidePanel();
        sidePanel.add(sidePanelLable, BorderLayout.WEST);
        add(sidePanel, BorderLayout.WEST);
        add(new SidePanel(), BorderLayout.EAST);

        setVisible(true);
    }
}
