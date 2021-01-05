package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.bean.EOrder;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBeanFactory;
import com.briup.estore.service.IOrderSureService;

@WebServlet("/order/orderSure.do")
public class OrderSureServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ECustomer cus = (ECustomer)session.getAttribute("cus");
		ShoppingCar shopCar = (ShoppingCar)session.getAttribute("shopCar");
		EOrder order = new EOrder();
		order.setCustomerId(cus.getId());
		order.setOrderdate(new Date());
		order.setTotal(shopCar.getPriceNum());
		order.setLine(shopCar.getItems());
		IOrderSureService orderSureService = MyBeanFactory.getBean(MyBeanFactory.ORDERSURE_SERVICE);
		try {
			orderSureService.savaOrder(order);
			shopCar.clear();
			req.setAttribute("order", order);
//			req.getRequestDispatcher("/order/OrderSure.jsp").forward(req, resp);
			req.getRequestDispatcher("/order/OrderSure.jsp").forward(req, resp);
		} catch (UserException e) {
			resp.sendRedirect(req.getContextPath()+"/order/confirm.jsp");
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
