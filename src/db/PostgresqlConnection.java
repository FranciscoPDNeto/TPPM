package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnection implements DatabaseConnection {

    private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "jdbc:postgresql://127.0.0.1:5432/tp";
    private final static String user = "postgres";
    private final static String pass = "password";

    public PostgresqlConnection() {
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, user, pass);
    }
}
