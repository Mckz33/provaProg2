package TestesUnitarios;

import java.sql.SQLException;
import java.util.Scanner;

import model.Contato;
import service.ContatoService;

public class BuscarPorIdTeste {

	public static void main(String[] args) {
Scanner input = new Scanner(System.in);
		
		System.out.print("Digite o ID: ");
		Integer id = input.nextInt();
		
		try {
			ContatoService contatoService = new ContatoService();
			Contato contato = contatoService.findById(id);
			
			if (contato != null) {
		        System.out.println("------Contato encontrado------");
	            System.out.println("   Nome: " + contato.getNome());
	            System.out.println("   Email: " + contato.getEmail());
	            System.out.println("   Endereço: " + contato.getEndereco());
	            System.out.println("------------------------------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
