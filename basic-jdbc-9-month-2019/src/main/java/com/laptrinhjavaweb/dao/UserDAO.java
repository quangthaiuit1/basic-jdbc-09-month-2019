package com.laptrinhjavaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.entity.User;

public class UserDAO {

	public static List<User> findAll() {
		List<User> results = new ArrayList<User>();
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from user";
		ResultSet resultSet = null;
		if (con != null) {
			try {
				statement = con.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setUserName(resultSet.getString("username"));
					user.setPassWord(resultSet.getString("password"));
					user.setName(resultSet.getString("name"));
					results.add(user);
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

	public static User findByUserName(String userName) {
		User user = new User();
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "SELECT u.id, u.username, u.password,u.role_id, r.name as role_name, r.created_date, r.modified_date, u.name as name\r\n" + 
				"	FROM user as u\r\n" + 
				"		INNER JOIN role as r ON u.role_id = r.id\r\n" + 
				"			WHERE u.username = ? " ;
		ResultSet resultSet = null;
		if (con != null) {
			try {
				statement = con.prepareStatement(sql);
				statement.setString(1, userName);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
					user.setUserName(resultSet.getString("username"));
					user.setPassWord(resultSet.getString("password"));
					user.setRoleId(resultSet.getInt("role_id"));
					user.setRoleName(resultSet.getString("role_name"));
					user.setName(resultSet.getString("name"));
				}
				return user;
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
	// Select pagination
	public static List<User> findByLimit(int offset, int limit) {
		List<User> results = new ArrayList<User>();
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from user LIMIT ?, ? " ;
		ResultSet resultSet = null;
		if (con != null) {
			try {
				statement = con.prepareStatement(sql);
				statement.setInt(1, offset);
				statement.setInt(2, limit);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setUserName(resultSet.getString("username"));
					user.setPassWord(resultSet.getString("password"));
					user.setName(resultSet.getString("name"));
					results.add(user);
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

	public static void addOne(User user) {
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "INSERT INTO user (username, password, role_id, created_date, name) VALUES (?,?,?,?,?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassWord());
			statement.setInt(3, user.getRoleId());
			statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			statement.setString(5, user.getName());
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

	/*
	 * public static void updateOne(Category category) { Connection con =
	 * ConnectionDAO.getConnection(); PreparedStatement statement = null; String sql
	 * = "UPDATE category set name = ?, modified_date = ? where id = ?"; try {
	 * statement = con.prepareStatement(sql); statement.setString(1,
	 * category.getName()); statement.setTimestamp(2, new
	 * Timestamp(System.currentTimeMillis())); statement.setInt(3,
	 * category.getId()); statement.execute(); } catch (SQLException e) {
	 * System.out.println(e.getMessage()); } finally { try {
	 * ConnectionDAO.closeConnection(con, statement); } catch (Exception e2) {
	 * System.out.println(e2.getMessage()); } } }
	 */
	public static void delete(int id) {
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "DELETE FROM user where id = ?";
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
