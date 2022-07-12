package com.jasdhir.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jasdhir.ers.dao.EmpReimbursement;
import com.jasdhir.ers.dao.EmpReimbursementImpl;
import com.jasdhir.ers.model.ERSUser;
import com.jasdhir.ers.model.Reimbursement;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String action=request.getParameter("action");
		System.out.println("Inside Employee Controller");
		HttpSession session = request.getSession();
		ERSUser loggedInUser = (ERSUser) session.getAttribute("loggedInUser");
		System.out.println("User Id :::: " + loggedInUser.getId());
		out.print("<a href='htmls/newRequest.html'>Add a New Request</a>");
		out.print("<br/><br/>");
		List<Reimbursement> allRecords = new ArrayList<Reimbursement>();
	
		if(action==null) {
			EmpReimbursement empReimbursement = new EmpReimbursementImpl();
			allRecords = empReimbursement.getAllRecords(loggedInUser.getId());
			out.print("<a href='EmpC?action=resolved'>Resolved</a>");
			out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.print("<a href='EmpC?action=pending'>Pending</a>");
			out.print("<br/><br/>");
			out.print("<table border='1'>");
			printTableHead(response);
			for (Reimbursement rem : allRecords) {
				displayTable(rem, response);

			} // for ends
			out.print("</table>");
			out.print("<br/><br/>");
		} // if ends
		else if(action.equalsIgnoreCase("pending")) {
			EmpReimbursement empReimbursement = new EmpReimbursementImpl();
			allRecords = empReimbursement.getPendingRecords(loggedInUser.getId());
			out.print("<a href='EmpC'>All</a>");
			out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.print("<a href='EmpC?action=resolved'>Resolved</a>");
			out.print("<br/><br/>");
			out.print("<table border='1'>");
			printTableHead(response);
			for (Reimbursement rem : allRecords) {
				displayTable(rem, response);

			} // for ends
			out.print("</table>");
			out.print("<br/><br/>");
		} // pending ends
		else if(action.equalsIgnoreCase("resolved")) {
			EmpReimbursement empReimbursement = new EmpReimbursementImpl();
			allRecords = empReimbursement.getResolvedRecords(loggedInUser.getId());
			out.print("<a href='EmpC'>All</a>");
			out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.print("<a href='EmpC?action=pending'>Pending</a>");
			out.print("<br/><br/>");
			out.print("<table border='1'>");
			printTableHead(response);
			for (Reimbursement rem : allRecords) {
				displayTable(rem, response);

			} // for ends
			out.print("</table>");
			out.print("<br/><br/>");
			
		} // resolved ends
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
public  void displayTable(Reimbursement rem,HttpServletResponse resp) throws IOException {
	PrintWriter out=resp.getWriter();
	out.print("<tr>");
	out.print("<td>" + rem.getReimbursementId() + "</td>");
	out.print("<td>" + rem.isAccepted() + "</td>");
	out.print("<td>" + rem.getAmount() + "</td>");
	out.print("<td>" + rem.getDescription() + "</td>");
	out.print("<td>" + rem.getReimbursementType() + "</td>");
	out.print("<td>" + rem.getResolveTime() + "</td>");
	out.print("<td>" + rem.isResolved() + "</td>");
	out.print("<td>" + rem.getSubmitTime() + "</td>");
	out.print("<td>" + rem.getAuthorId() + "</td>");
	out.print("<td>" + rem.getResolverId() + "</td>");
	out.print("</tr>");
}
public void printTableHead(HttpServletResponse resp) throws IOException {
	PrintWriter out=resp.getWriter();
	out.print("<tr><th>Rem Id</th><th>Accepted</th><th>Amount</th><th>Desc</th><th>Type</th>");
	out.print("<th>R - Time</th><th>Resolved</th><th>S - Time</th><th>Author</th><th>Resolver</th>");
	out.print("</tr>");
}
}
