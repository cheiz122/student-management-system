import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import com.mysql.cj.xdevapi.Result;
//import com.mysql.cj.xdevapi.Statement;

public class delete_student {
    JPanel panel;
    JFrame jf;
    JLabel label1, label2;
    static JTextField textfield1;
    JButton delete, cancel;
    static String reg_no, reg_nos;

    public delete_student() {
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
        label1 = new javax.swing.JLabel("Enter reg_no below to delete");
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

              /*   if (delete()) {
                    
                
                        JOptionPane.showMessageDialog(null, "student successfully deleted");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "the specified student does not exist");
                } */

            }
        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }

    /*private static String check() {

        try {
            Connection con = connection.createc();
            String m = "SELECT reg_no FROM student;";
            // PreparedStatement m1 = con.prepareStatement(m);
            java.sql.Statement m1 = con.createStatement();
            ResultSet Set = m1.executeQuery(m);
            while (Set.next()) {
                reg_nos = Set.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reg_nos;
    } */

    private static boolean delete() {
        boolean f=false;
        try {
            Connection con = connection.createc();

            String q = "DELETE FROM student WHERE reg_no=?; ";

            PreparedStatement psmt = con.prepareStatement(q);
         reg_no=textfield1.getText();
            psmt.setString(1, reg_no);
            psmt.executeUpdate();
                if (psmt != null){
                    JOptionPane.showMessageDialog(null,"The student was not Found", "Error", JOptionPane.ERROR_MESSAGE);
                } 
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public void getcourseInformation() {
        reg_no = textfield1.getText();
    }

    public static void main(String[] args) {
        delete_student m = new delete_student();
        System.out.println(m);
    }
}
