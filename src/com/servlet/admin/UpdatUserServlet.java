package com.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.entity.User;

/**
 * Servlet implementation class UpdatUserServlet
 */
@WebServlet("/admin/users/update")
public class UpdatUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatUserServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		User entity = this.userDAO.findById(id);

		request.setAttribute("user", entity);

		request.getRequestDispatcher("/views/admin/users/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User entity = new User();

		try {
			// read value from beanUtls with class entity
			BeanUtils.populate(entity, request.getParameterMap());

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Name: " + entity.getName());
		

		this.userDAO.updateUser(entity);
		

		System.out.println("--------" + request.getContextPath());
		response.sendRedirect(request.getContextPath() + "/admin/users");
	}

}
