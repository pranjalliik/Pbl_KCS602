package com.registration;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

@WebServlet("/signin")
public class StudentLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve values from the form
        String username = request.getParameter("studentid");
        String password = request.getParameter("student_pass");
System.out.println("Username: " + username);
System.out.println("Password: " + password);
    HttpSession session=request.getSession();
    if(username.equals("khushi") && password.equals("123")){
    session.setAttribute("uname",username);
	RequestDispatcher rd = request.getRequestDispatcher("/dashboard.jsp");
      rd.forward(request, response);
    }
    else{
         RequestDispatcher rd =   request.getRequestDispatcher("/error.jsp");
      rd.forward(request, response);  
    }
    }
}

