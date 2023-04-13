package com.algaworks.course.fjoo.inheritance;

/*
 * Em Java, todas as classes estender de java.lang.Object,
 * ou seja, a classe Conta implicitamente estende de Object.
 * (public class Conta extends Object) -> Não nessária essa declaração.
 */

public class Conta {
	/*
	 * Atributos protected são acessíveis para classes no mesmo pacote,
	 * e para classes que estendem (subclasses).
	 */
	protected String descricao;
	protected Double valor;
	protected String dataVencimento;
	protected SituacaoConta situacaoConta;

	public Conta() {
		this.situacaoConta = SituacaoConta.PENDENTE;
	}

	public Conta(String descricao, Double valor, String dataVencimento) {
		/*
		 * Chamada de construtor dentro de construtor this() ou this(a1...an). 
		 * Obs.: Para ser efetivo, deve ser a primeira instrução dentro do construtor chamador.
		 */
		this();
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public SituacaoConta getSituacaoConta() {
		return situacaoConta;
	}

	protected void cancelar() {
		switch (situacaoConta) {
			case PENDENTE: {
				situacaoConta = SituacaoConta.CANCELADA;
				System.out.println("Conta \"" + descricao + "\" cancelada com sucesso!");
				break;
			}
			case CANCELADA: {
				System.out.println(
						"Conta \"" + descricao + "\" já está cancelada! Não é possível realizar o cancelamento novamente!");
				break;
			}
			case PAGA: {
				System.out.println("Conta \"" + descricao + "\" já está paga! Não é possível realizar o cancelamento!");
				break;
			}
		}
	}
}
