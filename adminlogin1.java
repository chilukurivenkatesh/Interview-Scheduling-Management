package sample;





import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/adminlogin1")
public class adminlogin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("id");
        String pass = request.getParameter("pass");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/demo","root","123456789");
            java.sql.Statement s = conn.createStatement();
            ResultSet rs =s.executeQuery("select * from admintable");
            int i=0;
            while(rs.next())
			{
				if(rs.getString(6).equals(email) && rs.getString(7).equals(pass)){
					i++;
					break;
				}
			}
            if(i!=0){
				RequestDispatcher rd=request.getRequestDispatcher("index1.html");
				rd.forward(request, response);
			}else
			{RequestDispatcher rd=request.getRequestDispatcher("adminlogin1.html");
			rd.forward(request, response);
				out.println("<h1>invalid Userid or password</h1>");
				
			}
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        }
}
