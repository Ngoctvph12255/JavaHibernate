package com.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/admin/users")
public class UserManagementServlet extends HttpServlet {

	private UserDAO userDAO;

	public UserManagementServlet() {
		this.userDAO = new UserDAO();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getServletPath();
		
		String pageStr =request.getParameter("page");
		String limitStr = request.getParameter("limit");
//		int perPageStr = 5;
//		if (request.getParameter("perpage") == null)
//			perPageStr = 4;
//		else
//			System.out.println("Get param perpage: "  + request.getParameter("perpage"));
//			perPageStr = Integer.parseInt(request.getParameter("perpage"));
		
		
//		int perPageInt = Integer.parseInt(perPageStr) ;
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int limit = limitStr == null ? 5 : Integer.parseInt(limitStr);
		
		int offset = limit * (page - 1);
		
		
		List<User> listUser = this.userDAO.paginate(limit, offset);
		request.setAttribute("LIST_USERS", listUser);
		request.setAttribute("page", page);
		
		//Count Users
		List<Integer> Count = this.userDAO.countUserForFilter();
		
		request.setAttribute("countUsers", Count.get(0));
		request.setAttribute("Limit", limit);
		
		for (User user : listUser) {
			System.out.println(
					
					user.getName() + "---" + 
					user.getPosts().size()
					);
			
		}
//		this.userDAO.deleteUser();
//		  "  /views/display/display-user.jsp
		
		
		request.getRequestDispatcher("/views/admin/users/index.jsp").forward(request, response);

	}

}
