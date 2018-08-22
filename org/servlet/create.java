package org.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.book.BookDatabase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public create() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		//out.println("created");
		
		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String authorname = request.getParameter("authorname");
		String isbn = request.getParameter("isbn");
		long publication = Long.parseLong(request.getParameter("publicationyear"));
		long price = Long.parseLong(request.getParameter("price"));
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		BookDatabase auctionofwar=new BookDatabase();
		auctionofwar.setBookId(bookid);
		auctionofwar.setBookName(bookname);
		auctionofwar.setAuthorName(authorname);
		auctionofwar.setISBN(isbn);
		auctionofwar.setPublication(publication);
		auctionofwar.setPrice(price);
		session.save(auctionofwar);
		session.getTransaction().commit();
		session.close();
		sf.close();
		response.sendRedirect("show.html");
	}

}
