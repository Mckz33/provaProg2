package TestesUnitarios;

import java.sql.SQLException;
import java.util.Scanner;

import model.Contato;
import service.ContatoService;

public class CriarTeste {

	public static void main(String[] args) {
		Contato contato = new Contato();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nome: ");
		String nome = input.nextLine();
		contato.setNome(nome);
		
		System.out.print("Email: ");
		String email = input.nextLine();
		contato.setEmail(email);
		
		System.out.print("Endereço: ");
		String endereco = input.nextLine();
		contato.setEndereco(endereco);
		input.close();

		try {
			ContatoService contatoService = new ContatoService();
			contatoService.create(contato);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
