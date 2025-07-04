package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import tad.ElementoNaoEncontradoException;
import tad.listasEncadeadas.ListaDuplamenteEncadeadaIF;
import tad.listasEncadeadas.ListaDuplamenteEncadeadaImpl;
import tad.listasEncadeadas.ListaVaziaException;
import tad.listasEncadeadas.NodoListaDuplamenteEncadeada;


public class TestaListaDuplamenteEncadeada {
	
	private ListaDuplamenteEncadeadaIF<Integer> listaDuplaEnc = null;
	
	@BeforeEach
	public void inicializar() {
		listaDuplaEnc = new ListaDuplamenteEncadeadaImpl<Integer>();
	}
	
	@Test
	public void imprimeEmOrdemTest() {
		assertEquals("", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(2);
		assertEquals("2", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[]{2}, listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(10);
		assertEquals("2, 10", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(5);
		assertEquals("2, 10, 5", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(9);
		assertEquals("2, 10, 5, 9", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(1);
		assertEquals("2, 10, 5, 9, 1", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(3);
		assertEquals("2, 10, 5, 9, 1, 3", listaDuplaEnc.imprimeEmOrdem());
		listaDuplaEnc.insert(4);
		assertEquals("2, 10, 5, 9, 1, 3, 4", listaDuplaEnc.imprimeEmOrdem());
	}
	
	@Test
	public void toArrayTest() {
		assertArrayEquals(new Integer[0], listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(2);
		assertEquals("2", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {2}, listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(10);
		assertArrayEquals(new Integer[] {2,10}, listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(5);
		assertArrayEquals(new Integer[] {2,10, 5}, listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(9);
		assertArrayEquals(new Integer[] {2,10, 5,9}, listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(1);
		assertArrayEquals(new Integer[] {2,10, 5, 9, 1}, listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(3);
		assertArrayEquals(new Integer[] {2,10, 5, 9, 1, 3}, listaDuplaEnc.toArray(Integer.class));
		listaDuplaEnc.insert(4);
		assertArrayEquals(new Integer[] {2,10, 5, 9, 1, 3, 4}, listaDuplaEnc.toArray(Integer.class));
	}
	
	@Test
	public void imprimeInversoTest() {
		assertEquals("", listaDuplaEnc.imprimeInverso());
		listaDuplaEnc.insert(2);
		assertEquals("2", listaDuplaEnc.imprimeInverso());
		listaDuplaEnc.insert(10);
		assertEquals("10, 2", listaDuplaEnc.imprimeInverso());
		listaDuplaEnc.insert(5);
		assertEquals("5, 10, 2", listaDuplaEnc.imprimeInverso());
		listaDuplaEnc.insert(9);
		assertEquals("9, 5, 10, 2", listaDuplaEnc.imprimeInverso());
		listaDuplaEnc.insert(1);
		assertEquals("1, 9, 5, 10, 2", listaDuplaEnc.imprimeInverso());
		listaDuplaEnc.insert(3);
		assertEquals("3, 1, 9, 5, 10, 2", listaDuplaEnc.imprimeInverso());
		listaDuplaEnc.insert(4);
		assertEquals("4, 3, 1, 9, 5, 10, 2", listaDuplaEnc.imprimeInverso());
	}
	
	@Test
	public void insertsearchTeste() {
		assertEquals(null, listaDuplaEnc.search(20));
		listaDuplaEnc.insert(20);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(20), listaDuplaEnc.search(20));
		listaDuplaEnc.insert(15);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(15), listaDuplaEnc.search(15));
		listaDuplaEnc.insert(3);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(3), listaDuplaEnc.search(3));
		listaDuplaEnc.insert(90);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(90), listaDuplaEnc.search(90));
		listaDuplaEnc.insert(100);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(100), listaDuplaEnc.search(100));
		listaDuplaEnc.insert(73);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(73), listaDuplaEnc.search(73));
		listaDuplaEnc.insert(29);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(29), listaDuplaEnc.search(29));
		assertEquals(null, listaDuplaEnc.search(230));
	}
	
	@Test
	public void insertRemoverTeste() throws ElementoNaoEncontradoException, ListaVaziaException {
		assertThrows(ListaVaziaException.class, () -> {
			listaDuplaEnc.remove(38);
		});
		
		listaDuplaEnc.insert(206);
		listaDuplaEnc.insert(152);
		listaDuplaEnc.insert(38);
		listaDuplaEnc.insert(91);
		listaDuplaEnc.insert(18);
		listaDuplaEnc.insert(93);
		listaDuplaEnc.insert(69);
		assertEquals("206, 152, 38, 91, 18, 93, 69", listaDuplaEnc.imprimeEmOrdem());
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(91), listaDuplaEnc.remove(91));
		assertEquals("206, 152, 38, 18, 93, 69", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {206, 152, 38, 18, 93, 69}, listaDuplaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(18), listaDuplaEnc.remove(18));
		assertEquals("206, 152, 38, 93, 69", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {206, 152, 38, 93, 69}, listaDuplaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(206), listaDuplaEnc.remove(206));
		assertEquals("152, 38, 93, 69", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {152, 38, 93, 69}, listaDuplaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(152), listaDuplaEnc.remove(152));
		assertEquals("38, 93, 69", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {38, 93, 69}, listaDuplaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(93), listaDuplaEnc.remove(93));
		assertEquals("38, 69", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {38, 69}, listaDuplaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(69), listaDuplaEnc.remove(69));
		assertEquals("38", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[]{38}, listaDuplaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(38), listaDuplaEnc.remove(38));
		assertEquals("", listaDuplaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[0], listaDuplaEnc.toArray(Integer.class));
		assertTrue(listaDuplaEnc.isEmpty());
		
		assertThrows(ListaVaziaException.class, () -> {
			listaDuplaEnc.remove(38);
		});
	}
	
	@Test
	public void sucessorTeste() throws ElementoNaoEncontradoException {
		listaDuplaEnc.insert(206);
		listaDuplaEnc.insert(122);
		listaDuplaEnc.insert(58);
		listaDuplaEnc.insert(11);
		listaDuplaEnc.insert(78);
		listaDuplaEnc.insert(43);
		listaDuplaEnc.insert(59);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(122), listaDuplaEnc.sucessor(206));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(58), listaDuplaEnc.sucessor(122));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(11), listaDuplaEnc.sucessor(58));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(78), listaDuplaEnc.sucessor(11));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(43), listaDuplaEnc.sucessor(78));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(59), listaDuplaEnc.sucessor(43));
		
	}
	
	@Test
	public void predecessorTeste() throws ElementoNaoEncontradoException {
		listaDuplaEnc.insert(206);
		listaDuplaEnc.insert(122);
		listaDuplaEnc.insert(58);
		listaDuplaEnc.insert(11);
		listaDuplaEnc.insert(78);
		listaDuplaEnc.insert(43);
		listaDuplaEnc.insert(59);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(43), listaDuplaEnc.predecessor(59));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(78), listaDuplaEnc.predecessor(43));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(11), listaDuplaEnc.predecessor(78));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(58), listaDuplaEnc.predecessor(11));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(122), listaDuplaEnc.predecessor(58));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(206), listaDuplaEnc.predecessor(122));
		
	}
	
	@Test
	public void isEmptyTest() throws ElementoNaoEncontradoException, ListaVaziaException {
		assertTrue(listaDuplaEnc.isEmpty());
		listaDuplaEnc.insert(206);
		listaDuplaEnc.insert(122);
		listaDuplaEnc.insert(58);
		listaDuplaEnc.insert(11);
		listaDuplaEnc.insert(78);
		listaDuplaEnc.insert(43);
		listaDuplaEnc.insert(59);
		assertFalse(listaDuplaEnc.isEmpty());
		listaDuplaEnc.remove(206);
		listaDuplaEnc.remove(122);
		listaDuplaEnc.remove(58);
		listaDuplaEnc.remove(11);
		listaDuplaEnc.remove(78);
		listaDuplaEnc.remove(43);
		assertFalse(listaDuplaEnc.isEmpty());
		listaDuplaEnc.remove(59);
		assertTrue(listaDuplaEnc.isEmpty());
	}
	
	@Test
	public void sizeRemoveCabecaTest() throws ElementoNaoEncontradoException, ListaVaziaException {
		assertEquals(0, listaDuplaEnc.size());
		listaDuplaEnc.insert(58);
		assertEquals(1, listaDuplaEnc.size());
		listaDuplaEnc.insert(11);
		assertEquals(2, listaDuplaEnc.size());
		listaDuplaEnc.insert(78);
		assertEquals(3, listaDuplaEnc.size());
		listaDuplaEnc.insert(43);
		assertEquals(4, listaDuplaEnc.size());
		listaDuplaEnc.remove(58);
		assertEquals(3, listaDuplaEnc.size());
		listaDuplaEnc.remove(11);
		assertEquals(2, listaDuplaEnc.size());
		listaDuplaEnc.remove(78);
		assertEquals(1, listaDuplaEnc.size());
		listaDuplaEnc.remove(43);
		assertEquals(0, listaDuplaEnc.size());
	}
	
	@Test
	public void inserePrimeiroTest() throws ElementoNaoEncontradoException {
		listaDuplaEnc.insert(34);
		listaDuplaEnc.insert(75);
		listaDuplaEnc.insert(18);

		listaDuplaEnc.inserePrimeiro(23);

		assertArrayEquals(new Integer[]{23, 34, 75, 18}, listaDuplaEnc.toArray(Integer.class));
		assertNull(listaDuplaEnc.predecessor(23));
		assertEquals(34, listaDuplaEnc.sucessor(23).getChave());
	}
	
	@Test
	public void removeUltimoTest() throws ElementoNaoEncontradoException, ListaVaziaException {
		listaDuplaEnc.insert(33);
		listaDuplaEnc.insert(15);
		listaDuplaEnc.insert(78);
		
		assertArrayEquals(new Integer[] {33, 15, 78}, listaDuplaEnc.toArray(Integer.class));
		
		listaDuplaEnc.removeUltimo();
		
		NodoListaDuplamenteEncadeada<Integer> cauda = ((ListaDuplamenteEncadeadaImpl<Integer>)listaDuplaEnc).search(15);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(33), cauda.getAnterior());
		assertNull(cauda.getProximo());
		assertArrayEquals(new Integer[] {33, 15}, listaDuplaEnc.toArray(Integer.class));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(33),listaDuplaEnc.predecessor(15));
		assertNull(listaDuplaEnc.sucessor(15));
	}

	@Test
	public void removePrimeiro() throws ElementoNaoEncontradoException, ListaVaziaException {
		listaDuplaEnc.insert(33);
		listaDuplaEnc.insert(15);
		listaDuplaEnc.insert(78);

		assertArrayEquals(new Integer[] {33, 15, 78}, listaDuplaEnc.toArray(Integer.class));

		listaDuplaEnc.removePrimeiro();

		NodoListaDuplamenteEncadeada<Integer> primeiro = ((ListaDuplamenteEncadeadaImpl<Integer>)listaDuplaEnc).search(15);
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(78), primeiro.getProximo());
		assertTrue(primeiro.getAnterior().equals(((ListaDuplamenteEncadeadaImpl<Integer>) listaDuplaEnc).getCabeca())); // Verifica se aponta para a cabeça
		assertArrayEquals(new Integer[] {15, 78}, listaDuplaEnc.toArray(Integer.class));
		assertEquals(new NodoListaDuplamenteEncadeada<Integer>(78), listaDuplaEnc.sucessor(15));
		assertNull(listaDuplaEnc.predecessor(15)); // predecessor de primeiro elemento é null (considerando cabeça como sentinela)
	}

	//Novos testes

	// Testes para métodos específicos de lista duplamente encadeada
	@Test
	public void removeUltimo_QuandoListaVazia_DeveLancarExcecao() {
		assertThrows(ListaVaziaException.class, () -> listaDuplaEnc.removeUltimo());
	}

	@Test
	public void removePrimeiro_QuandoListaVazia_DeveLancarExcecao() {
		assertThrows(ListaVaziaException.class, () -> listaDuplaEnc.removePrimeiro());
	}

	@Test
	public void inserePrimeiro_EmListaVazia_DeveTornarUnicoElemento() throws ElementoNaoEncontradoException {
		listaDuplaEnc.inserePrimeiro(10);
		assertEquals(1, listaDuplaEnc.size());
		assertEquals(10, listaDuplaEnc.search(10).getChave());
		assertNull(listaDuplaEnc.predecessor(10));
		assertNull(listaDuplaEnc.sucessor(10));
	}

	// Testes para encadeamento duplo
	@Test
	public void encadeamentoDuplo_AposInsercoesERemocoes_DeveManterConsistencia() throws ElementoNaoEncontradoException, ListaVaziaException {
		listaDuplaEnc.insert(10);
		listaDuplaEnc.insert(20);
		listaDuplaEnc.insert(30);

		NodoListaDuplamenteEncadeada<Integer> nodo20 = (NodoListaDuplamenteEncadeada<Integer>) listaDuplaEnc.search(20);
		assertEquals(10, nodo20.getAnterior().getChave());
		assertEquals(30, nodo20.getProximo().getChave());

		listaDuplaEnc.remove(20);
		NodoListaDuplamenteEncadeada<Integer> nodo30 = (NodoListaDuplamenteEncadeada<Integer>) listaDuplaEnc.search(30);
		assertEquals(10, nodo30.getAnterior().getChave());
	}

	// Testes para valores extremos
	@Test
	public void valoresExtremos_QuandoInseridos_DeveManterIntegridade() {
		listaDuplaEnc.insert(Integer.MIN_VALUE);
		listaDuplaEnc.insert(0);
		listaDuplaEnc.insert(Integer.MAX_VALUE);

		assertEquals(3, listaDuplaEnc.size());
		assertEquals(Integer.MIN_VALUE, listaDuplaEnc.search(Integer.MIN_VALUE).getChave());
		assertEquals(Integer.MAX_VALUE, listaDuplaEnc.search(Integer.MAX_VALUE).getChave());
	}

	// Testes para casos especiais
	@Test
	public void removeUltimo_QuandoUnicoElemento_DeveEsvaziarLista() throws ListaVaziaException {
		listaDuplaEnc.insert(10);
		listaDuplaEnc.removeUltimo();
		assertTrue(listaDuplaEnc.isEmpty());
		assertEquals(0, listaDuplaEnc.size());
	}

	@Test
	public void removePrimeiro_QuandoUnicoElemento_DeveEsvaziarLista() throws ListaVaziaException {
		listaDuplaEnc.insert(10);
		listaDuplaEnc.removePrimeiro();
		assertTrue(listaDuplaEnc.isEmpty());
		assertEquals(0, listaDuplaEnc.size());
	}

}