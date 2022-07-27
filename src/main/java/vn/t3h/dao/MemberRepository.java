package vn.t3h.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import vn.t3h.domain.Member;
import vn.t3h.domain.Role;
import vn.t3h.mapper.MemberMapper;
import vn.t3h.util.Helper;



public class MemberRepository extends Repository {

	public int add(Member obj) {
		obj.setId(Helper.randomLong());
		
		int a = jdbc.update("INSERT INTO Member(MemberId, Username, Password, Email, Gender, Tel,Address) VALUES(?, ?, ?, ?, ?, ?, ?)", 
				obj.getId(), obj.getUsername(), Helper.bcrypt(obj.getPassword()), obj.getEmail(),
				obj.isGender(), obj.getTel(), obj.getAddress());
		
		int b = jdbc.update("INSERT INTO MemberInRole(MemberId, RoleId) VALUES(?, ?)", obj.getId(), 1);
		
		return a + b;
	}
	
	public Member logon(String username) {
		Member member = jdbc.queryForObject("SELECT MemberId, Username, Password FROM Member WHERE Username = ?", new MemberMapper(), username);
		member.setRoles(getRolesByMemberId(member.getId()));
		return member;
	}
	
	
	public List<Role> getRolesByMemberId(long id) {
		return jdbc.query("SELECT Role.RoleId, RoleName FROM Role INNER JOIN MemberInRole ON Role.RoleId = MemberInRole.RoleId WHERE MemberId = ?", new RowMapper<Role>() {

			@Override
			public Role mapRow(ResultSet rs, int arg1) throws SQLException {
				return new Role(rs.getInt("RoleId"), rs.getString("RoleName"));
			}
		}, id);
	}
}
