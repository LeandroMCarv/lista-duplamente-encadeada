package listaDuplamenteEncadeada;

public class NoDup {
	private int valor;
	private NoDup proximo;
	private NoDup anterior;
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public NoDup getProximo() {
		return proximo;
	}
	public void setProximo(NoDup proximo) {
		this.proximo = proximo;
	}
	public NoDup getAnterior() {
		return anterior;
	}
	public void setAnterior(NoDup anterior) {
		this.anterior = anterior;
	}
	public NoDup(int valor) {
		this.valor=valor;
		setProximo(null);
		setAnterior(null);
	}
}