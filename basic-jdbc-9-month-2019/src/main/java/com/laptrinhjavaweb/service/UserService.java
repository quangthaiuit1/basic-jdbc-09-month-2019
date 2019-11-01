package com.laptrinhjavaweb.service;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.UserDAO;
import com.laptrinhjavaweb.entity.User;

public class UserService {
	public static List<User> findAll() {
		return UserDAO.findAll();
	}
	public static List<User> findByLimit(int offset, int limit){
		return UserDAO.findByLimit(offset, limit);
	}
	public static User findByUserName(String userName){
		return UserDAO.findByUserName(userName);
	}

	// return total page of table based on number items one page
	public static int totalPages(int maxItemOnePage) {
		List<User> list = new ArrayList<User>();
		list = UserDAO.findAll();
		if(list.size() % maxItemOnePage == 0) {
			return list.size() / maxItemOnePage;
		}
		else return (list.size() / maxItemOnePage) + 1;
	}
	public void addOne(User user) {
		UserDAO.addOne(user);
	}

	/*
	 * public void updateOne(User category) { UserDAO.updateOne(category); }
	 */
	public void delete(int[] id) {
		for(int i = 0; i < id.length; i++) {
			UserDAO.delete(id[i]);
		}
	}

}
