package vn.t3h.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.t3h.domain.Member;





@Controller
public class AuthLogon {

	@RequestMapping("/auth/logon.html")
	public String register(HttpServletRequest request) {

		if (request.getParameter("error") != null) {
			request.setAttribute("msg", "Username or password incorrect.");
		}

		return "auth.logon";
	}
}
