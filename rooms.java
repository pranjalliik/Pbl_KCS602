package com.registration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getrooms")
public class rooms extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Rooms</title></head><body>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String jdbcUrl = "jdbc:mysql://localhost:3308/hostel";
            String username = "root";
            String password = "2002";
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sql = "SELECT * FROM rooms";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            out.println("<h2>Rooms</h2>");
            out.println("<table border='1'><tr><th class='pr-8'>Room No</th><th class='pr-8'>Capacity</th><th class='pr-8'>AC</th><th class='pr-8'>Capacity Left</th><th class='pr-8'>Vacant</th></tr>");
            while (resultSet.next()) {
          
                String acClass = "";
                String occupiedClass = "";
                String val = "";
                if(resultSet.getString("ac").equals("Yes")){
                    acClass = "bg-green-200";
                }else{
                    acClass = "bg-red-200";
                }
                  if(0 == resultSet.getInt("capacityLeft")) {
                    occupiedClass= "bg-red-200";
                    val = "No";
                  }else{
                    occupiedClass="bg-green-200";
                    val = "Yes";
                  }            

                out.println("<tr><td>" + resultSet.getInt("roomNo") + "</td><td>" + resultSet.getInt("capacity")
                        + "</td><td class='" + acClass + "'>"+ resultSet.getString("ac") + "</td><td>" + resultSet.getString("capacityLeft")
                        + "</td><td class='" + occupiedClass + "'>"+ val + "</td></tr>");
            }
            out.println("</table>");

            resultSet.close();
            preparedStatement.close();
            connection.close();


        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h3>Error retrieving rooms data</h3>");
            e.printStackTrace(out);
        }

        out.println("</body></html>");
    }
}
