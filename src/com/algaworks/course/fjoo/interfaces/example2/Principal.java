package com.algaworks.course.fjoo.interfaces.example2;

public class Principal {

	public static void main(String[] args) {
		CorretoraSeguros corretora = new CorretoraSeguros();

		Carro meuCarro = new Carro(45000d, 2012);
		Imovel minhaCasa = new Imovel(920000, 320);

		Barco meuBarco = new Barco(1500000, 45);
		Notebook meuNotebook = new Notebook(5440, 512);

		corretora.fazerPropostaSeguro(meuCarro);
		corretora.fazerPropostaSeguro(minhaCasa);

		corretora.fazerPropostaSeguro(meuBarco);
		corretora.fazerPropostaSeguro(meuNotebook);
	}
}