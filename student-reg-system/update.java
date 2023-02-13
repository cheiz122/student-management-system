import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
//import com.mysql.cj.xdevapi.Result;
//import com.mysql.cj.xdevapi.Statement;

public class update {
    JPanel panel;
    JFrame jf;
    JLabel label1, label2;
    JTextField textfield1;
    JButton update, cancel;
    static String reg_no, reg_nos, name, email, course_code, gender, mobileNumber;

    public update() {
        Components();
    }

    public void Components() {
        jf = new javax.swing.JFrame("Remove students");
        panel = new javax.swing.JPanel();
        jf.add(panel);
        panel.setBackground(new Color(191, 239, 255));
        panel.setLayout(null);
        jf.setSize(900, 700);
        // jf.show();
        jf.setVisible(true);
        label1 = new javax.swing.JLabel("Enter reg_no below to update");
        label1.setFont(new Font("Dialog", Font.ITALIC, 24));
        label1.setBounds(300, 20, 400, 40);
        panel.add(label1);

        label2 = new javax.swing.JLabel("Reg_no:");
        label2.setFont(new Font("Dialog", Font.BOLD, 20));
        label2.setBounds(100, 200, 150, 40);
        panel.add(label2);

        textfield1 = new javax.swing.JTextField();
        textfield1.setFont(new Font("Dialog", Font.BOLD, 16));
        textfield1.setBounds(350, 200, 180, 30);
        panel.add(textfield1);

        update = new javax.swing.JButton("DELETE");
        update.setFont(new Font("Dialog", Font.BOLD, 16));
        update.setBounds(400, 260, 100, 30);
        panel.add(update);

        cancel = new javax.swing.JButton("CANCEL");
        cancel.setFont(new Font("Dialog", Font.BOLD, 16));
        cancel.setBounds(550, 260, 100, 30);
        panel.add(cancel);

        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // updatestudent_info student=new updatestudent_info();
                // System.out.println(student);
                try {
                    Connection con = connection.createc();
                    String q = ("select * from student where reg_no= ? ");
                    PreparedStatement psmt = con.prepareStatement(q);
                    reg_no = textfield1.getText();
                    if(psmt == null){
        
                JOptionPane.showMessageDialog(null,"The coursestudent was not Found", "Error", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    else {
                        String w = ("UPDATE student SET name= ?,course_code= ?,gender= ?,mobilenumber= ?,email= ? WHERE reg_no = '?'");
                        PreparedStatement csmt = con.prepareStatement(w);
                       // updatestudent_info student2 = new updatestudent_info();
                        //System.out.println(student2);
                    
                    csmt.setString(1, name);
                    csmt.setString(2, course_code);
                    csmt.setString(3, gender);
                    csmt.setString(4, mobileNumber);
                    csmt.setString(5, email);
                    
                    } 
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    ;
                }

            }

        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        update m = new update();
        System.out.println(m);
    }
}
