package com.revature.projectone.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  private static String url;
  private static String dbname;
  private static String username;
  private static String password;
  private static String port;
  private static ConnectionFactory connectionFactory;

  private ConnectionFactory() {
    url = System.getenv("DB_URL");
    dbname = System.getenv("DB_DATABASE");
    port = System.getenv("DB_PORT");
    username = System.getenv("DB_USERNAME");
    password = System.getenv("DB_PASSWORD");
  }

  private Connection createConnection() {
    String completeUrl = "jdbc:postgresql://" + url + ":" + port + "/" + dbname + "?";
    Connection conn = null;
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Error: org.postgresql.Driver class not found.");
      System.exit(1);
    }
    try {
      conn = DriverManager.getConnection(completeUrl, username, password); 
    } catch (SQLException e) {
      System.out.println("Error: unable to make connection with " + completeUrl);
      System.exit(1);
    }
    return conn;
  }

  public static Connection getConnection() {
    if (connectionFactory == null) {
      connectionFactory = new ConnectionFactory();
    }
    return connectionFactory.createConnection();
  }

  public static void closeConnection(Connection conn) {
    try {
      conn.close();
      connectionFactory = null;
    } catch (SQLException e) {
      System.out.println("Error: Connection cannot close for some reason.");
      System.exit(1);
    }
  }
}
