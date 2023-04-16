package com.algaworks.course.fjoo.interfaces.example2;

public class Barco implements Seguravel {

	private double valorMercado;
	private int capacidadePessoas;

	public Barco(double valorMercado, int anoFabricacao) {
		this.valorMercado = valorMercado;
		this.capacidadePessoas = anoFabricacao;
	}

	@Override
	public double calcularValorApolice() {
		// cálculos fictícios do valor de uma apólice de um barco
		double valorApolice = this.valorMercado * 0.10;
		if (capacidadePessoas > 10) {
			// valorApolice = valorApolice * 0.90;
			valorApolice *= 0.98;
		}

		return valorApolice;
	}

	@Override
	public String obterDescricao() {
		return "Barco ano " + this.capacidadePessoas + " com valor de mercado " + this.valorMercado;
	}
}