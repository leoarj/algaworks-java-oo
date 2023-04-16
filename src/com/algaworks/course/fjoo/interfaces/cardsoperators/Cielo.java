package com.algaworks.course.fjoo.interfaces.cardsoperators;

import com.algaworks.course.fjoo.interfaces.payment.Autorizavel;
import com.algaworks.course.fjoo.interfaces.payment.Cartao;
import com.algaworks.course.fjoo.interfaces.payment.Operadora;

public class Cielo implements Operadora {

	@Override
	public boolean autorizar(Autorizavel autorizavel, Cartao cartao) {
		return cartao.getNumeroCartao().startsWith("123") && autorizavel.getValorTotal() < 100;
	}
}