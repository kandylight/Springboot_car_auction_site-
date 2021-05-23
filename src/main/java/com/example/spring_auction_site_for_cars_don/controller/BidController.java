package com.example.spring_auction_site_for_cars_don.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_auction_site_for_cars_don.model.Bid;
import com.example.spring_auction_site_for_cars_don.model.Car;
import com.example.spring_auction_site_for_cars_don.service.BidService;
import com.example.spring_auction_site_for_cars_don.service.BuyerService;
import com.example.spring_auction_site_for_cars_don.service.CarService;

@Controller
public class BidController {

	@Autowired
	private BidService bidService;

	@Autowired
	private CarService carService;

	@Autowired
	private BuyerService buyerService;

	@GetMapping("/AllBids")
	public ModelAndView allBids() {
		return new ModelAndView("WEB-INF/allBids.jsp", "allBids", bidService.retrieveAll());
	}

	@GetMapping("/AddBid")
	public ModelAndView addBid() {
		ModelAndView model = new ModelAndView("WEB-INF/addBid.jsp");
		model.addObject("bid", new Bid());
		model.addObject("allBuyers", buyerService.retrieveAll());
		model.addObject("allCars", carService.retrieveAll());
		return model;
	}

	@PostMapping("/AddBidSubmit")
	public ModelAndView addBidSubmit(Bid bid, ModelMap model) {
		bidService.create(bid);
		model.addAttribute("message", "Bid" + bid.getBidId() + " has been added");
		return new ModelAndView("WEB-INF/allBids.jsp", "allBids", bidService.retrieveAll());

	}

	@GetMapping("/EditBid/{bidId}")
	public ModelAndView editBid(@PathVariable("bidId") Long bidId, Model model) {
		model.addAttribute("bid", bidService.retrieveOne(bidId).get());
		model.addAttribute("allBuyers", buyerService.retrieveAll());
		model.addAttribute("allCars", carService.retrieveAll());
		return new ModelAndView("../WEB-INF/editBid.jsp", "bid", bidService.retrieveOne(bidId));
	}

	@PostMapping("/EditBidSubmit")
	public ModelAndView editBidSubmit(@ModelAttribute("bid") Bid bid, Model model) {
		bidService.upDate(bid);
		model.addAttribute("message", "Bid" + bid.getBidId() + "has been updated");
		return new ModelAndView("forward://WEB-INF/allBids.jsp", "allBids", bidService.retrieveAll());
	}

	@PostMapping(value = "/EditBidSubmit", params = { "Delete=Delete" })
	public ModelAndView editBidSubmit(Bid bid, Model model, Long bidId) {
		bidService.delete(bidId);
		model.addAttribute("message", " Bid was deleted");
		return new ModelAndView("forward://WEB-INF/allBids.jsp", "allBids", bidService.retrieveAll());
	}

}
