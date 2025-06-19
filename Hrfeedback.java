package sample;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
@WebServlet("/Hrfeedback")
public class Hrfeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hrfeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("id");
        String lname = request.getParameter("cs");
        String age = request.getParameter("ts");
        String gender = request.getParameter("ls");
        String number = request.getParameter("ao");
       
    	try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo","root","123456789");
			PreparedStatement ps = conn.prepareStatement
                    ("insert into hrfeedback values(?,?,?,?,?)");
	        ps.setString(1, fname);
	        ps.setString(2,lname);
	        ps.setString(3,age);
	        ps.setString(4,gender);
	        ps.setString(5,number);
	       
	        int i = ps.executeUpdate();
	        if(i!=0){
	        	out.println("Submitted");
	        }else{
	        	out.println("not Submitted");
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

}
