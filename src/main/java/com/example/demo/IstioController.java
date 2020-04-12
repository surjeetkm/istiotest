package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IstioController {

	@RequestMapping(value = "/getmessage",method = RequestMethod.GET)
	public String getMessage() {
		return "Hello This is Version V:1 Loaded!";
	}
	
}
