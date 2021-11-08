package com.erichiroshi.resistenciamateriais.teste;

import com.erichiroshi.resistenciamateriais.domain.entities.Secao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoC;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoCaixao;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoCircular;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoCircularVazado;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoI;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoL;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoRetangular;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoT;
import com.erichiroshi.resistenciamateriais.domain.entities.SecaoTriangular;

public class Program {

	public static void main(String[] args) {

		System.out.println("Seção Retangular");
		double largura = 0.20;
		double altura = 0.25;
		Secao r = new SecaoRetangular(largura, altura);
		System.out.println(Secao.escreveSecao(r));

		System.out.println("Seção Caixão");
		double larguraExterna = 21;
		double alturaExterna = 25;
		double larguraInterna = 15;
		double alturaInterna = 19;
		Secao caixao = new SecaoCaixao(larguraExterna, alturaExterna, larguraInterna, alturaInterna);
		System.out.println(Secao.escreveSecao(caixao));

		System.out.println("Seção Circular");
		double raio = 30;
		Secao circular = new SecaoCircular(raio);
		System.out.println(Secao.escreveSecao(circular));

		System.out.println("Seção Circular Vazado");
		double raioExterno = 7.5;
		double raioInterno = 7.0;
		Secao cv = new SecaoCircularVazado(raioExterno, raioInterno);
		System.out.println(Secao.escreveSecao(cv));

		System.out.println("Seção Triangular");
		double alturaTriangulo = 250;
		double baseTriangulo = 200;
		double aTriangulo = 75;
		Secao tri = new SecaoTriangular(baseTriangulo, alturaTriangulo, aTriangulo);
		System.out.println(Secao.escreveSecao(tri));

		System.out.println("Seção I");
		double larguraAlma = 0.5;
		double alturaAlma = 6;
		double larguraAbaInferior = 8;
		double alturaAbaInferior = 0.5;
		double larguraAbaSuperior = 8;
		double alturaAbaSuperior = 0.5;
		Secao i = new SecaoI(larguraAlma, alturaAlma, larguraAbaInferior, alturaAbaInferior, larguraAbaSuperior,
				alturaAbaSuperior);
		System.out.println(Secao.escreveSecao(i));

		System.out.println("Seção T");
		double larguraAlmaT = 0.03;
		double alturaAlmaT = 0.2;
		double larguraAbaT = 0.2;
		double alturaAbaT = 0.03;
		Secao t = new SecaoT(larguraAlmaT, alturaAlmaT, larguraAbaT, alturaAbaT);
		System.out.println(Secao.escreveSecao(t));

		System.out.println("Seção L");
		double larguraAlmaL = 1;
		double alturaAlmaL = 4;
		double larguraAbaL = 4;
		double alturaAbaL = 1;
		Secao l = new SecaoL(larguraAlmaL, alturaAlmaL, larguraAbaL, alturaAbaL);
		System.out.println(Secao.escreveSecao(l));

		System.out.println("Seção C");
		double larguraAlmaC = 0.1;
		double alturaAlmaC = 1.1;
		double larguraAbaC = 0.75;
		double alturaAbaC = 0.1;
		Secao c = new SecaoC(larguraAlmaC, alturaAlmaC, larguraAbaC, alturaAbaC, larguraAbaC, alturaAbaC);
		System.out.println(Secao.escreveSecao(c));

	}
}
