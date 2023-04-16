package com.algaworks.course.fjoo.inheritance;

/*
 * Java não possui herança múltipla, sendo assim, é possível uma classe estender apenas.
 * Atibutos protected se tornam acessíveis aqui.
 */

public class ContaPagar extends Conta {
	protected Fornecedor fornecedor;

	public ContaPagar() {
		super(); // Chamando construtor default da superclasse (Classe ancestral).
	}

	public ContaPagar(Fornecedor fornecedor, String descricao, Double valor, String dataVencimento) {
		super(descricao, valor, dataVencimento); // Chamando construtor da superclasse (Classe ancestral).
		this.fornecedor = fornecedor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void pagar() {
		switch (situacaoConta) {
			case PENDENTE: {
				situacaoConta = SituacaoConta.PAGA;
				System.out.println("Conta à Pagar \"" + descricao + "\" do Fornecedor \"" + fornecedor.getNome()
						+ "\" paga com sucesso!");
				break;
			}
			case CANCELADA: {
				System.out.println("Conta à Pagar \"" + descricao + "\" do Fornecedor \"" + fornecedor.getNome()
						+ "\" já está cancelada! Não é possível pagar!");
				break;
			}
			case PAGA: {
				System.out.println("Conta à Pagar \"" + descricao + "\" do Fornecedor \"" + fornecedor.getNome()
						+ "\" já está paga! Não é possível pagar novamente!");
				break;
			}
		}
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("Conta à Pagar.");
		super.exibirDetalhesGerais();
		System.out.println("Fornecedor: " + fornecedor.getNome());
	}

}