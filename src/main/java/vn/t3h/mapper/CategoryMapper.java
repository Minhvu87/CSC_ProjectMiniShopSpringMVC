package vn.t3h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vn.t3h.domain.Category;

public class CategoryMapper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int arg1) throws SQLException {
		Category category = new Category();
		category.setId(rs.getInt("CategoryId"));
		category.setName(rs.getString("CategoryName"));
		category.setParent(rs.getInt("ParentId"));
		
		return category;
	}

}
