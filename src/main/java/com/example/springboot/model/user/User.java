package com.example.springboot.model.user;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class User implements Serializable {
  public enum Role {
    USER, ADMIN
  }

  private String firstName;

  private String lastName;

  private String email;

  private Set<Role> roles;

  public User() {}

  /**
   * Convinience constructor for creating local domain User entities for remotely maintained users.
   *
   * @param firstName The user's first name.
   * @param lastName The users last name.
   * @param email The users email address
   * @param roles The users roles @see Role
   */
  public User(String firstName, String lastName, String email, Set<Role> roles) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.roles = roles;
  }

  /**
   * Convinience constructor for creating local domain User entities for remotely maintained users.
   *
   * @param firstName The user's first name.
   * @param lastName The users last name.
   * @param email The users email address
   * @param roles The users roles @see Role
   */
  public User(String firstName, String lastName, String email, Role... roles) {
    this(firstName, lastName, email, Arrays.stream(roles).collect(Collectors.toSet()));
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  /* */

  public User asPublicData() {
    return new User(firstName, lastName, email, roles.toArray(new Role[roles.size()]));
  }
}
