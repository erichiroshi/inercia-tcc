package com.erichiroshi.resistenciamateriais.domain.entities;

import java.text.DecimalFormat;

public interface Secao {

	double calcularArea();
	double calcularCentroideEixoXX();
	double calcularCentroideEixoYY();
	double calcularInerciaEixoXX();
	double calcularInerciaEixoYY();
	double calcularProdutoInercia();
	double calcularMomentoEstaticoEixoXX();
	double calcularMomentoEstaticoEixoYY();
	double calcularRaioDeGiracaoEixoXX();
	double calcularRaioDeGiracaoEixoYY();

	static String escreveSecao(Secao secao) {
		DecimalFormat df = new DecimalFormat("0.0000E0");
		DecimalFormat df2 = new DecimalFormat("0.0000");
		StringBuilder sb = new StringBuilder();
		sb.append("Área: " + df2.format(secao.calcularArea()));
		sb.append("\nX:  " + df2.format(secao.calcularCentroideEixoYY()));
		sb.append("\nY:  " + df2.format(secao.calcularCentroideEixoXX()));
		sb.append("\nQx: " + df.format(secao.calcularMomentoEstaticoEixoXX()));
		sb.append("\nQy: " + df.format(secao.calcularMomentoEstaticoEixoYY()));
		sb.append("\nIx: " + df.format(secao.calcularInerciaEixoXX()));
		sb.append("\nIy: " + df.format(secao.calcularInerciaEixoYY()));
		sb.append("\nIxy: " + df2.format(secao.calcularProdutoInercia()));
		sb.append("\nKx: " + df2.format(secao.calcularRaioDeGiracaoEixoXX()));
		sb.append("\nKy: " + df2.format(secao.calcularRaioDeGiracaoEixoYY()));
		sb.append("\n-------------------------------------------------------");
		return sb.toString();
	}
}