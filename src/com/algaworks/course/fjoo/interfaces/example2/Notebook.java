package com.algaworks.course.fjoo.interfaces.example2;

public class Notebook implements Seguravel {

	private double valorMercado;
	private int quantidadeArmazenamentoGB;

	public Notebook(double valorMercado, int quantidadeArmazenamentoGB) {
		this.valorMercado = valorMercado;
		this.quantidadeArmazenamentoGB = quantidadeArmazenamentoGB;
	}

	@Override
	public double calcularValorApolice() {
		// cálculos fictícios do valor de uma apólice de um notebook
		double valorApolice = this.valorMercado * 0.006;
		if (quantidadeArmazenamentoGB > 256) {
			valorApolice += quantidadeArmazenamentoGB * 0.002;
		}
		return valorApolice;
	}

	@Override
	public String obterDescricao() {
		return "Notebook com capacidade de armazenamento " + this.quantidadeArmazenamentoGB + " GB e valor de mercado "
				+ this.valorMercado;
	}
}