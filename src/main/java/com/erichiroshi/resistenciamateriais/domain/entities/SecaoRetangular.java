package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoRetangular implements Secao {

	private double largura;
	private double altura;

	@Override
	public double calcularArea() {
		return this.largura * this.altura;
	}

	// y
	@Override
	public double calcularCentroideEixoXX() {
		return this.altura / 2;
	}

	// x
	@Override
	public double calcularCentroideEixoYY() {
		return this.largura / 2;
	}

	// I = I + A*dyÂ²
	@Override
	public double calcularInerciaEixoXX() {
		return this.largura * Math.pow(this.altura, 3) / 12;
	}

	@Override
	public double calcularInerciaEixoYY() {
		return this.altura * Math.pow(this.largura, 3) / 12;
	}

	@Override
	public double calcularProdutoInercia() {
		return 0;
	}

	// Qx = y.A
	@Override
	public double calcularMomentoEstaticoEixoXX() {
		double area = this.calcularArea();
		return (this.altura / 2) * area;
	}

	// Qy = x.A
	@Override
	public double calcularMomentoEstaticoEixoYY() {
		double area = this.calcularArea();
		return (this.largura / 2) * area;
	}

	@Override
	public double calcularRaioDeGiracaoEixoXX() {
		return Math.sqrt(this.calcularInerciaEixoXX() / this.calcularArea());
	}

	@Override
	public double calcularRaioDeGiracaoEixoYY() {
		return Math.sqrt(this.calcularInerciaEixoYY() / this.calcularArea());
	}

	public static double calcularArea(double largura, double altura) {
		return largura * altura;
	}

	// y
	public static double calcularCentroideEixoXX(double largura, double altura) {
		return altura / 2;
	}

	// x
	public static double calcularCentroideEixoYY(double largura, double altura) {
		return largura / 2;
	}

	// I = I + A*dyÂ²
	public static double calcularInerciaEixoXX(double largura, double altura) {
		return largura * Math.pow(altura, 3) / 12;
	}

	public static double calcularInerciaEixoYY(double largura, double altura) {
		return altura * Math.pow(largura, 3) / 12;
	}

	// Qx = y.A
	public static double calcularMomentoEstaticoEixoXX(double largura, double altura) {
		double area = SecaoRetangular.calcularArea(largura, altura);
		return (altura / 2) * area;
	}

	// Qy = x.A
	public static double calcularMomentoEstaticoEixoYY(double largura, double altura) {
		double area = SecaoRetangular.calcularArea(largura, altura);
		return (largura / 2) * area;
	}

	public static double calcularRaioDeGiracaoEixoXX(double largura, double altura) {
		return Math.sqrt(
				SecaoRetangular.calcularInerciaEixoXX(largura, altura) / SecaoRetangular.calcularArea(largura, altura));
	}

	public static double calcularRaioDeGiracaoEixoYY(double largura, double altura) {
		return Math.sqrt(
				SecaoRetangular.calcularInerciaEixoYY(largura, altura) / SecaoRetangular.calcularArea(largura, altura));
	}
}
