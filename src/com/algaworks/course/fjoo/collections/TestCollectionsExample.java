package com.algaworks.course.fjoo.collections;

public class TestCollectionsExample {

	public static void main(String[] args) {
		CollectionsExample colecoes = new CollectionsExample();
		colecoes.populateArrayList();
		colecoes.populateLinkedList();
		try {
			colecoes.populateGenericCollection();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}
		colecoes.testSortedSetObjects();
		colecoes.testSortedMap();
		colecoes.testUnmodifiableList();
	}
}