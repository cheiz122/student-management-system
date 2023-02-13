import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
//import java.sql.*;
//import java.util.*;
import java.sql.PreparedStatement;

public class updatestudent_info {

    JLabel label1, label2, label3, label4, label5, label6,
            label7, label8, label9, label10, label11, label12, label13,s1, s2, s3;
    JPanel panel;
    JFrame jf;
    JButton register;
    JTextField textfield1, textfield2, textfield3, textfield4a,
            textfield4b, textfield4c, textfield5, textfield6, textfield7, textfield8, 
            textfield9,textfield10;
    JPasswordField passwordfield1;
    JRadioButton radiobutton2, radiobutton3,radioButton4,radioButton5,radioButton6,radioButton7;
    JButton cancel;
    String name, gender, dob1, dob2, dob, dobb, reg_no,
            mobileNumber, email, area, county, nationality,course_code;
    JComboBox combobox1;

    int index, count;

    public updatestudent_info() {
        
        initComponents();
        

    }

public void initComponents() {
jf=new javax.swing.JFrame("Registration Form");
panel=new javax.swing.JPanel();
jf.add(panel);
panel.setBackground(new Color(191,239,255));
panel.setLayout(null);
jf.setSize(970,700);
jf.setVisible(true);
//jf.show();

label1=new javax.swing.JLabel("Registration Form");
label1.setFont(new Font("Dialog", Font.ITALIC, 24));
label1.setBounds(300,20,400,40);
panel.add(label1);

label2=new javax.swing.JLabel("Name");
label2.setFont(new Font("Dialog", Font.BOLD, 20));
label2.setBounds(100,80,150,40);
panel.add(label2);

label3=new javax.swing.JLabel("Gender");
label3.setFont(new Font("Dialog", Font.BOLD, 20));
label3.setBounds(100,160,150,40);
panel.add(label3);

label4=new javax.swing.JLabel("Reg_no");
label4.setFont(new Font("Dialog", Font.BOLD, 20));
label4.setBounds(100,240,150,40);
panel.add(label4);
 

label5=new javax.swing.JLabel("Date Of Birth");
label5.setFont(new Font("Dialog", Font.BOLD, 20));
label5.setBounds(100,320,150,40);
panel.add(label5); 

label6=new javax.swing.JLabel("Mobile Number");
label6.setFont(new Font("Dialog", Font.BOLD, 20));
label6.setBounds(100,400,150,40);
panel.add(label6);

label7=new javax.swing.JLabel("E-mail");
label7.setFont(new Font("Dialog", Font.BOLD, 20));
label7.setBounds(100,480,150,40);
panel.add(label7);

textfield1=new javax.swing.JTextField();
textfield1.setFont(new Font("Dialog", Font.BOLD, 16));
textfield1.setBounds(350,80,400,30);
panel.add(textfield1);

label10=new javax.swing.JLabel("Male");
label10.setFont(new Font("Dialog", Font.BOLD, 20));
label10.setBounds(350,160,60,40);
panel.add(label10);

label11=new javax.swing.JLabel("Female");
label11.setFont(new Font("Dialog", Font.BOLD, 20));
label11.setBounds(460,160,100,40);
panel.add(label11);


label13=new javax.swing.JLabel("course_code");
label13.setFont(new Font("Dialog", Font.BOLD, 20));
label13.setBounds(100,560,150,40);
panel.add(label13);



radiobutton2=new javax.swing.JRadioButton();
radiobutton2.setFont(new Font("Dialog", Font.BOLD, 16));
radiobutton2.setBounds(420,160,20,30);
panel.add(radiobutton2);

radiobutton3=new javax.swing.JRadioButton();
radiobutton3.setFont(new Font("Dialog", Font.BOLD, 16));
radiobutton3.setBounds(570,160,20,30);
panel.add(radiobutton3);

ButtonGroup jb = new ButtonGroup();
jb.add(radiobutton2);
jb.add(radiobutton3);

textfield3=new javax.swing.JTextField();
textfield3.setFont(new Font("Dialog", Font.BOLD, 16));
textfield3.setBounds(350,240,400,30);
panel.add(textfield3);

textfield4a=new javax.swing.JTextField();
textfield4a.setFont(new Font("Dialog", Font.BOLD, 16));
textfield4a.setBounds(350,320,400,30);
panel.add(textfield4a);
/* 
s1=new javax.swing.JLabel("/");
s1.setFont(new Font("Dialog", Font.BOLD, 16));
s1.setBounds(400,260,20,30);
panel.add(s1); *

textfield4b=new javax.swing.JTextField();
textfield4b.setFont(new Font("Dialog", Font.BOLD, 16));
textfield4b.setBounds(430,260,40,30);
panel.add(textfield4b);
/* 
s2=new javax.swing.JLabel("/");
s2.setFont(new Font("Dialog", Font.BOLD, 16));
s2.setBounds(480,260,20,30);
panel.add(s2); 

textfield4c=new javax.swing.JTextField();
textfield4c.setFont(new Font("Dialog", Font.BOLD, 16));
textfield4c.setBounds(510,260,100,30);
panel.add(textfield4c);

s3=new javax.swing.JLabel("DD/MM/YYYY");
s3.setFont(new Font("Dialog", Font.BOLD, 16));
s3.setBounds(620,260,150,30);
panel.add(s3); */

textfield5=new javax.swing.JTextField();
textfield5.setFont(new Font("Dialog", Font.BOLD, 16));
textfield5.setBounds(350,400,400,30);
panel.add(textfield5);

textfield6=new javax.swing.JTextField();
textfield6.setFont(new Font("Dialog", Font.BOLD, 16));
textfield6.setBounds(350,480,400,30);
panel.add(textfield6);
/* 
textfield7=new javax.swing.JTextField();
textfield7.setFont(new Font("Dialog", Font.BOLD, 16));
textfield7.setBounds(350,440,400,30);
panel.add(textfield7);

textfield8=new javax.swing.JTextField();
textfield8.setFont(new Font("Dialog", Font.BOLD, 16));
textfield8.setBounds(350,500,400,30);
panel.add(textfield8); 

textfield9=new javax.swing.JTextField();
textfield9.setFont(new Font("Dialog", Font.BOLD, 16));
textfield9.setBounds(350,560,400,30);
panel.add(textfield9); */

 textfield10 = new javax.swing.JTextField();
textfield10.setFont(new Font("Dialog", Font.BOLD, 16));
textfield10.setBounds(350,560,400,30);
panel.add(textfield10);

register = new javax.swing.JButton("Register");
register.setFont(new Font("Dialog", Font.BOLD, 16));
register.setBounds(250,660,100,30);
panel.add(register);

cancel = new javax.swing.JButton("cancel");
cancel.setFont(new Font("Dialog", Font.BOLD, 16));
cancel.setBounds(450,660,100,30);
panel.add(cancel);


combobox1 = new JComboBox();
combobox1.setBounds(350,500,180,30);
register.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent event)
{
boolean f=update_info();
if(f){
    JOptionPane.showMessageDialog(null, "Student Data Updated");  
}
else{
    JOptionPane.showMessageDialog(null, "something came up"); 
}

}});
}
public boolean update_info(){
    boolean f=false;
    try 
               {
                Connection con = connection.createc();
                   String q = ("UPDATE student SET name= '?',course_code= '?',gender= '?',mobilenumber= '?',email= '?' WHERE reg_no = '?'");
                   PreparedStatement psmt = con.prepareStatement(q);
                   reg_no=textfield1.getText();
                   if (psmt == null){
                    JOptionPane.showMessageDialog(null,"The Student was not Found", "Error", JOptionPane.ERROR_MESSAGE);
                   }
                   psmt.setString(1, reg_no);
                   psmt.setString(2, name);
                   psmt.setString(3, course_code);
                   psmt.setString(4, gender);
                   psmt.setString(5, mobileNumber);
                   psmt.setString(6, email);

                   psmt.executeUpdate();
                   f=true;
                } 
            catch (Exception e) 
                {
                     e.printStackTrace();;
                }
                return f;
}
public static void main(String[] args) {
    updatestudent_info student=new updatestudent_info();
    System.out.println(student);
}}