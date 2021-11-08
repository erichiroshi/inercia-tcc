package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoI implements Secao {

	private double larguraAlma;
	private double alturaAlma;
	private double larguraAbaInferior;
	private double alturaAbaInferior;
	private double larguraAbaSuperior;
	private double alturaAbaSuperior;

	@Override
	public double calcularArea() {
		return SecaoRetangular.calcularArea(this.larguraAbaInferior, this.alturaAbaInferior)
				+ SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma)
				+ SecaoRetangular.calcularArea(this.larguraAbaSuperior, this.alturaAbaSuperior);
	}

	@Override
	public double calcularCentroideEixoXX() {
		double areaAbaInferior = SecaoRetangular.calcularArea(this.larguraAbaInferior, this.alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(this.larguraAbaSuperior, this.alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double yAbaInferior = this.alturaAbaInferior / 2;
		double yAlma = this.alturaAlma / 2 + this.alturaAbaInferior;
		double yAbaSuperior = this.alturaAbaSuperior / 2 + this.alturaAlma + this.alturaAbaInferior;

		return (yAbaInferior * areaAbaInferior + yAlma * areaAlma + yAbaSuperior * areaAbaSuperior)
				/ (areaAbaInferior + areaAlma + areaAbaSuperior);
	}

	@Override
	public double calcularCentroideEixoYY() {
		if (this.larguraAbaSuperior >= this.larguraAbaInferior)
			return this.larguraAbaSuperior / 2;
		else
			return this.larguraAbaInferior / 2;
	}

	@Override
	public double calcularInerciaEixoXX() {
		double areaAbaInferior = SecaoRetangular.calcularArea(this.larguraAbaInferior, this.alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(this.larguraAbaSuperior, this.alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double Cy = this.calcularCentroideEixoXX();

		double dyAbaInferior = Cy - this.alturaAbaInferior / 2;
		double dyAlma = this.alturaAlma >= Cy ? (this.alturaAlma / 2 + this.alturaAbaInferior) - Cy
				: Cy - (alturaAlma / 2 + alturaAbaInferior);
		double dyAbaSuperior = (this.alturaAbaSuperior / 2 + this.alturaAlma + this.alturaAbaInferior) - Cy;

		return SecaoRetangular.calcularInerciaEixoXX(this.larguraAbaInferior, this.alturaAbaInferior)
				+ areaAbaInferior * Math.pow(dyAbaInferior, 2)
				+ SecaoRetangular.calcularInerciaEixoXX(this.larguraAlma, this.alturaAlma)
				+ areaAlma * Math.pow(dyAlma, 2)
				+ SecaoRetangular.calcularInerciaEixoXX(this.larguraAbaSuperior, this.alturaAbaSuperior)
				+ areaAbaSuperior * Math.pow(dyAbaSuperior, 2);
	}

	@Override
	public double calcularInerciaEixoYY() {
		return SecaoRetangular.calcularInerciaEixoYY(this.larguraAbaInferior, this.alturaAbaInferior)
				+ SecaoRetangular.calcularInerciaEixoYY(this.larguraAlma, this.alturaAlma)
				+ SecaoRetangular.calcularInerciaEixoYY(this.larguraAbaSuperior, this.alturaAbaSuperior);
	}

	@Override
	public double calcularProdutoInercia() {
		return 0;
	}

	@Override
	public double calcularMomentoEstaticoEixoXX() {
		double areaAbaInferior = SecaoRetangular.calcularArea(this.larguraAbaInferior, this.alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(this.larguraAbaSuperior, this.alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);

		return this.alturaAbaInferior / 2 * areaAbaInferior + (this.alturaAlma / 2 + this.alturaAbaInferior) * areaAlma
				+ (this.alturaAbaSuperior / 2 + this.alturaAlma + this.alturaAbaInferior) * areaAbaSuperior;
	}

	@Override
	public double calcularMomentoEstaticoEixoYY() {
		double areaAbaInferior = SecaoRetangular.calcularArea(this.larguraAbaInferior, this.alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(this.larguraAbaSuperior, this.alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double x = this.larguraAbaInferior >= this.larguraAbaSuperior ? this.larguraAbaInferior / 2
				: this.larguraAbaSuperior / 2;

		return x * areaAbaInferior + x * areaAlma + x * areaAbaSuperior;
	}

	@Override
	public double calcularRaioDeGiracaoEixoXX() {
		return Math.sqrt(this.calcularInerciaEixoXX() / this.calcularArea());
	}

	@Override
	public double calcularRaioDeGiracaoEixoYY() {
		return Math.sqrt(this.calcularInerciaEixoYY() / this.calcularArea());
	}

	public static double calcularArea(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		return SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior)
				+ SecaoRetangular.calcularArea(larguraAlma, alturaAlma)
				+ SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
	}

	// y = y.A/A
	public static double calcularCentroideEixoXX(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double yAbaInferior = alturaAbaInferior / 2;
		double yAlma = alturaAlma / 2 + alturaAbaInferior;
		double yAbaSuperior = alturaAbaSuperior / 2 + alturaAlma + alturaAbaInferior;

		return (yAbaInferior * areaAbaInferior + yAlma * areaAlma + yAbaSuperior * areaAbaSuperior)
				/ (areaAbaInferior + areaAlma + areaAbaSuperior);

	}

	// x = x.A/A
	public static double calcularCentroideEixoYY(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		if (larguraAbaSuperior >= larguraAbaInferior)
			return larguraAbaSuperior / 2;
		else
			return larguraAbaInferior / 2;

	}

	// I = b.h³/12 + Ady²
	public static double calcularInerciaEixoXX(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double Cy = SecaoI.calcularCentroideEixoXX(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior,
				larguraAbaSuperior, alturaAbaSuperior);

		double dyAbaInferior = Cy - alturaAbaInferior / 2;
		double dyAlma = alturaAlma >= Cy ? (alturaAlma / 2 + alturaAbaInferior) - Cy
				: Cy - (alturaAlma / 2 + alturaAbaInferior);
		double dyAbaSuperior = (alturaAbaSuperior / 2 + alturaAlma + alturaAbaInferior) - Cy;

		return SecaoRetangular.calcularInerciaEixoXX(larguraAbaInferior, alturaAbaInferior)
				+ areaAbaInferior * Math.pow(dyAbaInferior, 2)
				+ SecaoRetangular.calcularInerciaEixoXX(larguraAlma, alturaAlma) + areaAlma * Math.pow(dyAlma, 2)
				+ SecaoRetangular.calcularInerciaEixoXX(larguraAbaSuperior, alturaAbaSuperior)
				+ areaAbaSuperior * Math.pow(dyAbaSuperior, 2);
	}

	public static double calcularInerciaEixoYY(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		return SecaoRetangular.calcularInerciaEixoYY(larguraAbaInferior, alturaAbaInferior)
				+ SecaoRetangular.calcularInerciaEixoYY(larguraAlma, alturaAlma)
				+ SecaoRetangular.calcularInerciaEixoYY(larguraAbaSuperior, alturaAbaSuperior);
	}

	// Qx = y.A
	public static double calcularMomentoEstaticoEixoXX(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);

		return alturaAbaInferior / 2 * areaAbaInferior + (alturaAlma / 2 + alturaAbaInferior) * areaAlma
				+ (alturaAbaSuperior / 2 + alturaAlma + alturaAbaInferior) * areaAbaSuperior;
	}

	// Qy = x.A
	public static double calcularMomentoEstaticoEixoYY(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double x = larguraAbaInferior >= larguraAbaSuperior ? larguraAbaInferior / 2 : larguraAbaSuperior / 2;

		return x * areaAbaInferior + x * areaAlma + x * areaAbaSuperior;
	}

	public static double calcularRaioDeGiracaoEixoXX(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		return Math.sqrt(SecaoI.calcularInerciaEixoXX(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior,
				larguraAbaSuperior, alturaAbaSuperior)
				/ SecaoI.calcularArea(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior, larguraAbaSuperior,
						alturaAbaSuperior));
	}

	public static double calcularRaioDeGiracaoEixoYY(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		return Math.sqrt(SecaoI.calcularInerciaEixoYY(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior,
				larguraAbaSuperior, alturaAbaSuperior)
				/ SecaoI.calcularArea(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior, larguraAbaSuperior,
						alturaAbaSuperior));
	}

}
