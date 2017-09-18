package in.codertechnologies.pettycash.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import in.codertechnologies.pettycash.dao.UserDao;
import in.codertechnologies.pettycash.dao.impl.UserDaoImpl;
import in.codertechnologies.pettycash.dto.User;




public class UserController extends HttpServlet

{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String prefix= "/WEB-INF/Jsps/User/";
		String suffix=".jsp";


		String action= req.getParameter("action");
		
		/*if(action!=null && action.equals("validationofEditProfile"))
		{
			
		}*/

		if( action!= null && action.equals("Logout"))
		{
			HttpSession hs = req.getSession(false);

			if(hs!=null)
			{
				hs.invalidate();
			resp.sendRedirect(resp.encodeRedirectURL("user?Logoutmessage=You Have Successfully Logged out"));
			}
			
		}


		else if(action!=null && action.equals("Register"))
		{
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"Register"+suffix));
			rd.forward(req, resp);
		}
		
		else if(action!=null && action.equals("editProfile"))
		{
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"EditProfile"+suffix));
			rd.forward(req, resp);
		}
		
		else if(action!=null && action.equals("Home"))
		{
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"Home"+suffix));
			rd.forward(req, resp);
		}
		
		else if(action!=null && action.equals("timeout"))
		{
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"Login"+suffix));
			req.setAttribute("timeout", "Session time out");
			rd.forward(req, resp);
		}
		
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"Login"+suffix));
		req.setAttribute("Logoutmessage", req.getParameter("Logoutmessage"));
			rd.forward(req, resp);
		}


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		String action = req.getParameter("action");
		String userName =req.getParameter("uname");
		String userNewPass = req.getParameter("newpass");
		String userOldPass = req.getParameter("oldpass");

		String prefix= "/WEB-INF/Jsps/User/";
		String suffix=".jsp";



		if(action!=null && action.equals("Login"))
		{
			System.out.println(action);
			
			UserDao userDao = new UserDaoImpl();

			User user = new User();
			user.setUname(req.getParameter("uname"));
			user.setPass(req.getParameter("pass"));


			if(userDao.isUserExists(user))
			{

				HttpSession hs = req.getSession();
				
				hs.setMaxInactiveInterval(900);			//session timeout
				
				hs.setAttribute("uname", userName.toUpperCase()); // Capital username

				//resp.sendRedirect(resp.encodeRedirectURL("daily"));//dailycontroller
				RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"Home"+suffix));
				rd.forward(req, resp);
				
				
			}

			else
			{
				RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"Login"+suffix));
				req.setAttribute("logInFailed", "InCorrect UserName & Password");
				rd.forward(req, resp);
			}
		}

		else if(action!=null && action.equals("Register"))
		{
			System.out.println(action);
			UserDao userDao = new UserDaoImpl();

			User user = new User();

			user.setUname(req.getParameter("uname"));
			user.setPass(req.getParameter("pass"));

			if(userDao.addUser(user))
			{

				HttpSession hs = req.getSession();
				hs.setAttribute("uname", userName);


				RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"Login"+suffix));
				req.setAttribute("registerSuccess", "Registration Successfully");
				rd.forward(req, resp);
			}
			
		
		}
		
		else if(action!=null && action.equals("EditProfile"))
		{
			System.out.println(action);
			UserDao userDao = new UserDaoImpl();

			User user = new User();

			user.setOldpass(req.getParameter("oldpass"));
			user.setNewpass(req.getParameter("newpass"));

			if(userDao.updateUser(user))
			{

				HttpSession hs = req.getSession();
				hs.setAttribute("newpass", userNewPass);
				hs.setAttribute("oldpass", userOldPass);
				
				hs=req.getSession(false);
				
				hs.invalidate();


				RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"Login"+suffix));
				req.setAttribute("changePassword", "Change Password Successfully");
				rd.forward(req, resp);
			}
			else
				
			{
				RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"EditProfile"+suffix));
				req.setAttribute("NotchangePassword", "Change Password Not Updated");
				rd.forward(req, resp);
			}
			
		
		}
		
		
		

	}
}
