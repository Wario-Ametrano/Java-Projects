package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Utente;
import com.web.service.UtenteService;

@Controller
@RequestMapping("/utente")
@ComponentScan(basePackages = "com.web.entity, com.web.dao, com.web.service, com.web.controller")
public class UtenteController {

	@Autowired
	private UtenteService customerService;

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Utente utente = new Utente();
		theModel.addAttribute("customer", utente);
		return "utente_form";
	}
	@PostMapping("/inserisciUtente")
	public String inserisciUtente(@ModelAttribute("utente") Utente utente) {
	customerService.inserisciUtente(utente);
	return "test";
	}

}
