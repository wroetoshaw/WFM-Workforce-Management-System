
package employee.management.system;
import java.sql.*;


public class Conn {
    
    private final String uRL = "jdbc:mysql:///employee";
    private final String admin = "root";
    private final String password = "VhxY916&";

    
    Connection conn;
    Statement statement;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(uRL, admin, password);
            statement = conn.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
