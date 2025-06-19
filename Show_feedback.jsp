<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#ADEFFF;
}
H1
{
COLOR:BLUE;
ALIGN:CENTER;
PADDING-LEFT:5CM;
}
h2
{
COLOR:red;
ALIGN:CENTER;
PADDING-LEFT:12CM;
}
</style>
</head>

<body>
	<%@page import="java.sql.DriverManager"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>
	<%
	
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	%>
	<H1>INTERVIEW SCHEDULING MANAGEMENT</H1>
	<h2>Mode Of Interview</h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	
	</tr>
	<tr bgcolor="#A52A2A">
	
	<td><b>Communication skills</b></td>
	<td><b>Technical Skills</b></td>
	<td><b>Leadership  Skills</b></td>
	<td><b>Any Other Improvements </b></td>
	</tr>
	<%
	try{ 
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/demo", "root", "123456789");
	st=conn.createStatement();
	rs = st.executeQuery("SELECT * FROM hrfeedback t1 INNER JOIN feeddammy t2 ON t1.id = t2.id  ");
	
	
	while(rs.next()){
	%>
	<tr bgcolor="#DEB887">
	
	
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td><%=rs.getString(5) %></td>
	
	
	
	

	
	
	<% 
	}
	String sql="truncate feeddammy";
	st.executeUpdate(sql);
	
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	</table>

</body>
</html>