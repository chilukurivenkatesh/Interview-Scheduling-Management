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
@WebServlet("/Hrlog")
public class Hrlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hrlog() {
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
            ResultSet rs =s.executeQuery("select * from Hrtab");
            int i=0,j,k;
            while(rs.next())
			{
				if(rs.getString(6).equals(email) && rs.getString(7).equals(pass)){
					 PreparedStatement ps = conn.prepareStatement("insert into nikhil2 values(?)");
				        ps.setString(1,email);
				        PreparedStatement ps1 = conn.prepareStatement("insert into nikhil3 values(?)");
				        ps1.setString(1,email);
				     
				         j = ps.executeUpdate();
				         k = ps1.executeUpdate();
					        
					i++;
					break;
				}
			}
            if(i!=0){
				RequestDispatcher rd=request.getRequestDispatcher("index1.html");
				rd.forward(request, response);
			}else{
				out.println("<h1>Not Success</h1>");
			}
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        }
}
