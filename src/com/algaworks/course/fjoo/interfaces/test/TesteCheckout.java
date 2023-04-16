package com.algaworks.course.fjoo.interfaces.test;

import com.algaworks.course.fjoo.interfaces.Impressora;
import com.algaworks.course.fjoo.interfaces.cardsoperators.Redecard;
import com.algaworks.course.fjoo.interfaces.cashier.Checkout;
import com.algaworks.course.fjoo.interfaces.cashier.Compra;
import com.algaworks.course.fjoo.interfaces.payment.Cartao;
import com.algaworks.course.fjoo.interfaces.payment.Operadora;
import com.algaworks.course.fjoo.interfaces.print.printers.ImpressoraHP;

/*
 * Interfaces podem ser consideradas como "contratos", onde pode se especificar o que se espera ser feito,
 * como serão informadas informações e como serão retornados os resultados.
 * 
 * Pode-se entender interfaces como papéis, e objetos que implementam interfaces como atores,
 * então métodos pode definir receber papéis específicos e consumir o que precisar,
 * sem conhecer diretamente os atores (implementações).
 * 
 * Interfaces além de reduzir o acomplamento, padronizam comportamentos e "escondem" implementações.
 * Sendo assim, tendo um contrato, diferentes implementações com diferentes comportamentos podem
 * implementar um método de uma interface, mas devido ao contrato, o resultado é de um tipo padronizado,
 * assim como a entrada de dados para o método (classes consumidoras não precisam saber como o processamento do resultado é feito).
 * 
 * Uma classe pode implementar mais de uma interface por vez (seguir mais de um contrato).
 * 
 * Programar voltado a interfaces é uma boa prática.
 * 
 * Interfaces podem ser utilizadas por bibliotecas e frameworks para que as aplicações que as utilizam
 * não fiquem diretamente atreladas a elas.
 * 
 * Muitas bibliotecas do Java se utilizam o recurso de interfaces, como o JPA (Java Persistence API) por exemplo.
 */

public class TesteCheckout {

	public static void main(String[] args) {
		// Operadora operadora = new Cielo();
		// Impressora impressora = new ImpressoraEpson();

		Operadora operadora = new Redecard();
		Impressora impressora = new ImpressoraHP();

		Cartao cartao = new Cartao();
		cartao.setNomeTitular("J M COUVES");
		// cartao.setNumeroCartao("123");
		cartao.setNumeroCartao("456");

		Compra compra = new Compra();
		compra.setNomeCliente("João Mendonça Couves");
		compra.setProduto("Sabonete");
		// compra.setValorTotal(2.5);
		compra.setValorTotal(500);

		Checkout checkout = new Checkout(operadora, impressora);
		checkout.fecharCompra(compra, cartao);
	}
}