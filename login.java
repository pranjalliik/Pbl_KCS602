import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
    HttpSession session=request.getSession();
    if(username.equals("admin") && password.equals("1234")){
    session.setAttribute("uname",username);
	RequestDispatcher rd =
      request.getRequestDispatcher("/home.jsp");
      rd.forward(request, response);
    }else{
         RequestDispatcher rd =   request.getRequestDispatcher("/err.jsp");
      rd.forward(request, response);  
    }
    }
}



/*
public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve values from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Print the received values
        out.println("<html>");
        out.println("<head><title>Registration Details</title></head>");
        out.println("<body>");
        out.println("<h2>Registration Details</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("</body>");
        out.println("</html>");
	RequestDispatcher rd =
      request.getRequestDispatcher("Welcome");
      rd.forward(request, response);
	
    }
}
*/