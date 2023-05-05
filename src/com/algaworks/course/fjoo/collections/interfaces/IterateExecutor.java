package com.algaworks.course.fjoo.collections.interfaces;

/*
 * Interface de teste, para personalizar a iteração de objetos.
 * Mais detalhes de programação funcional, interfaces funcionais e streams
 * serão vistos no curso Especialista Java - EJ.
 * 
 * Obs.: Apenas exemplos para fixação, de autoria própria.
 * Nada de lambdas aqui ainda.
 */

public interface IterateExecutor<T,E> {
	public T execute(E e);
}