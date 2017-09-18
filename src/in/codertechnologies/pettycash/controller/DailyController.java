package in.codertechnologies.pettycash.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import in.codertechnologies.pettycash.dao.DailyDao;
import in.codertechnologies.pettycash.dao.ProductDao;
import in.codertechnologies.pettycash.dao.impl.DailyDaoImpl;
import in.codertechnologies.pettycash.dao.impl.ProductDaoImpl;
import in.codertechnologies.pettycash.dto.Daily;
import in.codertechnologies.pettycash.dto.Product;
import in.codertechnologies.pettycash.dto.SearchEngine;
import in.codertechnologies.pettycash.exceptions.DataNotFoundException;
import in.codertechnologies.pettycash.service.DailyService;
import in.codertechnologies.pettycash.service.impl.DailyServiceImpl;



public class DailyController extends HttpServlet
{
	
	/*pagination*/
	
	public DailyController() {
        super();
}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String prefix="/WEB-INF/Jsps/DailyInfo/";
		String suffix=".jsp";
		DailyService dailyService=new DailyServiceImpl();
		String action=req.getParameter("action");
		
		
		
	

		if(action!=null && action.equals("update"))
		{
			try {
				System.out.println(req.getParameter("did"));
				ProductDao productdao = new ProductDaoImpl();
				List<Product> listOfProducts = productdao.getAllProduct();
				
				Daily daily =dailyService.findDaily(Integer.parseInt(req.getParameter("did")));
				System.out.println(daily);
				RequestDispatcher rd=req.getRequestDispatcher((resp.encodeURL(prefix+"UpdateDaily"+suffix)));
				req.setAttribute("listOfProducts", listOfProducts);
				req.setAttribute("daily", daily);
				rd.forward(req, resp);
			} 
			catch (NumberFormatException | DataNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		else if(action!=null && action.equals("addDaily"))
		{

			ProductDao productdao = new ProductDaoImpl();
			List<Product> listOfProducts = productdao.getAllProduct();

			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeRedirectURL(prefix+"AddDaily"+suffix));
			req.setAttribute("listOfProducts", listOfProducts);
			rd.forward(req, resp);

		}

		else if(action!=null && action.equals("delete"))
		{
			try
			{
				dailyService.deleteDaily((Integer.parseInt(req.getParameter("did"))));
				resp.sendRedirect(resp.encodeRedirectURL("daily"));

			}
			catch (NumberFormatException | DataNotFoundException e) 
			{
				e.printStackTrace();
			}

		}


		else if(action!=null && action.equals("ShowDaily"))
		{
			List<Daily> ShowDaily = dailyService.ShowAllTotalOfDay();

			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowDaily"+suffix));
			req.setAttribute("isShowDaily", true);
			req.setAttribute("ShowDaily", ShowDaily);
			rd.forward(req, resp);
		}

		else if(action!=null && action.equals("ShowDetailsDaily"))
		{
				
			/*pagination*/
			
			HttpSession hs = req.getSession();
			//hs.setAttribute(recordsPerPage, 5);
			
			int page = 1;
	        int recordsPerPage = 5;
	        
	        int limit = 5;
	        int offset ;
	        System.out.println("Here " + hs.getAttribute("offset"));
	        if(hs.getAttribute("offset")==null)
	        {
	        	offset = 0;
	        }
	        else
	        {
	        	
	        	offset = (Integer)hs.getAttribute("offset");
	        	String p = req.getParameter("p");
		        if(p!=null){
		        if(p.equalsIgnoreCase("prev"))
		        	offset-=limit;
		        else if(p.equalsIgnoreCase("next"))
		        	offset+=limit;
		        else if(p.equalsIgnoreCase("pages"))
		        	offset+=limit;
		        }
	        	//offset += 5;
	        	
	        }
	       
	        
	        hs.setAttribute("offset", offset);
	        
	        DailyDao dao = new DailyDaoImpl();
	        List<Daily> showDetailsDaily = dao.getRecords(offset,limit);
	        int noOfRecords = dao.getNoOfRecords();
	        System.out.println(noOfRecords);
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / limit);
	        
	        req.setAttribute("isShowDetailsDaily", true);
	        req.setAttribute("showDetailsDaily", showDetailsDaily);
	        req.setAttribute("noOfPages", noOfPages);
	       
	        req.setAttribute("noOfRecords", noOfRecords);
	        req.setAttribute("currentPage", page);
	        
	        
	        
	        RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowDetailsDaily"+suffix));
	        rd.forward(req, resp);
	    
			
				
		}
		
		else if(action!=null && action.equals("ShowWeekly"))
		{
			
			
			
			/*pagination*/
			
			HttpSession hs = req.getSession();
		
			
			int page = 1;
	        int recordsPerPage = 5;
	        
	        int limit = 50;
	        int offset ;
	        System.out.println("Here " + hs.getAttribute("offset"));
	        if(hs.getAttribute("offset")==null)
	        {
	        	offset = 0;
	        }
	        else
	        {
	        	
	        	offset = (Integer)hs.getAttribute("offset");
	        	String p = req.getParameter("p");
		        if(p!=null){
		        if(p.equalsIgnoreCase("prev"))
		        	offset-=limit;
		        else if(p.equalsIgnoreCase("next"))
		        	offset+=limit;
		        }
	        	
	        	
	        }
	       
	        
	        hs.setAttribute("offset", offset);
	        
	        DailyDao dao = new DailyDaoImpl();
	        List<Daily> ShowWeekly = dao.getRecords(offset,limit);
	        int noOfRecords = dao.getNoOfRecords();
	        System.out.println(noOfRecords);
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	        req.setAttribute("ShowWeekly", ShowWeekly);
	        req.setAttribute("noOfPages", noOfPages);
	        System.out.println(noOfRecords);
	        req.setAttribute("noOfRecords", noOfRecords);
	        req.setAttribute("currentPage", page);
	        System.out.println(noOfPages);
	        System.out.println(page);
	        RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowWeekly"+suffix));
	        rd.forward(req, resp);
	    
			req.setAttribute("isShowWeekly", true);
				
		}

		else if(action!=null && action.equals("ShowDetailsParticularDate"))
		{
			List<Daily> ShowDetailsParticularDate = dailyService.SearchByDetailParticularDate(Date.valueOf(req.getParameter("date1")));
			System.out.println(ShowDetailsParticularDate);
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowDetailsParticularDate"+suffix));
			req.setAttribute("isShowDetailsParticularMonth", true);
			req.setAttribute("ShowDetailsParticularDate", ShowDetailsParticularDate);
			rd.forward(req, resp);	
		}


		else if(action!=null && action.equals("ShowMonthly"))
		{

			List<Daily> ShowMonthly = dailyService.ShowAllTotalOfMonth();

			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowMonthly"+suffix));
			req.setAttribute("isShowMonthly", true);
			req.setAttribute("ShowMonthly", ShowMonthly);
			rd.forward(req, resp);
		}


		else if(action!=null && action.equals("ShowDetailsParticularMonth"))
		{
			List<Daily> ShowDetailsParticularMonth = dailyService.SearchByDetailParticularMonth(Date.valueOf(req.getParameter("date1")));

			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowDetailsParticularMonth"+suffix));
			req.setAttribute("isShowDetailsParticularMonth", true);
			req.setAttribute("ShowDetailsParticularMonth", ShowDetailsParticularMonth);
			rd.forward(req, resp);	
		}

		else if(action!=null && action.equals("ShowYearly"))
		{
			List<Daily> ShowYearly = dailyService.ShowAllTotalOfYear();

			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowYearly"+suffix));
			req.setAttribute("isShowYearly", true);
			req.setAttribute("ShowYearly", ShowYearly);
			rd.forward(req, resp);
		}

		else if(action!=null && action.equals("ShowDetailsParticularYear"))
		{
			List<Daily> ShowDetailsParticularYear = dailyService.SearchByDetailParticularYear(Date.valueOf(req.getParameter("date1")));

			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowDetailsParticularYear"+suffix));
			req.setAttribute("isShowDetailsParticularMonth", true);
			req.setAttribute("ShowDetailsParticularYear", ShowDetailsParticularYear);
			rd.forward(req, resp);	
		}



		/*Search Engine Part*/


		else if(action!=null && action.equals("searchProductName"))	
		{
			System.out.println();
			resp.setContentType("application/json");
			DailyDao dailyDao = new DailyDaoImpl();
			PrintWriter  out = resp.getWriter();

			//if(bName!=null && bName.length() >= 2 )

			List<SearchEngine> searchProductName = dailyDao.SearchByProduct(req.getParameter("productName"));


			Gson gson = new Gson();
			
			System.out.println(gson.toJson(searchProductName));
			out.println(gson.toJson(searchProductName));
			out.flush();

			out.close();
		}

		else if(action!=null && action.equals("searchDate"))	
		{
			resp.setContentType("application/json");
			DailyDao dailyDao = new DailyDaoImpl();

			PrintWriter  out = resp.getWriter();

			List<SearchEngine> searchDate = dailyDao.SearchByDate(req.getParameter("date1"));


			Gson gson = new Gson();
			System.out.println(gson.toJson(searchDate));
			out.println(gson.toJson(searchDate));
			out.flush();

			out.close();
		}

		else if(action!=null && action.equals("searchMonth"))	
		{
			resp.setContentType("application/json");
			DailyDao dailyDao = new DailyDaoImpl();
			
			PrintWriter  out = resp.getWriter();

			List<SearchEngine> searchMonth = dailyDao.SearchByMonth(req.getParameter("date1"));

			Gson gson = new Gson();
			System.out.println(gson.toJson(searchMonth));
			out.println(gson.toJson(searchMonth));
			out.flush();

			out.close();
		}
		
		/*About Us & Contact us*/
		
		else if(action!=null && action.equals("AboutUs"))
		{
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"AboutUs"+suffix));
			rd.forward(req, resp);
		}
		
		else if(action!=null && action.equals("ContactUs"))
		{

			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ContactUs"+suffix));
			rd.forward(req, resp);
		}

		else
		{
			List<Daily> showDetailsDaily = dailyService.getAllDaily();
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowDetailsDaily"+suffix));
			req.setAttribute("isShowDetailsDaily", true);
			req.setAttribute("showDetailsDaily", showDetailsDaily);
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{


		String prefix="/WEB-INF/Jsps/DailyInfo/";
		String suffix=".jsp";
		DailyService dailyService=new DailyServiceImpl();

		DailyDao dailyDao=new DailyDaoImpl();

		String action=req.getParameter("action");

		if(action!=null && action.equals("update"))
		{
			System.out.println(req.getParameter("did"));

			int did=Integer.parseInt(req.getParameter("did"));
			int productPrice = Integer.parseInt(req.getParameter("productPrice"));
			int productQuantity = Integer.parseInt(req.getParameter("productQuantity"));
			int productTotal=productPrice*productQuantity;
			String pname=req.getParameter("productName");
			//productTotal = Integer.parseInt(req.getParameter("productTotal"));



			Daily daily=new Daily();
			daily.setDid(did);
			daily.setProductPrice(productPrice);
			daily.setProductQuantity(productQuantity);
			daily.setProductTotal(productTotal);

			Product product =new Product();
			product.setProductName(pname);
			daily.setDailyProduct(product);

			if(dailyDao.updateDaily(daily))
			{

				List<Daily> showDetailsDaily = dailyService.getAllDaily();
				RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowDetailsDaily"+suffix));
				req.setAttribute("isShowDetailsDaily", true);
				req.setAttribute("showDetailsDaily", showDetailsDaily);
				rd.forward(req, resp);
			}

		}


		else if(action!=null && action.equals("addDaily"))
		{
			//dailyDao=new DailyDaoImpl();
			System.out.println(action);
			//int did=Integer.parseInt(req.getParameter("did"));
			
			
			int ProductPrice = Integer.parseInt(req.getParameter("productPrice"));
			int productQuantity = Integer.parseInt(req.getParameter("productQuantity"));
			int productTotal=ProductPrice*productQuantity;
			String pname=req.getParameter("pname");

			
			
			Daily daily=new Daily();
			//daily.setDid(did);
			daily.setDate1(new Date(new java.util.Date().getTime()));
			daily.setProductPrice(ProductPrice);
			daily.setProductQuantity(productQuantity);
			daily.setProductTotal(productTotal);

			//daily.setpId();
			Product product =new Product();
			product.setProductName(pname);
			daily.setDailyProduct(product); 


			if(dailyDao.addDaily(daily))
			{

				List<Daily> showDetailsDaily = dailyService.getAllDaily();
				RequestDispatcher rd = req.getRequestDispatcher(resp.encodeURL(prefix+"ShowDetailsDaily"+suffix));
				req.setAttribute("isShowDetailsDaily", true);
				req.setAttribute("showDetailsDaily", showDetailsDaily);
				resp.sendRedirect("/PettyCashLatest1/daily?action=ShowDetailsDaily");
				
			}


		}


	}
}
