package com.registration;
import javax.servlet.RequestDispatcher;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





@WebServlet("/employeeRegistration")
public class employeer extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    HttpSession session=request.getSession(false);

   String Role=(String)session.getAttribute("uname");
if(Role.equals("admin")){

               String name = request.getParameter("name");
        String role = request.getParameter("role");
        int empNo = Integer.parseInt(request.getParameter("empNo"));
        int mobileNo = Integer.parseInt(request.getParameter("mobileNo"));


       

        String url = "jdbc:mysql://localhost:3308/hostel";
        String user = "root";
        String password = "2002";

           // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                        out.print("<h3 class='ml-80'>cannot connect</h3>");
            throw new ServletException("Error loading JDBC driver", e);
        }


try (
    // Establish a connection
    Connection connection = DriverManager.getConnection(url, user, password);
    // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO employee (name, role, empNo, mobileNo) VALUES (?, ?, ?, ?)"
            )

) {
    
                preparedStatement.setString(1, name);
            preparedStatement.setString(2, role);
            preparedStatement.setInt(3, empNo);
            preparedStatement.setInt(4, mobileNo);


            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();



out.print("<h3 class='ml-80'>Successfully Registered</h3>");
	/*RequestDispatcher rd =
      request.getRequestDispatcher("/home.jsp");
      rd.forward(request, response);
	*/



} catch (SQLException e) {
    out.print("<h3 class='ml-80'>coludnt enter data</h3>");

    out.print("<h3 class='ml-80'>Could not enter data. Error: " + e.getMessage() + "</h3>");

}


}else{

out.print("<h3 class='ml-80'> not authorized</h3>");
}
	
    }
}
