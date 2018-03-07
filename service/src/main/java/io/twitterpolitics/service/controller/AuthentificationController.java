package io.twitterpolitics.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthentificationController {
	
	 @RequestMapping(value="/authentication", method=RequestMethod.POST)
	 public boolean checkConnection(@RequestBody String password) {
		return "macron2018".equals(password);
		
	}

}
