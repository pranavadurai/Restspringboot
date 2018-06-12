package com.rest.mastermicro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.mastermicro.model.User;

@Service
public class UserService {

	private static List<User> users = new ArrayList<>();
	
	private static int Usercount = 3;
	
	static {
		users.add(new User(1,"pranav", new Date()));
		users.add(new User(2,"pranavam", new Date()));
		users.add(new User(3,"pranavadurai", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()== 0 ) {
			user.setId(++Usercount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
        return null;	
	}
	
	public User deletebyid(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
