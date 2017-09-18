package in.codertechnologies.pettycash.dao.impl;

import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class DaoSupport 
{
 private Connection con;
 private DataSource datasource;
 
 public DaoSupport()
 {
	Properties p=new Properties();
	
	try{
		p.load(DailyDaoImpl.class.getResourceAsStream("../../../../../resource/database.properties"));
		
		datasource=new MysqlDataSource();
		con=datasource.getConnection(p.getProperty("username"),p.getProperty("password"));
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 }
 public Connection getConnection()
 {
	 return con;
 }

public void close()
{
	if(con!=null)
	{
		try {
			con.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
}
