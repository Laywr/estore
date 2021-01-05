package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBeanFactory;
import com.briup.estore.service.IUserService;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		resp.setCharacterEncoding("UTF-8");
		IUserService userService = MyBeanFactory.getBean(MyBeanFactory.USER_SERVICE);
		try {
			ECustomer customer = userService.loginUser(name, password);
			HttpSession session = req.getSession();
			session.setAttribute("cus", customer);
			resp.sendRedirect(req.getContextPath()+"/index.do");
		} catch (UserException e) {
			req.setAttribute("msg", e.getMessage());
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
