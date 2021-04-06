package com.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.entity.User;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/admin/users/delete")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");
		if(idStr ==null) {
			// 400 bad request
		}
		
		int id = Integer.parseInt(idStr);
		
		User entity = new User();
		entity.setId(id);
		this.userDAO.delete(entity);

		
		response.sendRedirect(request.getContextPath() + "/admin/users");
	}


}
