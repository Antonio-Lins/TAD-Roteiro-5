package tad.pilha;

/**
 * Implementacao de uma pilha generica usando array.
 * A pilha armazena elementos do tipo Integer e possui operações básicas de pilha.
 * Author: fabioleite.
 */

/**
 * Manoel Firmino Dos Santos Neto.
 * Roteiro 05 - TADs.
 * Caracterização do roteiro: Implementa uma pilha fixa de inteiros com operações básicas e tratamento de exceções.
 * Objetivo da classe: Fornecer estrutura LIFO simples e eficiente para manipulação de inteiros.
 */

public class MinhaPilha implements PilhaIF<Integer> {

	private int tamanho = 5;
	private Integer[] meusDados = null;
	private int indiceTopo = -1;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		this.meusDados = new Integer[tamanho];
	}

	public MinhaPilha() {
		this.meusDados = new Integer[tamanho];
	}

	/**
	 * Método para inserir um elemento no topo da pilha, lançando exceção se a pilha estiver cheia.
	 * @author Manoel Firmino Dos Santos Neto.
	 * @param item o elemento a ser empilhado.
	 * @throws PilhaCheiaException se a pilha estiver cheia.
	 */
	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if (indiceTopo == meusDados.length - 1) {
			throw new PilhaCheiaException();
		} else {
			meusDados[++indiceTopo] = item;
		}
	}

	/**
	 * Método para remover e retornar o elemento do topo da pilha.
	 * @author Manoel Firmino Dos Santos Neto.
	 * @return o elemento do topo.
	 * @throws PilhaVaziaException se a pilha estiver vazia.
	 */
	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (!isEmpty()) {
			return meusDados[indiceTopo--];
		} else {
			throw new PilhaVaziaException("pilha vazia!!");
		}
	}

	/**
	 * Método para retornar o elemento do topo da pilha sem removê-lo.
	 * @author Manoel Firmino Dos Santos Neto.
	 * @return o elemento do topo ou null se a pilha estiver vazia.
	 */
	@Override
	public Integer topo() {
		if (!isEmpty()) {
			return meusDados[indiceTopo];
		} else {
			return null;
		}
	}

	/**
	 * Método que retorna uma nova pilha contendo os k elementos do topo da pilha atual.
	 * @author Manoel Firmino Dos Santos Neto.
	 * A ordem dos elementos na nova pilha preserva a ordem de desempilhamento.
	 * @param k número de elementos do topo a copiar.
	 * @return nova pilha com os k elementos do topo.
	 * @throws IllegalArgumentException se k for menor ou igual a zero.
	 */
	@Override
	public PilhaIF<Integer> multitop(int k) {
		if (k <= 0) {
			throw new IllegalArgumentException("k deve ser positivo");
		}

		MinhaPilha novaPilha = new MinhaPilha(Math.min(k, this.capacidade()));
		int limite = Math.min(k, indiceTopo + 1);

		for (int i = indiceTopo; i >= indiceTopo - limite + 1; i--) {
			try {
				novaPilha.empilhar(meusDados[i]);
			} catch (PilhaCheiaException e) {
				e.printStackTrace();
			}
		}
		return novaPilha;
	}

	/**
	 * Método que verifica se a pilha está vazia.
	 * @author Manoel Firmino Dos Santos Neto.
	 * @return true se a pilha estiver vazia, false caso contrário.
	 */
	@Override
	public boolean isEmpty() {
		return this.indiceTopo == -1;
	}

	/**
	 * Método que compara esta pilha com outro objeto para verificar igualdade.
	 * @author Manoel Firmino Dos Santos Neto.
	 * Duas pilhas são iguais se tiverem o mesmo número de elementos e todos os elementos, na mesma ordem, forem iguais.
	 * @param obj objeto a comparar.
	 * @return true se as pilhas forem iguais, false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		MinhaPilha outra = (MinhaPilha) obj;

		if (this.indiceTopo != outra.indiceTopo) return false;

		for (int i = 0; i <= indiceTopo; i++) {
			if (!this.meusDados[i].equals(outra.meusDados[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Método que gera o código hash da pilha com base nos elementos armazenados.
	 * @author Manoel Firmino Dos Santos Neto.
	 * @return código hash da pilha.
	 */
	@Override
	public int hashCode() {
		int result = 1;
		for (int i = 0; i <= indiceTopo; i++) {
			result = 31 * result + meusDados[i].hashCode();
		}
		return result;
	}

	/**
	 * Método que retorna a capacidade máxima da pilha.
	 * @author Manoel Firmino Dos Santos Neto.
	 * @return a capacidade máxima.
	 */
	@Override
	public int capacidade() {
		return meusDados.length;
	}

	/**
	 * Método que retorna o tamanho atual da pilha (número de elementos).
	 * @author Manoel Firmino Dos Santos Neto.
	 * @return o tamanho atual da pilha.
	 */
	@Override
	public int tamanho() {
		return indiceTopo + 1;
	}
}