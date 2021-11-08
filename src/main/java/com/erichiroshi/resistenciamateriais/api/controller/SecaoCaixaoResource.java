package com.erichiroshi.resistenciamateriais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.resistenciamateriais.domain.entities.Propriedades;
import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoCaixao;

@RestController
@RequestMapping("/secaoCaixao")
public class SecaoCaixaoResource {

	@GetMapping("/propriedades")
	public Propriedades Propriedades(@RequestParam(value = "larguraExterna") Double larguraExterna,
									@RequestParam(value = "alturaExterna") Double alturaExterna,
									@RequestParam(value = "larguraInterna") Double larguraInterna,
									@RequestParam(value = "alturaInterna") Double alturaInterna) {
		Secao obj = new SecaoCaixao(larguraExterna, alturaExterna, larguraInterna, alturaInterna);
		return new Propriedades(obj);
	}
	
}