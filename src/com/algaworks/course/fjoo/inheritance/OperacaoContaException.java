package com.algaworks.course.fjoo.inheritance;

/*
 * Exceções são situações esperadas ou não de erros em um sistema,
 * como entradas (parâmetros inválidos), erros de cálculos e regras de negócio.
 * 
 * Em Java, exceções são tratadas como objetos.
 * 
 * Todas as classes de exceções descendem de Exception (Checked exceptions).
 * RuntimeException descende de Exception, mas ela e a partir dela (suas subclasses) são
 * Unchecked exceptions.
 * 
 * Sobre os dois tipos:
 * - Unchecked exceptions -> Exceções não checadas, são exceções referentes a erros
 * de execução (runtime exceptions), em que o estado do programa é comprometido,
 * não se tem previsibilidade de quando podem ocorrer, devido a isso,
 * o compilador não obriga necessariamente um bloco tyr-catch para tratar.
 * Caso não haja um bloco try-catch para tratar, o processo em que ela acontece é interrompido.
 * 
 * - Checked exceptions -> Exceções checadas, são exceções referentes a erros de regra de negócio,
 * são erros definidos e já esperados, onde o método chamador deve ter um bloco try-catch para tratamento,
 * esse bloco também é conhecido com "exception handler".
 * O compilador obriga a declarar uma claúsula throws na assinatura do método, indicando que aquela excecão
 * é também um dos possíveis retornos do método, e obriga o método chamador a tratar a excessão,
 * para que o método que chamou possa se recuperar.
 * É possível tratar a exceção ou propagá-la se necessário.
 * 
 * Existem também "errors", que são exceções especiais, usadas pela JVM para controle de recursos.
 * errors também são do tipo unchecked.
 */

public class OperacaoContaException extends Exception {

	public OperacaoContaException(String message) {
		super(message);
	}
}