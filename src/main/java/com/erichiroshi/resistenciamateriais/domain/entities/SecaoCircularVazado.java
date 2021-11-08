package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoCircularVazado implements Secao {

	private double raioExterno;
	private double raioInterno;



	@Override
	public double calcularArea() {
		return SecaoCircular.calcularArea(this.raioExterno) - SecaoCircular.calcularArea(this.raioInterno);
	}

	@Override
	public double calcularCentroideEixoXX() {
		return this.raioExterno;
	}

	@Override
	public double calcularCentroideEixoYY() {
		return this.raioExterno;
	}

	@Override
	public double calcularInerciaEixoXX() {
		return SecaoCircular.calcularInerciaEixoXX(raioExterno) - SecaoCircular.calcularInerciaEixoXX(raioInterno);
	}

	@Override
	public double calcularInerciaEixoYY() {
		return SecaoCircular.calcularInerciaEixoXX(raioExterno) - SecaoCircular.calcularInerciaEixoXX(raioInterno);
	}

	@Override
	public double calcularProdutoInercia() {
		return 0;
	}

	@Override
	public double calcularMomentoEstaticoEixoXX() {
		double y = this.calcularCentroideEixoXX();
		double area = this.calcularArea();
		return y * area;
	}

	@Override
	public double calcularMomentoEstaticoEixoYY() {
		double x = this.calcularCentroideEixoXX();
		double area = this.calcularArea();
		return x * area;
	}

	@Override
	public double calcularRaioDeGiracaoEixoXX() {
		return Math.sqrt(this.calcularInerciaEixoXX() / this.calcularArea());
	}

	@Override
	public double calcularRaioDeGiracaoEixoYY() {
		return Math.sqrt(this.calcularInerciaEixoYY() / this.calcularArea());
	}

	public static double calcularArea(double raioExterno, double raioInterno) {
		return SecaoCircular.calcularArea(raioExterno) - SecaoCircular.calcularArea(raioInterno);
	}

	public static double calcularCentroideEixoXX(double raioExterno, double raioInterno) {
		return raioExterno;
	}

	public static double calcularCentroideEixoYY(double raioExterno, double raioInterno) {
		return raioExterno;
	}

	public static double calcularInerciaEixoXX(double raioExterno, double raioInterno) {
		return SecaoCircular.calcularInerciaEixoXX(raioExterno) - SecaoCircular.calcularInerciaEixoXX(raioInterno);
	}

	public static double calcularInerciaEixoYY(double raioExterno, double raioInterno) {
		return SecaoCircular.calcularInerciaEixoXX(raioExterno) - SecaoCircular.calcularInerciaEixoXX(raioInterno);
	}

	// Qx = y.A
	public static double calcularMomentoEstaticoEixoXX(double raioExterno, double raioInterno) {
		double y = SecaoCircularVazado.calcularCentroideEixoXX(raioExterno, raioInterno);
		double area = SecaoCircularVazado.calcularArea(raioExterno, raioInterno);
		return y * area;
	}

	// Qy = x.A
	public static double calcularMomentoEstaticoEixoYY(double raioExterno, double raioInterno) {
		double x = SecaoCircularVazado.calcularCentroideEixoXX(raioExterno, raioInterno);
		double area = SecaoCircularVazado.calcularArea(raioExterno, raioInterno);
		return x * area;
	}

	public static double calcularRaioDeGiracaoEixoXX(double raioExterno, double raioInterno) {
		return Math.sqrt(SecaoCircularVazado.calcularInerciaEixoXX(raioExterno, raioInterno)
				/ SecaoCircularVazado.calcularArea(raioExterno, raioInterno));
	}

	public static double calcularRaioDeGiracaoEixoYY(double raioExterno, double raioInterno) {
		return Math.sqrt(SecaoCircularVazado.calcularInerciaEixoYY(raioExterno, raioInterno)
				/ SecaoCircularVazado.calcularArea(raioExterno, raioInterno));
	}

}