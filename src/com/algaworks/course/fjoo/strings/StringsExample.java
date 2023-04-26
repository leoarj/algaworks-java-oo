package com.algaworks.course.fjoo.strings;

public class StringsExample {

	public void testUpperCase() {
		System.out.println("StringsExample -> testUpperCase:");

		String nome = "Pedro";
		System.out.println(nome.toUpperCase());
		System.out.println(nome);
		
		System.out.println("========================================");
	}

	public void compareStringReferencesBad() {
		System.out.println("StringsExample -> compareStringReferencesBad:");
		
		String s1 = "Pedro";
		String s2 = "Pedro";

		System.out.println("s1 == s2? " + (s1 == s2));

		String s3 = new String("Pedro");

		System.out.println("s3 == s1? " + (s3 == s1));
		
		System.out.println("========================================");
	}

	public void compareStringsRightWay() {
		System.out.println("StringsExample -> compareStringsRightWay:");
		
		String s1 = "Pedro";
		String s2 = "Pedro";

		System.out.println("s1 == s2?" + s1.equals(s2));

		String s3 = "Pedro";

		System.out.println("s3 == s1?" + s3.equals(s1));
		
		System.out.println("========================================");
	}

	public void testCharAt() {
		System.out.println("StringsExample -> testCharAt:");
		
		String s = "ALGAWORKS";

		System.out.println(s.charAt(0));
		System.out.println(s.charAt(2));
		System.out.println(s.charAt(8));
		//System.out.println(s.charAt(9)); index > length -> java.lang.StringIndexOutOfBoundsException
		
		System.out.println("========================================");
	}

	public void createStringWithCharArray() {
		System.out.println("StringsExample -> createStringWithCharArray:");
		
		char[] array = { 'A', 'L', 'G', 'A', 'W', 'O', 'R', 'K', 'S' };

		String s = new String(array);

		// Substring começa do índice 0 (zero):
		System.out.println(s.substring(1));
		System.out.println(s.substring(0, 6)); // Não adiciona o último caractere (0-5), o mesmo que (0-(6-1))
		
		System.out.println("========================================");
	}

	public void testSplit() {
		System.out.println("StringsExample -> testSplit:");
		
		// Método split():
		String s = "Cursos_online_de_desenvolvimento_de_software";

		String[] array = s.split("_");

		for (String a : array) {
			System.out.println(a);
		}
		
		System.out.println("========================================");
	}

	public void testIndexOf() {
		System.out.println("StringsExample -> testIndexOf:");
		
		String s = "Java";

		System.out.println(s.indexOf('a'));
		System.out.println(s.lastIndexOf('a'));
		
		System.out.println("========================================");
	}

	public void testReplaceAll() {
		System.out.println("StringsExample -> testReplaceAll:");
		
		String s = "Desenvolvimento Java";

		System.out.println(s.replaceAll("Java", "de Software"));
		
		System.out.println("========================================");
	}

	/*
	 * String (imutável): Strings são imutáveis, uma vez criadas, seu valor não pode ser modificado.
	 * Ao atribuir ou incrementar uma string a uma variável, a variável estará apontando para uma nova
	 * referência de um novo objeto String.
	 * 
	 * Sua instanciação não obriga diretamento o uso da palavra reservada new,
	 * mas pode ser inicializada como se "fosse" um tipo primitivo, com o valor entre aspas duplas,
	 * pois o Java infere automaticamente a instância e sua referência.
	 * 
	 * StringBuffer e StringBuilder deve ser inicializadas com a palavra reservada new.
	 */
	
	/*
	 * StringBuffer (mutável, thread-safe): Instâncias dessa classe são modificáveis
	 * e podem ser compartilhadas entre threads.
	 * 
	 * No caso da aplicação precisar alterar uma String diversas vezes, compartilhando 
	 * entre threads, ela é a melhor escolha.
	 */
	public void testStringBuffer() {
		System.out.println("StringsExample -> testStringBuffer:");
		
		StringBuffer sb = new StringBuffer();

		sb.append("Bem-vindo");
		sb.append("Teste com StringBuffer");

		System.out.println(sb);
		
		System.out.println("========================================");
	}

	public void testStringBufferWithInsert() {
		System.out.println("StringsExample -> testStringBufferWithInsert:");
		
		StringBuffer sb = new StringBuffer();

		sb.append("Bem vindo ao curso de Java.");
		sb.append("Fique a vontade para tirar suas dúvidas.");
		sb.append("Estamos aqui para te ajudar a aprender.");

		// Com método insert podemos escolher onde "inserir o texto":
		sb.insert(26, "da AlgaWorks");

		System.out.println(sb);
		
		System.out.println("========================================");
	}

	/*
	 * StringBuilder (mutável, não thread-safe): Possui os mesmos métodos que
	 * StringBuffer, mas não é thread-safe, o que significa que não pode ser
	 * compartilhada entre threads com segurança.
	 * 
	 * É mais rápida, e se não houver a necessidade de compartilhamento entre
	 * threads, dê preferência a StringBuilder.
	 */
}
