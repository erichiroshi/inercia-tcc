package com.erichiroshi.resistenciamateriais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.resistenciamateriais.domain.entities.Propriedades;
import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoCircular;

@RestController
@RequestMapping("/secaoCircular")
public class SecaoCircularResource {

	@GetMapping("/propriedades")
	public Propriedades Propriedades(@RequestParam(value = "raio") Double raio) {
		Secao obj = new SecaoCircular(raio);
		return new Propriedades(obj);
	}
	
}