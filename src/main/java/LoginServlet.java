

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
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/genrepick";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url,user,password);
			String n = request.getParameter("txtName");
			String p = request.getParameter("txtPwd");
			PreparedStatement ps = con.prepareStatement("select * from users where Username=? and Password=?");
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd = request.getRequestDispatcher("Index.html");
				rd.forward(request, response);
			}
			else
			{
				out.println("<font color = red size=18>Login Failed!!<br>");
				out.println("<a href = login.jsp> TRY AGAIN!!</a>");
			}
			
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
