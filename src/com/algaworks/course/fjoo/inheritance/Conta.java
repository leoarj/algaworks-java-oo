package com.algaworks.course.fjoo.inheritance;

/*
 * Em Java, todas as classes estendem de java.lang.Object,
 * ou seja, a classe Conta implicitamente estende de Object.
 * (public class Conta extends Object) -> Não nessária essa declaração.
 */

/*
 * Adicionado pacote: com.algaworks.course.fjoo.inheritance.abstraction.
 * 
 * Classes abstratas servem para satisfazer um design onde algo é muito "genérico" para ser instanciado.
 * 
 * Classes abstratas também forçam que suas subclasses implementem métodos pré-definidos.
 * 
 * Classes abstratas também são úteis para auxiliar que métodos consumidores não tenham que saber
 * detalhes das subclasses, caso chamem apenas os métodos definidos como abstratos na superclasse,
 * esses mesmos métodos que obrigatoriamente estarão implementados nas subclasses.
 * 
 * Classes abstratas não podem ser instanciadas diretamente.
 */

public abstract class Conta {
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

	protected void cancelar() throws OperacaoContaException {
		switch (situacaoConta) {
			case PENDENTE: {
				situacaoConta = SituacaoConta.CANCELADA;
				System.out.println("Conta \"" + descricao + "\" cancelada com sucesso!");
				break;
			}
			case CANCELADA: {
				//System.out.println(
				//		"Conta \"" + descricao + "\" já está cancelada! Não é possível realizar o cancelamento novamente!");
				throw new OperacaoContaException("Conta \"" + descricao + "\" já está cancelada! Não é possível realizar o cancelamento novamente!");
				//break; Não precisa do break pois a excessão interrompe o fluxo de execução
			}
			case PAGA: {
				//System.out.println("Conta \"" + descricao + "\" já está paga! Não é possível realizar o cancelamento!");
				throw new OperacaoContaException("Conta \"" + descricao + "\" já está paga! Não é possível realizar o cancelamento!");
				//break;
			}
		}
	}
	
	/*
	 * Métodos abstratos devem ser implementados pelas subclasses,
	 * porém podem ser referenciados em outras chamadas dentro da própria classe abstrata.
	 * 
	 * Existem várias abordagens, como por exemplo as subclasses escolherem chamar
	 * um comportamento padrão já implementado na superclasse, ao implementar o método abstrato,
	 * ou a classe abstrata ter um comportamento padrão chamado um comportamento mais específico (método abstrato).
	 * 
	 * Métodos abstratos, como o próprio nome diz, não possuem bloco de implementação,
	 * mas apenas a assinatura declarada.
	 */
	public abstract void exibirDetalhes();
	
	// Pode ser usado para exibir detalhes comuns
	protected void exibirDetalhesGerais() {
		System.out.println("Descrição: " + descricao);
		System.out.println("Valor: " + valor);
		System.out.println("Data de Vencimento: " + dataVencimento);
		System.out.println("Situação: " + situacaoConta);
		//exibirDetalhes(); // Uma opção de chamada de método abstrato (estará implementado em subclasses)
	}
}