package vn.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.t3h.dao.CartRepository;

@Controller
@RequestMapping("cart")
public class CartsListController {

	CartRepository repository = new CartRepository();
	
	@RequestMapping("list.html")
	public String index(Model model, @CookieValue("cart") String id) {
		model.addAttribute("title", "Your Cart");
		model.addAttribute("list", repository.getCarts(id));
		return "cart.list";
	}
	
	
}
