package db;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
  
    private static ConnectionManager singleton;
    private static DatabaseConnection conn;

    private ConnectionManager() {
        ConnectionFactory factory = new ConnectionFactory();
        ConnectionManager.conn = factory.getConnection("postgresql");
    }

    public static ConnectionManager getInstance() {
        if(singleton == null)
            singleton = new ConnectionManager();

        return singleton;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return ConnectionManager.conn.getConnection();
    }
}
