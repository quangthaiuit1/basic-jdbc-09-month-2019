package com.laptrinhjavaweb.dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.entity.Product;
public class ProductDAO {
	
	
	public static List<Product> findAll() {
		List<Product> results = new ArrayList<Product>();
		Connection con = ConnectionDAO.getConnection();
		String sql = "select * from product";
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		
		//open connection
		if(con != null) {
			try {
				// truy�?n câu query vào.
				statement = con.prepareStatement(sql);
				//excute câu query
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					Blob img = null;
					Product product = new Product();
					product.setId(resultSet.getInt("id"));
					product.setName(resultSet.getString("name"));
					product.setPrice(resultSet.getDouble("price"));
					product.setImageName(resultSet.getString("image_name"));
					img = resultSet.getBlob("image_data");
					product.setImageData(img.getBytes(1,(int)img.length()));
					product.setDescription(resultSet.getString("description"));
					product.setCategoryId(resultSet.getInt("category_id"));
					product.setProductTypeId(resultSet.getInt("producttype_id"));
					/*
					 * product.setCreatedBy(resultSet.getString("created_by"));
					 * product.setModifiedBy(resultSet.getString("modified_by"));
					 */
					product.setCreatedDate(resultSet.getTimestamp("created_date"));
					product.setModifiedDate(resultSet.getTimestamp("modified_date"));
					results.add(product);
				}
				return results;
			} catch (SQLException e) {
				return null;
			}finally {
				try {
					ConnectionDAO.closeConnection(con, statement);
					if(resultSet != null)
						resultSet.close();
				} catch (Exception e2) {
					return null;
				}
			}
		}
		
		return null;
	}
	
	public static List<Product> findByLimit(int offset,int limit){
		List<Product> results = new ArrayList<Product>();
		Connection con = ConnectionDAO.getConnection();
		String sql = "SELECT  news.id, news.name, news.description, news.price, news.category_name,\r\n" + 
				"				news.created_date, news.image_data, news.producttype_id, pt.name as producttype_name, news.category_id,\r\n" + 
				"					news.modified_date\r\n" + 
				"	   FROM \r\n" + 
				"			(SELECT p.id, p.name, p.description, p.price, c.name as category_name,\r\n" + 
				"				p.created_date, p.image_data, p.producttype_id, p.category_id,p.modified_date \r\n" + 
				"					FROM product as p \r\n" + 
				"						INNER JOIN category as c ON p.category_id = c.id) \r\n" + 
				"							as news \r\n" + 
				"								INNER JOIN product_type as pt ON news.producttype_id = pt.id LIMIT ? ,?;\r\n" + 
				"";
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		
		//open connection
		if(con != null) {
			try {
				// truy�?n câu query vào.
				statement = con.prepareStatement(sql);
				//excute câu query
				statement.setInt(1, offset);
				statement.setInt(2, limit);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					Blob img = null;
					Product product = new Product();
					product.setId(resultSet.getInt("id"));
					product.setName(resultSet.getString("name"));
					product.setPrice(resultSet.getDouble("price"));
					
					img = resultSet.getBlob("image_data");
					product.setImageData(img.getBytes(1,(int)img.length()));
					product.setDescription(resultSet.getString("description"));
					product.setCategoryId(resultSet.getInt("category_id"));
					product.setProductTypeId(resultSet.getInt("producttype_id"));
					product.setCategoryName(resultSet.getString("category_name"));
					product.setProductTypeName(resultSet.getString("producttype_name"));
					/*
					 * product.setCreatedBy(resultSet.getString("created_by"));
					 * product.setModifiedBy(resultSet.getString("modified_by"));
					 */
					product.setCreatedDate(resultSet.getTimestamp("created_date"));
					product.setModifiedDate(resultSet.getTimestamp("modified_date"));
					//product.setImageName(resultSet.getString("name_image"));
					results.add(product);
				}
				return results;
			} catch (SQLException e) {
				return null;
			}finally {
				try {
					ConnectionDAO.closeConnection(con, statement);
					if(resultSet != null)
						resultSet.close();
				} catch (Exception e2) {
					return null;
				}
			}
		}
		return null;
	}

	public static List<Product> findByCategoryId(int x) {
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
					Blob img = null;
					Product product = new Product();
					product.setId(resultSet.getInt("id"));
					product.setName(resultSet.getString("name"));
					product.setPrice(resultSet.getDouble("price"));
					product.setImageName(resultSet.getString("image_name"));
					img = resultSet.getBlob("image_data");
					product.setImageData(img.getBytes(1,(int)img.length()));
					product.setDescription(resultSet.getString("description"));
					product.setCategoryId(resultSet.getInt("category_id"));
					product.setProductTypeId(resultSet.getInt("producttype_id"));
					/*
					 * product.setCreatedBy(resultSet.getString("created_by"));
					 * product.setModifiedBy(resultSet.getString("modified_by"));
					 */
					product.setCreatedDate(resultSet.getTimestamp("created_date"));
					product.setModifiedDate(resultSet.getTimestamp("modified_date"));
					results.add(product);
				}
				return results;
			} catch (SQLException e) {
				return null;
			}finally {
				try {
					ConnectionDAO.closeConnection(con, statement);
					if(resultSet != null)
						resultSet.close();
				} catch (Exception e2) {
					return null;
				}
			}
		}
		return null;
	}

	public static void addOne(Product product) throws FileNotFoundException {
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		FileInputStream fileInput = null;
		String sql = "INSERT INTO product (name, price, category_id, producttype_id,created_date,image_name,image_data) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			
			fileInput = new FileInputStream(product.getImageFile());
			
			statement = con.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setInt(3, product.getCategoryId());
			statement.setInt(4, product.getProductTypeId());
			statement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			statement.setString(6, product.getImageName());
			statement.setBlob(7, fileInput);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				ConnectionDAO.closeConnection(con, statement);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}