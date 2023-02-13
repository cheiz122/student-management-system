import java.sql.Connection;
import java.sql.DriverManager;
public class connection {
    static Connection con=null;
    public static Connection createc(){
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String user="chegep122";
            String password="root";
            String url=("jdbc:mysql://localhost/std_reg_system");
            
            
   con=DriverManager.getConnection(url,password,user);
   System.out.println("connected successfully");
        } catch (Exception e) {
           e.printStackTrace(); 
        }
        return con;
    }

}
