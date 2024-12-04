package controller;

import com.google.gson.Gson;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Servlet to handle login and registration requests.
 * Handles POST requests to /login and /register endpoints.
 */
@WebServlet(urlPatterns = {"/login", "/register"})
public class LoginRegisterServlet extends HttpServlet {
    private final UserService userService = new UserService(); // Business logic layer instance

    /**
     * Handles POST requests for login and registration.
     *
     * @param req  HttpServletRequest from the client
     * @param resp HttpServletResponse to the client
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath(); // Determine if the request is for login or register
        BufferedReader reader = req.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;

        // Read JSON data from the request body
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }

        // Parse JSON request into UserRequest object
        Gson gson = new Gson();
        UserRequest userRequest = gson.fromJson(requestBody.toString(), UserRequest.class);

        // Determine action based on endpoint path
        String responseMessage;
        if ("/login".equals(path)) {
            responseMessage = handleLogin(userRequest);
        } else if ("/register".equals(path)) {
            responseMessage = handleRegister(userRequest);
        } else {
            responseMessage = "{\"status\": \"error\", \"message\": \"Invalid endpoint\"}";
        }

        // Send JSON response back to the client
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(responseMessage);
    }

    /**
     * Handles login requests by validating the user's credentials.
     *
     * @param userRequest Contains the username and password from the client.
     * @return JSON response indicating success or failure.
     */
    private String handleLogin(UserRequest userRequest) {
        boolean isValid = userService.validateUser(userRequest.getUsername(), userRequest.getPassword());
        if (isValid) {
            return "{\"status\": \"success\", \"message\": \"Login successful\"}";
        } else {
            return "{\"status\": \"error\", \"message\": \"Invalid username or password\"}";
        }
    }

    /**
     * Handles registration requests by checking and saving user details.
     *
     * @param userRequest Contains the username and password from the client.
     * @return JSON response indicating success or failure.
     */
    private String handleRegister(UserRequest userRequest) {
        boolean isRegistered = userService.registerUser(userRequest.getUsername(), userRequest.getPassword());
        if (isRegistered) {
            return "{\"status\": \"success\", \"message\": \"Registration successful\"}";
        } else {
            return "{\"status\": \"error\", \"message\": \"Username already exists\"}";
        }
    }
}
