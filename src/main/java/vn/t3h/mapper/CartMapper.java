package vn.t3h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vn.t3h.domain.Cart;



public class CartMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Cart(rs.getString("CartId"), rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ImageUrl"),
				rs.getInt("Price"), rs.getShort("Quantity"));

	}

}
