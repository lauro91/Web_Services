package aula_2;

import java.util.ArrayList;
import java.util.List;

//classe que representa a turma
public class Turma{
	private String nome;
	private String disciplina;
	private String professor;
	private int ano;
	private List<Aluno> alunos;
	
	
	public Turma(String nome, String disciplina, String professor, int ano) {
		super();
		this.nome = nome;
		this.disciplina = disciplina;
		this.professor = professor;
		this.ano = ano;
		alunos = new ArrayList<Aluno>();
	}

	public String getNome() {
		return nome;
	}
	
	public String getDisciplina() {
		return disciplina;
	}
	
	public String getProfessor() {
		return professor;
	}
	
	public int getAno() {
		return ano;
	}
	
	public List<Aluno> getListaAlunos() {
		return alunos;
	}
}//class Turma