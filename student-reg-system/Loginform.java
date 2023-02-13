

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Loginform extends JFrame {
    // final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);

    JTextField tfusername;
    JPasswordField pfPassword;
String passwordl,usernamel;
    public void initialize() {
        JLabel lbloginform = new JLabel("login form", SwingConstants.CENTER);
        // lbloginform.setFont(mainFont);
        JLabel lbusername = new JLabel("username");
        // lbusername.setFont(mainFont);

        tfusername = new JTextField();
        // tfusername.setFont(mainFont);

        JLabel lbpassword = new JLabel("password");
        // lbpassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        // pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.add(lbloginform);
        formPanel.add(lbusername);
        formPanel.add(tfusername);
        formPanel.add(lbpassword);
        formPanel.add(pfPassword);

        JButton btnlogin = new JButton("login");
        // btnlogin.setFont(mainFont);
        btnlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
            String password = String.valueOf(pfPassword.getPassword());
              /*  if(passwordl==password & username==usernamel){
                myframe myframe=new myframe();
                System.out.println(myframe);
                dispose();
               }*/
                User user = getAuthenticateduser(username, password);
                /*if(usernamel==User.username & passwordl==User.password){
                    myframe myframe=new myframe();
                    System.out.println(myframe);
                    dispose();
                } */
                if (user != null) {

                    myframe myframe=new myframe();
                    System.out.println(myframe);
                    dispose();

                }  else {
                    JOptionPane.showMessageDialog(Loginform.this, "username or password invalid",
                            "try again", JOptionPane.ERROR_MESSAGE);

                }
            }

        });

        JButton btncancel = new JButton("cancel");
        // btncancel.setFont(mainFont);
        btncancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();

            }

        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.add(btnlogin);
        buttonsPanel.add(btncancel);

        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("login form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private User getAuthenticateduser(String username, String password) {
        User user = null;
        try {
            Connection con=connection.createc();

            String q = "SELECT *  FROM users; ";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            if (set.next()) {
                user = new User();
                user.username = set.getString("username");
                 user.password = set.getString("password");

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return user;

    }

    public static void main(String[] args) {

        Loginform loginform = new Loginform();
        loginform.initialize();
    }
}
