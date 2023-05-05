package com.algaworks.course.fjoo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.algaworks.course.fjoo.collections.beans.Aluno;
import com.algaworks.course.fjoo.collections.interfaces.IterateExecutor;
import com.algaworks.course.fjoo.collections.interfaces.IterateExecutorConsumer;

/*
 * Collections Framework
 * 
 * Hierarquia das interfaces:
 * 
 * - Collection -> List
 *              -> Set -> SortedSet
 * 
 * - Map        -> SortedMap
 * 
 * - Collection = Raíz das coleções.
 * 
 * - Set = Não aceita elementos duplicados. Conjunto de Itens.
 * 
 * - List = Aceita elementos duplicados, ordenados por sequência, geralmente de inserção.
 * 
 * - Map = Coleção para itens com identificação exclusiva.
 * O valor pode-se repetir mas a chave não.
 * 
 * - SortedSrt = Conjunto de elementos únicos, mas com ordenação natural crescente.
 * Exemplo: Armazenar os estados brasileiros em ordem alfabética.
 * 
 * - SortedMap = Mapa com chaves ordenadas.
 * Exemplo: Manter dicionários.
 * 
 * Obs.: Collection não possui uma implementação específica, sendo um supertipo mais genérico,
 * parar poder aumentar o nível de abstração por exemplo.
 */

/*
 * Principais implementações (em resumo):
 * 
 * - List -> ArrayList
 * - Set  -> HashSet
 * - Map  -> HashMap
 */

/*
 * Listas - Interface List
 * 
 * - List (Interface) -> ArrayList (Implementação, não thread-safe)
 *                    -> LinkedList (Implementação, não thread-safe)
 *                    -> Vector (Implementação, thread-sefe)
 *                    -> etc.
 * 
 * - ArrayList = É a implementação que proporciona iteração e acesso aleatório com rapidez.
 * 
 * Cada elemento recebe um índice, iniciando por 0 (zero), como em um array.
 * É ordenada por esse índice.
 * ArrayList pode crescer ou diminuir dinamicamente.
 * 
 * size() = Retorna o tamanho da coleção (quantidade de elementos).
 * 
 * Iterator = Interface para percorrer coleções,no caso de ArrayList é na ordem que os elementos
 * foram incluídos.
 * 
 * ListIterator = Interface de iteração, específica para listas.
 * Mais avançado, também permite percorrer na ordem inversa,
 * passando size() como parâmetro para que o cursor seja posicionado na última posição,
 */

/*
 * Conjuntos -> Interface Set
 * 
 * - Set (Interface) -> HashSet (Implementação, não thread-safe)
 *                   -> LinkedHashSet (Implementação, não thread-safe)
 *                   -> TreeSet (Implementação, não thread-safe)
 *                   
 * Obs.: Para obter instâncias thread-safe para implementações de Set,
 * a classe Collections fornece métodos como Collections.synchronizedSet(new HashSet(...)) entre outros.
 *                   
 * Principal característica = Não aceitar elementos duplicados.
 * 
 * Elementos não são acessados através de índices.
 * 
 * java.util.HashSet -> Não há garantia da ordem que vai ler (percorrer) os elementos.
 * 
 * Set também suporta henhancedfor e Iterator.
 */

/*
 * Implementação dos métodos equals() e hashCode() de java.lang.Object é importante
 * para que coleções funcionem de acordo com o esperado e com mais desempenho.
 * 
 * equals()   -> Coleção usa para comparar objetos.
 * hashCode() -> Coleção usa para agrupar elementos em subconjuntos menores (buckets),
 * a fim de facilitar a pesquisa posteriormente.
 */

/*
 * Mapas - Interface Map
 * 
 * - Map (Interface) -> HashMap (Implementação, não thread-safe)
 *                   -> ConcurrentHashMap (Implementação, thread-safe)
 *                   -> TreeSet (Implementação, não thread-safe)
 *                   -> etc.
 *                   
 * Principal característica: Coleção para pares (chave, valor),
 * onde a chave não pode ser duplicada, mas o valor sim.
 * 
 * Pode-se assumir então que para a chave se utiliza identificador único,
 * mas um valor pode ser mapeado por mais de uma chave.
 * 
 * V put(K key, V Value) -> Colocar elemento na coleção.
 * V -> O tipo do elemento na coleção.
 * O Retorno do método representa o objeto anterior para aquela chave.
 * 
 * V get(Object Key) -> Recuperar elemento da coleção.
 * V -> O tipo do elemento da coleção.
 * 
 * keySet() -> Retorna conjunto com as chaves.
 * values() -> Retorna uma collection com os valores.
 */

/*
 * Conjunto ordenado - Interface SortedSet
 * 
 * É um Set ordenado, um conjunto de elementos que não se repetem,
 * organizados por ordem natural.
 * 
 * java.util.TreeSet -> Uma das implementações.
 * 
 * SortedSet adiciona alguns métodos como first() e last().
 * 
 * Interaces Comparable e Comparator são utilizadas, para prover o modo
 * como os elementos serão comparados e ordenados (em caso de classes próprias).
 */

/*
 * Mapa ordenado -> Interface SortedMap
 * 
 * É um mapa com as chaves ordenadas.
 * 
 * java.util.TreeMap -> Uma das implementações.
 * K firstKey() -> Retorna primeira chave.
 * K lastKey() -> Retorna última chave.
 * 
 * sortedMap<K, V> headMap(K toKey) -> Retorna um novo mapa com elementos
 * da primeira até a chave informada, mas sem incluí-la.
 * 
 * sortedMap<K, V> tailMap(K fromKey) -> Retorna um novo mapa com elementos
 * a partir da chave informada (a incluindo) até o final do mapa.
 */

/*
 * java.util.Collections
 * 
 * Provê métodos utilitários estáticos para coleções.
 * 
 * Por exemplo:
 * 
 * - Ordenação crescente:
 * Collections.sort(colecao)
 * 
 * - Ordenação decrescente:
 * Usar com Comparator<T>, obtendo uma instância a partir de Collections.reverseOrder().
 * 
 * Collections.sort(colecao, comparador).
 * 
 * reverse() -> Apenas inverte a ordem (posicionamento) dos elementos,
 * se, levar em consideração ordenação.
 * 
 * - Bloqueando modificações:
 * Collections.unmodifiableList() -> Cria uma cópia que não pode ser alterada.
 * 
 * - Obter instâncias thread-safe para List, Set, Map:
 * Como citado acima, pode se usar Collections.synchronizedSet(new HashSet(...)),
 * Collections.synchronizedMap(new HashMap), entre outros.
 * 
 */

public class CollectionsExample {

	/*
	 * List (Objetos repetidos) é o básico, ficando a conferir suas 3 principais
	 * implementações: ArrayList, LinkedList, Vector.
	 */

	private List<String> lista;
	private List<String> listaLinkedList;

	// Conjuntos (Objetos não repetem) a interface é Set
	private Set<String> conjunto;
	private Set<String> conjunto2;

	// Collection é a super interface para List e Set (Pois possuem conceitos semelhantes)
	private Collection<String> colecaoCollection;

	private static <E> void clearCollection(Collection<E> collection) {
		if (collection != null) {
			collection.clear();
			System.out.println("Uma coleção: " + collection.getClass().getName() + " foi limpada.");
		}
	}

	private static <T, E> void iterateCollection(Collection<E> collection, IterateExecutor<T, E> iterateExecutor) {
		IterateExecutorConsumer<E, T, IterateExecutor<T,E>> iterateExecutorConsumer = new PrinterIterateExecutorConsumer<>();
		
		for (E e : collection) {
			iterateExecutorConsumer.consume(iterateExecutor, e);
		}
	}
	
	private static <E> void iterateCollection(Collection<E> collection) {
		CollectionsExample.<E,E>iterateCollection(collection, new DefaultIterateExecutor<>());
	}

	public void populateArrayList() {
		System.out.println("CollectionsExample -> populateArrayList:");

		lista = new ArrayList<>(2); // Pode-se passar uma capacidade inicial como parâmetro

		lista.add("ArrayList: Str");
		lista.add("ArrayList: Str2");

		CollectionsExample.<String>iterateCollection(lista);
		CollectionsExample.<String>clearCollection(lista);

		System.out.println("========================================");
	}

	public void populateLinkedList() {
		System.out.println("CollectionsExample -> populateLinkedList:");

		listaLinkedList = new LinkedList<>();

		listaLinkedList.add("LinkedList: Str");
		listaLinkedList.add("LinkedList: Str2");

		CollectionsExample.<String>iterateCollection(listaLinkedList);
		CollectionsExample.<String>clearCollection(listaLinkedList);

		System.out.println("========================================");
	}

	public void populateSet() {
		System.out.println("CollectionsExample -> populateSet:");

		conjunto = new HashSet<>();
		conjunto.add("HashSet: Str");
		conjunto.add("HashSet: Str2");

		CollectionsExample.<String>iterateCollection(conjunto);
		CollectionsExample.<String>clearCollection(conjunto);

		System.out.println("========================================");
	}

	public void populateSetTreeSet() {
		System.out.println("CollectionsExample -> populateSetTreeSet:");

		conjunto2 = new TreeSet<>();
		conjunto2.add("TreeSet: Str");
		conjunto2.add("TreeSet: Str2");

		CollectionsExample.<String>iterateCollection(conjunto2);
		CollectionsExample.<String>clearCollection(conjunto2);

		System.out.println("========================================");
	}

	public void populateGenericCollection() throws Exception {
		System.out.println("CollectionsExample -> populateGenericCollection:");

		colecaoCollection = new HashSet<>();

		colecaoCollection.add("Valor 01");

		if (!colecaoCollection.add("Valor 01")) {
			throw new Exception("Valor já existe");
		}

		System.out.println("========================================");
	}

	public void iterateWithIterator() {
		System.out.println("CollectionsExample -> iterateWithIterator:");

		List<String> listaLocal = new ArrayList<>();

		listaLocal.add("Valor 01");
		listaLocal.add("Valor 02");

		Iterator<String> it = listaLocal.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// Outro meio, de percorrer
		for (Iterator<String> i = listaLocal.iterator(); i.hasNext();) {
			System.out.println(i.next());
		}

		// Iteração reversa
		ListIterator<String> lit = listaLocal.listIterator(listaLocal.size());

		while (lit.hasPrevious()) {
			System.out.println(lit.previous());
		}

		System.out.println("========================================");
	}

	public void testMap() {
		System.out.println("CollectionsExample -> testMap:");

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "Dois");
		map.put(3, "Três");

		System.out.println(map.getOrDefault(1, "Não encontrado!"));

		System.out.println("========================================");
	}

	public void iterateMap() {
		System.out.println("CollectionsExample -> iterateMap:");

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "Dois");
		map.put(3, "Três");

		// Por meio das chaves:
		Set<Integer> chaves = map.keySet();

		CollectionsExample.<Integer>iterateCollection(chaves);

		// Por meio dos valores:
		Collection<String> valores = map.values();

		CollectionsExample.<String>iterateCollection(valores);

		System.out.println("========================================");
	}

	/*
	 * Na verdade a implementação TreeSet que faz a ordenação, mas a interface
	 * SortedSet possui métodos a mais, como first() e last().
	 */

	public void testSortedSet() {
		System.out.println("CollectionsExample -> testSortedSet:");

		SortedSet<String> sortedSet = new TreeSet<>();

		sortedSet.add("Ricardo");
		sortedSet.add("João");
		sortedSet.add("Ana");
		sortedSet.add("Fabrício");

		CollectionsExample.<String>iterateCollection(sortedSet);

		System.out.println("========================================");
	}

	public void testSortedSetObjects() {
		System.out.println("CollectionsExample -> testSortedSet:");

		SortedSet<Aluno> sortedSetObjetos = new TreeSet<>();

		sortedSetObjetos.add(new Aluno("João Costa", 1111));
		sortedSetObjetos.add(new Aluno("Maria Rita", 1112));
		sortedSetObjetos.add(new Aluno("José de Castro", 1113));
		sortedSetObjetos.add(new Aluno("Ricardo Caetano", 1114));
		sortedSetObjetos.add(new Aluno("Maria Rita", 1115));

		for (Aluno aluno : sortedSetObjetos) {
			System.out.println("Nome: " + aluno.getNome() + ". Matrícula: " + aluno.getMatricula());
		}

		System.out.println("========================================");
	}

	/*
	 * Maps ordenados: SortedMap é a interface com chaves ordenadas. TreeMap é uma
	 * implementação.
	 */

	public void testSortedMap() {
		System.out.println("CollectionsExample -> testSortedMap:");

		SortedMap<Integer, Aluno> sortedMapObjetos = new TreeMap<>();

		sortedMapObjetos.put(1111, new Aluno("João", 1111));
		sortedMapObjetos.put(1112, new Aluno("Maria", 1112));
		sortedMapObjetos.put(1113, new Aluno("Ricardo", 1113));
		sortedMapObjetos.put(1114, new Aluno("José", 1114));
		sortedMapObjetos.put(1115, new Aluno("Sarah", 1115));
		sortedMapObjetos.put(1116, new Aluno("Thiago", 1116));
		sortedMapObjetos.put(1117, new Aluno("Mateus", 1117));
		sortedMapObjetos.put(1118, new Aluno("Eduardo", 1118));

		System.out.println("Primeiros três alunos:");
		SortedMap<Integer, Aluno> tresPrimeirosAlunos = sortedMapObjetos.headMap(1114);

		CollectionsExample.<String, Aluno>iterateCollection(tresPrimeirosAlunos.values(),
				new IterateExecutor<String, Aluno>() {

					@Override
					public String execute(Aluno e) {
						return "Matrícula: " + e.getMatricula() + ". Nome: " + e.getNome();
					}
				}
		);

		System.out.println("\nÚltimos três alunos:");
		SortedMap<Integer, Aluno> tresUltimosAlunos = sortedMapObjetos.tailMap(1116);

		for (Aluno aluno : tresUltimosAlunos.values()) {
			System.out.println("Matrícula: " + aluno.getMatricula() + ". Nome: " + aluno.getNome());
		}

		System.out.println("========================================");
	}

	/*
	 * A classe java.util.Collections possui diversos métodos estáticos para se
	 * trabalhar com coleções.
	 */

	public void testSort() {
		System.out.println("CollectionsExample -> testSort:");

		List<String> nomes = new ArrayList<>();

		nomes.add("Pedro");
		nomes.add("José");
		nomes.add("Maria");
		nomes.add("Ana");

		System.out.println("Antes de ordenar:");
		// ArrayList mantém a ordem de inserção dos elementos
		CollectionsExample.<String>iterateCollection(nomes);

		Collections.sort(nomes);

		System.out.println("\nDepois de ordenar:");
		// agora a lista foi ordenada
		CollectionsExample.<String>iterateCollection(nomes);

		System.out.println("========================================");
	}

	public void testReverseOrder() {
		System.out.println("CollectionsExample -> testReverseOrder:");

		List<String> nomes = new ArrayList<>();

		nomes.add("Pedro");
		nomes.add("José");
		nomes.add("Maria");
		nomes.add("Ana");

		System.out.println("Antes de ordenar:");
		// ArrayList mantém a ordem de inserção dos elementos
		CollectionsExample.<String>iterateCollection(nomes);

		Comparator<String> reverseComparator = Collections.reverseOrder();

		Collections.sort(nomes, reverseComparator);

		System.out.println("\nnDepois de ordenar descrescente:");
		// agora a lista foi ordenada
		CollectionsExample.<String>iterateCollection(nomes);

		System.out.println("========================================");
	}

	public void testReverse() {
		System.out.println("CollectionsExample -> testReverse:");

		// Método reverse() muda os elementos na lista (não faz ordenação, apenas "vira
		// ao contrário").

		List<String> nomes = new ArrayList<>();

		nomes.add("Pedro");
		nomes.add("José");
		nomes.add("Maria");
		nomes.add("Ana");

		Collections.reverse(nomes);

		CollectionsExample.<String>iterateCollection(nomes);

		System.out.println("========================================");
	}

	public void testUnmodifiableList() {
		System.out.println("CollectionsExample -> testUnmodifiableList:");

		List<String> nomes = new ArrayList<>();

		nomes.add("Pedro");
		nomes.add("José");
		nomes.add("Maria");

		List<String> nomesNaoModificaveis = Collections.unmodifiableList(nomes);

		// Não permitirá adicionar ou remover elementos da lista
		try {
			nomesNaoModificaveis.add("Ricardo");
		} catch (UnsupportedOperationException e) {
			System.err.println("Lista não modificável, você não pode alterá-la!");
		}

		System.out.println("========================================");
	}
}
