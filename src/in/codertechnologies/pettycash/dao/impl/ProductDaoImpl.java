package in.codertechnologies.pettycash.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import in.codertechnologies.pettycash.dao.DBConstant;
import in.codertechnologies.pettycash.dao.ProductDao;
import in.codertechnologies.pettycash.dto.Product;
import in.codertechnologies.pettycash.exceptions.ProductNotFoundException;


public class ProductDaoImpl extends DaoSupport implements ProductDao{

	private PreparedStatement ps;
	private ResultSet rs;
	private DataSource datasource;
	
	@Override
	public List<Product> getAllProduct() {
		List<Product> plist=new ArrayList<>();
		
		try{
			ps=getConnection().prepareStatement(DBConstant.Get_All_Products);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Product p=new Product();
				p.setProductId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				plist.add(p);			
			}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		//System.out.println(plist);
		return plist;
	}
	@Override
	public int getProductIdByProductName(String pName) {
		
		try(PreparedStatement ps = getConnection().prepareStatement(DBConstant.Get_ProductId_ByName))
		{
			ps.setString(1, pName);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt("productId");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public boolean addpub(Product product) {
		
		int count =0;
		try
		{
			ps=getConnection().prepareStatement(DBConstant.INSERT_PRODUCT);
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());

			count = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count!=0;
	}
	@Override
	public Product findpub(int productId) throws ProductNotFoundException {
		Product product = new Product();
		
		try(PreparedStatement ps = getConnection().prepareStatement(DBConstant.GET_BY_PRODUCT_ID))
		{
			ps.setInt(1, productId);
			rs = ps.executeQuery();

			while (rs.next())
			{
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));


			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return product;
		
	}
	@Override
	public boolean updatepub(Product product) {
		
		int count =0;
		try
		{
			ps=getConnection().prepareStatement(DBConstant.UPDATE_PRODUCT);
			ps.setInt(2, product.getProductId());
			ps.setString(1, product.getProductName());

			count = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count!=0;
	}
	@Override
	public boolean deletepub(int productId) throws ProductNotFoundException {
		int count =0;
		try
		{
			ps=getConnection().prepareStatement(DBConstant.DELETE_PRODUCT);
			ps.setInt(1, productId);
			count = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count!=0;	
		}
		

}
