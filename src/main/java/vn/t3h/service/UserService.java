package vn.t3h.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.t3h.dao.MemberRepository;
import vn.t3h.domain.Member;
import vn.t3h.domain.Role;



public class UserService implements UserDetailsService {
	
	MemberRepository repository = new MemberRepository();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("======================");
		
		try {
			Member obj = repository.logon(username);
			List<GrantedAuthority> authorities = new ArrayList<>();
			for (Role role : obj.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getName()));
			}
			return new User(obj.getUsername(), obj.getPassword(), true, true, true, true, authorities);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
