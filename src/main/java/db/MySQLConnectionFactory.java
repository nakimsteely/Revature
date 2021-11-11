package db;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory {
    public static Connection getConnection() throws SQLException{
        Connection connection = null;

        DriverManager.registerDriver(new Driver());

        String url = "jdbc:mysql://localhost:3306/tododb";
        String username = "root";
        String password = "Root$1212";

        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
