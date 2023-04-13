package com.algaworks.course.fjoo.inheritance;

/*
 * Java não possui herança múltipla, sendo assim, é possível uma classe estender apenas.
 * Atibutos protected se tornam acessíveis aqui.
 */

public class ContaReceber extends Conta {
	private Cliente cliente;

	public ContaReceber() {
		super(); // Chamando construtor default da superclasse (Classe ancestral).
	}

	public ContaReceber(Cliente cliente, String descricao, Double valor, String dataVencimento) {
		super(descricao, valor, dataVencimento); // Chamando construtor da superclasse (Classe ancestral).
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Sobreescrita (sobrecarga) de métodos da superclasse.

	@Override
	protected void cancelar() {
		if (valor <= 50000) {
			super.cancelar(); // Chamada de comportamento da superclasse.
		} else {
			System.out.println("Não é permitido cancelar Conta à Receber com valor maior que R$50.000,00");
		}
	}

	public void receber() {
		switch (situacaoConta) {
			case PENDENTE: {
				situacaoConta = SituacaoConta.PAGA;
				System.out.println("Conta à Receber \"" + descricao + "\" do Fornecedor \"" + cliente.getNome()
						+ "\" paga com sucesso!");
				break;
			}
			case CANCELADA: {
				System.out.println("Conta à Receber \"" + descricao + "\" do Fornecedor \"" + cliente.getNome()
						+ "\" já está cancelada! Não é possível receber!");
				break;
			}
			case PAGA: {
				System.out.println("Cont à Receber \"" + descricao + "\" do Fornecedor \"" + cliente.getNome()
						+ "\" já está paga! Não é possível receber novamente!");
				break;
			}
		}
	}
}