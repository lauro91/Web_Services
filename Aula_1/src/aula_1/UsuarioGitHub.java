package aula_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

/*
 * Recebe os dados de usuario por um arquivo JSON do site github.com, faz o parse e exibe os dados
 */
public class UsuarioGitHub {
	
	//constroi o diálogo
	public UsuarioGitHub(){
		Usuario usuario;
		HttpsURLConnection connection;
		BufferedReader buffer;
		final String urlSite = "https://api.github.com/users/";
		URL url;
		
		String user = "";
		do{
			user = JOptionPane.showInputDialog(null, "Dados de Usuário GitHub.\n\nUsuário", 
					"Usuário GitHub",JOptionPane.QUESTION_MESSAGE);
			if (user == null)
				System.exit(0);
						
			try{
				url = new URL(urlSite + user);
				connection = (HttpsURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				if (connection.getResponseCode() == 200){
					buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					usuario = new Gson().fromJson(buffer, Usuario.class);
					JOptionPane.showMessageDialog(null, usuario);
				}else
					JOptionPane.showMessageDialog(null, "Usuário não existe.");
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}while(true);
		
	}
	
	//classe usuario, com alguns dos atributos 
	class Usuario{
		protected String login;
		protected String url;
		protected String html_url;
		protected String followers;
		protected int id;
			
		@Override
		public String toString() {
			return "Login: " + login + "\nUrl: " + url + "\nHtml_url: "
					+ html_url + "\nSeguidores: " + followers + "\nId=" + id
					+ "";
		}
		
		
	}//class Usuario
	
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		UsuarioGitHub app = new UsuarioGitHub();
	}
}//class UsuarioGitHub