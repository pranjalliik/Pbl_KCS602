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





@WebServlet("/processRegistration")
public class register extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    HttpSession session=request.getSession(false);

   String role=(String)session.getAttribute("uname");
if(role.equals("admin")){

               String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        int rollNo = Integer.parseInt(request.getParameter("rollNo"));
        int mobileNo = Integer.parseInt(request.getParameter("mobileNo"));
        int fathersContactNo = Integer.parseInt(request.getParameter("fathersContactNo"));
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





    int capacity = 0;
    int capacityLeft = 0;
 try (
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement capacityStatement = connection.prepareStatement(
                "SELECT capacity, capacityLeft FROM rooms WHERE roomNo = ?"
        )
    ) {

 capacityStatement.setInt(1, roomNo);

    ResultSet resultSet = capacityStatement.executeQuery();

    while (resultSet.next()) {
        capacity = resultSet.getInt("capacity");
        capacityLeft = resultSet.getInt("capacityLeft");
    }


        if (capacityLeft == 0) {
            out.print("<h3 class='ml-80'>Room Capacity Full</h3>");
        } 

    } catch (SQLException e) {
        out.print("<h3 class='ml-80'>Could not check room capacity. Error: " + e.getMessage() + "</h3>");
    }


  


 if (capacityLeft != 0) {



            String updateQuery = "UPDATE rooms SET capacityLeft = capacityLeft - 1 WHERE roomNo = ?";
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











try (
    // Establish a connection
    Connection connection = DriverManager.getConnection(url, user, password);
    // Create a statement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO students (name, year, rollNo, mobileNo, fatherMobileNo, roomNo) VALUES (?, ?, ?, ?, ?, ?)"
            )

) {
    
                preparedStatement.setString(1, name);
            preparedStatement.setInt(2, year);
            preparedStatement.setInt(3, rollNo);
            preparedStatement.setInt(4, mobileNo);
            preparedStatement.setInt(5, fathersContactNo);
            preparedStatement.setInt(6, roomNo);

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

 }
}else{

out.print("<h3 class='ml-80'> not authorized</h3>");
}
	
    }
}
