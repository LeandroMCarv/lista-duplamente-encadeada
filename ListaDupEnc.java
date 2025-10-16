package listaDuplamenteEncadeada;

public class ListaDupEnc {
	private NoDup cabeca;

	public NoDup getCabeca() {
		return cabeca;
	}

	public void setCabeca(NoDup cabeca) {
		this.cabeca = cabeca;
	}

	public ListaDupEnc() {
		this.cabeca=null;
	}
	
	public boolean estaVazia() {
		return this.cabeca==null;
	}
	
	public void adicionarNo(NoDup no) {
		NoDup noTemp = this.cabeca;
		NoDup noAnt = null;
		if(estaVazia()) {
			this.cabeca=no;
		}else {
			//vai inserir na cabeca
			if(this.cabeca.getValor()>no.getValor()) {
				no.setProximo(this.cabeca);
				this.cabeca.setAnterior(no);
				this.cabeca=no;
			}
			else {
				while(noTemp.getProximo()!=null&&noTemp.getValor()<no.getValor()) {
					noAnt = noTemp;
					noTemp=noTemp.getProximo();
				}
				//vai inserir no meio
				if(noTemp.getProximo()!=null||no.getValor()<noTemp.getValor()) {
					noAnt.setProximo(no);
					no.setAnterior(noAnt);
					no.setProximo(noTemp);
					noTemp.setAnterior(no);
				}
				//vai inserir no fim
				else {
					noTemp.setProximo(no);
					no.setAnterior(noTemp);
				}
			}
		}
/*		Adicionar sempre no final
		}else {
			while(noTemp.getProximo()!=null) {
				noTemp=noTemp.getProximo();
			}
			noTemp.setProximo(no);
			no.setAnterior(noTemp);
		}
*/
	}
	
	public void adicionarCabeca(NoDup no) {
		NoDup noTemp = this.cabeca;
		//se estaVazia adiciona apenas o no à cabeça
		if(estaVazia()) {
			this.cabeca=no;
			//senao, o no a ser inserido aponta para cabeça, o no anterior a cabeça passara a ser o no a ser inserido e entao esse novo no
			//se tornara a cabeça
		}else {
			no.setProximo(noTemp);
			noTemp.setAnterior(no);
			this.cabeca=no;
		}
	}
	
	public void removerNo(int valor) {
		NoDup noTemp = this.cabeca;
		NoDup noAnt = null;
		if(!estaVazia()) {
			if(noTemp.getValor()==valor) {//tá na cabeça
				this.cabeca=this.cabeca.getProximo();
				if(this.cabeca!=null) {//a cabeça não é o unico nó da lista
					this.cabeca.setAnterior(null);
					noTemp.setProximo(null);
				}
			}else {//nao encontrou na cabeça, vai para o meio
				while(noTemp.getProximo()!=null&&noTemp.getValor()!=valor) {//percorre todo a lista para verificar
					noAnt=noTemp;
					noTemp=noTemp.getProximo();
				}
				if(noTemp.getValor()==valor) {//ta no meio
					if(noTemp.getProximo()!=null) {
						noAnt.setProximo(noTemp.getProximo());
						noTemp.getProximo().setAnterior(noAnt);
					}else{//é o ultimo
						noAnt.setProximo(null);
					}
					noTemp.setProximo(null);
					noTemp.setAnterior(null);
				}
			}
		}
	}
	
	public NoDup buscarNo(int valor) {
		//verifica se tem algo para buscar na lista
		if(!estaVazia()) {
			NoDup noTemp = this.cabeca;
			//vasculha todo a lista
			while(noTemp!=null) {
				//se encontrar retorna o valor
				if(noTemp.getValor()==valor) {
					return noTemp;
				}
				noTemp=noTemp.getProximo();
			}
		}
		//senao, retorna null
		return null;
	}
	
	public void limparLista() {
		//verifica se há algo para ser limpo
		if(!estaVazia()) {
			NoDup noTemp = this.cabeca;
			NoDup proximo;
			//percorre ate o final da lista desreferenciando nó por nó
			while(noTemp!=null) {
				proximo = noTemp.getProximo();
				noTemp.setProximo(null);
				noTemp.setAnterior(null);
				noTemp=proximo;
			}
			//desreferencia a cabeca
			this.cabeca=null;
		}
	}
	
	public String toString() {
		if(estaVazia()) {
			return "";
		}
		else {
			String retorno = "";
			NoDup noTemp = this.cabeca;
			while(noTemp.getProximo()!=null) {
				retorno+=noTemp.getValor();
				if(noTemp.getProximo()!=null) {
					retorno+=",";
				}
				noTemp=noTemp.getProximo();
			}
			retorno+=noTemp.getValor();
			return retorno;
		}
	}
}