package com.algaworks.course.fjoo.polimorfism;

public class ServicoTerceirizado extends Servico {

	private double taxa;

	public ServicoTerceirizado(String nome, double taxa) {
		super(nome);
		this.taxa = taxa;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	@Override
	public void executar(double valor) {
		super.executar(valor);
		System.out.println("Serviço terceirizado com faturamento parcial.");
		System.out.println("Valor parcial a receber: R$" + (valor - (valor * taxa / 100)));
	}
}