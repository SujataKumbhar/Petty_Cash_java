package in.codertechnologies.pettycash.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.codertechnologies.pettycash.dao.ProductDao;
import in.codertechnologies.pettycash.dao.impl.ProductDaoImpl;
import in.codertechnologies.pettycash.dto.Product;
import in.codertechnologies.pettycash.exceptions.ProductNotFoundException;
import in.codertechnologies.pettycash.service.ProductService;
import in.codertechnologies.pettycash.service.impl.ProductServiceImpl;


  

public class ProductController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		String prefix= "/WEB-INF/Jsps/Product/";
		String suffix=".jsp";


		String action = req.getParameter("action");
		
		ProductService productService = new ProductServiceImpl();


		if(action!=null && action.equals("productupdate"))
		{
			try
			{
				Product product = productService.findpub(Integer.parseInt(req.getParameter("productId")));

				RequestDispatcher rd = req.getRequestDispatcher(resp.encodeRedirectURL(prefix+"updateProduct"+suffix));

				req.setAttribute("product", product);
				rd.forward(req, resp);

			}
			catch(ProductNotFoundException e)
			{
				e.printStackTrace();
			}
		}

		else if(action!=null && action.equals("addProduct"))
		{
			RequestDispatcher rd = req.getRequestDispatcher(resp.encodeRedirectURL(prefix+"addProduct"+suffix));
			rd.forward(req, resp);
		}

		else if(action!=null && action.equals("productdelete"))
		{
			try
			{
				productService.deletepub(Integer.parseInt(req.getParameter("productId")));
				resp.sendRedirect(resp.encodeRedirectURL("product"));

			}catch(ProductNotFoundException e)
			{
				e.printStackTrace();
			}
		}

		else if(action!=null && action.equals("showProducts"))
		{


			List<Product> listOfProducts = productService.getAllProduct();
			RequestDispatcher rd = req.getRequestDispatcher(prefix+"showProducts"+suffix);

			req.setAttribute("listOfProducts", listOfProducts);//passing the publisher
			req.setAttribute("isShowProduct", true);
			rd.forward(req, resp);
		}



		else{

			List<Product> listOfProducts = productService.getAllProduct();

			RequestDispatcher rd = req.getRequestDispatcher(prefix+"showProducts"+suffix);

			req.setAttribute("listOfProducts", listOfProducts);//passing the publisher
			req.setAttribute("isShowProduct", true);
			rd.forward(req, resp);
		}
	}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		{
			String prefix= "/WEB-INF/Jsps/Product/";
			String suffix=".jsp";


			String action = req.getParameter("action");
			
			ProductDao productDao = new ProductDaoImpl();
			ProductService productService = new ProductServiceImpl();
			RequestDispatcher rd = null;

			if(action!=null && action.equals("addProduct"))
			{

				int pId = Integer.parseInt(req.getParameter("productId"));
				String pName = req.getParameter("productName");


				Product product = new Product();
				product.setProductId(pId);
				product.setProductName(pName);
				
				if(productDao.addpub(product))
				{
					List<Product> listOfProducts = productDao.getAllProduct();
					rd = req.getRequestDispatcher(resp.encodeURL(prefix+"showProducts"+suffix));
					req.setAttribute("listOfProducts", listOfProducts);
					rd.forward(req, resp);
				}
			}

			else if(action!=null && action.equals("productupdate"))
			{
				int pId = Integer.parseInt(req.getParameter("productId"));
				String pName = req.getParameter("productName");


				Product product = new Product();
				product.setProductId(pId);
				product.setProductName(pName);

				if(productDao.updatepub(product))
				{
					List<Product> listOfProducts = productDao.getAllProduct();
					rd = req.getRequestDispatcher(resp.encodeURL(prefix+"showProducts"+suffix));
					req.setAttribute("listOfProducts", listOfProducts);
					rd.forward(req, resp);
				}


			}

			else
			{
				List<Product> listOfProducts = productDao.getAllProduct();
				rd = req.getRequestDispatcher(resp.encodeURL(prefix+"showProducts"+suffix));
				req.setAttribute("listOfProducts", listOfProducts);
				rd.forward(req, resp);
			}

		}
	}
}
