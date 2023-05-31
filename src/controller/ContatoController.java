package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Contato;
import service.ContatoService;

public class ContatoController {
	
	public static void create() {
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

	public static void delete() {
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

	public static void findById() {
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

	public static void getAll() {
		try {
			ContatoService contatoService = new ContatoService();
			
			for (Contato contato : contatoService.getAll()) {
				System.out.println("----------------------------------");
				System.out.println("Nome: "+contato.getNome()); 
				System.out.println("Email: "+contato.getEmail()); 
				System.out.println("Endereço: "+contato.getEndereco()); 
				System.out.println("----------------------------------");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update() {
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

	public static void findByFirstLetter() {
	    Scanner input = new Scanner(System.in);

	    System.out.print("Digite um caractere: ");
	    String letra = input.next();

	    ContatoService contatoService;
		try {
	        if (letra.length() == 1) {
	            char caractere = letra.charAt(0);
	            System.out.println("O caractere digitado foi: " + caractere);
	            contatoService = new ContatoService();
	            List<Contato> contatos = contatoService.findByFirstLetter(caractere);
		        for (Contato contato : contatos) {
		            System.out.println("Nome: " + contato.getNome());
		            System.out.println("Email: " + contato.getEmail());
		            System.out.println("Endereço: " + contato.getEndereco());
		            System.out.println();
		        }
	        } else {
	            System.out.println("Entrada inválida. Digite apenas um caractere.");
	        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
