package ling2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lingjava.Aluno;

public class ConsultaAluno {
	
	public static void main(String[] args) {
		Aluno aluno;
		List<Aluno> listAlunos;
		Type tipoList = new TypeToken<List<Aluno>>(){}.getType();
		HttpURLConnection connection;
		BufferedReader buffer;
		final String urlSite = "http://localhost/usuarios/";
		URL url;
		
		String user = "";
		do{
			user = JOptionPane.showInputDialog(null, "Dados do Aluno.\n\nNome", 
					"Dados de Aluno",JOptionPane.QUESTION_MESSAGE);
			if (user == null)
				System.exit(0);
						
			try{
				url = new URL(urlSite + user + ".json");
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				if (connection.getResponseCode() == 200){
					buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					if (user.equals("all")){
						listAlunos = new Gson().fromJson(buffer, tipoList);
						String content = "";
						Iterator<Aluno> iterator = listAlunos.iterator();
						while (iterator.hasNext())
							content += iterator.next().toString() + "\n\n";
						
						JTextArea area = new JTextArea(10,20);
						area.setText(content);
						JOptionPane.showMessageDialog(null,new JScrollPane(area));
					}else{
						aluno = new Gson().fromJson(buffer, Aluno.class);
						JOptionPane.showMessageDialog(null, aluno);
					}
				}else
					JOptionPane.showMessageDialog(null, "Aluno não existe.");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}while(true);
	}

}
