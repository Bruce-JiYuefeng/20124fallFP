package dao;

import config.DatabaseConfig;

import java.sql.*;

/**
 * Data Access Object (DAO) class to interact with the MySQL database for user-related operations.
 */
public class UserDao {

    /**
     * Retrieves the password associated with a username.
     *
     * @param username The username to query.
     * @return The password if the username exists, otherwise null.
     */
    public String getPasswordByUsername(String username) {
        String query = "SELECT password FROM users WHERE username = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Checks if a username already exists in the database.
     *
     * @param username The username to check.
     * @return True if the username exists, otherwise false.
     */
    public boolean isUsernameExists(String username) {
        String query = "SELECT 1 FROM users WHERE username = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Saves a new user into the database.
     *
     * @param username The username to save.
     * @param password The password to save.
     * @return True if the operation is successful, otherwise false.
     */
    public boolean saveUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
