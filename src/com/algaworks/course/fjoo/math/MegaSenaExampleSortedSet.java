package com.algaworks.course.fjoo.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class MegaSenaExampleSortedSet {

	private static final int NUMERO_INICIAL = 1;
	private static final int NUMERO_FINAL = 60;
	private static final int QUANTIDADE_NUMEROS = 6;

	private int quantidadeJogos;
	private List<SortedSet<Integer>> jogos;

	public MegaSenaExampleSortedSet(int quantidadeJogos) {
		this.quantidadeJogos = quantidadeJogos;
		this.jogos = new ArrayList<>(quantidadeJogos);
	}
	
	public void sortearNumeros() {
		Random random = new Random();

		for (int i = 0; i < quantidadeJogos; i++) {
			SortedSet<Integer> jogo = new TreeSet<>();
			
			for (int j = 1; j < QUANTIDADE_NUMEROS; j++) {
				int numeroSorteado = random.nextInt(NUMERO_INICIAL, NUMERO_FINAL);

				if (!jogo.add(numeroSorteado)) {
					j--;
				}
			}
			
			jogos.add(jogo);
			
		}
	}
	
	public void exibirJogos() {
		for (SortedSet<Integer> o : jogos) {
			System.out.println(o);
		}
	}
}