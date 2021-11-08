package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoT implements Secao {

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

		return ((this.alturaAlma / 2) * areaAlma + (this.alturaAlma + this.alturaAba / 2) * areaAba)
				/ (areaAlma + areaAba);
	}

	@Override
	public double calcularCentroideEixoYY() {
		return this.larguraAba / 2;
	}

	@Override
	public double calcularInerciaEixoXX() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double y = this.calcularCentroideEixoXX();

		double dyAlma = y - this.alturaAlma / 2;
		double dyAba = (this.alturaAlma + this.alturaAba / 2) - y;

		return SecaoRetangular.calcularInerciaEixoXX(this.larguraAlma, this.alturaAlma) + areaAlma * Math.pow(dyAlma, 2)
				+ SecaoRetangular.calcularInerciaEixoXX(this.larguraAba, this.alturaAba) + areaAba * Math.pow(dyAba, 2);
	}

	@Override
	public double calcularInerciaEixoYY() {
		return SecaoRetangular.calcularInerciaEixoYY(this.larguraAlma, this.alturaAlma)
				+ SecaoRetangular.calcularInerciaEixoYY(this.larguraAba, this.alturaAba);
	}

	@Override
	public double calcularProdutoInercia() {
		return 0;
	}

	@Override
	public double calcularMomentoEstaticoEixoXX() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);

		return this.alturaAlma / 2 * areaAlma + (this.alturaAba / 2 + this.alturaAlma) * areaAba;
	}

	@Override
	public double calcularMomentoEstaticoEixoYY() {
		double areaAlma = SecaoRetangular.calcularArea(this.larguraAlma, this.alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(this.larguraAba, this.alturaAba);
		double x = this.larguraAba / 2;

		return x * areaAlma + x * areaAba;
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

//y = y.A/A
	public static double calcularCentroideEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);

		return ((alturaAlma / 2) * areaAlma + (alturaAlma + alturaAba / 2) * areaAba) / (areaAlma + areaAba);
	}

	// x = x.A/A
	public static double calcularCentroideEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		return larguraAba / 2;
	}

	// I = b.h³/12 + Ady² y = y.A/A
	public static double calcularInerciaEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double y = SecaoT.calcularCentroideEixoXX(larguraAlma, alturaAlma, larguraAba, alturaAba);

		double dyAlma = y - alturaAlma / 2;
		double dyAba = (alturaAlma + alturaAba / 2) - y;

		return SecaoRetangular.calcularInerciaEixoXX(larguraAlma, alturaAlma) + areaAlma * Math.pow(dyAlma, 2)
				+ SecaoRetangular.calcularInerciaEixoXX(larguraAba, alturaAba) + areaAba * Math.pow(dyAba, 2);
	}

	public static double calcularInerciaEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {
		return SecaoRetangular.calcularInerciaEixoYY(larguraAlma, alturaAlma)
				+ SecaoRetangular.calcularInerciaEixoYY(larguraAba, alturaAba);
	}

	// Qx = y.A
	public static double calcularMomentoEstaticoEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);

		return alturaAlma / 2 * areaAlma + (alturaAba / 2 + alturaAlma) * areaAba;
	}

	// Qy = x.A
	public static double calcularMomentoEstaticoEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		double areaAba = SecaoRetangular.calcularArea(larguraAba, alturaAba);
		double areaAlma = SecaoRetangular.calcularArea(larguraAlma, alturaAlma);
		double x = larguraAba / 2;

		return x * areaAlma + x * areaAba;
	}

	public static double calcularRaioDeGiracaoEixoXX(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		return Math.sqrt(SecaoT.calcularInerciaEixoXX(larguraAlma, alturaAlma, larguraAba, alturaAba)
				/ SecaoT.calcularArea(larguraAlma, alturaAlma, larguraAba, alturaAba));
	}

	public static double calcularRaioDeGiracaoEixoYY(double larguraAlma, double alturaAlma, double larguraAba,
			double alturaAba) {

		return Math.sqrt(SecaoT.calcularInerciaEixoYY(larguraAlma, alturaAlma, larguraAba, alturaAba)
				/ SecaoT.calcularArea(larguraAlma, alturaAlma, larguraAba, alturaAba));
	}

}
