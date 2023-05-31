package TestesUnitarios;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Contato;
import service.ContatoService;

public class BuscarPorLetraTeste {

	public static void main(String[] args) {
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
