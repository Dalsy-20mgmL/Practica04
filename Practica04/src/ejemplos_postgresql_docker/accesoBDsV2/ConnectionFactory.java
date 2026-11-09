package accesoBDsV2;

import java.sql.*;

public class ConnectionFactory {
  private static ConnectionFactory ref = new ConnectionFactory();
  private ConnectionFactory() {
    try {        
        Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("ERROR: exception loading driver class");
    } 
  }

  public static Connection getConnection() throws SQLException {
    String url = "jdbc:postgresql://localhost:5432/empresa";
	return DriverManager.getConnection(url,"admin","admin1234");
  } 

  public static void close(ResultSet rs) {
    try {
      rs.close();
    } catch (Exception ignored) {}
  } 

  public static void close(Statement stmt) {
    try {
      stmt.close();
    } catch (Exception ignored) {}
  } 

  public static void close(Connection conn) {
    try {
      conn.close();
    } catch (Exception ignored) {}
  } 
}