import java.sql.*;

public class TestJDBCConnection {
    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/gernepick"; // Adjust the URL as per your setup
        String dbUser = "root"; // Default user for MySQL
        String dbPassword = "root"; // Provide the actual password

        // Check if the JDBC driver is available
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver found.");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found. Add the JDBC Driver to your project.");
            e.printStackTrace();
            return;
        }

        // Test the connection
        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            System.out.println("Connection successful!");

            // Verify the current user
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CURRENT_USER()");
            if (resultSet.next()) {
                String currentUser = resultSet.getString(1);
                System.out.println("Current user: " + currentUser);
            }
        } catch (SQLException e) {
            System.out.println("Connection failed. Check your database connection details.");
            e.printStackTrace();
        }
    }
}
