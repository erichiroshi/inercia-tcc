package com.erichiroshi.resistenciamateriais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.resistenciamateriais.domain.entities.Propriedades;
import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoCircularVazado;

@RestController
@RequestMapping("/secaoCircularVazado")
public class SecaoCircularVazadoResource {

	@GetMapping("/propriedades")
	public Propriedades Propriedades(@RequestParam(value = "raioExterno") Double raioExterno,
									@RequestParam(value = "raioInterno") Double raioInterno) {
		Secao obj = new SecaoCircularVazado(raioExterno, raioInterno);
		return new Propriedades(obj);
	}
	
}