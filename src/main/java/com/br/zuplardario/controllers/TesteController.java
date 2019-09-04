package com.br.zuplardario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TesteController {
	
	@GetMapping
	public ModelAndView teste() {
		ModelAndView modelAndView = new ModelAndView("login.html");
		return modelAndView;
	}

}
