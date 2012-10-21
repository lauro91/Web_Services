package aula_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;

/*
 * Recupera os dados da turma a partir de um arquivo JSON
 */
public class RecuperarDadosTurma {

	private static Gson manipuladorJson;
	private static Turma turma;
	private static String json;
	
	//Método principal
	public static void main(String[] args) {
		try {
			manipuladorJson = new Gson();	//cria o manipulador de JSON		
			json = lerArquivo("turma.json");
					
			//desserializa o conteudo json em um objeto turma
			turma = manipuladorJson.fromJson(json, Turma.class);
			
			//imprime os dados recuperados
			System.out.println("Nome........:" + turma.getNome());
			System.out.println("Ano.........:" + turma.getAno());
			System.out.println("Disciplina..:" + turma.getDisciplina());
			System.out.println("Professor...:" + turma.getProfessor());
			
			System.out.println("------- Alunos--------");
			
			Iterator<Aluno> iterator = turma.getListaAlunos().iterator();
			while (iterator.hasNext())
				System.out.println(iterator.next());
		
									
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}//main

    //Lê arquivo texto e retorna seu conteúdo
	private static String lerArquivo(String path) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(path));
		String conteudo = "";
		
		while(scan.hasNextLine())
			conteudo += scan.nextLine();
		
		scan.close();
		return conteudo;
	}//lerArquivo()
	
	
	
	
	
	
}
