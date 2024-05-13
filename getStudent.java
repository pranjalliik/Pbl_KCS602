package com.registration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getStudent")
public class getStudent extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String rollNoParam = request.getParameter("rollNo");
       

        int rollNo = Integer.parseInt(rollNoParam);

     String url = "jdbc:mysql://localhost:3308/hostel";
        String user = "root";
        String password = "2002";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                        out.print("<h3 class='ml-80'>cannot connect</h3>");
            throw new ServletException("Error loading JDBC driver", e);
        }

                 String selectQuery = "SELECT * FROM students WHERE rollNo = ?";


           
            try (
                        Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement selectStatement = connection.prepareStatement(selectQuery))
                 {

                selectStatement.setInt(1, rollNo);

                ResultSet resultSet = selectStatement.executeQuery();


                    if (resultSet.next()) {
                        String name = resultSet.getString("name");
                        int year = resultSet.getInt("year");
                        int mobileNo = resultSet.getInt("mobileNo");
                        int fathersContactNo = resultSet.getInt("fatherMobileNo");
                        int roomNo = resultSet.getInt("roomNo");
                        out.println("<h3>Student Information:</h3>");
                        out.println("<p>Name: " + name + "</p>");
                       out.println("<p id='roomNoValue'>RoomNo: " + roomNo + "</p>");

                        out.println("<p>Year: " + year + "</p>");
                        out.println("<p>Mobile No: " + mobileNo + "</p>");
                        out.println("<p>Father's Contact No: " + fathersContactNo + "</p>");
                    } else {
                        out.println("<h3>No student found with rollNo " + rollNo + "</h3>");
                    }
                
            
        } catch (SQLException e) {
            out.println("<h3>Error connecting to the database: " + e.getMessage() + "</h3>");
        }
    }
}
