package com.example.springboot.model.user;

public class AuthStatus {

  private boolean loggedIn;

  private User user;

  public AuthStatus() {}

  /**
   * Convinience constructor to construct AuthStatus entities.
   *
   * @param loggedIn login status indicator
   * @param user logged in user od null
   */
  public AuthStatus(boolean loggedIn, User user) {
    this.loggedIn = loggedIn;
    this.user = user;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
