package com.algaworks.course.fjoo.math;

public class TestMegaSenaExample {

	public static void main(String[] args) {
		//MegaSenaExample example = new MegaSenaExample(10);
		//example.sortearNumeros();
		//example.exibirJogos();
		
		MegaSenaExampleSortedSet exampleSortedSet = new MegaSenaExampleSortedSet(10);
		exampleSortedSet.sortearNumeros();
		exampleSortedSet.exibirJogos();
		
		/*
		 * Exemplo de saída:
		[1, 7, 10, 18, 38, 55]
		[2, 6, 14, 23, 31, 49]
		[1, 9, 16, 21, 23, 56]
		[4, 20, 23, 32, 46, 50]
		[1, 32, 43, 49, 55, 58]
		[3, 4, 20, 30, 51, 58]
		[15, 17, 19, 37, 38, 58]
		[24, 26, 37, 51, 53, 54]
		[8, 15, 18, 27, 31, 51]
		*/
	}	
}