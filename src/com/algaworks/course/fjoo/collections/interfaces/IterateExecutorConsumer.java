package com.algaworks.course.fjoo.collections.interfaces;

/*
 * Consome algum resultado processado pelo executor.
 * 
 * Obs.: Apenas exemplos para fixação, de autoria própria.
 * Nada de lambdas aqui ainda.
 */

public interface IterateExecutorConsumer<E, T, V extends IterateExecutor<T, E>> {

	public void consume(V iterateExecutor, E e);
}