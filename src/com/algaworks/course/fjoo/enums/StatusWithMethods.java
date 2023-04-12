package com.algaworks.course.fjoo.enums;

public enum StatusWithMethods {

	ATIVO("Status Ativo") {
		@Override
		public void check(int id) {
			if ((id > 0) && (id < 100)) {
				System.out.println("O cadastro \"" + id + "\" tem " + this.getDescription());
			}
		}
	},
	EM_ANALISE("Status Em Análise") {
		@Override
		public void check(int id) {
			if (id < 0) {
				System.out.println("O cadastro \"" + id + "\" tem " + this.getDescription());
			}
		}
	},
	CANCELADO("Status Cancelado") {
		@Override
		public void check(int id) {
			if (id == 0) {
				System.out.println("O cadastro \"" + id + "\" tem " + this.getDescription());
			}
		}
	},
	BLOQUEADO("Status Bloqueado") {
		@Override
		public void check(int id) {
			if (id >= 100) {
				System.out.println("O cadastro \"" + id + "\" tem " + this.getDescription());
			}
		}
	};

	/*
	 * Podem possuir algum valor padrão definido. Apesar de permitirem isso, o ideal
	 * é usar a própria enumaração em tipagens, comparações e gravações para não se
	 * perder o recurso de typesafe, já que se pode repetir um valor para uma
	 * enumeração e isso não é verificado em build-time.
	 */

	private String description; // Poderia ser também "value" por exemplo.

	/*
	 * Enuns podem possuir métodos por cada enumeração definida.
	 * Devem ser declarados como abstratos e implementados em cada enumeração.
	 * Apesar de possível, deve se analisar muito bem quando utilizar esse recurso,
	 * tentar limitar o uso a métodos baseados em expressões fundamentadas e que não mudam
	 * com frequência (funções matemáticas por exemplo) ou então partir para o uso
	 * de Herança e/ou interfaces com implementações concretas.
	 */

	public abstract void check(int id);

	// Enums podem ter construtores (que deve ser privado).
	private StatusWithMethods(String description) {
		this.description = description;
	}

	// Método comum a todas as enumerações (sem mudança de comportamento).
	public String getDescription() {
		return description;
	}

}
