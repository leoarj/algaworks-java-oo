/*
 * Polimorfismo é um dos quatro pilares da Orientação a Objetos.
 * Ela diz respeito a uma classe poder assumir vários comportamentos,
 * porém vale lembrar que isso se refere no contexto associado ao pilar da Herança.
 * Palavras chave por exemplo: extensão ou especialização.
 * Se diz assim então, que subclasses extendem ou especializam uma superclasse
 * e podem modificar/estender o seu comportamento.
 */

package com.algaworks.course.fjoo.polimorfism;

public class Servico {

	private String nome;

	public Servico(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Comportamento padrão
	public void executar(double valor) {
		System.out.println("O serviço: " + nome + " foi executado por R$" + valor);
	}
}