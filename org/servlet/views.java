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

@WebServlet("/views")
public class views extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private String test;
  
    public String getTest() {
	return test;
}
public void setTest(String test) {
	this.test = test;
}
	public views() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String s=request.getParameter("search");
		System.out.println(s);
		HttpSession session = request.getSession();
		session.setAttribute("emp",s);
		response.sendRedirect("Setsessionservlet");
			}

}
