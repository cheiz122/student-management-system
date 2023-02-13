import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class deletecourse {
    JPanel panel;
    JFrame jf;
    JLabel label1, label2;
    JTextField textfield1;
    JButton delete, cancel;
    static String course_code;

    public deletecourse() {
        Components();
    }

    public void Components() {
        jf = new javax.swing.JFrame("Registration Form");
        panel = new javax.swing.JPanel();
        jf.add(panel);
        panel.setBackground(new Color(191, 239, 255));
        panel.setLayout(null);
         jf.setSize(900, 700);
       // jf.show();
           jf.setVisible(true);
        label1 = new javax.swing.JLabel("Enter course code below to delete");
        label1.setFont(new Font("Dialog", Font.ITALIC, 24));
        label1.setBounds(300, 20, 400, 40);
        panel.add(label1);

        label2 = new javax.swing.JLabel("Course_code:");
        label2.setFont(new Font("Dialog", Font.BOLD, 20));
        label2.setBounds(100, 200, 150, 40);
        panel.add(label2);

        textfield1 = new javax.swing.JTextField();
        textfield1.setFont(new Font("Dialog", Font.BOLD, 16));
        textfield1.setBounds(350, 200, 180, 30);
        panel.add(textfield1);

        delete = new javax.swing.JButton("DELETE");
        delete.setFont(new Font("Dialog", Font.BOLD, 16));
        delete.setBounds(400, 260, 100, 30);
        panel.add(delete);

        cancel = new javax.swing.JButton("CANCEL");
        cancel.setFont(new Font("Dialog", Font.BOLD, 16));
        cancel.setBounds(550, 260, 100, 30);
        panel.add(cancel);

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                getcourseInformation();

                delete();
                /*if (result) { 
                    JOptionPane.showMessageDialog(null, "course successfully deleted");
                } else {
                    JOptionPane.showMessageDialog(null, "something came up");
                }
*/
            }
        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }

    private static boolean delete() {
        boolean f = false;
        try {
            Connection con = connection.createc();

            String q = "DELETE FROM course WHERE course_code=?; ";

            PreparedStatement psmt = con.prepareStatement(q);
            
            psmt.setString(1, course_code);
            psmt.executeUpdate();
            if (psmt != null){
                JOptionPane.showMessageDialog(null,"The course was not Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public void getcourseInformation() {
        course_code = textfield1.getText();
        
    }

    public static void main(String[] args) {
        deletecourse m = new deletecourse();
        System.out.println(m);
    }
}
