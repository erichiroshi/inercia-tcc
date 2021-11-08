package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoTriangular implements Secao {

	private double base;
	private double altura;
	private double a;

	@Override
	public double calcularArea() {
		return this.base * this.altura / 2;
	}

	@Override
	public double calcularCentroideEixoXX() {
		return this.altura / 3;
	}

	@Override
	public double calcularCentroideEixoYY() {
		return (2 * this.base - this.a) / 3;
	}

	@Override
	public double calcularInerciaEixoXX() {
		return (this.base * Math.pow(this.altura, 3)) / 36;
	}

	@Override
	public double calcularInerciaEixoYY() {
		return (this.altura * this.base / 36) * (Math.pow(this.base, 2) - this.a * this.base + Math.pow(this.a, 2));
	}

	@Override
	public double calcularProdutoInercia() {
		return (this.base * Math.pow(this.altura, 2) * (this.base - 2 * this.a)) / 72;
	}

	@Override
	public double calcularMomentoEstaticoEixoXX() {
		return (this.base * Math.pow(this.altura, 2)) / 6;
	}

	@Override
	public double calcularMomentoEstaticoEixoYY() {
		return (2 * this.base - this.a) * this.altura * this.base / 6;
	}

	@Override
	public double calcularRaioDeGiracaoEixoXX() {
		return Math.sqrt(this.calcularInerciaEixoXX() / this.calcularArea());
	}

	@Override
	public double calcularRaioDeGiracaoEixoYY() {
		return Math.sqrt(this.calcularInerciaEixoYY() / this.calcularArea());
	}

	public static double calcularArea(double base, double altura) {
		return base * altura / 2;
	}

	// y
	public static double calcularCentroideEixoXX(double base, double altura) {
		return altura / 3;
	}

	// x
	public static double calcularCentroideEixoYY(double base, double altura, double a) {
		return (2 * base - a) / 3;
	}

	public static double calcularInerciaEixoXX(double base, double altura) {
		return (base * Math.pow(altura, 3)) / 36;
	}

	public static double calcularInerciaEixoYY(double base, double altura, double a) {
		return (altura * base / 36) * (Math.pow(base, 2) - a * base + Math.pow(a, 2));
	}

	// Qx = y.A
	public static double calcularMomentoEstaticoEixoXX(double base, double altura) {

		return (base * Math.pow(altura, 2)) / 6;
	}

	// Qy = y.A
	public static double calcularMomentoEstaticoEixoYY(double base, double altura, double a) {

		return (2 * base - a) * altura * base / 6;
	}

	public static double calcularRaioDeGiracaoEixoXX(double base, double altura) {
		return Math
				.sqrt(SecaoTriangular.calcularInerciaEixoXX(base, altura) / SecaoTriangular.calcularArea(base, altura));
	}

	public static double calcularRaioDeGiracaoEixoYY(double base, double altura, double a) {
		return Math.sqrt(
				SecaoTriangular.calcularInerciaEixoYY(base, altura, a) / SecaoTriangular.calcularArea(base, altura));
	}
}
