package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoL implements Secao {

	private double larguraAlma;
	private double alturaAlma;
	private double larguraAba;
	private double alturaAba;

	@Override
	public double calcularArea() {
		return SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma)
				+ SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
	}

	@Override
	public double calcularCentroideEixoXX() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double yAlma = this.alturaAlma / 2 + this.alturaAba;
		double yAba = this.alturaAba / 2;

		return (yAba * areaAba + yAlma * areaAlma) / (areaAba + areaAlma);
	}

	@Override
	public double calcularCentroideEixoYY() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double xAlma = this.larguraAlma / 2;
		double xAba = this.larguraAba / 2;

		return (xAba * areaAba + xAlma * areaAlma) / (areaAba + areaAlma);
	}

	@Override
	public double calcularInerciaEixoXX() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double yc = this.calcularCentroideEixoXX();
		double dyAba = yc - this.alturaAba / 2;
		double dyAlma = (this.alturaAlma / 2 + this.alturaAba) - yc;

		return SecaoRetangular.calcularInerciaEixoXX(this.larguraAba, this.alturaAba) + areaAba * Math.pow(dyAba, 2)
				+ SecaoRetangular.calcularInerciaEixoXX(this.larguraAlma, this.alturaAlma)
				+ areaAlma * Math.pow(dyAlma, 2);
	}

	@Override
	public double calcularInerciaEixoYY() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double xc = this.calcularCentroideEixoYY();
		double dxAba = this.larguraAba / 2 - xc;
		double dxAlma = xc - this.larguraAlma / 2;

		return SecaoRetangular.calcularInerciaEixoYY(this.larguraAba, this.alturaAba) + areaAba * Math.pow(dxAba, 2)
				+ SecaoRetangular.calcularInerciaEixoYY(this.larguraAlma, this.alturaAlma)
				+ areaAlma * Math.pow(dxAlma, 2);
	}

	@Override
	public double calcularProdutoInercia() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double Cx = this.calcularCentroideEixoYY();
		double Cy = this.calcularCentroideEixoXX();
		double dxAba = this.larguraAba / 2;
		double dxAlma = this.larguraAlma / 2;
		double dyAba = this.alturaAba / 2;
		double dyAlma = (this.alturaAlma / 2 + this.alturaAba);

		return areaAlma * (Cx - dxAlma) * (Cy - dyAlma) + areaAba * (Cx - dxAba) * (Cy - dyAba);
	}

	@Override
	public double calcularMomentoEstaticoEixoXX() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double yAba = this.alturaAba / 2;
		double yAlma = this.alturaAlma / 2 + this.alturaAba;

		return yAba * areaAba + yAlma * areaAlma;
	}

	@Override
	public double calcularMomentoEstaticoEixoYY() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double xAba = this.larguraAba / 2;
		double xAlma = this.larguraAlma / 2;

		return xAba * areaAba + xAlma * areaAlma;
	}

	@Override
	public double calcularRaioDeGiracaoEixoXX() {
		return Math.sqrt(this.calcularInerciaEixoXX() / this.calcularArea());
	}

	@Override
	public double calcularRaioDeGiracaoEixoYY() {
		return Math.sqrt(this.calcularInerciaEixoYY() / this.calcularArea());
	}

	public static double calcularArea(double larguraAlma, double alturaAlma, double larguraAba, double alturaAba) {
		return SecaoRetangular.calcularArea(larguraAlma, alturaAlma)
				+ SecaoRetangular.calcularArea(larguraAba, alturaAba);
	}

	// y = y.A/A
	public static double calcularCentroideEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double yAlma = alturaAlma / 2 + alturaAba;
		double yAba = alturaAba / 2;

		return (yAba * areaAba + yAlma * areaAlma) / (areaAba + areaAlma);
	}

	// x = x.A/A
	public static double calcularCentroideEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double xAlma = larguraAlma / 2;
		double xAba = larguraAba / 2;

		return (xAba * areaAba + xAlma * areaAlma) / (areaAba + areaAlma);
	}

	// I = b.h³/12 + Ady² y = y.A/A
	public static double calcularInerciaEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double yc = SecaoL.calcularCentroideEixoXX(larguraAlma, alturaAlma, larguraAba, alturaAba);
		double dyAba = yc - alturaAba / 2;
		double dyAlma = (alturaAlma / 2 + alturaAba) - yc;

		return SecaoRetangular.calcularInerciaEixoXX(larguraAba, alturaAba) + areaAba * Math.pow(dyAba, 2)
				+ SecaoRetangular.calcularInerciaEixoXX(larguraAlma, alturaAlma) + areaAlma * Math.pow(dyAlma, 2);
	}

	public static double calcularInerciaEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double xc = SecaoL.calcularCentroideEixoYY(larguraAlma, alturaAlma, larguraAba, alturaAba);
		double dxAba = larguraAba / 2 - xc;
		double dxAlma = xc - larguraAlma / 2;

		return SecaoRetangular.calcularInerciaEixoYY(larguraAba, alturaAba) + areaAba * Math.pow(dxAba, 2)
				+ SecaoRetangular.calcularInerciaEixoYY(larguraAlma, alturaAlma) + areaAlma * Math.pow(dxAlma, 2);
	}

	// Qx = y.A
	public static double calcularMomentoEstaticoEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double yAba = alturaAba / 2;
		double yAlma = alturaAlma / 2 + alturaAba;

		return yAba * areaAba + yAlma * areaAlma;
	}

	// Qy = x.A
	public static double calcularMomentoEstaticoEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double xAba = larguraAba / 2;
		double xAlma = larguraAlma / 2;

		return xAba * areaAba + xAlma * areaAlma;
	}

	public static double calcularRaioDeGiracaoEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		return Math.sqrt(SecaoL.calcularInerciaEixoXX(larguraAlma, alturaAlma, larguraAba, alturaAba)
				/ SecaoL.calcularArea(larguraAlma, alturaAlma, larguraAba, alturaAba));
	}

	public static double calcularRaioDeGiracaoEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		return Math.sqrt(SecaoL.calcularInerciaEixoYY(larguraAlma, alturaAlma, larguraAba, alturaAba)
				/ SecaoL.calcularArea(larguraAlma, alturaAlma, larguraAba, alturaAba));
	}

}
