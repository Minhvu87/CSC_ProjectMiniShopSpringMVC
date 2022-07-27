package vn.t3h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vn.t3h.domain.Member;


public class MemberMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Member(rs.getLong("MemberId"), rs.getString("UserName"), 
				rs.getString("Password"));
	}

}
