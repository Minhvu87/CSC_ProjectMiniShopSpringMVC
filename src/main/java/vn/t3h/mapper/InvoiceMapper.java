package vn.t3h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vn.t3h.domain.Invoice;

public class InvoiceMapper implements RowMapper<Invoice> {

	@Override
	public Invoice mapRow(ResultSet rs, int arg1) throws SQLException {
		Invoice obj = new Invoice(rs.getString("InvoiceId"), rs.getLong("MemberId"), rs.getString("Tel"),
				rs.getString("Address"), rs.getString("Email"), rs.getByte("StatusId"), rs.getString("StatusName"),
				rs.getDate("AddedDate"));
		return obj;
	}

}
