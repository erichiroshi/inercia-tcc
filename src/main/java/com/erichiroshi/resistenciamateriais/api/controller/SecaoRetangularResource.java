package com.erichiroshi.resistenciamateriais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.resistenciamateriais.domain.entities.Propriedades;
import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoRetangular;

@RestController
@RequestMapping("/secaoRetangular")
public class SecaoRetangularResource {

	@GetMapping("/propriedades")
	public Propriedades Propriedades(@RequestParam(value = "largura") Double largura,
									@RequestParam(value = "altura") Double altura) {
		Secao obj = new SecaoRetangular(largura, altura);
		return new Propriedades(obj);
	}

}