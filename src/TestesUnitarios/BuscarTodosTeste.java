package TestesUnitarios;

import java.sql.SQLException;

import model.Contato;
import service.ContatoService;

public class BuscarTodosTeste {

	public static void main(String[] args) {
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
}
