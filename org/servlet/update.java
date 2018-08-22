package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.book.BookDatabase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("created");
		String bid = request.getParameter("bookid");
		String bname=request.getParameter("bookname");
		
		String aname = request.getParameter("authorname");
		String bisbn = request.getParameter("isbn");
		long bpublication =Long.parseLong( request.getParameter("publication"));
		long bprice = Long.parseLong(request.getParameter("price"));
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		BookDatabase book=new BookDatabase();
		book.setBookId(bid);
		book.setBookName(bname);
		book.setAuthorName(aname);
		book.setISBN(bisbn);
		book.setPublication(bpublication);
		book.setPrice(bprice);
		session.save(book);
		session.getTransaction().commit();
		session.close();
		sf.close();
			out.println("updated");
	
	}
}
