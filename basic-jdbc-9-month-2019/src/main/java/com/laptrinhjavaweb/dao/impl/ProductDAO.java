package com.laptrinhjavaweb.dao.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.laptrinhjavaweb.dao.iProductDAO;
import com.laptrinhjavaweb.entity.*;
public class ProductDAO implements iProductDAO{


	@Override
	public List<Product> findAll() {
		List<Product> results = new ArrayList<Product>();
		Connection con = ConnectionDAO.getConnection();
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
					Product product = new Product();
					product.setId(resultSet.getInt("id"));
					product.setName(resultSet.getString("name"));
					product.setPrice(resultSet.getDouble("price"));
					product.setImageName(resultSet.getString("image_name"));
					product.setImageData(resultSet.getBlob("image_data"));
					product.setDescription(resultSet.getString("description"));
					product.setCategoryId(resultSet.getInt("category_id"));
					product.setProductTypeId(resultSet.getInt("producttype_id"));
					product.setCreatedBy(resultSet.getString("created_by"));
					product.setModifiedBy(resultSet.getString("modified_by"));
//					product.setCreatedDay(resultSet.getTimestamp("created_day"));
//					product.setModifiedDay(resultSet.getTimestamp("modified_day"));
					results.add(product);
				}
				return results;
			} catch (SQLException e) {
				return null;
			}finally {
				try {
					ConnectionDAO.closeConnection(con, resultSet, statement);
				} catch (Exception e2) {
					return null;
				}
			}
		}
		
		return null;
	}

	@Override
	public List<Product> findByCategoryId(int x) {
		Connection con = ConnectionDAO.getConnection();
		List<Product> results = new ArrayList<Product>();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		String sql = "select * from product where category_id = ?";
		if(con != null) {
			try {
				statement = con.prepareStatement(sql);
				statement.setInt(1, x);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					Product product = new Product();
					product.setId(resultSet.getInt("id"));
					product.setName(resultSet.getString("name"));
					product.setPrice(resultSet.getDouble("price"));
					product.setImageName(resultSet.getString("image_name"));
					product.setImageData(resultSet.getBlob("image_data"));
					product.setDescription(resultSet.getString("description"));
					product.setCategoryId(resultSet.getInt("category_id"));
					product.setProductTypeId(resultSet.getInt("producttype_id"));
					product.setCreatedBy(resultSet.getString("created_by"));
					product.setModifiedBy(resultSet.getString("modified_by"));
//					product.setCreatedDay(resultSet.getTimestamp("created_day"));
//					product.setModifiedDay(resultSet.getTimestamp("modified_day"));
					results.add(product);
				}
				return results;
			} catch (SQLException e) {
				return null;
			}finally {
				try {
					ConnectionDAO.closeConnection(con, resultSet, statement);
				} catch (Exception e2) {
					return null;
				}
			}
		}
		return null;
	}

}
