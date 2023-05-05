package com.algaworks.course.fjoo.collections;

import com.algaworks.course.fjoo.collections.interfaces.IterateExecutor;

/*
 * Padrão da iteração, apenas retorna o mesmo objeto informado.
 * 
 * Obs.: Apenas exemplos para fixação, de autoria própria.
 * Nada de lambdas aqui ainda.
 */

public class DefaultIterateExecutor<E> implements IterateExecutor<E, E> {

	@Override
	public E execute(E e) {
		return e;
	}
}