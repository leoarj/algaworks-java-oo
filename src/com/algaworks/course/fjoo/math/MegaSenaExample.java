package com.algaworks.course.fjoo.math;

import java.util.Arrays;
import java.util.Random;

public class MegaSenaExample {

	private static final int NUMERO_INICIAL = 1;
	private static final int NUMERO_FINAL = 60;
	private static final int QUANTIDADE_NUMEROS = 6;
	
	private int[][] jogos;

	public MegaSenaExample(int quantidadeJogos) {
		this.jogos = new int[quantidadeJogos - 1][QUANTIDADE_NUMEROS];
	}

	private void ordenarNumeros(int[] jogo, int indexAtual) {	
		Arrays.sort(jogo, 0, indexAtual);
	}
	
	private boolean jaFoiSorteado(int[] jogo, int indexAtual, int numero) {
//		boolean resultado = false;

//		for (int i = 0; i < jogo.length; i++) {
//			if (jogo[i] == numero) {
//				resultado = true;
//			}
//		}
		
		//return resultado;
		// Pode ser utilizado Arrays.binarySearch();
		ordenarNumeros(jogo, indexAtual);
		return Arrays.binarySearch(jogo, numero) >= 0;
	}
	
	private boolean adicionarNumero(int[] jogo, int indexAtual, int numero) {
		boolean resultado = false;
		if (!jaFoiSorteado(jogo, indexAtual, numero)) {
			jogo[indexAtual] = numero;
			resultado = true;
		}
		return resultado;
	}
	
	public void exibirJogos() {
		for (int i = 0; i < jogos.length; i++) {
			//Arrays.sort(jogos[i]);
			ordenarNumeros(jogos[i], jogos[i].length);
			System.out.println(Arrays.toString(jogos[i]));
		}
	}

	public void sortearNumeros() {
		Random random = new Random();

		for (int i = 0; i < jogos.length; i++) {
			for (int j = 1; j <= jogos[i].length; j++) {
				int numeroSorteado = random.nextInt(NUMERO_INICIAL, NUMERO_FINAL);

				//if (!jaFoiSorteado(jogos[i], j, numeroSorteado)) {
					//jogos[i][j] = numeroSorteado;
				//}
				
				if (!adicionarNumero(jogos[i], j-1, numeroSorteado)) {
					j--;
				}
			}
		}
	}
}