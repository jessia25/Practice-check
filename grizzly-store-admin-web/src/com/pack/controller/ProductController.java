package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.model.Login;
import com.pack.model.Product;
import com.pack.service.LoginServiceImpl;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> productList=new LoginServiceImpl().fetchProducts();
		request.setAttribute("prodList", productList);
		RequestDispatcher rd=request.getRequestDispatcher("/list.jsp");
	rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("id"));
		String category=request.getParameter("category");
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		int price=Integer.parseInt(request.getParameter("price"));
		Product p=new Product(pid,category,name,description,price);
		int i=new LoginServiceImpl().insertProduct(p);
		if(i==1) {
			//pw.print("records added ");
			List<Product> productList=new LoginServiceImpl().fetchProducts();
			request.setAttribute("prodList", productList);
			RequestDispatcher rd=request.getRequestDispatcher("/list.jsp");
		rd.forward(request,response);
		}
	}

}
