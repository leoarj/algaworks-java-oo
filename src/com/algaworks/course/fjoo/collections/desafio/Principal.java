package com.algaworks.course.fjoo.collections.desafio;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Principal {

	public static void main(String[] args) {
		DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");

		// instancia governo
		Governo governo = new Governo();

		// instancia cargos
		Cargo vereador = new Cargo();
		vereador.setDescricao("Vereador");
		vereador.setSalario(new BigDecimal(16000));

		Cargo deputadoEstadual = new Cargo();
		deputadoEstadual.setDescricao("Deputado estadual");
		deputadoEstadual.setSalario(new BigDecimal(25000));

		Cargo prefeito = new Cargo();
		prefeito.setDescricao("Prefeito");
		prefeito.setSalario(new BigDecimal(27000));

		// adiciona vereadores
		Politico politico = new Politico();
		politico.setNome("João das Couves");
		politico.setCargo(vereador);
		governo.adicionarPolitico("RBLH", politico);

		politico = new Politico();
		politico.setNome("Zé Mané");
		politico.setCargo(vereador);
		governo.adicionarPolitico("PCOR", politico);

		politico = new Politico();
		politico.setNome("Maria Carvalho");
		politico.setCargo(vereador);
		governo.adicionarPolitico("LDRS", politico);

		politico = new Politico();
		politico.setNome("Maria Carvalho");
		politico.setCargo(vereador);
		governo.adicionarPolitico("LDRS", politico);
		
		politico.setNome("Teste1");
		politico.setCargo(vereador);
		governo.adicionarPolitico("PARTIDO1", politico);

		politico = new Politico();
		politico.setNome("TESTE2");
		politico.setCargo(vereador);
		governo.adicionarPolitico("PARTIDO2", politico);

		politico = new Politico();
		politico.setNome("TESTE3");
		politico.setCargo(vereador);
		governo.adicionarPolitico("PARTIDO1", politico);

		// adiciona deputados estaduais
		politico = new Politico();
		politico.setNome("Josefa Silva");
		politico.setCargo(deputadoEstadual);
		governo.adicionarPolitico("LDRS", politico);

		politico = new Politico();
		politico.setNome("Fátima Gonçalves");
		politico.setCargo(deputadoEstadual);
		governo.adicionarPolitico("PCOR", politico);

		politico = new Politico();
		politico.setNome("TESTE DEPUTADO 1");
		politico.setCargo(deputadoEstadual);
		governo.adicionarPolitico("PARTIDO2", politico);
		
		// adiciona prefeito
		politico = new Politico();
		politico.setNome("Sebastião Mendes");
		politico.setCargo(prefeito);
		governo.adicionarPolitico("PCOR", politico);
		
		politico = new Politico();
		politico.setNome("TESTE PREFEITO 1");
		politico.setCargo(prefeito);
		governo.adicionarPolitico("PARTIDO3", politico);
		
		politico = new Politico();
		politico.setNome("TESTE PREFEITO 2");
		politico.setCargo(prefeito);
		governo.adicionarPolitico("PARTIDO1", politico);

		// calcula gastos com partidos
		BigDecimal gastosPcor = governo.calcularGastosComSalario("PCOR");
		System.out.println("Gastos com partido PCOR: " + formatador.format(gastosPcor.doubleValue()));

		BigDecimal gastosLdrs = governo.calcularGastosComSalario("LDRS");
		System.out.println("Gastos com partido LDRS: " + formatador.format(gastosLdrs.doubleValue()));
		
		BigDecimal gastosPartido1 = governo.calcularGastosComSalario("PARTIDO1");
		System.out.println("Gastos com partido PARTIDO1: " + formatador.format(gastosPartido1.doubleValue()));
		
		BigDecimal gastosPartido2 = governo.calcularGastosComSalario("PARTIDO2");
		System.out.println("Gastos com partido PARTIDO2: " + formatador.format(gastosPartido2.doubleValue()));
		
		BigDecimal gastosPartido3 = governo.calcularGastosComSalario("PARTIDO3");
		System.out.println("Gastos com partido PARTIDO3: " + formatador.format(gastosPartido3.doubleValue()));

		// calcula gastos com partidos para determinados cargos
		BigDecimal gastosVereadoresLdrs = governo.calcularGastosComSalarioParaCargo(vereador, "LDRS");
		System.out.println(
				"Gastos com vereadores do partido LDRS: " + formatador.format(gastosVereadoresLdrs.doubleValue()));
		
		BigDecimal gastosVereadoresPartido1 = governo.calcularGastosComSalarioParaCargo(vereador, "PARTIDO1");
		System.out.println(
				"Gastos com vereadores do partido PARTIDO1: " + formatador.format(gastosVereadoresPartido1.doubleValue()));
		
		BigDecimal gastosVereadoresPartido2 = governo.calcularGastosComSalarioParaCargo(vereador, "PARTIDO2");
		System.out.println(
				"Gastos com vereadores do partido PARTIDO2: " + formatador.format(gastosVereadoresPartido2.doubleValue()));
		
		BigDecimal gastosVereadoresPartido3 = governo.calcularGastosComSalarioParaCargo(vereador, "PARTIDO3");
		System.out.println(
				"Gastos com vereadores do partido PARTIDO3: " + formatador.format(gastosVereadoresPartido3.doubleValue()));

		BigDecimal gastosDeputadosEstaduaisLdrs = governo.calcularGastosComSalarioParaCargo(deputadoEstadual, "LDRS");
		System.out.println("Gastos com deputados estaduais do partido LDRS: "
				+ formatador.format(gastosDeputadosEstaduaisLdrs.doubleValue()));
		
		BigDecimal gastosDeputadosEstaduaisPartido2 = governo.calcularGastosComSalarioParaCargo(deputadoEstadual, "PARTIDO2");
		System.out.println("Gastos com deputados estaduais do partido PARTIDO2: "
				+ formatador.format(gastosDeputadosEstaduaisPartido2.doubleValue()));

		BigDecimal gastosPrefeitosLdrs = governo.calcularGastosComSalarioParaCargo(prefeito, "LDRS");
		System.out.println(
				"Gastos com prefeitos do partido LDRS: " + formatador.format(gastosPrefeitosLdrs.doubleValue()));
		
		BigDecimal gastosPrefeitosPartido1 = governo.calcularGastosComSalarioParaCargo(prefeito, "PARTIDO1");
		System.out.println(
				"Gastos com prefeitos do partido PARTIDO1: " + formatador.format(gastosPrefeitosPartido1.doubleValue()));
		
		BigDecimal gastosPrefeitosPartido3 = governo.calcularGastosComSalarioParaCargo(prefeito, "PARTIDO3");
		System.out.println(
				"Gastos com prefeitos do partido PARTIDO3: " + formatador.format(gastosPrefeitosPartido3.doubleValue()));
	}
}
