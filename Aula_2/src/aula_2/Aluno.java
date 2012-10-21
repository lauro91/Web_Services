package aula_2;

//classe que representa o aluno
public class Aluno{
	private String nome;
	private double nota;
	private int codigo;
	
	public Aluno (String nome, double nota, int codigo){
		this.nome = nome;
		this.nota = nota;
		this.codigo = codigo;
	}
	
	//retorna uma string formatada do objeto Lluno
	public String toString() {
		return "[" + codigo + "] " + nome + " ---> " + nota;
	}
}//class Aluno