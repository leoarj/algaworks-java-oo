package com.algaworks.course.fjoo.collections;

import com.algaworks.course.fjoo.collections.interfaces.IterateExecutor;
import com.algaworks.course.fjoo.collections.interfaces.IterateExecutorConsumer;

/*
 * Consome algum resultado processado pelo executor e tem o papel de imprimir esse resultado.
 * 
 * Obs.: Apenas exemplos para fixação, de autoria própria.
 * Nada de lambdas aqui ainda.
 */

public class PrinterIterateExecutorConsumer<E, T> implements IterateExecutorConsumer<E, T, IterateExecutor<T, E>> {

	@Override
	public void consume(IterateExecutor<T, E> iterateExecutor, E e) {
		System.out.println(iterateExecutor.execute(e));
	}
}