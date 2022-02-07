package com.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Utente;
import com.example.service.UtenteService;

@RestController
public class FirstController {
	
	@RequestMapping("/Utenti")
	public List<Utente> getAllUtenti() {
		
		return UtenteService.getAllUtenti();
	}
	@RequestMapping("/getId")
	public Utente getId() {
		return UtenteService.getByID((long)1);
		
	}
}