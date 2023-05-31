package app;

import java.util.Scanner;

import controller.ContatoController;

public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ContatoController contatoController = new ContatoController();
		
		System.out.println("Bem vindo ao Banco de dados\n"
				+ "1- Para criar um novo contato\n"
				+ "2- Para deletar um contato existente por ID\n"
				+ "3- Para buscar um contato por ID\n"
				+ "4- Para buscar todos os contatos\n"
				+ "5- Para Atualizar um contato\n"
				+ "6- Para Buscar por Letra");
		
		int number = input.nextInt();
		switch(number) {
			case 1: {
				contatoController.create();
				break;
			} case 2: {
				contatoController.delete();
				break;
			} case 3: {
				contatoController.findById();
				break;
			} case 4: {
				contatoController.getAll();
				break;
			} case 5: {
				contatoController.update();
				break;
			} case 6: {
				contatoController.findByFirstLetter();
				break;
			}
		}	
	}
}
