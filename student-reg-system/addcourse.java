import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class addcourse {
    private String course_code;
    private String id;
    private String dept_code;
    private String course_name;
    JTextField textfield1, textfield2, textfield3, textfield4;
    JLabel label1, label2, label3, label4, label5;
    JButton add, cancel;
    JPanel panel;
    JFrame jf;

    public addcourse() {
        component();
    }

    private void component() {
        jf = new javax.swing.JFrame("add course Form");
        panel = new javax.swing.JPanel();
        jf.add(panel);
        panel.setBackground(new Color(191, 239, 255));
        panel.setLayout(null);
         jf.setSize(900, 700);
        //jf.show();
        jf.setVisible(true);
        label1 = new javax.swing.JLabel("Enter course details to add course to database");
        label1.setFont(new Font("Dialog", Font.ITALIC, 24));
        label1.setBounds(300, 20, 400, 40);
        panel.add(label1);

        label2 = new javax.swing.JLabel("course_code");
        label2.setFont(new Font("Dialog", Font.BOLD, 20));
        label2.setBounds(100, 80, 150, 40);
        panel.add(label2);

        label3 = new javax.swing.JLabel("course_name");
        label3.setFont(new Font("Dialog", Font.BOLD, 20));
        label3.setBounds(100, 170, 150, 40);
        panel.add(label3);

        label4 = new javax.swing.JLabel("course_id");
        label4.setFont(new Font("Dialog", Font.BOLD, 20));
        label4.setBounds(100, 260, 150, 40);
        panel.add(label4);

        label5 = new javax.swing.JLabel("dept_code");
        label5.setFont(new Font("Dialog", Font.BOLD, 20));
        label5.setBounds(100, 350, 150, 40);
        panel.add(label5);

        textfield1 = new javax.swing.JTextField();
        textfield1.setFont(new Font("Dialog", Font.BOLD, 16));
        textfield1.setBounds(350, 80, 180, 30);
        panel.add(textfield1);

        textfield2 = new javax.swing.JTextField();
        textfield2.setFont(new Font("Dialog", Font.BOLD, 16));
        textfield2.setBounds(350, 170, 180, 30);
        panel.add(textfield2);

        textfield3 = new javax.swing.JTextField();
        textfield3.setFont(new Font("Dialog", Font.BOLD, 16));
        textfield3.setBounds(350, 260, 180, 30);
        panel.add(textfield3);

        textfield4 = new javax.swing.JTextField();
        textfield4.setFont(new Font("Dialog", Font.BOLD, 16));
        textfield4.setBounds(350, 350, 180, 30);
        panel.add(textfield4);

        add = new javax.swing.JButton("Add course");
        add.setFont(new Font("Dialog", Font.BOLD, 16));
        add.setBounds(300, 400, 100, 30);
        panel.add(add);

        cancel = new javax.swing.JButton("cancel");
        cancel.setFont(new Font("Dialog", Font.BOLD, 16));
        cancel.setBounds(500, 400, 100, 30);
        panel.add(cancel);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                getcourseinformation();
                boolean result = add();
                if (result) {
                    JOptionPane.showMessageDialog(null, "course added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "something occured");
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }

    private boolean add() {
        boolean f = false;
        try {
            Connection con = connection.createc();

            String q = "INSERT INTO course VALUES (?,?,?,?);";

            PreparedStatement psmt = con.prepareStatement(q);

            psmt.setString(1, id);
            psmt.setString(2, course_code);
            psmt.setString(3, course_name);
            psmt.setString(4, dept_code);

            psmt.executeUpdate();
        f=true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public void getcourseinformation() {
        course_code = textfield1.getText();
        course_name = textfield2.getText();
        id = textfield3.getText();
        dept_code = textfield4.getText();
    }

    public static void main(String[] args) {
        addcourse course = new addcourse();
    }
}
