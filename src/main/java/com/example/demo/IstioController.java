package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.Customer;
import com.example.config.MyProperties;
import com.example.model.Trader;
import com.example.model.Transaction;
import com.example.service.IstioUtilityService;

@RestController
public class IstioController {

	@Autowired
	private IstioUtilityService istioUtilityService;
	
	@RequestMapping(value = "/getmessage", method = RequestMethod.GET)
	public String getMessage() {
		return "Hello This is Version V:2 Loaded!!!!!!";
	}

	// 1.Find all transactions in the year 2011 and sort them by value (small to
	// high).
	@RequestMapping(value = "/getAllTransByYear/{year}", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getAllTransactionGivenYear(@PathVariable("year") int year) {
		System.out.println("Controller::::::::::::::::" + year);

		List<Transaction> transaction = istioUtilityService.getAllTransactionGivenYear(year);
		if (transaction != null)
			return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
		else {
			return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "/getAllTradersCity", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllTradersCity() {
		return new ResponseEntity(istioUtilityService.getAllTradersCity(), HttpStatus.OK);
	}
	@RequestMapping(value = "/getAllTradersByCity/{city}", method = RequestMethod.GET)
	public ResponseEntity<List<Trader>> getAllTradersByCity(@PathVariable("city") String city) {
		List<Trader> traders = istioUtilityService.getAllTradersByCity(city);
		return new ResponseEntity(traders, HttpStatus.OK);
	}
	@RequestMapping(value = "/getAllTradersName", method = RequestMethod.GET)
	public String getAllTradersName() {
		return istioUtilityService.getAllTradersName();
	}
	@RequestMapping(value = "/getAllTransactionValueByCity/{city}", method = RequestMethod.GET)
	public List<Double> getTransactionValueGivenCity(@PathVariable("city") String city) {

		return istioUtilityService.getTransactionValueGivenCity(city);
	}

}
