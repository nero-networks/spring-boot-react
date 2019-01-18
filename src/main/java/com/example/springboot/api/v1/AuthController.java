package com.example.springboot.api.v1;

import com.example.springboot.model.user.AuthStatus;
import com.example.springboot.model.user.User;
import com.example.springboot.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  /**
   * Get the AuthStatus for the current session.
   * @return
   */
  @GetMapping
  public AuthStatus getAuthStatus() {
    User user = authService.getCurrentUser();

    boolean isLoggedIn = user != null;

    return new AuthStatus(isLoggedIn,
            isLoggedIn ? user.asPublicData() : null);
  }

  /**
   * Get the User entity for the current session.
   * @return
   */
  @GetMapping("/user")
  public User currentUser() {
    return authService.getCurrentUser();
  }

}
