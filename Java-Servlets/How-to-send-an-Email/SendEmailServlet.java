//copyright seda kunda
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SendEmailServlet")
public class SendEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String host;
    private String port;
    private String usern;
    private String pass;
 
    public void init() {
        //reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        usern = context.getInitParameter("usern");
        pass = context.getInitParameter("pass");
    }
    public SendEmailServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String subject = "Test Account Creation";
    		String content = "Dear " + fname + " " + lname + ",\n\n"
                      + "You have succesfully created a new account.\n\n\n"
                      + "This is an automated email. Do not reply.\n\n\n"
                      + "Regards, TheZedCoder.com";
			        try {
			            EmailUtility.sendEmail(host, port, usern, pass, email, subject, content);	
				        out.println("Your message has been sent");
			        } 
			        catch (Exception ex) {
			            out.println("An error occured");
			        }
	}
}