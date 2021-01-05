package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.EBook;
import com.briup.estore.bean.ECategory;
import com.briup.estore.common.exceptions.UserException;
import com.briup.estore.common.utils.MyBeanFactory;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.ICategoryService;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IBookService bookservice = MyBeanFactory.getBean(MyBeanFactory.BOOK_SERVICE);
		ICategoryService categoryService = MyBeanFactory.getBean(MyBeanFactory.CATE_SERVICE);
		String name = req.getParameter("bookName");
		try {
			List<EBook> allBooks = null;
			if( name != null && !"".equals(name)) {
				allBooks = bookservice.getBookByName(name);
			}else{
				allBooks = bookservice.getAllBooks();
			}
			req.setAttribute("books", allBooks);
			List<ECategory> allCategory = categoryService.getAllCategory();
			req.setAttribute("categorys", allCategory);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (UserException e) {
			resp.sendRedirect("/login.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
