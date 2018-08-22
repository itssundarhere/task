package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Setsessionservlet
 */
@WebServlet("/Setsessionservlet")
public class Setsessionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Setsessionservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emp=(String) session.getAttribute("emp");
	//	System.out.println(emp);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\" >");
		out.println("<title>view</title>");
		
		out.println("<body>");
	out.println("	<form method=\"post\" action=\"edit\">");
	
		out.println("<div class=\"container\">");
		out.println("<table class=\"table table-bordered\" style =\"width:700px;margin:50px auto\">");
		out.println("    <thead>");
		out.println("    <tr>");
		out.println("  <th>BookID</th>");
		out.println(" <th>BookNAME</th>");
		out.println(" <th>AuthorNAME</th>");
		out.println("  <th>ISBN</th>");
		out.println(" <th>Publicatoin</th>");
		out.println(" <th>Price</th>");
		out.println("  </tr>");
		out.println("   </thead>");
		out.println(" <tbody style =\"width:350px\">");
		String bookid;
	
		try {
		
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select * from book_db where bookId='"+emp+"'");
			while (rs.next()) {
		
				out.println("<tr>");
				out.println(" <td>" + rs.getString("bookId") + "</td>");
		
			bookid=rs.getString("bookId");
	
		
				//request.setAttribute("empid",rs.getString("empid"));
				out.println("<td>" + rs.getString("bookName") + "</td>");
				out.println(" <td>" + rs.getString("authorName") + "</td>");
				out.println(" <td>" + rs.getString("ISBN") + "</td>");
				out.println(" <td>" + rs.getString("publication") + "</td>");
				out.println(" <td>" + rs.getString("price") + "</td>");
							
				out.println(" <td>" + "<button type=\"submit\" class=\"btn btn-success\">Edit</button>"+ "</td>");	
				out.println( " <td>"+"<a href=\"http://localhost:8081/crud/delete\" type=\"submit\" class=\"btn btn-danger\">Delete</button>"+ "</td>");
				
				out.println("</tr>");
			

			}
			out.println(" </tbody>");
			out.println(" </table>");
			out.println("</div>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		
		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

}
