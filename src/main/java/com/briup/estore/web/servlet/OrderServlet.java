package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.bean.EOrder;
import com.briup.estore.common.utils.MyBeanFactory;
import com.briup.estore.service.IOrderService;

@WebServlet("/order/order.do")
public class OrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ECustomer cus = (ECustomer)session.getAttribute("cus");
		IOrderService orderService = MyBeanFactory.getBean(MyBeanFactory.ORDER_SERVICE);
		List<EOrder> orders = orderService.getOrders(cus.getId());
		req.setAttribute("orders", orders);
		req.getRequestDispatcher("/order/order.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
