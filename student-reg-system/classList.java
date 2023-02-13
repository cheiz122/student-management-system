import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

public class classList {
    JFrame frame1;
    JLabel l0, l1, l2;
    JComboBox c1;
    JButton b1;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    static JTable table;
    String[] columnNames = { " name",  "gender", "mobilenumber","course_code","reg_no" };
    String from;
    JPanel panel;
    JFrame jf;
    JLabel label1, label2;
    JTextField textfield1;
    JButton class_list, cancel;
    static String course_code;

    public classList() {
        Components();
    }

    public void Components() {
        jf = new javax.swing.JFrame("student information");
        panel = new javax.swing.JPanel();
        jf.add(panel);
        panel.setBackground(new Color(191, 239, 255));
        panel.setLayout(null);
        jf.setSize(900, 700);
        // jf.show();
        jf.setVisible(true);
        label1 = new javax.swing.JLabel("Enter course code below to get a class list");
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

        class_list= new javax.swing.JButton("class_list");
        class_list.setFont(new Font("Dialog", Font.BOLD, 16));
        class_list.setBounds(400, 260, 100, 30);
        panel.add(class_list);

        cancel = new javax.swing.JButton("CANCEL");
        cancel.setFont(new Font("Dialog", Font.BOLD, 16));
        cancel.setBounds(550, 260, 100, 30);
        panel.add(cancel);

        class_list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                getcourseInformation();
               showTableData();
                

            }
        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }

    

    public void getcourseInformation() {
        course_code = textfield1.getText();
    }
    public void showTableData() {
        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        // TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        // DefaultTableModel model = new DefaultTableModel(tm.getData1(),
        // tm.getColumnNames());
        table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // from = (String) c1.getSelectedItem();
        // String textvalue = textbox.getText();

        /*String name = "";
        String email = "";
        String phone = "";
        String gender = "";
        String reg_no = ""; */
        try {
            Connection con = connection.createc();

            String q = "SELECT *  FROM student where course_code= '?' ";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            int i=0;
            if (set.next()) {
                String name = set.getString("name");
               // String email = set.getString("email");
                String gender = set.getString("gender");
                String phone = set.getString("mobilenumber");
                String reg_no=set.getString("reg_no");
                String course_code=set.getString("course_code");

                model.addRow(new Object[] { name,  gender, phone,reg_no,course_code });
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i >= 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
    }
    public static void main(String[] args) {
        classList m = new classList();
        System.out.println(m);
    }
}
