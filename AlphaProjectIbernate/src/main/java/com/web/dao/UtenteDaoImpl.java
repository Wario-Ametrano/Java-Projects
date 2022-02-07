package com.web.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.web.entity.Utente;
import com.web.service.UtenteService;



@Repository
@Transactional
@EnableTransactionManagement
public class UtenteDaoImpl implements UtenteService{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void inserisciUtente(Utente utente) {
		Session sessionHibernate = sessionFactory.getCurrentSession();
		sessionHibernate.saveOrUpdate(utente);
	}
}
