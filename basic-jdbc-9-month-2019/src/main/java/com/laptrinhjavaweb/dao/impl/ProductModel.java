package com.laptrinhjavaweb.dao.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.iProductModel;
import com.laptrinhjavaweb.model.CategoryModel;

public class ProductModel implements iProductModel{

	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shopdan";
			return DriverManager.getConnection(url, "root","voquangthai");
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<CategoryModel>();
		Connection con = getConnection();
		String sql = "select * from category";
		ResultSet resultSet = null;
		
		//open connection
		if(con != null) {
			try {
				// truyền câu query vào.
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				//excute câu query
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					CategoryModel category = new CategoryModel();
					
					results.add(category);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return results;
	}
	

}
