package listaDuplamenteEncadeada;

public class Main {
	public static void main(String[] args) {
		ListaDupEnc lista = new ListaDupEnc();
		lista.adicionarNo(new NoDup(4));
		lista.adicionarNo(new NoDup(12));
		lista.adicionarNo(new NoDup(9));
		lista.adicionarNo(new NoDup(2));
		lista.adicionarNo(new NoDup(8));
		lista.adicionarNo(new NoDup(20));
		lista.adicionarNo(new NoDup(15));
		System.out.println(lista.toString());
	}
}
