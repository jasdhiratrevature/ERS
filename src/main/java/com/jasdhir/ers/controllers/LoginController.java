package com.jasdhir.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jasdhir.ers.dao.LoginDao;
import com.jasdhir.ers.dao.LoginDaoImpl;
import com.jasdhir.ers.model.ERSUser;
import com.jasdhir.ers.utils.ConnectionUtils;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher requestDispatcher;
		String userName = request.getParameter("username");
		String pwd = request.getParameter("password");
		LoginDao loginDao = new LoginDaoImpl();
		ERSUser loggedInUser = loginDao.login(userName, pwd);
		System.out.println(loggedInUser);
		HttpSession session = request.getSession();
		session.setAttribute("loggedInUser", loggedInUser);
		if (loggedInUser == null) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Incorrect Username or Password...');");
			out.println("location='login.html';");
			out.println("</script>");
			// response.sendRedirect("login.html");
		} else if (loggedInUser.getUserRole().equalsIgnoreCase("EMPLOYEE")) {
			requestDispatcher = request.getRequestDispatcher("EmpC");
			requestDispatcher.forward(request, response);
		} else if (loggedInUser.getUserRole().equalsIgnoreCase("MANAGER")) {
			requestDispatcher = request.getRequestDispatcher("ManC");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
