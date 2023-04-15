package com.algaworks.course.fjoo.polimorfism;

/*
 * Classe que herda de serviço a fim de aplicar o conceito de Polimorfismo.
 * O comportamento padrão herdado pode ser complementado ou substituído pela subclasse.
 */

public class ServicoProprio extends Servico {

	private int pontosAcumulados;

	/*
	 * Modificar o construtor também pode fazer parte da especialização.
	 * 
	 * Todavia deve se atentar ao fato que o ideal é primeiramente chamar o
	 * construtor da superclasse, a fim de manter o comportamento padrão na criação
	 * do objeto, e partir disso complementar com propriedades adicionais.
	 * 
	 * Isso traz segurança, evita duplicação de código e reduz a introdução de
	 * erros.
	 * Caso o construtor esteja modificado ao ponto de não chamar
	 * primariamente o construtor da superclasse, deve-se repensar se não é o caso
	 * de refatorar a classe para uma nova sem extensão (Isso também vale para os
	 * métodos herdados e sobreescritos).
	 * 
	 * Não seguir essa regra pode levar a um mau design ou perca do propósito de
	 * Polimorfismo e Herança.
	 */
	public ServicoProprio(String nome, int pontosAcumulados) {
		super(nome);
		this.pontosAcumulados = pontosAcumulados;
	}

	public int getPontosAcumulados() {
		return pontosAcumulados;
	}

	public void setPontosAcumulados(int pontosAcumulados) {
		this.pontosAcumulados = pontosAcumulados;
	}

	// Comportamento modificado ou substituído
	@Override
	public void executar(double valor) {
		super.executar(valor);
		System.out.println("Serviço próprio com faturamento total.");
		pontosAcumulados++;
	}
}