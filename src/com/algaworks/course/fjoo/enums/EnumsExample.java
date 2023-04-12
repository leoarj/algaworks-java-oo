package com.algaworks.course.fjoo.enums;

public class EnumsExample {

	private static void testSimpleEnum() {
		/*
		 * Testar enum simples, podemos percorrer o mesmo (Usando enhanced-for), usando
		 * o método values() que retorna um array com as enumerações definidas.
		 */

		System.out.println("EnumsExample -> testSimpleEnum:");

		for (Status e : Status.values()) {
			System.out.println(e);
		}

		System.out.println("========================================");
	}

	private static void testEnumWithMethodsCrescentFor() {
		System.out.println("EnumsExample -> testEnumWithMethodsCrescentFor:");

		for (StatusWithMethods e : StatusWithMethods.values()) {
			System.out.println(e);

			for (int i = 0; i < 100; i++) {
				e.check(i); // Chamando método definido na enumeração
			}
		}

		System.out.println("========================================");
	}

	private static void testEnumWithMethodsDecrescentFor() {
		System.out.println("EnumsExample -> testEnumWithMethodsDecrescentFor:");

		for (StatusWithMethods e : StatusWithMethods.values()) {
			System.out.println(e);

			for (int i = 100; i >= 0; i--) {
				e.check(i);
			}
		}

		System.out.println("========================================");
	}

	private static void testEnumWithMethodsDecrescentForNegative() {
		System.out.println("EnumsExample -> testEnumWithMethodsDecrescentForNegative:");

		for (StatusWithMethods e : StatusWithMethods.values()) {
			System.out.println(e);

			for (int i = 0; i >= -100; i--) {
				e.check(i);
			}
		}

		System.out.println("========================================");
	}

	public static void main(String[] args) {
		EnumsExample.testSimpleEnum();
		EnumsExample.testEnumWithMethodsCrescentFor();
		EnumsExample.testEnumWithMethodsDecrescentFor();
		EnumsExample.testEnumWithMethodsDecrescentForNegative();
	}

}
