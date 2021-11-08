package com.erichiroshi.resistenciamateriais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoSemiCircular;

@RestController
@RequestMapping("/secaoSemiCircularResource")
public class SecaoSemiCircularResource {

	@GetMapping("/area")
	public double area(@RequestBody SecaoSemiCircular obj) {
		return obj.calcularArea();
	}

	@GetMapping("/centroideEixoXX")
	public double centroideEixoXX(@RequestBody SecaoSemiCircular obj) {
		return obj.calcularCentroideEixoXX();
	}

	@GetMapping("/centroideEixoYY")
	public double centroideEixoYY(@RequestBody SecaoSemiCircular obj) {
		return obj.calcularCentroideEixoYY();
	}

	@GetMapping("/inerciaxx")
	public double inerciaxx(@RequestBody SecaoSemiCircular obj) {
		return obj.calcularInerciaEixoXX();
	}

	@GetMapping("/inerciayy")
	public double inerciayy(@RequestBody SecaoSemiCircular obj) {
		return obj.calcularInerciaEixoYY();
	}

	@GetMapping("/tudo")
	public String imprimeTudo(@RequestBody SecaoSemiCircular obj) {
		return Secao.escreveSecao(obj);
	}

}