package TestesUnitarios;

import java.sql.SQLException;
import java.util.Scanner;

import service.ContatoService;

public class AtualizarTeste {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o ID: ");
		int id = input.nextInt();
		
		try {
			ContatoService contatoService = new ContatoService();
			if (contatoService.exists(id)) {
				System.out.println("ID encontrado!");
				while(true) {
					input.nextLine();
					System.out.print("Digite o NOVO nome: ");
					String nome = input.nextLine();
					System.out.print("Digite o NOVO email: ");
					String email = input.nextLine();
					System.out.print("Digite o NOVO endereco: ");
					String endereco = input.nextLine();
					
					contatoService.update(id, nome, email, endereco);
					System.out.println("Atualizado com sucesso!");
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
