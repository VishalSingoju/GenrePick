import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registerServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieve form data
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String username = request.getParameter("Username");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/genrepick";
            String user = "root";
            String dbPassword = "root";
            con = DriverManager.getConnection(url, user, dbPassword);
            
            // SQL query to insert the new user
            String query = "INSERT INTO users (Name, Email, Username, Password) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            
            // Set the values in the query
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, username);
            ps.setString(4, password);

            // Execute the query
            int rowCount = ps.executeUpdate();
            
            if (rowCount > 0) {
                out.println("<font color='green'>Registration successful!</font>");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            } else {
                out.println("<font color='red'>Registration failed. Please try again.</font>");
                RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
                rd.include(request, response);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("<font color='red'>An error occurred. Please try again later.</font>");
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
