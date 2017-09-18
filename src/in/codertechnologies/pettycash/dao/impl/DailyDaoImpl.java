
package in.codertechnologies.pettycash.dao.impl;

import java.sql.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import in.codertechnologies.pettycash.dao.DBConstant;
import in.codertechnologies.pettycash.dao.DailyDao;
import in.codertechnologies.pettycash.dao.ProductDao;
import in.codertechnologies.pettycash.dto.Daily;
import in.codertechnologies.pettycash.dto.Product;
import in.codertechnologies.pettycash.dto.SearchEngine;
import in.codertechnologies.pettycash.exceptions.DataNotFoundException;
import in.codertechnologies.pettycash.exceptions.ProductNotFoundException;



public class DailyDaoImpl extends DaoSupport implements DailyDao
{

	private PreparedStatement ps;
	private ProductDao productdao;
	public ResultSet rs;

	/*pagination purpose*/
	Statement stmt;
	private int noOfRecords;

	public DailyDaoImpl()
	{
		productdao = new ProductDaoImpl();
	}

	@Override
	public boolean addDaily(Daily daily) {

		int pid= productdao.getProductIdByProductName(daily.getDailyProduct().getProductName());

		try
		{

			ps=getConnection().prepareStatement(DBConstant.InsertData);
			ps.setInt(1, daily.getDid());
			ps.setDate(2,  daily.getDate1());
			if(pid!=0)
			{
				ps.setInt(3, pid);
			}

			ps.setInt(4, daily.getProductPrice());
			ps.setInt(5, daily.getProductQuantity());
			ps.setInt(6, daily.getProductTotal());//automatically calculated using ajax
			ps.executeUpdate();

			return true;

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateDaily(Daily daily)
	{

		try


		//PreparedStatement ps=getConnection().prepareStatement(DBConstant.UpdateData);

		//PreparedStatement ps=getConnection().prepareStatement("update daily d,product p set d.productPrice=?,d.productQuantity=?,d.productTotal=?,p.productName=? where d.did=p.productId;");



		{
			PreparedStatement ps=getConnection().prepareStatement(DBConstant.UpdateData);

			ps.setInt(1, daily.getProductPrice());
			ps.setInt(2, daily.getProductQuantity());
			ps.setInt(3, daily.getProductTotal());//automatically calculated using ajax
			ps.setInt(4, daily.getDid());

			/*Product p =new Product();
			ps.setString(4, p.getProductName());*/
			ps.executeUpdate();
			return true;

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean deleteDaily(int did) throws DataNotFoundException {
		try {
			ps=getConnection().prepareStatement(DBConstant.DeleteData);
			ps.setInt(1, did);
			ps.executeUpdate();

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Daily findDaily(int did) throws DataNotFoundException {

		try{
			ps = getConnection().prepareStatement(DBConstant.FindData);
			ps.setInt(1, did);
			rs = ps.executeQuery();


			while(rs.next())
			{
				Daily d= new Daily();
				Product p = new  Product();

				d.setDid(rs.getInt("did"));
				d.setDate1(rs.getDate("date1"));
				d.setpId(rs.getInt("pId"));
				d.setProductPrice(rs.getInt("productPrice"));
				d.setProductQuantity(rs.getInt("productQuantity"));
				p.setProductId(rs.getInt("pId"));
				p.setProductName(rs.getString("productName"));
				d.setProductTotal(rs.getInt("productTotal"));	
				d.setDailyProduct(p);
				return d;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Daily> getAllDaily() 
	{

		List<Daily> b1 = new ArrayList<>();
		try

		(PreparedStatement pubps = getConnection().prepareStatement(DBConstant.GET_PRODUCT_NAME_BY_ID);
				PreparedStatement ps = getConnection().prepareStatement(DBConstant.GET_ALL_Daily);
				ResultSet rs = ps.executeQuery();)
		{

			while(rs.next())
			{
				int did = rs.getInt("did");

				Daily b = new Daily();

				b.setDid(did);
				b.setDate1(rs.getDate("date1"));
				b.setProductPrice(rs.getInt("productPrice"));
				b.setProductQuantity(rs.getInt("productQuantity"));
				b.setProductTotal(rs.getInt("productTotal"));

				pubps.setInt(1, did);

				ResultSet pubrs = pubps.executeQuery();
				pubrs.next();


				Product p = new Product();
				p.setProductId(rs.getInt("pId"));
				p.setProductName(pubrs.getString(1));

				b.setDailyProduct(p);

				b1.add(b);

			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return b1;
	}

	@Override
	public List<Daily> SearchByDetailParticularDate(Date date1) {


		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		try(PreparedStatement ps = getConnection().prepareStatement(DBConstant.SearchByDetailParticularDate))
		{
			Daily daily =null;
			List<Daily> a1 = new ArrayList<Daily>();
			ps.setInt(1, c.get(Calendar.DAY_OF_MONTH));
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				int did = rs.getInt(1);
				daily = new Daily();

				daily.setDid(did);
				daily.setDate1(rs.getDate("date1"));
				daily.setProductPrice(rs.getInt("productPrice"));
				daily.setProductQuantity(rs.getInt("productQuantity"));
				daily.setProductTotal(rs.getInt("productTotal"));

				int pid= rs.getInt("pId");
				Product p = null;
				try
				{
					p = new ProductDaoImpl().findpub(pid);
				} catch (ProductNotFoundException e)
				{

					e.printStackTrace();
				}

				daily.setDailyProduct(p);

				a1.add(daily);
			}
			return a1;
		}


		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public List<Daily> ShowAllTotalOfDay() {
		List<Daily> a1 = new ArrayList<>();
		try
		{
			PreparedStatement ps = getConnection().prepareStatement(DBConstant.ShowAllTotalOfDay);

			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Daily b = new Daily();

				b.setDate1(rs.getDate("date1"));
				b.setProductTotal(rs.getInt("Total"));

				a1.add(b);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a1;

	}

	@Override
	public List<Daily> SearchByDetailParticularMonth(Date date1)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
	

		try(PreparedStatement ps = getConnection().prepareStatement(DBConstant.SearchByDetailParticularMonth))
		{	
			List<Daily> a1 = new ArrayList<>();
			ps.setInt(1, c.get(Calendar.MONTH)+1);
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				Daily b = new Daily();

				b.setDate1(rs.getDate("date1"));
				b.setProductTotal(rs.getInt("Total"));

				a1.add(b);
			}
			System.out.println(a1+" hsdksjdhskdhksjdhjskdhjkshdk");
			return a1;
		}


		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Daily> ShowAllTotalOfMonth() {

		List<Daily> a1 = new ArrayList<>();
		try
		{
			PreparedStatement ps = getConnection().prepareStatement(DBConstant.ShowAllTotalOfMonth);

			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Daily b = new Daily();

				b.setDate1(rs.getDate("date1"));
				b.setProductTotal(rs.getInt("Total"));
				a1.add(b);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a1;
	}

	@Override
	public List<Daily> ShowAllTotalOfYear() {

		List<Daily> a1 = new ArrayList<>();
		try
		{
			PreparedStatement ps = getConnection().prepareStatement(DBConstant.ShowAllTotalOfYEAR);

			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Daily b = new Daily();

				b.setDate1(rs.getDate("date1"));
				b.setProductTotal(rs.getInt("Total"));
				a1.add(b);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a1;
	}


	@Override
	public List<Daily> SearchByDetailParticularYear(Date date1) {

		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		System.out.println(c.get(Calendar.YEAR));

		try(PreparedStatement ps = getConnection().prepareStatement(DBConstant.SearchByDetailParticularYear))
		{
			List<Daily> a1 = new ArrayList<>();
			ps.setInt(1, c.get(Calendar.YEAR));
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				Daily b = new Daily();

				b.setDate1(rs.getDate("date1"));
				b.setProductTotal(rs.getInt("Total"));
				a1.add(b);
			}
			return a1;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;

	}

	/*Search Engine Part*/

	@Override
	public List<SearchEngine> SearchByProduct(String productName)

	{
		try(PreparedStatement pstmtGetAll =getConnection().prepareStatement(DBConstant.SearchByProduct);	

				)
		{
			List<SearchEngine> searchDetail=new ArrayList<SearchEngine>();
			pstmtGetAll.setString(1 ,productName+"%");
			System.out.println(productName+"jhdsfsdjh");
			rs =pstmtGetAll.executeQuery();

			while(rs.next())
			{
				System.out.println("Here");
				Product p = new Product();
				Daily d = new Daily();
				SearchEngine s = new SearchEngine();

				d.setDid(rs.getInt("did"));
				d.setDate1(rs.getDate("date1"));

				p.setProductName(rs.getString("productName"));

				d.setProductPrice(rs.getInt("productPrice"));
				d.setProductTotal(rs.getInt("productTotal"));
				d.setProductQuantity(rs.getInt("productQuantity"));

				s.setDaily(d);
				s.setProduct(p);
				searchDetail.add(s);

			}

			return searchDetail;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SearchEngine> SearchByDate(String date1) 

	{
		try(PreparedStatement pstmtGetAll =getConnection().prepareStatement(DBConstant.SearchByDate))	


		{
			List<SearchEngine> searchDetail=new ArrayList<SearchEngine>();
			pstmtGetAll.setString(1 ,date1+"%");
			rs =pstmtGetAll.executeQuery();

			while(rs.next())
			{
				Product p = new Product();
				Daily d = new Daily();
				SearchEngine s = new SearchEngine();

				d.setDid(rs.getInt("did"));
				d.setDate1(rs.getDate("date1"));

				p.setProductName(rs.getString("productName"));

				d.setProductPrice(rs.getInt("productPrice"));
				d.setProductTotal(rs.getInt("productTotal"));
				d.setProductQuantity(rs.getInt("productQuantity"));

				s.setDaily(d);
				s.setProduct(p);
				searchDetail.add(s);

			}
			return searchDetail;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SearchEngine> SearchByMonth(String date1) 
	{
		try(PreparedStatement pstmtGetAll =getConnection().prepareStatement(DBConstant.SearchByMonth))	

		{
			System.out.println(date1);
			List<SearchEngine> searchDetail=new ArrayList<SearchEngine>();
			pstmtGetAll.setString(1 ,date1+"%");
			rs =pstmtGetAll.executeQuery();

			while(rs.next())
			{

				Daily d = new Daily();
				SearchEngine s = new SearchEngine();

				d.setDate1(rs.getDate("date1"));
				d.setProductTotal(rs.getInt("Total"));

				s.setDaily(d);

				searchDetail.add(s);

			}
			return searchDetail;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Daily> getRecords(int offset,int limit) {

		
		List<Daily> b1 = new ArrayList<Daily>();
		try

		(PreparedStatement pubps = getConnection().prepareStatement(DBConstant.GET_PRODUCT_NAME_BY_ID);
				PreparedStatement ps = getConnection().prepareStatement(DBConstant.GET_ALL_DAILY_PAGINATION)
				)

		{
			ps.setInt(1,limit);
			ps.setInt(2, offset);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int did = rs.getInt("did");

				Daily b = new Daily();

				b.setDid(did);
				b.setDate1(rs.getDate("date1"));
				b.setProductPrice(rs.getInt("productPrice"));
				b.setProductQuantity(rs.getInt("productQuantity"));
				b.setProductTotal(rs.getInt("productTotal"));

				pubps.setInt(1, did);

				ResultSet pubrs = pubps.executeQuery();
				pubrs.next();


				Product p = new Product();
				p.setProductId(rs.getInt("pId"));
				p.setProductName(pubrs.getString(1));

				b.setDailyProduct(p);

				b1.add(b);

			}
			//rs.close();
			//rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
				this.noOfRecords = rs.getInt(1);

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return b1;

	}

	@Override
	public int getNoOfRecords() {
		// TODO Auto-generated method stub	
		int noOfRecords=0;
		try {
			ps=getConnection().prepareStatement(DBConstant.GET_ALL_Daily);
			ResultSet rs = ps.executeQuery();
			rs.last();
			noOfRecords = rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return noOfRecords;	
	}
	//http://tech24salt.blogspot.in/2013/06/pagination-in-jsp-and-servlet.html
}











