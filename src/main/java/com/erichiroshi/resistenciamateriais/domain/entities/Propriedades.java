package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.Data;

@Data
public class Propriedades {

	private double area;
	private double cx;
	private double cy;
	private double inerciaxx;
	private double inerciayy;

	public Propriedades(Secao obj) {
		this.area = obj.calcularArea();
		this.cx = obj.calcularCentroideEixoYY();
		this.cy = obj.calcularCentroideEixoXX();
		this.inerciaxx = obj.calcularInerciaEixoXX();
		this.inerciayy = obj.calcularInerciaEixoYY();
	}

}
