package lingjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import static javax.swing.JOptionPane.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CadastroAluno {
	//caminho da pasta onde ficam os arquivos json, trocar conforme a necessidade
	private final static String dirPath = "D:\\Arquivos de programas\\EasyPHP-12.0\\www\\usuarios\\";
	private static Gson manipuladorJson = new Gson(); //manipula o json
	private static Formatter saida;
	private static Scanner entrada;
	private static List<Aluno> listAlunos = new ArrayList<Aluno>();
		
	/*
	 * M�todo principal.
	 */
	public static void main(String[] args) {
		
		//inicializa a listAlunos
			inicializaLista();
		
		String nomeAluno = "", id = "";
		
		//loop principal do programa
		do{
			nomeAluno = showInputDialog(null, "Dados do Aluno\n\nNome");
			//verifica se o bot�o sa�r ou cancelar foi apertado
			if (nomeAluno == null)
				System.exit(0);
			
			if (nomeAluno.isEmpty()){
				showMessageDialog(null, "Digite um nome por favor.");
				continue;
			}
			
			id = showInputDialog(null, "Dados do Aluno\n\nId");
			//verifica se o bot�o sa�r ou cancelar foi apertado
			if (id == null)
				System.exit(0);
			
			if (id.isEmpty()){
				showMessageDialog(null, "Digite uma Id v�lida por favor.");
				continue;
			}
			
			
			//cria arquivo json	
			try{
				criaJSON(new Aluno(nomeAluno, id));
			}catch(Exception e){
				e.printStackTrace();
			}
			

		}while(true);
		
		
	}//main()

	/*
	 * Cria os arquivo json
	 */
	private static void criaJSON(Aluno aluno) throws Exception{
		//cria arquivo com nome do aluno
		saida = new Formatter(new FileOutputStream(dirPath + aluno.getNome() + ".json"));
		
		//converte o objeto aluno em json
		String json = manipuladorJson.toJson(aluno);
		
		saida.format("%s", json);
		
		//fecha arquivo
		saida.close();
		
		listAlunos.add(aluno);
		System.out.println(listAlunos);
		json = manipuladorJson.toJson(listAlunos);
		System.out.println(json	);
		FileOutputStream fo = new FileOutputStream(dirPath + "all.json");
		Formatter output = new Formatter(fo);
		output.format("%s", json);
		output.close();
		
	}//criaJSON
	
	/*
	 * Inicializa listaAlunos com objetos alunos j� criados na inicializa��o do programa.
	 */
	private static void inicializaLista() {
		try{
			String conteudoJSONIndex = "";
			entrada = new Scanner(new FileInputStream(dirPath + "all.json"));
						
			while(entrada.hasNext()){
				System.out.println(conteudoJSONIndex += entrada.nextLine());
			}
				
			Type tipoLista = new TypeToken<List<Aluno>>(){}.getType();	
			listAlunos = manipuladorJson.fromJson(conteudoJSONIndex,tipoLista);
			
			//se a lista de alunos n�o existe ainda, cria-se uma vazia
			if (listAlunos == null)
				listAlunos = new ArrayList<Aluno>();
			
			entrada.close();
		}
		catch (Exception e) {
			System.out.println("N�o existe");
			listAlunos = new ArrayList<Aluno>();
		}
	}//inicializaLista()
}
