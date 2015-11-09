package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String display(HttpServletRequest request, HttpServletResponse response) throws Exception {
		InventoryService inventoryService = ServiceLocator.getInventoryService();
		Inventory inventory = inventoryService.getAvailableInventory();

		Order order = new Order();
		List<LineItem> items = new ArrayList<LineItem>();
		for (Item item : inventory.getItems()) {
			LineItem lineItem = new LineItem();
			//Item i = new Item();
			lineItem.setName(item.getName());
			items.add(lineItem);
			// i.setQuantity("0");
			//order.getList().add(i);
		}
		order.setItems(items);
		request.getSession().setAttribute("order", order);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order inputOrder, HttpServletRequest request) throws Exception {
		Order order = (Order) request.getSession().getAttribute("order");
		for (int i = 0; i < inputOrder.getItems().size(); i++) {
			int quantity = inputOrder.getItems().get(i).getQuantity();
			order.getItems().get(i).setQuantity(quantity);
		}
		request.getSession().setAttribute("order", order);
		OrderProcessingServiceBean ops = ServiceLocator.getOrderProcessingService();
		boolean correct = ops.validateItemAvailability(order);
		if (correct) {
			request.getSession().setAttribute("warning", "");

			return "redirect:/purchase/paymentEntry";
		} else {
			request.getSession().setAttribute("warning", "Your input quantity not avaiable, pls try again");

			return "OrderEntryForm";
		}
	}

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String paymentEntry(HttpServletRequest request) throws Exception {
		//request.getSession().setAttribute("warning", "");
		PaymentInfo paymentInfo = new PaymentInfo();
		request.setAttribute("paymentInfo", paymentInfo);
		return "PaymentEntryForm";
	}

	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request)
			throws Exception {
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
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request)
			throws Exception {
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
	public String ConfirmOrder(HttpServletRequest request) throws Exception {
		OrderProcessingServiceBean ops = ServiceLocator.getOrderProcessingService();
		Order order = (Order) request.getSession().getAttribute("order");
		ShippingInfo shippingInfo =(ShippingInfo)request.getSession().getAttribute("shippingInfo");
		PaymentInfo paymentInfo =(PaymentInfo)request.getSession().getAttribute("paymentInfo");
	
		order.setPaymentInfo(paymentInfo);
		order.setShippingInfo(shippingInfo);
		
		String confirmCode = ops.processOrder(order);
		request.getSession().setAttribute("confirmCode", confirmCode);
		return "ConfirmOrder";
	}
}