package com.laptrinhjavaweb.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.laptrinhjavaweb.dao.iCategoryDAO;
import com.laptrinhjavaweb.dao.impl.ConnectionDAO;
import com.laptrinhjavaweb.entity.Category;


public class CategoryDAO implements iCategoryDAO{

	@Override
	public List<Category> findAll() {
		List<Category> results = new ArrayList<Category>();
		Connection con = ConnectionDAO.getConnection();
		PreparedStatement statement = null;
		String sql = "select * from category";
		ResultSet resultSet = null;
		if(con != null) {
			try {
				statement = con.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					Category category = new Category();
					category.setId(resultSet.getInt("id"));
					category.setName(resultSet.getNString("name"));
					results.add(category);
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
