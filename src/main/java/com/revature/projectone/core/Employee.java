package com.revature.projectone.core;

public class Employee {
 
  int id;
  String firstName;
  String lastName;
  String email;
  String username;
  String password;
  String type; 

  public static int getNewId() {
    return 0;
  }

  public Employee() {
    this.setId(getNewId()); 
  }

  public Employee(String firstName, String lastName, String username, String password, String type) {
    this();
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setUsername(username);
    this.setPassword(password);
    this.setType(type);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword() {
    this.password = password;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
