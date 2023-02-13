import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class std_info extends JFrame implements ActionListener {
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
    String[] columnNames = { " name",  "gender", "mobilenumber","course_code","reg_no","email" };
    String name,email,phone,gender,reg_no,course_code;

    std_info() {
        l0 = new JLabel("Fatching student Information");
        l0.setForeground(Color.red);
        l0.setFont(new Font("Serif", Font.BOLD, 20));
        // l1 = new JLabel("Select name");
        b1 = new JButton("submit");
        l0.setBounds(100, 50, 350, 40);
        // l1.setBounds(75, 110, 75, 20);
        b1.setBounds(150, 150, 150, 20);
        b1.addActionListener(this);
        setTitle("Fetching Student Info From DataBase");
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(l0);
        // add(l1);;
        add(b1);

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                showTableData();
                
            }

        });
    }

    public void showTableData() {
        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        // TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(),
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

            String q = "SELECT  *   FROM student; ";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            int i=0;
            while(set.next()) {
                name = set.getString("name");
                email = set.getString("email");
                gender = set.getString("gender");
                 phone = set.getString("mobilenumber");
                 reg_no=set.getString("reg_no");
                 course_code=set.getString("course_code");

                model.addRow(new Object[] { name,  gender, phone,reg_no,course_code,email });
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null,"No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            if (i >= 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }

        }}
        catch (Exception e) {
            e.printStackTrace();
        }

        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
    }

    
            
    

    public static void main(String args[]) {
        new std_info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showTableData();

    }
}
