package db;

public class ConnectionFactory {
    
    public DatabaseConnection getConnection(String connectionType) {
        if (connectionType.equals("postgresql")) {
            return new PostgresqlConnection();
        }
        return null;    
    }
}
