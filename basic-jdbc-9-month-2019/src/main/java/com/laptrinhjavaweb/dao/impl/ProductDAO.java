package com.laptrinhjavaweb.dao.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.laptrinhjavaweb.dao.iProductDAO;
import com.laptrinhjavaweb.model.*;
public class ProductDAO implements iProductDAO{

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
	public List<ProductModel> findAll() {
		List<ProductModel> results = new ArrayList<ProductModel>();
		Connection con = getConnection();
		String sql = "select * from product";
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		
		//open connection
		if(con != null) {
			try {
				// truyền câu query vào.
				statement = con.prepareStatement(sql);
				//excute câu query
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					ProductModel product = new ProductModel();
					product.setId(resultSet.getInt("id"));
					product.setName(resultSet.getString("name"));
					product.setPrice(resultSet.getDouble("price"));
					product.setImageName(resultSet.getString("image_name"));
					product.setImageData(resultSet.getBlob("image_data"));
					product.setDescription(resultSet.getString("description"));
					product.setCategoryId(resultSet.getInt("category_id"));
					product.setProductTypeId(resultSet.getInt("producttype_id"));
					product.setCreatedBy(resultSet.getInt("create_by"));
					product.setModifiedBy(resultSet.getInt("modified_by"));
					product.setCreatedDay(resultSet.getTimestamp("created_day"));
					product.setModifiedDay(resultSet.getTimestamp("modified_day"));
					results.add(product);
				}
				if(con != null) {
					con.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				return null;
			}finally {
				try {
					if(con != null) {
						con.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
					if(statement != null) {
						statement.close();
					}
				} catch (Exception e2) {
					return null;
				}
			}
		}
		
		return null;
	}

}
