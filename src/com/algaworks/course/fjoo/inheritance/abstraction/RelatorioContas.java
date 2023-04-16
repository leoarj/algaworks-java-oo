package com.algaworks.course.fjoo.inheritance.abstraction;

import com.algaworks.course.fjoo.inheritance.Conta;

public class RelatorioContas {

	/*
	 * Argumento do tipo da superclasse para reduzir o acoplamento,
	 * utilizando o maior grau de abstração que for possível.
	 */
	public void exibirListagem(Conta[] contas) {
		if (contas.length == 0) {
			System.out.println("Não existem contas para exibir!");
			return;
		}
		
		System.out.println("========================================\n");
		System.out.println("Relatório de Contas\n");
		
		for (int i = 0; i < contas.length; i++) {
			contas[i].exibirDetalhes(); // Consumindo método, mas sem conhecer os detalhes de implementação.
			System.out.println();
		}
		
		System.out.println("========================================");
	}
}