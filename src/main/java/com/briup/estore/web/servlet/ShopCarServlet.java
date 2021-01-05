package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.service.IShopCarService;
import com.briup.estore.service.impl.ShopCarServiceImpl;

@WebServlet("/shopCar.do")
public class ShopCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookIdStr = req.getParameter("bookId");
		String num = req.getParameter("num");
		int bookId = Integer.parseInt(bookIdStr);
		HttpSession session = req.getSession();
		ShoppingCar shopCar = (ShoppingCar)session.getAttribute("shopCar");
		if(shopCar==null) {
			shopCar = new ShoppingCar();
			session.setAttribute("shopCar", shopCar);
		}
		IShopCarService shopCarService = new ShopCarServiceImpl();
		shopCarService.addToCar(shopCar, bookId,
				num==null||"".equals(num)?1:Integer.parseInt(num));
	
		String returnUrl = req.getParameter("returnUrl");
		resp.sendRedirect(req.getContextPath()+"/"+returnUrl);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
