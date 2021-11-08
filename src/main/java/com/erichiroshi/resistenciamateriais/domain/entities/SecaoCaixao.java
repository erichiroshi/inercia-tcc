package com.erichiroshi.resistenciamateriais.domain.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecaoCaixao implements Secao {

	private double larguraExterna;
	private double alturaExterna;
	private double larguraInterna;
	private double alturaInterna;

	@Override
	public double calcularArea() {
		return SecaoRetangular.calcularArea(larguraExterna, alturaExterna)
				- SecaoRetangular.calcularArea(larguraInterna, alturaInterna);
	}

	@Override
	public double calcularCentroideEixoXX() {
		return alturaExterna / 2;
	}

	@Override
	public double calcularCentroideEixoYY() {
		return larguraExterna / 2;
	}

	@Override
	public double calcularInerciaEixoXX() {
		return SecaoRetangular.calcularInerciaEixoXX(larguraExterna, alturaExterna)
				- SecaoRetangular.calcularInerciaEixoXX(larguraInterna, alturaInterna);
	}

	@Override
	public double calcularInerciaEixoYY() {
		return SecaoRetangular.calcularInerciaEixoYY(larguraExterna, alturaExterna)
				- SecaoRetangular.calcularInerciaEixoYY(larguraInterna, alturaInterna);
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

	public static double calcularArea(double larguraExterna, double alturaExterna, double larguraInterna,
			double alturaInterna) {
		return SecaoRetangular.calcularArea(larguraExterna, alturaExterna)
				- SecaoRetangular.calcularArea(larguraInterna, alturaInterna);
	}

	// y
	public static double calcularCentroideEixoXX(double larguraExterna, double alturaExterna, double larguraInterna,
			double alturaInterna) {

		return alturaExterna / 2;
	}

	// x
	public static double calcularCentroideEixoYY(double larguraExterna, double alturaExterna, double larguraInterna,
			double alturaInterna) {

		return larguraExterna / 2;
	}

	public static double calcularInerciaEixoXX(double larguraExterna, double alturaExterna, double larguraInterna,
			double alturaInterna) {
		return SecaoRetangular.calcularInerciaEixoXX(larguraExterna, alturaExterna)
				- SecaoRetangular.calcularInerciaEixoXX(larguraInterna, alturaInterna);
	}

	public static double calcularInerciaEixoYY(double larguraExterna, double alturaExterna, double larguraInterna,
			double alturaInterna) {
		return SecaoRetangular.calcularInerciaEixoYY(larguraExterna, alturaExterna)
				- SecaoRetangular.calcularInerciaEixoYY(larguraInterna, alturaInterna);
	}

	// Qx = y.A
	public static double calcularMomentoEstaticoEixoXX(double larguraExterna, double alturaExterna,
			double larguraInterna, double alturaInterna) {

		double y = SecaoCaixao.calcularCentroideEixoXX(larguraExterna, alturaExterna, larguraInterna, alturaInterna);
		double area = SecaoCaixao.calcularArea(larguraExterna, alturaExterna, larguraInterna, alturaInterna);
		return y * area;

	}

	// Qy = x.A
	public static double calcularMomentoEstaticoEixoYY(double larguraExterna, double alturaExterna,
			double larguraInterna, double alturaInterna) {

		double x = SecaoCaixao.calcularCentroideEixoYY(larguraExterna, alturaExterna, larguraInterna, alturaInterna);
		double area = SecaoCaixao.calcularArea(larguraExterna, alturaExterna, larguraInterna, alturaInterna);
		return x * area;
	}

	public static double calcularRaioDeGiracaoEixoXX(double larguraExterna, double alturaExterna, double larguraInterna,
			double alturaInterna) {
		return Math.sqrt(SecaoCaixao.calcularInerciaEixoXX(larguraExterna, alturaExterna, larguraInterna, alturaInterna)
				/ SecaoCaixao.calcularArea(larguraExterna, alturaExterna, larguraInterna, alturaInterna));
	}

	public static double calcularRaioDeGiracaoEixoYY(double larguraExterna, double alturaExterna, double larguraInterna,
			double alturaInterna) {
		return Math.sqrt(SecaoCaixao.calcularInerciaEixoYY(larguraExterna, alturaExterna, larguraInterna, alturaInterna)
				/ SecaoCaixao.calcularArea(larguraExterna, alturaExterna, larguraInterna, alturaInterna));
	}

}
