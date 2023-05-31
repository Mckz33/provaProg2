package TestesUnitarios;

import java.sql.SQLException;
import java.util.Scanner;

import model.Contato;
import service.ContatoService;

public class DeletarPorIdTeste {

	public static void main(String[] args) {
		Contato contato = new Contato();
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Digite o ID para excluir: ");
			Integer id = input.nextInt();
			
			
			try {
				ContatoService contatoService = new ContatoService();
				contatoService.delete(id);

			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

	}

}
