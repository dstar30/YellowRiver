package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;

@Controller
@RequestMapping("/purchase")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String display(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Order order = new Order();
		Item w = new Item();
		w.setName("Windows");
		Item l = new Item();
		l.setName("Linux");
		Item u = new Item();
		u.setName("Unix");
		order.getList().add(w);
		order.getList().add(l);
		order.getList().add(u);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String paymentEntry(HttpServletRequest request) throws Exception {
		PaymentInfo paymentInfo = new PaymentInfo();
		request.setAttribute("paymentInfo", paymentInfo);
		return "PaymentEntryForm";
	}

	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		return "redirect:/purchase/shippingEntry";
	}

	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request) throws Exception {
		ShippingInfo shippingInfo = new ShippingInfo();
		request.setAttribute("shippingInfo", shippingInfo);
		return "ShippingEntryForm";
	}

	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}

	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request) throws Exception {
	    ModelMap model = new ModelMap();
        model.addAttribute("order", request.getSession().getAttribute("order"));
        model.addAttribute("paymentInfo", request.getSession().getAttribute("paymentInfo"));
        model.addAttribute("shippingInfo", request.getSession().getAttribute("shippingInfo"));	
		return "ViewOrder";
	}

	@RequestMapping(path = "/ConfirmOrder", method = RequestMethod.POST)
	public String ConfirmOrder() throws Exception {
		return "ConfirmOrder";
	}
}