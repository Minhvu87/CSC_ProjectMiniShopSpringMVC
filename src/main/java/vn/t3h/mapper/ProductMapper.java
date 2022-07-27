package vn.t3h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vn.t3h.domain.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int arg1) throws SQLException {
		Product product = new Product();
		
		product.setId(rs.getInt("ProductId"));
		product.setTitle(rs.getString("Title"));
		product.setIsbn(rs.getString("ISBN"));
		product.setPrice(rs.getInt("Price"));
		product.setPages(rs.getString("Pages"));
		product.setImageUrl(rs.getString("ImageUrl"));
		
		return product;
	}

}
