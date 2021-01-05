package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.estore.bean.EOrder;
import com.briup.estore.common.utils.AlipayConfig;

@WebServlet("/order/alipay.do")
public class OrderAlipayServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlipayClient alipayClient =  
				 AlipayConfig.getAlipayClient();
		 AlipayTradePagePayRequest alipayRequest =  
				new  AlipayTradePagePayRequest(); //创建API对应的request 
		 alipayRequest.setReturnUrl(
				 "http://localhost:8080/estore/order/OrderSure.jsp" );
		 alipayRequest.setNotifyUrl(
				 "http://localhost:8080/estore/index.do" ); //在公共参数中设置回跳和通知地址 
		 EOrder order = (EOrder)req.getAttribute("order");
		 alipayRequest.setBizContent( "{"  +
		         "    \"out_trade_no\":\""+order.getId()+"\","  +
		         "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\","  +
		         "    \"total_amount\":"+order.getTotal()+","  +
		         "    \"subject\":\"图书订单\","  +
		         "    \"body\":\""+System.currentTimeMillis()+"\""  +
		         "  }" ); //填充业务参数 
		    String form= "" ;
		     try  {
		        form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单 
		    }  catch  (AlipayApiException e) {
		        e.printStackTrace();
		    }
		    resp.setContentType( "text/html;charset=UTF-8");
		    resp.getWriter().write(form); //直接将完整的表单html输出到页面 
		    resp.getWriter().flush();
		    resp.getWriter().close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
