package com.example.spring_auction_site_for_cars_don.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_auction_site_for_cars_don.model.Car;
import com.example.spring_auction_site_for_cars_don.service.CarService;
import com.example.spring_auction_site_for_cars_don.service.SellerService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private SellerService sellerService;
	
	private static final Logger LOGGER = LogManager.getLogger(CarController.class);
	
	@GetMapping("/AllCars")
	public ModelAndView allCars() {
		return new ModelAndView("WEB-INF/allCars.jsp", "allCars", carService.retrieveAll());
	}
	
	@GetMapping("/AddCar")
	public ModelAndView addCar() {
		ModelAndView model = new ModelAndView("WEB-INF/addCar.jsp");
		model.addObject("car", new Car());
		model.addObject("allSellers", sellerService.retrieveAll());
		return model;
	}
	
	@PostMapping("/AddCarSubmit")
	public ModelAndView addCarSubmit(Car car, ModelMap model) {
		carService.create(car);
		model.addAttribute("message", "Car " + car.getMake() + " " + car.getModel() + " has been added");
		return new ModelAndView("WEB-INF/allCars.jsp", "allCars", carService.retrieveAll());
	}
	
	@GetMapping("/EditCar/{carId}")
	public ModelAndView editCar(@PathVariable("carId") Long carId, Model model) {
		model.addAttribute("car", carService.retrieveOne(carId).get());
		model.addAttribute("allSellers", sellerService.retrieveAll());
		return new ModelAndView("../WEB-INF/editCar.jsp", "car", carService.retrieveOne(carId));
	}
	
	@PostMapping("/EditCarSubmit")
	public ModelAndView editCarSubmit(@ModelAttribute("car") Car car, Model model) {
		carService.update(car);
		model.addAttribute("message", "Car " + car.getMake() + car.getModel() + " has been updated");
		return new ModelAndView("forward://WEB-INF/allCars.jsp", "allCars", carService.retrieveAll());
	}
	
	@PostMapping(value= "/EditCarSubmit", params= {"Delete=Delete"})
	public ModelAndView editCarSubmit(Car car, Model model, Long carId) {
		carService.delete(carId);
		model.addAttribute("message", " Car was deleted");
		return new ModelAndView("forward://WEB-INF/allCars.jsp", "allCars", carService.retrieveAll());
	}
	
	

}
