package com.erichiroshi.resistenciamateriais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoL;

@RestController
@RequestMapping("/secaoL")
public class SecaoLResource {

	@GetMapping("/area")
	public double area(@RequestBody SecaoL obj) {
		return obj.calcularArea();
	}

	@GetMapping("/centroideEixoXX")
	public double centroideEixoXX(@RequestBody SecaoL obj) {
		return obj.calcularCentroideEixoXX();
	}

	@GetMapping("/centroideEixoYY")
	public double centroideEixoYY(@RequestBody SecaoL obj) {
		return obj.calcularCentroideEixoYY();
	}

	@GetMapping("/inerciaxx")
	public double inerciaxx(@RequestBody SecaoL obj) {
		return obj.calcularInerciaEixoXX();
	}

	@GetMapping("/inerciayy")
	public double inerciayy(@RequestBody SecaoL obj) {
		return obj.calcularInerciaEixoYY();
	}

	@GetMapping("/tudo")
	public String imprimeTudo(@RequestBody SecaoL obj) {
		return Secao.escreveSecao(obj);
	}
}