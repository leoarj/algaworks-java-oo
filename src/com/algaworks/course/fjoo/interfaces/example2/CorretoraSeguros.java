package com.algaworks.course.fjoo.interfaces.example2;

public class CorretoraSeguros {

	public void fazerPropostaSeguro(Seguravel seguravel) {
		System.out.println("------------------------");
		System.out.println("Corretora de Seguros - Proposta");
		System.out.println("------------------------");
		System.out.println(seguravel.obterDescricao());
		System.out.println("Valor da apólice " + seguravel.calcularValorApolice());
		System.out.println("------------------------\n");
	}
}
