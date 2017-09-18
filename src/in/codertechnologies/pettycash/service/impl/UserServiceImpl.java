package in.codertechnologies.pettycash.service.impl;

import in.codertechnologies.pettycash.dao.UserDao;
import in.codertechnologies.pettycash.dao.impl.UserDaoImpl;
import in.codertechnologies.pettycash.dto.User;
import in.codertechnologies.pettycash.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public UserServiceImpl()
	{
		userDao = new UserDaoImpl();
	}


	@Override
	public boolean addUser(User user) {
		
		return userDao.addUser(user);
	}

	@Override
	public boolean isUserExists(User user) {
		
		return userDao.isUserExists(user);
	}

}
