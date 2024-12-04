package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Configuration class to manage MySQL database connections.
 */
public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/UserDB";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * Establishes and returns a connection to the database.
     *
     * @return A Connection object for database interaction.
     * @throws SQLException If there is an error connecting to the database.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
