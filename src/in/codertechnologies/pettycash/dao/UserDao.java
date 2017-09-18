package in.codertechnologies.pettycash.dao;

import in.codertechnologies.pettycash.dto.User;

public interface UserDao {
	
	boolean addUser(User user);
	boolean isUserExists(User user);
	boolean updateUser(User user);

}
