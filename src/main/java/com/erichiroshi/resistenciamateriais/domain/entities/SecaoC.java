package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoC implements Secao {

	private double larguraAlma;
	private double alturaAlma;
	private double larguraAbaInferior;
	private double alturaAbaInferior;
	private double larguraAbaSuperior;
	private double alturaAbaSuperior;

	@Override
	public double calcularArea() {

		return SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma)
				+ SecaoRetangular.calcularArea(this.larguraAbaInferior, this.alturaAbaInferior)
				+ SecaoRetangular.calcularArea(this.larguraAbaSuperior, this.alturaAbaSuperior);
	}

	// y = y.A/A
	@Override
	public double calcularCentroideEixoXX() {
		double areaAbaInferior = SecaoRetangular.calcularArea(this.larguraAbaInferior, this.alturaAbaInferior);
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAbaSuperior = SecaoRetangular.calcularArea(this.larguraAbaSuperior, this.alturaAbaSuperior);
		double yAbaInferior = this.alturaAbaInferior / 2;
		double yAlma = this.alturaAlma / 2 + this.alturaAbaInferior;
		double yAbaSuperior = this.alturaAbaSuperior / 2 + this.alturaAlma + this.alturaAbaInferior;

		return (yAbaInferior * areaAbaInferior + yAlma * areaAlma + yAbaSuperior * areaAbaSuperior)
				/ (areaAbaInferior + areaAlma + areaAbaSuperior);
	}

	// x = x.A/A
	@Override
	public double calcularCentroideEixoYY() {
		double areaAbaInferior = SecaoRetangular.calcularArea(this.larguraAbaInferior, this.alturaAbaInferior);
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAbaSuperior = SecaoRetangular.calcularArea(this.larguraAbaSuperior, this.alturaAbaSuperior);
		double xAbaInferior = this.larguraAbaInferior / 2;
		double xAlma = this.larguraAlma / 2;
		double xAbaSuperior = this.larguraAbaSuperior / 2;

		return (xAbaInferior * areaAbaInferior + xAlma * areaAlma + xAbaSuperior * areaAbaSuperior)
				/ (areaAbaInferior + areaAlma + areaAbaSuperior);
	}

	// Ix = Ix + A.dy² y=y.A/A
	@Override
	public double calcularInerciaEixoXX() {
		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double Cy = calcularCentroideEixoXX();
		double dyAbaInferior = Cy - this.alturaAbaInferior / 2;
		double dyAlma = Cy - (this.alturaAlma / 2 + this.alturaAbaInferior);
		if (dyAlma < 0)
			dyAlma *= -1;
		double dyAbaSuperior = this.alturaAbaSuperior / 2 + this.alturaAlma + this.alturaAbaInferior - Cy;
		double inerciaAbaInferior = SecaoRetangular.calcularInerciaEixoXX(this.larguraAbaInferior,
				this.alturaAbaInferior);
		double inerciaAlma = SecaoRetangular.calcularInerciaEixoXX(this.larguraAlma, this.alturaAlma);
		double inerciaAbaSuperior = SecaoRetangular.calcularInerciaEixoXX(this.larguraAbaSuperior,
				this.alturaAbaSuperior);

		return inerciaAbaInferior + areaAbaInferior * Math.pow(dyAbaInferior, 2) + inerciaAlma
				+ areaAlma * Math.pow(dyAlma, 2) + inerciaAbaSuperior + areaAbaSuperior * Math.pow(dyAbaSuperior, 2);
	}

	// I = I + A.dx² x=x.A/A
	@Override
	public double calcularInerciaEixoYY() {
		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double Cx = calcularCentroideEixoYY();
		double dxAbaInferior = Cx - this.larguraAbaInferior / 2;
		double dxAlma = Cx - this.larguraAlma / 2;
		double dxAbaSuperior = Cx - this.larguraAbaSuperior / 2;
		double inerciaAbaInferior = SecaoRetangular.calcularInerciaEixoYY(this.larguraAbaInferior,
				this.alturaAbaInferior);
		double inerciaAlma = SecaoRetangular.calcularInerciaEixoYY(this.larguraAlma, this.alturaAlma);
		double inerciaAbaSuperior = SecaoRetangular.calcularInerciaEixoYY(this.larguraAbaSuperior,
				this.alturaAbaSuperior);
		return inerciaAbaInferior + areaAbaInferior * Math.pow(dxAbaInferior, 2) + inerciaAlma
				+ areaAlma * Math.pow(dxAlma, 2) + inerciaAbaSuperior + areaAbaSuperior * Math.pow(dxAbaSuperior, 2);
	}

	@Override
	public double calcularProdutoInercia() {
		return 0;
	}

	// Qx = y.A
	@Override
	public double calcularMomentoEstaticoEixoXX() {

		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double yAbaInferior = alturaAbaInferior / 2;
		double yAlma = alturaAlma / 2 + alturaAbaInferior;
		double yAbaSuperior = alturaAbaSuperior / 2 + alturaAlma + alturaAbaInferior;

		return yAbaInferior * areaAbaInferior + yAlma * areaAlma + yAbaSuperior * areaAbaSuperior;
	}

	// Qy = x.A
	@Override
	public double calcularMomentoEstaticoEixoYY() {

		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double xAbaInferior = larguraAbaInferior / 2;
		double xAlma = larguraAlma / 2;
		double xAbaSuperior = larguraAbaSuperior / 2;

		return xAbaInferior * areaAbaInferior + xAlma * areaAlma + xAbaSuperior * areaAbaSuperior;
	}

	@Override
	public double calcularRaioDeGiracaoEixoXX() {

		return Math.sqrt(this.calcularInerciaEixoXX() / this.calcularArea());
	}

	@Override
	public double calcularRaioDeGiracaoEixoYY() {

		return Math.sqrt(this.calcularInerciaEixoYY() / this.calcularArea());
	}

	/*
	public static double calcularRaioDeGiracaoEixoXX(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		return Math.sqrt(calcularInerciaEixoXX(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior)
				/ calcularArea(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior, larguraAbaSuperior,
						alturaAbaSuperior));
	}

	public static double calcularRaioDeGiracaoEixoYY(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		return Math.sqrt(calcularInerciaEixoYY(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior)
				/ calcularArea(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior, larguraAbaSuperior,
						alturaAbaSuperior));
	}

	public static double calcularArea(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		return SecaoRetangular.calcularArea(larguraAlma, alturaAlma)
				+ SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior)
				+ SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
	}

	// y = y.A/A
	public static double calcularCentroideEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		return alturaAlma / 2 + alturaAba;
	}

	// x = x.A/A
	public static double calcularCentroideEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);

		return (larguraAlma / 2 * areaAlma + 2 * (larguraAba / 2 * areaAba)) / (areaAlma + 2 * areaAba);
	}

	public static double calcularInerciaEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double dyAba = (alturaAlma / 2 + alturaAba) - alturaAba / 2;

		return 2 * (SecaoRetangular.calcularInerciaEixoXX(larguraAba, alturaAba) + areaAba * Math.pow(dyAba, 2))
				+ SecaoRetangular.calcularInerciaEixoXX(larguraAlma, alturaAlma);
	}

	// I = I + A.dx² x=x.A/A
	public static double calcularInerciaEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);

		double x = SecaoC.calcularCentroideEixoYY(larguraAlma, alturaAlma, larguraAba, alturaAba);
		double dxAlma = x - larguraAlma / 2;
		double dxAba = larguraAba / 2 - x;

		return 2 * (SecaoRetangular.calcularInerciaEixoYY(larguraAba, alturaAba) + areaAba * Math.pow(dxAba, 2))
				+ SecaoRetangular.calcularInerciaEixoYY(larguraAlma, alturaAlma) + areaAlma * Math.pow(dxAlma, 2);
	}

	// Qx = y.A
	public static double calcularMomentoEstaticoEixoXX(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double yAbaInferior = alturaAbaInferior / 2;
		double yAlma = alturaAlma / 2 + alturaAbaInferior;
		double yAbaSuperior = alturaAbaSuperior / 2 + alturaAlma + alturaAbaInferior;

		return yAbaInferior * areaAbaInferior + yAlma * areaAlma + yAbaSuperior * areaAbaSuperior;
	}

	// Qy = x.A
	public static double calcularMomentoEstaticoEixoYY(double larguraAlma, double alturaAlma, double larguraAbaInferior,
			double alturaAbaInferior, double larguraAbaSuperior, double alturaAbaSuperior) {

		double areaAbaInferior = SecaoRetangular.calcularArea(larguraAbaInferior, alturaAbaInferior);
		double areaAbaSuperior = SecaoRetangular.calcularArea(larguraAbaSuperior, alturaAbaSuperior);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double xAbaInferior = larguraAbaInferior / 2;
		double xAlma = larguraAlma / 2;
		double xAbaSuperior = larguraAbaSuperior / 2;

		return xAbaInferior * areaAbaInferior + xAlma * areaAlma + xAbaSuperior * areaAbaSuperior;
	}
*/
}
