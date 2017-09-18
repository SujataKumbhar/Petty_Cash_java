package in.codertechnologies.pettycash.dao.impl;

import java.sql.*;

import in.codertechnologies.pettycash.dao.DBConstant;
import in.codertechnologies.pettycash.dao.UserDao;
import in.codertechnologies.pettycash.dto.User;



public class UserDaoImpl extends DaoSupport implements UserDao{

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean addUser(User user) 
	{

		int count =0;
		try
		{
			ps=getConnection().prepareStatement(DBConstant.ADD_USER);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPass());

			count = ps.executeUpdate();

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count!=0;
	}

	@Override
	public boolean isUserExists(User user) {
		
		try
		{
			ps = getConnection().prepareStatement(DBConstant.GET_ALL_USER);
			rs = ps.executeQuery();

			while(rs.next())
			{
				if(user.getUname().equals(rs.getString ("userName")) && user.getPass().equals(rs.getString("userPass")))
				{
					return true;
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		
		int count =0;
		try
		{
			ps=getConnection().prepareStatement(DBConstant.UPDATE_USER);
			ps.setString(1, user.getNewpass());
			ps.setString(2, user.getOldpass());

			count = ps.executeUpdate();

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count!=0;
	}

}
