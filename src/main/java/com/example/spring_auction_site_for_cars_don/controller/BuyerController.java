package com.example.spring_auction_site_for_cars_don.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_auction_site_for_cars_don.model.Buyer;
import com.example.spring_auction_site_for_cars_don.service.BuyerService;

@Controller
public class BuyerController {

	@Autowired
	private BuyerService buyerService;

	private static final Logger LOGGER = LogManager.getLogger(BuyerController.class);
	
	@GetMapping("/main")
	public ModelAndView main() {
		return new ModelAndView("WEB-INF/main.jsp");
	}

	@GetMapping("/AllBuyers")
	public ModelAndView allBuyers() {
		return new ModelAndView("WEB-INF/allBuyers.jsp", "allBuyers", buyerService.retrieveAll());
	}

	@GetMapping("/AddBuyer")
	public String addBuyer() {
		return "WEB-INF/addBuyer.jsp";
	}

	@PostMapping("/AddBuyerSubmit")
	public ModelAndView addBuyerSubmit(Buyer buyer, ModelMap model) {
		buyerService.create(buyer);
		LOGGER.info("Buyer " + buyer + " was added");
		model.addAttribute("message", "Buyer " + buyer.getBuyerName() + " " + buyer.getBuyerAddress() + " been added");
		return new ModelAndView("WEB-INF/allBuyers.jsp", "allBuyers", buyerService.retrieveAll());
	}

	@GetMapping("/EditBuyer/{buyerId}")
	public ModelAndView editBuyer(@PathVariable("buyerId") Long buyerId, Model model) {
		return new ModelAndView("../WEB-INF/editBuyer.jsp", "buyer", buyerService.retrieveOne(buyerId));
	}

	@PostMapping("/EditBuyerSubmit")
	public ModelAndView editBuyerSubmit(Buyer buyer, ModelMap model) {
		buyerService.update(buyer);
		return new ModelAndView("forward://WEB-INF/allBuyers.jsp", "allBuyers", buyerService.retrieveAll());
	}

	@PostMapping(value = "EditBuyerSubmit", params = { "Delete=Delete" })
	public ModelAndView editBuyerSubmit(Buyer buyer, ModelMap model, Long buyerId) {
		buyerService.delete(buyerId);
		model.addAttribute("message", " The buyer has been deleted");
		return new ModelAndView("forward://WEB-INF/allBuyers.jsp", "allBuyers", buyerService.retrieveAll());
	}

}
