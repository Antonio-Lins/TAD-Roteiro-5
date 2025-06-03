package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */

/** Roteiro 05 - TADs
 * @author Arthur Barbosa Donato
 * Caracterização do roteiro: Implementar uma fila com estratégia circular usando apenas arrays fixos.
 * Objetivo da classe: Fornecer uma fila com o comportamento FIFO (First in First out).
 * */
public class MinhaFila implements FilaIF<Integer> {

	private int tamanho = 5;

	private int cauda = 1;
	private int cabeca = 0;

	private final Integer[] meusDados;

	public MinhaFila(int tamanhoInicial) {
		tamanho = tamanhoInicial;
		this.meusDados = new Integer[tamanho];
	}

	public MinhaFila() {
		this.meusDados = new Integer[tamanho];
	}

	/** Esse método enfileira os elementos na fila, fazendo a verificação se a fila está cheia e se o elemento que vai ser enfileirado é um elemento nulo.
	 * 	@author Arthur Barbosa Donato
	 * 	@param Integer item - Elemento que vai ser enfileirado na fila.
	 * 	@throws FilaCheiaException - Caso tente enfileirar um elemento e a fila atual esteja cheia.
	 * */
	@Override
	public void enfileirar(Integer item) throws FilaCheiaException{
		if(this.isFull()){
			throw new FilaCheiaException();
		}
		else{
			if(this.isEmpty()){
				this.meusDados[cabeca] = item;
			}
			else{
				this.meusDados[cauda] = item;
				this.cauda++;
			}
		}

	}

	/** Esse mètodo desenfileira os elementos da fila usando da ordem FIFO (First in First out), fazendo a verificação se a fila já está vazia.
	 * 	@author Arthur Barbosa Donato
	 * 	@return Integer numeroRemovido - Número que foi removido da fila.
	 * 	@throws FilaVaziaException - Caso tente desenfileirar um elemento e a fila atual esteja vazia.
	 * */
	@Override
	public Integer desenfileirar() throws FilaVaziaException{
		if(this.isEmpty()){
			throw new FilaVaziaException();
		}

		Integer numeroRemovido = this.meusDados[cabeca];

		this.cauda--;
		for(int i = 0; i < this.cauda; i++){
			this.meusDados[i] = this.meusDados[i + 1];
		}

		this.meusDados[cauda] = null;
		return numeroRemovido;
	}

	/** Esse método faz a verificação do elemento que se encontra na cauda da fila, ou seja, na ultima posição.
	 * 	@author Arthur Barbosa Donato
	 * 	@return Integer elementoCauda - Número que se encontra na última posição da fila.
	 *
	 * */
	@Override
	public Integer verificarCauda() {
		if(this.isEmpty()){
			return null;
		}
		return this.meusDados[cauda - 1];
	}

	/** Esse método faz a verificação do elemento que se encontra na cabeça da fila, ou seja, na primeira posição.
	 * 	@author Arthur Barbosa Donato
	 * 	@return Integer elementoCabeca - Número que se encontra na cabeça da fila.
	 * */
	@Override
	public Integer verificarCabeca() {
		if(this.isEmpty()){
			return null;
		}
		return this.meusDados[cabeca];
	}

	/** Esse método faz a verificação se a fila atual está vazia ou não.
	 * 	@author Arthur Barbosa Donato
	 * 	@return boolean isEmpty - Booleano que representa se a fila está vazia ou não.
	 * */
	@Override
	public boolean isEmpty() {
		return this.tamanho() == 0;
	}

	/** Esse método faz a verificação se a fila atual está cheia ou não.
	 *	@author Arthur Barbosa Donato
	 * 	@return boolean isFull - Booleano que representa a fila esá cheia ou não.
	 * */
	@Override
	public boolean isFull() {
		return this.tamanho() == this.tamanho;
	}

	/** Esse método é utilizado para verificar a capacidade total da fila, ou seja, quantos elementos a fila pode armazenar no total.
	 * 	@author Arthur Barbosa Donato
	 * 	@return int capacidade - Número que representa a capacidade total da fila.
	 * */
	@Override
	public int capacidade() {
		return this.tamanho;
	}
	/** Esse método faz a contagem do tamanho da fila, contando apenas os elementos que são diferentes de nulos;
	 * 	@author Arthur Barbosa Donato
	 * 	@return int tamanho - Número que representa o tamanho da fila.
	 * */
	@Override
	public int tamanho() {
		int contadorElementos = 0;

		for(Integer numero : this.meusDados){
			if(numero != null){
				contadorElementos++;
			}
		}

		return contadorElementos;
	}

}