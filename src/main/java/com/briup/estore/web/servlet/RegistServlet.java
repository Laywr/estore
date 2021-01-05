package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBeanFactory;
import com.briup.estore.service.IUserService;

@WebServlet("/regist.do")
public class RegistServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String postcode = req.getParameter("postcode");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		ECustomer customer = new ECustomer();
		customer.setUsername(name);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setPassword(pwd);
		customer.setPhone(telephone);
		customer.setZip(postcode);
		IUserService userservice = 
				MyBeanFactory.getBean(MyBeanFactory.USER_SERVICE);
		try {
			userservice.registUser(customer);
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		} catch (UserException e) {
			String msg = e.getMessage();
			req.getRequestDispatcher("/register.jsp?msg="+msg).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
