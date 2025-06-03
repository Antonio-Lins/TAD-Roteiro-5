package tad.conjuntoDinamico;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

	/** Esse método adiciona o elemento que foi passado como paramtro dentro do conjunto dinamico.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser adicionado no conjunto.
	 * */
	@Override
	public void inserir(Integer item) {
		// TODO Auto-generated method stub
		
	}

	/** Esse método remove um elemento do conjunto dinamico, caso esse elemento exista dentro do conjunto.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser removido do conjunto.
	 * @return Integer numeroRemovido - Elemento que foi removido do conjunto dinamico.
	 * */
	@Override
	public Integer remover(Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Esse método verifica o predecessor do elemento que foi passado como parametro.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser procurando o predecessor.
	 * @return Integer sucessor - Elemento predecessor do elemento que foi passado como parametro.
	 * */
	@Override
	public Integer predecessor(Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Esse método verifica o sucessor do elemento que foi passado como parametro.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser procurando o sucessor.
	 * @return Integer sucessor - Elemento sucessor do elemento que foi passado como parametro.
	 * */
	@Override
	public Integer sucessor(Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Esse método faz a verificação do tamanho atual do conjunto dinamico, ou seja, quantos elementos ele possui diferentes de nulo.
	 * @author Arthur Barbosa Donato
	 * @return int tamanho - Número que representa o tamanho atual do conjunto dinamico.
	 * */
	@Override
	public int tamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	/** Esse método busca um elemento dentro do conjunto dinamico.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser procurando dentro do conjunto dinamico.
	 * @return Integer numeroProcurado - Número que estava a ser procurado no conjunto.
	 * */
	@Override
	public Integer buscar(Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Esse método verifica o menor elemento dentro do conjunto dinamico.
	 * @author Arthur Barbosa Donato
	 * @return Integer menorElemento - Menor número dentro do conjunto.
	 * */
	@Override
	public Integer minimum() {
		// TODO Auto-generated method stub
		return null;
	}

	/** Esse método verifica o maior elemento dentro do conjunto dinamico.
	 * @author Arthur Barbosa Donato
	 * @return Integer maiorElemento - Maior número dentro do conjunto.
	 * */
	@Override
	public Integer maximum() {
		// TODO Auto-generated method stub
		return null;
	}

}