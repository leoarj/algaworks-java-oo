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

	private void ordenarNumerosParcialmente(int[] jogo, int indexAtual) {
		/*
		 * Ordena o array parcialmente (em pequenos blocos conforme os índices
		 * informados).
		 * Nesse caso, o início (inclusive) até a posição atual (exclusive).
		 */
		Arrays.sort(jogo, 0, indexAtual);
	}

	private void ordenarNumerosCompletamente(int[] jogo) {
		// Ordena totalmente o array, do primeiro ao último elemento.
		Arrays.sort(jogo);
	}

	private boolean jaFoiSorteado(int[] jogo, int indexAtual, int numero) {
		// Busca linear com for() ou métodos utilitários da API do Java.

		/*
		 * Pode ser utilizado Arrays.binarySearch().
		 * Array deve ser ordenado total ou
		 * parcialmente ante de executar busca binária.
		 * 
		 * Ordenando e buscando parcialmente (sub-array: parte do array) por questões de
		 * performance.
		 */
		ordenarNumerosParcialmente(jogo, indexAtual);
		return Arrays.binarySearch(jogo, 0, indexAtual, numero) >= 0;
	}

	/*
	 * Conhecido apenas pelo método de sortearNumeros().
	 * Retorna se foi possível adicionar o número.
	 * Chama jaFoiSorteado() (que já ordena e pesquisa parcialmente).
	 */
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
			ordenarNumerosCompletamente(jogos[i]);
			System.out.println(Arrays.toString(jogos[i]));
		}
	}

	public void sortearNumeros() {
		Random random = new Random();

		for (int i = 0; i < jogos.length; i++) {
			for (int j = 1; j <= jogos[i].length; j++) {
				int numeroSorteado = random.nextInt(NUMERO_INICIAL, NUMERO_FINAL);

				if (!adicionarNumero(jogos[i], j - 1, numeroSorteado)) {
					j--;
				}
			}
		}
	}
}