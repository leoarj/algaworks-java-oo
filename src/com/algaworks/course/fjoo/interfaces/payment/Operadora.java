package com.algaworks.course.fjoo.interfaces.payment;

public interface Operadora {

	public boolean autorizar(Autorizavel autorizavel, Cartao cartao);
	
}
