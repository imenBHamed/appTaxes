package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.EntrepriseRepository;
import com.app.entities.Entreprise;

@Controller
public class TaxeController {

	@Autowired
	private EntrepriseRepository entrepriseRepository;

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

}
