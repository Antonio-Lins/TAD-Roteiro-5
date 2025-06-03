package tad.conjuntoDinamico;

import tad.ElementoNaoEncontradoException;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	private int tamanho = 10;
	private Integer[] meusDados = null;
	private int posInsercao = 0;

	public MeuConjuntoDinamico(){
		this.meusDados = new Integer[tamanho];
	}
	/** Método para inserir elemento dentro do conjunto dinâmico, se caso o conjunto esteja cheio, é chamada a função para aumentar o tamanho do conjunto.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser adicionado no conjunto
	 * @return void
	 */
	@Override
	public void inserir(Integer item) throws IllegalArgumentException{
		if(item == null){
			throw new IllegalArgumentException("Elemento não pode ser null");
		}
		if(this.posInsercao == tamanho - 1){
			this.meusDados = aumentarArray();
		}
		this.meusDados[posInsercao] = item;
		posInsercao++;

	}

	/** Método para aumentar o tamanho do conjunto dinâmico, utilizando um taxa de aumento de 10. Esse método também tem a função de copiar os dados do array menor e preencher o array maior que vai ser retornado.
	 * @author Arthur Barbosa Donato
	 * @return Integer[] - Retorna um array de Integer que representa o mesmo array só que com um tamanho maior
	 */

	private Integer[] aumentarArray() {
		// criar um array maior (arrayMaior)
		// Qual é a taxa de aumento desse array?
		// copiar os dados de meusDados (array cheio)
		// colar os dados para o novo array (arrayMaior)
		this.tamanho += 10;
		Integer[] novoArray = new Integer[this.tamanho];
		int i = 0;
		for(Integer numero : this.meusDados){
			novoArray[i] = numero;
			i++;
		}

		return novoArray;
	}

	/** Método para remover elemento do conjunto dinâmico, verificando se o conjunto está vazio ou não e se o elemento que vai ser removido existe ou não dentro do conjunto.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser removido do conjunto
	 * @return Integer - Número que foi removido do conjunto
	 * @throws ElementoNaoEncontradoException - Caso o elemento recebido no parâmetro não exista dentro do conjunto
	 * @throws ConjuntoDinamicoVazioException - Caso tente se remover um elemento em um conjunto que esteja vazio
	 */
	@Override
	public Integer remover(Integer item) throws ConjuntoDinamicoVazioException, ElementoNaoEncontradoException {

		if(item == null){
			throw new IllegalArgumentException("Elemento não pode ser null");
		}
		if(this.posInsercao == 0){
			throw new ConjuntoDinamicoVazioException();
		}

		boolean numeroEncontrado = false;
		Integer numeroRemovido = null;
		for(int i = 0; i < posInsercao; i++){
			if(this.meusDados[i].equals(item)){
				numeroEncontrado = true;
				numeroRemovido = this.meusDados[i];
				this.meusDados[i] = this.meusDados[i + 1];
				this.meusDados[i + 1] = numeroRemovido;
			}
		}

		if(!numeroEncontrado){
			throw new ElementoNaoEncontradoException();
		}
		else{
			this.meusDados[posInsercao] = null;
			posInsercao--;
			return numeroRemovido;
		}


	}

	/** Método para retornar o predecessor de um elemento que esteja dentro do conjunto dinâmico, usando como base um inteiro que vai ser passado como parâmetro.
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser usando como referência para saber o seu predecessor
	 * @return Integer - Predecessor do elemento que foi dado como parâmetro
	 * @throws ConjuntoDinamicoVazioException - Caso tente achar o predecessor de um elemento em um conjunto que esteja vazio
	 */
	@Override
	public Integer predecessor(Integer item) throws ConjuntoDinamicoVazioException{
		if(this.posInsercao == 0){
			throw new ConjuntoDinamicoVazioException();
		}
		boolean elementoEncontrado = false;
		Integer indicePredecessor = 0;
		for(int i = 0; i < posInsercao; i++){
			if(this.meusDados[i].equals(item)){
				elementoEncontrado = true;
				indicePredecessor = i - 1;
			}
		}

		if(!elementoEncontrado){
			return null;
		}

		if(indicePredecessor  < 0){
			return null;
		}

		return this.meusDados[indicePredecessor];
	}

	/** Método para retornar o sucessor de um elemento que esteja dentro do conjunto dinâmico, usando como parâmetro um inteiro que vai ser passado para o método
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser usando como referência para saber o seu sucessor
	 * @return Integer - Sucessor do elemento que foi dado como parâmetro
	 * @throws ConjuntoDinamicoVazioException - Caso tente achar o sucessor de um elemento em um conjunto que esteja vazio
	 */
	@Override
	public Integer sucessor(Integer item) throws ConjuntoDinamicoVazioException{
		if(this.posInsercao == 0) {
			throw new ConjuntoDinamicoVazioException();
		}
		boolean elementoEncontrado = false;
		Integer indiceSucessor = 0;

		for(int i = 0; i < posInsercao; i++){
			if(this.meusDados[i].equals(item)){
				elementoEncontrado = true;
				indiceSucessor = i + 1;
			}
		}

		if(!elementoEncontrado){
			return null;
		}

		if(indiceSucessor == posInsercao){
			return null;
		}
		return this.meusDados[indiceSucessor];
	}

	/** Método para calcular o tamanho do conjunto dinâmico
	 * @author Arthur Barbosa Donato
	 * @return int - Inteiro referente ao tamanho atual do conjunto dinâmico
	 */
	@Override
	public int tamanho() {
		return this.posInsercao;
	}

	/** Método para buscar um elemento dentro do conjunto dinâmico
	 * @author Arthur Barbosa Donato
	 * @param Integer item - Elemento que vai ser procurado dentro do conjunto
	 * @return Integer - Número que esta sendo procurado
	 * @throws ElementoNaoEncontradoException - Caso o elemento recebido no parâmetro não exista dentro do conjunto
	 * @throws ConjuntoDinamicoVazioException - Caso tente achar um elemento em um conjunto que esteja vazio
	 */
	@Override
	public Integer buscar(Integer item) throws ElementoNaoEncontradoException, IllegalArgumentException{

		if(item == null){
			throw new IllegalArgumentException("Elemento não pode ser null");
		}

		boolean numeroEncontrado = false;
		Integer numeroProcurado = null;
		for(int i = 0; i < posInsercao; i++){
			if(this.meusDados[i].equals(item)){
				numeroEncontrado = true;
			}
		}

		if(!numeroEncontrado){
			throw new ElementoNaoEncontradoException();
		}
		else{
			return item;
		}
	}

	/** Método para retornar o menor valor dentro do conjunto dinâmico
	 * @author Arthur Barbosa Donato
	 * @return Integer - Menor número encontrado dentro do conjunto
	 * @throws ConjuntoDinamicoVazioException - Caso tente achar o valor mínimo em um conjunto que esteja vazio
	 */
	@Override
	public Integer minimum() throws ConjuntoDinamicoVazioException{

		if(this.posInsercao == 0){
			throw new ConjuntoDinamicoVazioException();
		}

		Integer menorNumero = this.meusDados[0];
		for(int i = 0 ; i < this.posInsercao; i++){
			if(this.meusDados[i] < menorNumero){
				menorNumero = this.meusDados[i];
			}
		}
		return menorNumero;
	}

	/** Método para retornar o maior valor dentro do conjunto dinâmico
	 * @author Arthur Barbosa Donato
	 * @return Integer - Maior número encontrado dentro do conjunto
	 * @throws ConjuntoDinamicoVazioException - Caso tente achar o valor máximo em um conjunto que esteja vazio
	 */
	@Override
	public Integer maximum() throws ConjuntoDinamicoVazioException{

		if(this.posInsercao == 0){
			throw new ConjuntoDinamicoVazioException();
		}

		Integer maiorNumero = this.meusDados[0];

		for(int i = 0; i < this.posInsercao ; i++){
			if(this.meusDados[i] > maiorNumero){
				maiorNumero = this.meusDados[i];
			}
		}
		return maiorNumero;
	}



}