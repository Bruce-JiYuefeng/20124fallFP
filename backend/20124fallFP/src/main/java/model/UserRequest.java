package model;

/**
 * A model class representing the user's login or registration request.
 */
public class UserRequest {
    private String username; // The username provided by the client
    private String password; // The password provided by the client

    // Constructor
    public UserRequest() {}

    public UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
