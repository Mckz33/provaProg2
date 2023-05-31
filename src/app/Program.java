package app;

import java.sql.SQLException;
import java.util.Scanner;

import controller.ContatoController;

public class Program {
	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		ContatoController contatoController = new ContatoController();
		Boolean sair = false;
		
		while(!sair) {
			System.out.println("================Bem vindo ao Banco de dados================\n"
					+ "1- Para criar um novo contato\n"
					+ "2- Para deletar um contato existente por ID\n"
					+ "3- Para buscar um contato por ID\n"
					+ "4- Para buscar todos os contatos\n"
					+ "5- Para Atualizar um contato\n"
					+ "6- Para Buscar por Letra\n"
					+ "S- Para Encerrar!");
			
			System.out.print("Digite uma opção: ");
			String op = input.next();
			
			switch(op.toLowerCase()) {
				case "1": {
					contatoController.create();
					System.out.println("\n===========================================================");
					break;
				} case "2": {
					contatoController.delete();//BIXADO
					System.out.println("\n===========================================================");
					break;
				} case "3": {
					contatoController.findById();
					System.out.println("\n===========================================================");
					break;
				} case "4": {
					contatoController.getAll();
					System.out.println("\n===========================================================");
					break;
				} case "5": {
					contatoController.update();
					System.out.println("\n===========================================================");
					break;
				} case "6": {
					contatoController.findByFirstLetter();
					System.out.println("\n===========================================================");
					break;
				} case "s": {
					System.out.println("\nPrograma encerrado!");
					sair = true;
					System.out.println("\n===========================================================");
					break;
					
					
				}
			}
		}
	}
}
