package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.model.Login;
import com.pack.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		//pw.print("hello");
		int userid=Integer.parseInt(request.getParameter("userid"));
		String password=request.getParameter("password");
		Login l=new Login(userid,password);
		//int count=l.getCount();
		boolean i=new LoginServiceImpl().checkDetails(l);
		if(i==true)
		{
			 int k=new LoginServiceImpl().setZeroCount(l);
			  String username=new LoginServiceImpl().getUsername(l);
			  float rating=new LoginServiceImpl().getRating( l);
			  String contact=new LoginServiceImpl().getContact(l);
			  String address=new LoginServiceImpl().getAddress(l);
			 HttpSession hs=request.getSession();
			 //hs.setAttribute("userid", userid);
			 hs.setAttribute("username",username);
			 hs.setAttribute("rating",rating);
			 hs.setAttribute("contact", contact);
			 hs.setAttribute("address", address);
			 //pw.print("success");
            //RequestDispatcher rd=request.getRequestDispatcher("/ProductController");
           //rd.forward(request, response);
			 response.sendRedirect("/grizzly-store-vendor-web/ProductController");
            //pw.println(k);

		}
		else { 
            int count=new LoginServiceImpl().getCountValue(l);
            if(count==3)
            {
                  pw.println("Account Locked");
            }
            else
            {
                  int j=new LoginServiceImpl().incrementCount(l,count);
                  System.out.println(j);
                  pw.println(" checkmessage details");
                  RequestDispatcher rd=request.getRequestDispatcher("/login.html");
                  rd.include(request, response);
                  
                  
            }

		}
		
	
	}
	}

