package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Utente;
import com.example.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService{
	
	@Autowired
	UtenteRepository utente;
	
	/*@Override
	public List<Utente> getAll(){
		return utente.findAll();
	}*/

}
