
package hotel.management.system;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {
    Connection connection;
    Statement statement;

    public Connection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS", "root", "MySQL@123");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
