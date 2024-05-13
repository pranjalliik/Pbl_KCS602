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
import java.sql.ResultSet;





@WebServlet("/deleteStudent")
public class delstud extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    HttpSession session=request.getSession(false);

   String role=(String)session.getAttribute("uname");
if(role.equals("admin")){


        int rollNo = Integer.parseInt(request.getParameter("rollNo"));
        int roomNo = Integer.parseInt(request.getParameter("roomNo"));

       

        String url = "jdbc:mysql://localhost:3308/hostel";
        String user = "root";
        String password = "2002";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                        out.print("<h3 class='ml-80'>cannot connect</h3>");
            throw new ServletException("Error loading JDBC driver", e);
        }




 try (
    Connection connection = DriverManager.getConnection(url, user, password)) {

            String deleteQuery = "DELETE FROM students WHERE rollNo = ?";
            try (
                PreparedStatement delStatement = connection.prepareStatement(deleteQuery)) {
                delStatement.setInt(1, rollNo);

                int rowsAffected = delStatement.executeUpdate();

                    out.println("<h3>Student with rollNo " + rollNo + " deleted successfully</h3>");
               
            }
        } catch (SQLException e) {
            out.println("<h3>Error connecting to the database: " + e.getMessage() + "</h3>");
        }







 



            String updateQuery = "UPDATE rooms SET capacityLeft = capacityLeft + 1 WHERE roomNo = ?";
            try (
                        Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) 
                {
                updateStatement.setInt(1, roomNo);

                int rowsAffected = updateStatement.executeUpdate();

             
                    out.println("<h3>Updated Capacity of room " + roomNo + "is "+rowsAffected+"</h3>");
               
            }
         catch (SQLException e) {
            out.println("<h3>Error connecting to the database: " + e.getMessage() + "</h3>");
        }

}else{

out.print("<h3 class='ml-80'> not authorized</h3>");
}
	
    }
}
