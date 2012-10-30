package lingjava;

/*
 * Dados do aluno
 */
public class Aluno {
	private String nome;
	private String id;
	
	/*
	 * Construtor sobrecarregado
	 */
	public Aluno(String nome, String id) {
		super();
		this.nome = nome;
		this.id = id;
	}

	public String getNome(){
		return nome;
	}
	
	public String toString() {
		return "Nome: " + nome + "\nID=" + id;
	}
	
	
}//class Aluno
