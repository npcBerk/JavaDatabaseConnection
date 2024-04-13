package db.operations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    public static Connection connection = null;

    

    public static Connection getConnection() {
        if (connection == null) {
            try {
                //This section must be rearranged
                String url = "jdbc:postgresql://localhost:5432/netflixDatabase";
                String username = "postgres";
                String password = "Password1";

                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    
}