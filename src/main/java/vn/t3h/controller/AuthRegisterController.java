package vn.t3h.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.t3h.dao.MemberRepository;
import vn.t3h.domain.Member;

@Controller
public class AuthRegisterController {

	MemberRepository repository = new MemberRepository();
	
	@RequestMapping(value = "/auth/register.html", method = RequestMethod.POST)
	public String register(Member obj) {
		repository.add(obj);
		return "redirect:/auth/logon.html";
	}
		
	@RequestMapping("/auth/register.html")
	public String register() {
		return "auth.register";
	}
	
	

}
