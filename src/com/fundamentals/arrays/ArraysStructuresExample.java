package com.fundamentals.arrays;

import java.util.Arrays;

public class ArraysStructuresExample {

	public void testCopyArray() {
		// Formas válidas de inicialização
		int[] array1 = new int[2];
		//int[] array1 = {2, 5};
		//int[] array1 = new int[] {2, 5};
		
		/*
		 * Não é possível expandir um array atual, deve-se realizar uma cópia, definindo novo tamanho.
		 * Para isso, pode se utilizar Arrays.copyof do pacote java.util da classe utilitária Arrays.
		 * */
		int[] array2 = Arrays.copyOf(array1, 5);
		
		System.out.println("ArraysStructuresExample -> testCopyArray:");
		System.out.println("array1: " + Arrays.toString(array1));
		System.out.println("array2: " + Arrays.toString(array2));
		System.out.println("========================================");
	}
	
	/*
	 * Arrays multidimensionais são arrays em que seus elementos também são arrays.
	 * São "arrays-de-arrays".
	 * Analogia básica (duas dimensões): Linha, Coluna.
	 * 
	 * */
	public void testMultidimensionalArrays() {
		/*
		 * Formas válidas de inicialização.
		 * (Obs.: Primeira dimensão deve ser informada na inicialização).
		 * */
		String[][] locais = new String[3][];
		
		locais[0] = new String[3];
		locais[0][0] = "Uberlândia";
		locais[0][1] = "Uberaba";
		locais[0][2] = "Belo Horizonte";
		
		locais[1] = new String[1];
		locais[1][0] = "Rio da Janeiro";
		
		locais[2] = new String[2];
		locais[2][0] = "São Paulo";
		locais[2][1] = "Ribeirão Preto";
		
		// Forma de inicialização informando array multidimensional de forma literal
		String[][] locais2 = {
				{"Uberlândia", "Uberaba", "Belo Horizonte"},
				{"Rio da Janeiro"},
				{"São Paulo", "Ribeirão Preto"}
		};
		
		System.out.println("ArraysStructuresExample -> testMultidimensionalArrays:");
		System.out.println("locais: ");
		
		for (int i = 0; i < locais.length; i++) {
			for (int j = 0; j < locais[i].length; j++) {
				System.out.println(locais[i][j]);
			}
		}
		
		// Para imprimir arrays multidimensionais, podemos usar Arrays.deepToString
		System.out.println("locais2: " + Arrays.deepToString(locais2));
		System.out.println("========================================");
	}
	
	public void testCopyMultidimensionalArray() {
		String[][] locais2 = {
				{"Uberlândia", "Uberaba", "Belo Horizonte"},
				{"Rio da Janeiro"},
				{"São Paulo", "Ribeirão Preto"}
		};
		
		// Cópia básica de arrays usando for e Arrays.copyOf para segunda dimensão.
		String[][] locais3 = new String[locais2.length][];
		for (int i = 0; i < locais2.length; i++) {
			locais3[i] = Arrays.copyOf(locais2[i], locais2[i].length); 
		}
		
		System.out.println("ArraysStructuresExample -> testCopyMultidimensionalArray:");
		System.out.println("locais2: " + Arrays.deepToString(locais2));
		System.out.println("locais3: " + Arrays.deepToString(locais3));
		System.out.println("========================================");
	}
	
	/*
	 * Arrays como argumento podem ser declarados em qualquer posição.
	 * Para consumir o método, deve ser informada uma variável do mesmo tipo.
	 * */
	public int getLengthArrayArg(String[] args, int defaultValue) {
		System.out.println("ArraysStructuresExample -> getLengthArrayArg:");
		System.out.println(Arrays.toString(args));
		System.out.println("========================================");
		return args.length;
	}
	
	public void testGetLengthArrayArg() {
		//String[] arg1 = new String[5];
		
		int arrayArgLength = getLengthArrayArg(new String[] {"1", "2"}, 0);
		
		System.out.println("ArraysStructuresExample -> testGetLengthArrayArg:");
		System.out.println(arrayArgLength);
		System.out.println("========================================");
	}
	
	// Argumento de tamanho variável devem ser o último.
	// Recebe um array literal como argumento.
	public int getLengthVarArg(int defaultValue, String... args) {
		System.out.println("ArraysStructuresExample -> getLengthVarArg:");
		System.out.println(Arrays.toString(args));
		System.out.println("========================================");
		return args.length;
	}
	
	public void testGetLengthVarArg() {
		int varArgLength = getLengthVarArg(0, "12", "55", "55");
		
		System.out.println("ArraysStructuresExample -> testCopyMultidimensionalArray:");
		System.out.println(varArgLength);
		System.out.println("========================================");
	}
	
	public static void main(String[] args) {
		ArraysStructuresExample arraysStructuresExample = new ArraysStructuresExample();
		
		arraysStructuresExample.testCopyArray();
		arraysStructuresExample.testMultidimensionalArrays();
		arraysStructuresExample.testCopyMultidimensionalArray();
		arraysStructuresExample.testGetLengthArrayArg();
		arraysStructuresExample.testGetLengthVarArg();
	}
}
