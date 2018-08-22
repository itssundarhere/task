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
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String emp1= (String)session.getAttribute("emp");
		int emp=Integer.parseInt(emp1);
		//out.println(emp);
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\" >");
		out.println("<title>view</title>");
		out.println("<body>");
		out.println("<form method=\"post\" action=\"update\">");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery("select * from book_db where bookId='"+emp+"'");
			while (rs.next()) {
		
		out.println("<div>"+
		  "<div class=\"form-group\" style=\"width: 350px;padding-left: 5%\">"+
		   " <label>BookId</label>"+
		    "<input type=\"text\" class=\"form-control\" name=\"bookid\"id=\"bookid\" value="+rs.getString("bookId")+">"+
		    "<label>BookName</label>"+
		    "<input type=\"text\" class=\"form-control\" name=\"bookname\"id=\"bookname\" value="+rs.getString("bookName")+">"+
		   " <label>AuthorName</label>"+
		    "<input type=\"text\" class=\"form-control\" name=\"authorname\"id=\"authorname\" value="+rs.getString("authorName")+">"+
		    
		    "<label>ISBN</label>"+
		   "<input type=\"text\" class=\"form-control\" name=\"isbn\"id=\"isbn\" value="+rs.getString("ISBN")+">"+
		   " <label>Publication</label>"+
		   " <input type=\"text\" class=\"form-control\" name=\"publication\"id=\"publication\" value="+rs.getString("publication")+">"+
		    "<label>Price</label>"+
		  "  <input type=\"text\" class=\"form-control\" name=\"price\"id=\"price\" value="+rs.getString("price")+">"+
		   "<div class=\"container\" >"+
		  "<button type=\"submit\" class=\"btn btn-success\">Save</button>"+
		  "</div>"+
		"</form>");
		out.println("</body>");
		out.println("</html>");
			}
		}
		catch(Exception e){
			
		}

	}

}
