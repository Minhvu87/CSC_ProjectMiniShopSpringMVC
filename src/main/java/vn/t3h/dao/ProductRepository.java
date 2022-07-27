package vn.t3h.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import vn.t3h.domain.Product;
import vn.t3h.mapper.ProductMapper;



public class ProductRepository extends Repository {

	public int count() {
		return jdbc.queryForObject("SELECT COUNT(*) AS Total FROM Product", new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getInt("Total");
			}
		});
	}

	public List<Product> getProducts(int index, int size) {
		return jdbc.query("SELECT * FROM Product LIMIT ?, ?", new ProductMapper(), (index - 1) * size, size);
	}
	
	public Product getProduct(int id) {
		return jdbc.queryForObject("SELECT * FROM Product WHERE ProductId = ?", new ProductMapper(), id);
	}
	
	public List<Product> search(String q){
		return jdbc.query("SELECT * FROM Product WHERE Title LIKE ?", new ProductMapper(), "%" + q + "%");
	}
}
