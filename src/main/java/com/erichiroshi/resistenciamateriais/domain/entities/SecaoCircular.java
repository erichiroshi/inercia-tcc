package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoCircular implements Secao {

	private static final double PI = Math.PI;

	private double raio;

	@Override
	public double calcularArea() {
		return Math.PI * Math.pow(this.raio, 2);
	}

	@Override
	public double calcularCentroideEixoXX() {
		return this.raio;
	}

	@Override
	public double calcularCentroideEixoYY() {
		return this.raio;
	}

	@Override
	public double calcularInerciaEixoXX() {
		return PI * Math.pow(this.raio, 4) / 4;
	}

	@Override
	public double calcularInerciaEixoYY() {
		return PI * Math.pow(this.raio, 4) / 4;
	}

	@Override
	public double calcularProdutoInercia() {
		return 0;
	}

	// Qx = y.A
	@Override
	public double calcularMomentoEstaticoEixoXX() {
		double y = this.calcularCentroideEixoXX();
		double area = this.calcularArea();
		return y * area;
	}

	@Override
	public double calcularMomentoEstaticoEixoYY() {
		double x = this.calcularCentroideEixoYY();
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

	public static double calcularArea(double raio) {
		return Math.PI * Math.pow(raio, 2);
	}

	public static double calcularCentroideEixoXX(double raio) {
		return raio;
	}

	public static double calcularCentroideEixoYY(double raio) {
		return raio;
	}

	public static double calcularInerciaEixoXX(double raio) {
		return PI * Math.pow(raio, 4) / 4;
	}

	public static double calcularInerciaEixoYY(double raio) {
		return PI * Math.pow(raio, 4) / 4;
	}

	// Q = y.A
	public static double calcularMomentoEstaticoEixoXX(double raio) {
		return Math.PI * Math.pow(raio, 3);
	}

	// Q = y.A
	public static double calcularMomentoEstaticoEixoYY(double raio) {
		return Math.PI * Math.pow(raio, 3);
	}

	public static double calcularRaioDeGiracaoEixoXX(double raio) {
		return Math.sqrt(SecaoCircular.calcularInerciaEixoXX(raio) / SecaoCircular.calcularArea(raio));
	}

	public static double calcularRaioDeGiracaoEixoYY(double raio) {
		return Math.sqrt(SecaoCircular.calcularInerciaEixoYY(raio) / SecaoCircular.calcularArea(raio));
	}

}
