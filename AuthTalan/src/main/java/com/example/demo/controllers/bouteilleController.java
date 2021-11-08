package com.example.demo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.bouteille;
import com.example.demo.security.services.bouteilleService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class bouteilleController {
	
	@Autowired
	private bouteilleService service;
	@GetMapping("/Allbouteille")
	public Iterable<bouteille> showallbouteille(){
		return service.showbouteille();
	}
	@PostMapping("/savebouteille")
	@Transactional
	public String bouteilleadd(@RequestBody bouteille bou) {
		service.savebouteille(bou);
		return "pourcentage:"+bou.getPourcentage();
	}
}
