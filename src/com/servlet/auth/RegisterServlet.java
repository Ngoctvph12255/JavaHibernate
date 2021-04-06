package com.servlet.auth;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.entity.User;
import com.dao.UserDAO;
import com.utils.HibernatUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private UserDAO userDAO;
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute(getServletName(), response);
		request.getRequestDispatcher("views/auth/register.jsp").forward(request, response);

		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
//		String number = request.getParameter("number");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		String gender = request.getParameter("gender");
//		String age = request.getParameter("age");
//		String role = request.getParameter("role");
//		String notification = request.getParameter("notification");
//		response.getWriter().write("<h1>"+ name+"</h1>");
//		response.getWriter().write("<h1>"+ number+"</h1>");
//		response.getWriter().write("<h1>"+ email+"</h1>");
		
//		response.getWriter().write("<h1>"+ gender+"</h1>");
//		response.getWriter().write("<h1>"+ password+"</h1>");
//		response.getWriter().write("<h1>"+ notification+"</h1>");
//		response.getWriter().write("<h1> URI: "+ request.getRequestURI()+"</h1>");
//		response.getWriter().write("<h1> URl: "+ request.getRequestURL()+"</h1>");
//		response.getWriter().write("<h1> METHOD: "+ request.getMethod()+"</h1>");
		request.setAttribute("NAME", name);

		User entity = new User();

		try {
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setRole(1);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		this.userDAO.store(entity);
		
		
		System.out.println("Entity: " + entity.toString());
		
		
		
		
		response.sendRedirect(request.getContextPath() + "/admin/users");

	}

}
