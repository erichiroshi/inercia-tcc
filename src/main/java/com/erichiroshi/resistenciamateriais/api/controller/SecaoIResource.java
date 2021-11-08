package com.erichiroshi.resistenciamateriais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.resistenciamateriais.domain.entities.Propriedades;
import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoI;

@RestController
@RequestMapping("/secaoI")
public class SecaoIResource {

	@GetMapping("/propriedades")
	public Propriedades Propriedades(@RequestParam(value = "larguraAlma") Double larguraAlma,
									@RequestParam(value = "alturaAlma") Double alturaAlma,
									@RequestParam(value = "larguraAbaInferior") Double larguraAbaInferior,
									@RequestParam(value = "alturaAbaInferior") Double alturaAbaInferior) {

		Secao obj = new SecaoI(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior, larguraAbaInferior,
				alturaAbaInferior);
		return new Propriedades(obj);
	}
	
}