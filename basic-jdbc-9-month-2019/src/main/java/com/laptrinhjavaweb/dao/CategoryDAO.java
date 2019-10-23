package com.laptrinhjavaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.entity.Category;

public class CategoryDAO {

	public static List<Category> findAll() {
		List<Category> results = new ArrayList<Category>();
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from category";
		ResultSet resultSet = null;
		if (con != null) {
			try {
				statement = con.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Category category = new Category();
					category.setId(resultSet.getInt("id"));
					category.setName(resultSet.getNString("name"));
					results.add(category);
				}
				return results;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					ConnectionDAO.closeConnection(con, statement);
					if (resultSet != null)
						resultSet.close();
				} catch (Exception e2) {
					return null;
				}
			}
		}
		return null;
	}
	//Select pagination
	public static List<Category> findByRows(int offset, int limit) {
		List<Category> results = new ArrayList<Category>();
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from category Orders LIMIT ?, ?";
		ResultSet resultSet = null;
		if (con != null) {
			try {
				statement = con.prepareStatement(sql);
				statement.setInt(1, offset);
				statement.setInt(2, limit);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Category category = new Category();
					category.setId(resultSet.getInt("id"));
					category.setName(resultSet.getNString("name"));
					results.add(category);
				}
				return results;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					ConnectionDAO.closeConnection(con, statement);
					if (resultSet != null)
						resultSet.close();
				} catch (Exception e2) {
					return null;
				}
			}
		}
		return null;
	}

	public static void addOne(Category category) {
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "INSERT INTO category (name, created_date) VALUES (?,?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, category.getName());
			statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ConnectionDAO.closeConnection(con, statement);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	public static void updateOne(Category category) {
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "UPDATE category set name = ?, modified_date = ? where id = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, category.getName());
			statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			statement.setInt(3, category.getId());
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ConnectionDAO.closeConnection(con, statement);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	public static void delete(int id) {
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "DELETE FROM category where id = ?";
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ConnectionDAO.closeConnection(con, statement);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
