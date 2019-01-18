package com.example.springboot.service.auth;

import com.example.springboot.model.user.User;
import com.example.springboot.model.user.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Value("${auth.endpoint}")
  private String endpoint;

  @Autowired
  private UserSession session;

  /**
   * Logs in a user into the current session. TODO oAuth service integration.
   *
   * @param username The username to login.
   * @param password The users password.
   * @return A User entity on successfull login otherwise null.
   */
  public User login(String username, String password) {
    User user = null;

    // TODO oAuth service integration
    if ("test".equals(username) && "123".equals(password)) {
      user = new User("Test", "User","test@example.com",
          User.Role.USER, User.Role.ADMIN);
    }

    session.setUser(user);
    return user;
  }

  /**
   * Logs out the user from the current session.
   */
  public void logout() {
    session.setUser(null);
  }

  /**
   * Retrieves the User entity of the current session.
   * Returns null if session is not authenticated
   *
   * @return The User entity off the current session or null if session is not authenticated.
   */
  public User getCurrentUser() {
    return session.getUser();
  }

}
