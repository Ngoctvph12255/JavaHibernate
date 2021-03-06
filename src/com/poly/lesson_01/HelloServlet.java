package com.poly.lesson_01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/HelloServlet" , "/"})
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String reParam = request.getParameter("name");
		String name = reParam != null ? reParam : "Bug maker";
		request.setAttribute("NAME", name);

		request.getRequestDispatcher("views/hello.jsp").forward(request, response);

	}
}
