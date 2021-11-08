package com.erichiroshi.resistenciamateriais.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoTriangular;

@RestController
@RequestMapping("/secaoTriangular")
public class SecaoTriangularResource {

	@GetMapping("/area")
	public double area(@RequestBody SecaoTriangular obj) {
		return obj.calcularArea();
	}

	@GetMapping("/centroideEixoXX")
	public double centroideEixoXX(@RequestBody SecaoTriangular obj) {
		return obj.calcularCentroideEixoXX();
	}

	@GetMapping("/centroideEixoYY")
	public double centroideEixoYY(@RequestBody SecaoTriangular obj) {
		return obj.calcularCentroideEixoYY();
	}

	@GetMapping("/inerciaxx")
	public double inerciaxx(@RequestBody SecaoTriangular obj) {
		return obj.calcularInerciaEixoXX();
	}

	@GetMapping("/inerciayy")
	public double inerciayy(@RequestBody SecaoTriangular obj) {
		return obj.calcularInerciaEixoYY();
	}

	@GetMapping("/tudo")
	public String imprimeTudo(@RequestBody SecaoTriangular obj) {
		return Secao.escreveSecao(obj);
	}

}