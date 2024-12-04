package services;

import dao.UserDao;

/**
 * Service layer for handling business logic related to user login and registration.
 */
public class UserService {
    private final UserDao userDao = new UserDao(); // Data Access Layer instance

    /**
     * Validates a user's credentials by comparing input with database records.
     *
     * @param username The username provided by the user.
     * @param password The password provided by the user.
     * @return True if the credentials are valid, otherwise false.
     */
    public boolean validateUser(String username, String password) {
        String storedPassword = userDao.getPasswordByUsername(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    /**
     * Registers a new user by ensuring the username is unique and storing their details.
     *
     * @param username The username provided by the user.
     * @param password The password provided by the user.
     * @return True if registration is successful, otherwise false.
     */
    public boolean registerUser(String username, String password) {
        if (userDao.isUsernameExists(username)) {
            return false; // Username already exists
        }
        return userDao.saveUser(username, password);
    }
}
