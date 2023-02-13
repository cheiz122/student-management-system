
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class units {

    JPanel panel;
    JFrame jf;
    JButton register;
    JLabel label1, label2, label3, label4, label5, label6, label7;
    JTextField textfield1, textfield2, textfield3, textfield4a,
            textfield4b, textfield4c, textfield5, textfield6, textfield7, textfield8,
            textfield9, textfield10;
    JPasswordField passwordfield1;
    JRadioButton radiobutton2, radiobutton3, radioButton4, radioButton5, radioButton6, radioButton7;
    JButton cancel;
    String name, gender, dob1, dob2, dob, dobb, reg_no,
            mobileNumber, email, area, county, nationality, course_code;
    // JComboBox combobox1;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    String unit_name, unit_name1, unit_name2, unit_name3, unit_name4, unit_name5;
    String unit_code, unit_code1, unit_code2, unit_code3, unit_code4, unit_code5;
    int index, count;

    public units() {

        initComponents();

    }

    public void initComponents() {
        jf = new javax.swing.JFrame("Registration Form");
        panel = new javax.swing.JPanel();
        jf.add(panel);
        panel.setBackground(new Color(91, 239, 255));
        panel.setLayout(null);
        jf.setSize(970, 700);
        jf.setVisible(true);
        // jf.show();

        label1 = new javax.swing.JLabel("Units Registration");
        label1.setFont(new Font("Dialog", Font.ITALIC, 24));
        label1.setBounds(540, 0, 400, 40);
        panel.add(label1);

        label2 = new javax.swing.JLabel("Unit  Name");
        label2.setFont(new Font("Dialog", Font.BOLD, 40));
        label2.setBounds(300, 30, 350, 60);
        panel.add(label2);

        label2 = new javax.swing.JLabel("Unit  Code");
        label2.setFont(new Font("Dialog", Font.BOLD, 40));
        label2.setBounds(900, 30, 350, 60);
        panel.add(label2);

        checkBox1 = new javax.swing.JCheckBox("Components Development");
        checkBox1.setFont(new Font("Dialog", Font.ITALIC, 24));
        checkBox1.setBounds(100, 100, 650, 60);
        panel.add(checkBox1);

        label2 = new javax.swing.JLabel("SOEN303");
        label2.setFont(new Font("Dialog", Font.BOLD, 24));
        label2.setBounds(900, 100, 350, 60);
        panel.add(label2);

        checkBox2 = new javax.swing.JCheckBox("Computer Security");
        checkBox2.setFont(new Font("Dialog", Font.ITALIC, 24));
        checkBox2.setBounds(100, 180, 650, 60);
        panel.add(checkBox2);

        label3 = new javax.swing.JLabel("SOEN311");
        label3.setFont(new Font("Dialog", Font.BOLD, 24));
        label3.setBounds(900, 180, 350, 60);
        panel.add(label3);

        checkBox3 = new javax.swing.JCheckBox("Object Oriented Using Java(II)");
        checkBox3.setFont(new Font("Dialog", Font.ITALIC, 24));
        checkBox3.setBounds(100, 260, 650, 60);
        panel.add(checkBox3);

        label4 = new javax.swing.JLabel("SOEN305");
        label4.setFont(new Font("Dialog", Font.BOLD, 24));
        label4.setBounds(900, 260, 350, 60);
        panel.add(label4);

        checkBox4 = new javax.swing.JCheckBox("Introduction to Data Structures and Algorithims");
        checkBox4.setFont(new Font("Dialog", Font.ITALIC, 24));
        checkBox4.setBounds(100, 340, 650, 60);
        panel.add(checkBox4);

        label5 = new javax.swing.JLabel("SOEN301");
        label5.setFont(new Font("Dialog", Font.BOLD, 24));
        label5.setBounds(900, 340, 350, 60);
        panel.add(label5);

        checkBox5 = new javax.swing.JCheckBox("System Development and Desighn");
        checkBox5.setFont(new Font("Dialog", Font.ITALIC, 24));
        checkBox5.setBounds(100, 420, 650, 60);
        panel.add(checkBox5);

        label6 = new javax.swing.JLabel("SOEN370");
        label6.setFont(new Font("Dialog", Font.BOLD, 24));
        label6.setBounds(900, 420, 350, 60);
        panel.add(label6);

        checkBox6 = new javax.swing.JCheckBox("Introduction to Mobile Programing");
        checkBox6.setFont(new Font("Dialog", Font.ITALIC, 24));
        checkBox6.setBounds(100, 500, 650, 60);
        panel.add(checkBox6);

        label7 = new javax.swing.JLabel("SOEN350");
        label7.setFont(new Font("Dialog", Font.BOLD, 24));
        label7.setBounds(900, 500, 350, 60);
        panel.add(label7);

        

        register = new javax.swing.JButton("Register");
        register.setFont(new Font("Dialog", Font.BOLD, 16));
        register.setBounds(250, 660, 100, 30);
        panel.add(register);

        cancel = new javax.swing.JButton("cancel");
        cancel.setFont(new Font("Dialog", Font.BOLD, 16));
        cancel.setBounds(450, 660, 100, 30);
        panel.add(cancel);

        // combobox1 = new JComboBox();
        // combobox1.setBounds(350,500,180,30);
        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                Boolean f = addUnits();
                if (f) {
                    JOptionPane.showMessageDialog(null, "Units Registered succesfully");
                } else {
                    JOptionPane.showMessageDialog(null, "something came up");
                }
            }

        });

    }

    public boolean addUnits() {
        boolean f = false;
        try {
            Connection con = connection.createc();
            String q = "INSERT INTO units VALUES (?,?);";
            if (checkBox1.isSelected()) {
                unit_name = checkBox1.getText();
                unit_code = label2.getText();

                PreparedStatement psmt = con.prepareStatement(q);
                psmt.setString(1, unit_name);
                psmt.setString(2, unit_code);
                psmt.executeUpdate();

            }
            if (checkBox2.isSelected()) {
                unit_name1 = checkBox2.getText();
                unit_code1 = label3.getText();

                PreparedStatement ysmt = con.prepareStatement(q);
                ysmt.setString(1, unit_name1);
                ysmt.setString(2, unit_code1);

                ysmt.executeUpdate();

            }
            if (checkBox3.isSelected()) {
                unit_name2 = checkBox3.getText();
                unit_code2 = label4.getText();
                PreparedStatement xsmt = con.prepareStatement(q);
                xsmt.setString(1, unit_name2);
                xsmt.setString(2, unit_code2);
                xsmt.executeUpdate();

            }
            if (checkBox4.isSelected()) {
                unit_name3 = checkBox4.getText();
                unit_code3 = label5.getText();
                PreparedStatement csmt = con.prepareStatement(q);
                csmt.setString(1, unit_name3);
                csmt.setString(2, unit_code3);
                csmt.executeUpdate();
            }
            if (checkBox5.isSelected()) {
                unit_name4 = checkBox5.getText();
                unit_code4 = label6.getText();
                PreparedStatement zsmt = con.prepareStatement(q);
                zsmt.setString(1, unit_name4);
                zsmt.setString(2, unit_code4);
                zsmt.executeUpdate();

            }
            if (checkBox6.isSelected()) {
                unit_name5 = checkBox6.getText();
                unit_code5 = label5.getText();
                PreparedStatement fsmt = con.prepareStatement(q);
                fsmt.setString(1, unit_name5);
                fsmt.setString(2, unit_code5);
                fsmt.executeUpdate();

            }
            f = true;
        } catch (Exception e) {

        }
        return f;
    }

    public static void main(String[] args) {
        units unit = new units();
        unit.initComponents();
    }

}