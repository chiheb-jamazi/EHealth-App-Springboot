package com.example.demo.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.bouteille;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.bouteilleRepository;

@Service
public class bouteilleService {

	@Autowired
private bouteilleRepository repo;
	public bouteilleService() {
	}
	public bouteilleService(bouteilleRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Iterable<bouteille> showbouteille(){
		return repo.findAll();
	}
	
	public void savebouteille(bouteille bout)
	{
		repo.save(bout);
	}

}
