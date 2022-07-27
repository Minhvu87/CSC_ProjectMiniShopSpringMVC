package vn.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.t3h.dao.CartRepository;
import vn.t3h.dao.InvoiceRepository;
import vn.t3h.domain.Invoice;

@Controller
@RequestMapping("cart")
public class CartsCheckoutController {
	private CartRepository repository = new CartRepository();
	private InvoiceRepository invoiceRepository = new InvoiceRepository();

	@RequestMapping("checkout.html")
	public String checkout(Model model, @CookieValue("cart") String id) {
		model.addAttribute("title", "Check Out");
		model.addAttribute("list", repository.getCarts(id));
		return "cart.checkout";
	}

	@RequestMapping(value = "checkout.html", method = RequestMethod.POST)
	public String checkout(Model model, Invoice obj, @CookieValue("cart") String id) {
		obj.setId(id);
		invoiceRepository.add(obj);
		return "redirect:/order/detail.html/" + obj.getId();
	}
}
