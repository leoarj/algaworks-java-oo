package com.algaworks.course.fjoo.collections.beans;

import java.util.Objects;

/*
 * Devemos implementar a interface Comparable para que objetos de classes definidas
 * por nós sejam ordenados corretamente em um SortedSet e outras coleções.
 */

public class Aluno implements Comparable<Aluno> {
	
	private String nome;
	private Integer matricula;
	
	public Aluno(String nome, Integer matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula) && Objects.equals(nome, other.nome);
	}

	@Override
	public int compareTo(Aluno arg0) {
		int result = 0;
		if (arg0 != null) {
			result = this.nome.compareTo(arg0.getNome());
			
			if (result == 0) {
				// Próximo passo de comparação:
				result = this.getMatricula() > arg0.getMatricula() ? 1 : -1;
			}			
		}		
		return result;
	}
}