package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.EntrepriseRepository;
import com.app.entities.Entreprise;

@Controller
public class TaxeController {

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@RequestMapping(value="/entreprises", method=RequestMethod.GET)
	
	public String index(Model model){
		List<Entreprise> listEntreprises= entrepriseRepository.findAll();
		model.addAttribute("listEntreprises", listEntreprises);
		return "entreprises";
	}
	
}
