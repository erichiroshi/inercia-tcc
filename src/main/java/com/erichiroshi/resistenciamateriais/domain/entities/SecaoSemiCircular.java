package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoSemiCircular implements Secao {

	private double raio;

	@Override
	public double calcularArea() {
		return SecaoCircular.calcularArea(this.raio) / 2;
	}

	@Override
	public double calcularCentroideEixoXX() {
		return (4 * this.raio) / (3 * Math.PI);
	}

	@Override
	public double calcularCentroideEixoYY() {
		return (4 * this.raio) / (3 * Math.PI);
	}

	@Override
	public double calcularInerciaEixoXX() {
		return SecaoCircular.calcularInerciaEixoXX(this.raio) / 2;
	}

	@Override
	public double calcularInerciaEixoYY() {
		return SecaoCircular.calcularInerciaEixoYY(this.raio) / 2;
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
		return SecaoCircular.calcularArea(raio) / 2;
	}

	public static double calcularCentroideSemiCircular(double raio) {
		return (4 * raio) / (3 * Math.PI);
	}

	public static double calcularInerciaEixoXX(double raio) {
		return SecaoCircular.calcularInerciaEixoXX(raio) / 2;
	}

	public static double calcularInerciaEixoYY(double raio) {
		return SecaoCircular.calcularInerciaEixoYY(raio) / 2;
	}

	// Q = y.A
	public static double calcularMomentoEstaticoEixoXX(double raio) {

		return SecaoCircular.calcularMomentoEstaticoEixoXX(raio) - SecaoCircular.calcularMomentoEstaticoEixoXX(raio);
	}

	// Q = y.A
	public static double calcularMomentoEstaticoEixoYY(double raio) {

		return SecaoCircular.calcularMomentoEstaticoEixoYY(raio) - SecaoCircular.calcularMomentoEstaticoEixoYY(raio);
	}

}
