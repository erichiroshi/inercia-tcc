package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoTrapezoidal implements Secao {

	private double baseMaior;
	private double baseMenor;
	private double altura;

	@Override
	public double calcularArea() {
		return (this.baseMaior + this.baseMenor) * this.altura / 2;
	}

	@Override
	public double calcularCentroideEixoXX() {
		return ((2 * this.baseMenor + this.baseMaior) / (this.baseMenor + this.baseMaior)) * (this.altura / 3);
	}

	@Override
	public double calcularCentroideEixoYY() {
		return 0;
	}

	@Override
	public double calcularInerciaEixoXX() {
		return 0;
	}

	@Override
	public double calcularInerciaEixoYY() {
		return 0;
	}

	@Override
	public double calcularProdutoInercia() {
		return 0;
	}

	@Override
	public double calcularMomentoEstaticoEixoXX() {
		return 0;
	}

	@Override
	public double calcularMomentoEstaticoEixoYY() {
		return 0;
	}

	@Override
	public double calcularRaioDeGiracaoEixoXX() {
		return 0;
	}

	@Override
	public double calcularRaioDeGiracaoEixoYY() {
		return 0;
	}

	public static double calcularArea(double baseMaior, double baseMenor, double altura) {
		return (baseMaior + baseMenor) * altura / 2;
	}

	public static double calcularCentroidoEixoXX(double baseMaior, double baseMenor, double altura) {
		return ((2 * baseMenor + baseMaior) / (baseMenor + baseMaior)) * (altura / 3);
	}

}
