package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.dao.EntrepriseRepository;

@Controller
public class TaxeController {

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@RequestMapping(value="/entreprises", method=RequestMethod.GET)
	public String index(){
		return "entreprises";
	}
	
}
