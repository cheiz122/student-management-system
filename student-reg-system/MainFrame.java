

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
//import java.awt.*;

public class MainFrame extends JFrame {

    public void initializer(User user) {
        JPanel infopanel = new JPanel();
        infopanel.setLayout(new GridLayout(0, 2, 5, 5));

        infopanel.add(new JLabel("username"));
        infopanel.add(new JLabel(user.username));
        infopanel.add(new JLabel("password"));
        infopanel.add(new JLabel(user.password));

        add(infopanel, BorderLayout.NORTH);
        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
    
