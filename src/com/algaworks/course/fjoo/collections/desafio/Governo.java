package com.algaworks.course.fjoo.collections.desafio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Governo {

	// armazena uma lista de políticos por partido
	private Map<String, List<Politico>> partidosPoliticos;

	public Governo() {
		this.partidosPoliticos = new HashMap<String, List<Politico>>(); // diamondo operator
	}

	public void adicionarPolitico(String partidoPolitico, Politico politico) {
		// recupera a lista de políticos para um partido
		List<Politico> politicos = this.partidosPoliticos.get(partidoPolitico);

		// se não existir uma lista de políticos para o partido informado,
		// devemos instanciar uma nova lista (pois é a primeira inclusão neste partido)
		if (politicos == null) {
			politicos = new ArrayList<Politico>();
		}

		// adiciona o político recebido como parâmetro à lista de políticos
		politicos.add(politico);

		// adiciona a lista de políticos ao mapa de partidos usando
		// como chave o nome do partido
		this.partidosPoliticos.put(partidoPolitico, politicos);
	}

	public BigDecimal calcularGastosComSalario(String partidoPolitico) {
		// implementar busca de políticos para o partido informado
		// e cálculo dos salários

		BigDecimal totalSalario = new BigDecimal("0.00");

		if (this.partidosPoliticos.containsKey(partidoPolitico)) {
			List<Politico> politicos = this.partidosPoliticos.get(partidoPolitico);

			if (politicos != null) {
				for (Politico o : politicos) {
					totalSalario = totalSalario.add(o.getCargo().getSalario());
				}
			}
		}
		return totalSalario;
	}

	public BigDecimal calcularGastosComSalarioParaCargo(Cargo cargo, String partidoPolitico) {
		// implementar busca dos políticos para o partido e cargo informados
		// e cálculo dos salários

		BigDecimal totalSalarioParaCargo = new BigDecimal("0.00");

		if (this.partidosPoliticos.containsKey(partidoPolitico)) {
			List<Politico> politicos = this.partidosPoliticos.get(partidoPolitico);

			if (politicos != null) {
				for (Politico o : politicos) {
					if (o.getCargo().equals(cargo)) {
						totalSalarioParaCargo = totalSalarioParaCargo.add(o.getCargo().getSalario());
					}
				}
			}
		}
		return totalSalarioParaCargo;
	}
}