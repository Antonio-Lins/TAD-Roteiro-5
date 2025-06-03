package tad.fila;


import tad.ElementoNaoEncontradoException;
import tad.listasEncadeadas.ListaEncadeadaImpl;
import tad.listasEncadeadas.ListaVaziaException;

/** Roteiro 05 - TADs
 * @author Arthur Barbosa Donato
 * Caracterização do roteiro: Implementar uma fila com estratégia circular usando lista encadeada.
 * Objetivo da classe: Fornecer uma fila com o comportamento FIFO (First in First out).
 * */
public class MinhaFilaEncadeada implements FilaIF<Integer> {

	private int tamanho = 5;
	private ListaEncadeadaImpl<Integer> listaEncadeada = null;

	public MinhaFilaEncadeada(int tamanho){
		this.tamanho = tamanho;
		this.listaEncadeada = new ListaEncadeadaImpl<>();
	}
	public MinhaFilaEncadeada(){
		listaEncadeada = new ListaEncadeadaImpl<>();
	}
	/** Esse método adiciona elementos na fila sempre pela cauda e fazendo a verificação se caso a fila esteja cheia.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser adicionado na fila.
	 * @throws FilaCheiaException - Caso tente adicionar um elemento na fila que esteja cheia.
	 * */

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		if(this.listaEncadeada.size() == this.tamanho){
			throw new FilaCheiaException();
		}
		this.listaEncadeada.insert(item);
		
	}

	/** Esse método remove elementos da fila usando a estratégia FIFO (First in First out), e fazendo a verificação se caso a fila esteja vazia.
	 * @author Arthur Barbosa Donato
	 * @return Integer numeroRemovido - Elemento removido da fila.
	 * @throws FilaVaziaException - Caso tente remover um elemento da fila que esteja vazia.
	 * */
	@Override
	public Integer desenfileirar() throws FilaVaziaException {

		Integer numeroRemovido = null;

		try{
			numeroRemovido = this.listaEncadeada.remove(this.listaEncadeada.cabeca.getChave()).getChave();
		} catch(ElementoNaoEncontradoException | ListaVaziaException e){
			System.out.println(e.getMessage());
		}

		return numeroRemovido;
	}

	/** Esse método verifica o elemento que se encontra na cauda da fila, ou seja, na última posição.
	 * @author Arthur Barbosa Donato
	 * @return Integer elementoCauda - Elemento que se encontra na cauda da fila.
	 * */
	@Override
	public Integer verificarCauda() {
		if(this.listaEncadeada.isEmpty()){
			return null;
		}
		return this.listaEncadeada.getCauda().getChave();
	}

	/** Esse método verifica o elemento que se encontra na cabeça da fila, ou seja, na primeira posicão.
	 * @author Arthur Barbosa Donato
	 * @return Integer elementoCabeca - Elemento que se encontra na cabeça da fila.
	 * */
	@Override
	public Integer verificarCabeca() {
		if(this.listaEncadeada.isEmpty()){
			return null;
		}
		return this.listaEncadeada.cabeca.getChave();
	}

	/** Esse método faz a verificação se a fila está vazia ou não
	 * @author Arthur Barbosa Donato
	 * @return boolean isEmpty - Booleano que indica se a fila está vazia ou não.
	 * */
	@Override
	public boolean isEmpty() {
		return this.listaEncadeada.isEmpty();
	}

	/** Esse método faz a verificação se a fila está cheia ou não
	 * @author Arthur Barbosa Donato
	 * @return boolean isFull - Booleano que indica se a fila está cheia ou não.
	 * */
	@Override
	public boolean isFull() {
		return this.listaEncadeada.size() == this.tamanho;
	}

	/** Esse método verifica a capacidade total da fila, ou seja, quantos elementos ela pode armazenar no total.
	 * @author Arthur Barbosa Donato
	 * @return int capacidade - Número da capacidade total da fila.
	 * */
	@Override
	public int capacidade() {
		return this.tamanho;
	}

	/** Esse método verifica o tamanho da fila atual, ou seja, quantos elementos ela possui diferentes de nulo.
	 * @author Arthur Barbosa Donato
	 * @return int tamanho - Número do tamanho total da fila
	 * */
	@Override
	public int tamanho() {
		return this.listaEncadeada.size();
	}

}