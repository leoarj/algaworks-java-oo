package com.algaworks.course.fjoo.enums;

/*
 * Enums são tipos enumerados,
 * sendo assim, é um tipo para poder definir um grupo delimitado de valores.
 * É útil para o mapeamento de valores de domínio por exemplo.
 * São type-safe, ou seja, não se pode usar um valor fora dos definidos no enum
 * em alguma variável do tipo do enum.
 */

public enum Status {

	ATIVO, EM_ANALISE, CANCELADO, BLOQUEADO;
}