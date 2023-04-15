package com.algaworks.course.fjoo.polimorfism;

public class TestPolimorfismExample {

	public static void main(String[] args) {
		/*
		 * Não necessita de casting (conversão), pois a ordem hierárquica garante que as
		 * instâncias são de classes que descendem da classe da variável.
		 * Obs.: Tipo "maior" <- receber tipo "menor".
		 */

		// Instância do tipo Servico sendo atribuída à variável do tipo serviço
		Servico servico1 = new Servico("Serviço de limpeza");
		// Instância do tipo ServicoProprio sendo atribuída à variável do tipo serviço
		Servico servico2 = new ServicoProprio("Serviço de manutenção elétrica", 10);
		// Instância do tipo ServicoTerceirizado sendo atribuída à variável do tipo
		// serviço
		Servico servico3 = new ServicoTerceirizado("Serviço de jardinagem", 5.00f);

		TestPolimorfismExample.executeService(servico1, 40);
		TestPolimorfismExample.executeService(servico2, 212);
		TestPolimorfismExample.executeService(servico3, 320);
	}

	/*
	 * Com o Polimorfismo, associado à Herança, torna-se possível passar referências
	 * como da superclasse, e dentro do método consumidor específicar e chamar
	 * comportamentos das subclasses.
	 * 
	 * Para isso se tornar possível, se torna necessário o uso de casting
	 * (conversao).
	 */

	public static void executeService(Servico servico, double valor) {
		servico.executar(valor);

		/*
		 * O operador instanceof permite testar se uma instância é de determinado tipo.
		 * Aqui testa se o objeto recebido (do tipo da superclasse) é também um tipo da
		 * subclasse.
		 * 
		 * Nesses casos, o casting é necessário, já que não se sabe se um Servico é de
		 * um tipo específico, já que ele é a superclasse e outras classes descendem
		 * dele.
		 * 
		 * Por exemplo, um Servico pode ser um ServicoProprio ou não, ou ser um
		 * ServicoTerceirizado ou não. Para se ter certeza, e assumir a conversão sem
		 * riscos, o teste com instanceof é mandatório, caso contrário, podemos ter
		 * erros de casting em runtime.
		 */

		if (servico instanceof ServicoProprio) {
			ServicoProprio sp = (ServicoProprio) servico;
			System.out.println("Pontos acumulados após o serviço: " + sp.getPontosAcumulados());
		}

		if (servico instanceof ServicoTerceirizado) {
			ServicoTerceirizado st = (ServicoTerceirizado) servico;
			System.out.println("Taxa cobrada inclusa no serviço: " + st.getTaxa() + "%");
		}
	}
}