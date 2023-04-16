package com.algaworks.course.fjoo.interfaces.cardsoperators;

import com.algaworks.course.fjoo.interfaces.payment.Autorizavel;
import com.algaworks.course.fjoo.interfaces.payment.Cartao;
import com.algaworks.course.fjoo.interfaces.payment.Operadora;

public class Redecard implements Operadora {

	@Override
	public boolean autorizar(Autorizavel autorizavel, Cartao cartao) {
		return cartao.getNumeroCartao().startsWith("456") && autorizavel.getValorTotal() < 200;
	}

}