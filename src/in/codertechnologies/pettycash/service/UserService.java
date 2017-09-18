package in.codertechnologies.pettycash.service;

import in.codertechnologies.pettycash.dto.User;

public interface UserService 
{

	boolean addUser(User user);
	boolean isUserExists(User user);
	
}
