package com.algaworks.course.fjoo.interfaces.cashier;

import com.algaworks.course.fjoo.interfaces.Impressora;
import com.algaworks.course.fjoo.interfaces.payment.Cartao;
import com.algaworks.course.fjoo.interfaces.payment.Operadora;

public class Checkout {

	private Operadora operadora;
	private Impressora impressora;

	public Checkout(Operadora operadora, Impressora impressora) {
		this.operadora = operadora;
		this.impressora = impressora;
	}

	public void fecharCompra(Compra compra, Cartao cartao) {
		boolean autorizado = this.operadora.autorizar(compra, cartao);

		if (autorizado) {
			this.impressora.imprimir(compra);
		} else {
			System.out.println("O pagamento foi negado!");
		}
	}
}