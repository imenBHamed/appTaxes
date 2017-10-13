package com.app.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.EntrepriseRepository;
import com.app.dao.TaxesRepository;
import com.app.entities.Entreprise;

@Controller
public class TaxeController {

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private TaxesRepository taxesRepository;

	@RequestMapping(value = "/entreprises", method = RequestMethod.GET)
	public String index(Model model,
			@RequestParam(name = "motCle", defaultValue = "") String motCle,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "4") int s) {

		Page<Entreprise> pageEntreprises = entrepriseRepository.chercher("%"
				+ motCle + "%", new PageRequest(p, s));
		model.addAttribute("listEntreprises", pageEntreprises.getContent());
		int[] pages = new int[pageEntreprises.getTotalPages()];
		model.addAttribute("page", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", motCle);
		return "entreprises";
	}

	@RequestMapping(value = "/formEntreprise")
	public String form(Model model) {
		model.addAttribute("entreprise", new Entreprise());
		return "formEntreprise";
	}

	@RequestMapping(value = "/saveEntreprise")
	public String save(Model model, @Valid Entreprise e,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "formEntreprise";
		entrepriseRepository.save(e);
		return "redirect:/entreprises";
	}
	
	@RequestMapping(value = "/taxes")
	public String save(Model model, Long code) {
		Entreprise e= new Entreprise();
		e.setCode(code);
		model.addAttribute("entreprises", entrepriseRepository.findAll());
	 model.addAttribute("taxes", taxesRepository.findByEntreprise(e));
		return "taxes";
	}
}
