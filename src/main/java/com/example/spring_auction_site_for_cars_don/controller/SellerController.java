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

import com.example.spring_auction_site_for_cars_don.model.Seller;
import com.example.spring_auction_site_for_cars_don.service.SellerService;

@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;

	private static final Logger LOGGER = LogManager.getLogger(SellerController.class);

	@GetMapping("/AllSellers")
	public ModelAndView allSellers() {
		return new ModelAndView("WEB-INF/allSellers.jsp", "allSelers", sellerService.retrieveAll());
	}

	@GetMapping("/AddSeller")
	public String addSeller() {
		return "WEB-INF/addSeller.jsp";
	}

	@PostMapping("/AddSellerSubmit")
	public ModelAndView addSellerSubmit(Seller seller, ModelMap model) {
		sellerService.create(seller);
		LOGGER.info("Seller " + seller + " was added");
		model.addAttribute("message",
				"Seller " + seller.getSellerName() + " " + seller.getSellerAddress() + " has been added");
		return new ModelAndView("WEB-INF/allSellers.jsp", "allSellers", sellerService.retrieveAll());
	}

	@GetMapping("/EditSeller/{sellerId}")
	public ModelAndView editSeller(@PathVariable("sellerId") Long sellerId, Model model) {
		return new ModelAndView("../WEB-INF/editSeller.jsp", "seller", sellerService.retrieveOne(sellerId));
	}

	@PostMapping("/EditSellerSubmit")
	public ModelAndView editSellerSubmit(Seller seller, ModelMap model) {
		sellerService.update(seller);
		return new ModelAndView("forward://WEB-INF/allSellers.jsp", "allSellers", sellerService.retrieveAll());
	}

	@PostMapping(value = "EditSellerSubmit", params = { "Delete=Delete" })
	public ModelAndView editSellerSubmit(Seller seller, ModelMap model, Long sellerId) {
		sellerService.delete(sellerId);
		model.addAttribute("message", " The seller has been deleted");
		return new ModelAndView("forward://WEB-INF/allSellers.jsp", "allSellers", sellerService.retrieveAll());
	}

}
