package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contato;
import repository.ConnectionFactory;

public class ContatoService {
	private Connection con;
	
	public ContatoService() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}

	public void create(Contato contato) throws SQLException {
		String sql = "INSERT INTO contatos (nome, endereco, email) VALUES (?,?,?)";
		PreparedStatement stmt =  con.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEndereco());
		stmt.setString(3, contato.getEmail());
		stmt.execute();
		stmt.close();
		System.out.println("Inserido com sucesso!");
		this.con.close();
	}
	
	public void delete(Integer id) throws SQLException {
		String sql = "DELETE FROM contatos WHERE contatos.id = ?";
		PreparedStatement stmt =  con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		System.out.println("Deletado com sucesso!");
		con.close();
	}
	
	public Boolean exists(int id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contato contato = null;
        
        String sql = "SELECT * FROM contatos WHERE id = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        
        if (rs.next()) {
			return true;
		}
        return null;
	}
	
	public boolean update(int id, String novoNome, String novoEmail, String novoEndereco) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contato contato = null;

        try {
            String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, novoNome);
            stmt.setString(2, novoEmail);
            stmt.setString(3, novoEndereco);
            stmt.setInt(4, id);

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	public List<Contato> findByFirstLetter(char letra) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Contato> contatos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM contatos WHERE nome LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, letra + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");

                Contato contato = new Contato();
                contatos.add(contato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contatos;
	}
	
    public Contato findById(int id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contato contato = null;

        try {
   
            String sql = "SELECT * FROM contatos WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
            	contato = new Contato();
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        stmt.close();
        rs.close();
        this.con.close();
		return contato;
        
    }
	
	public List<Contato> getAll() throws SQLException {
		String sql = "SELECT * FROM contatos";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Contato> contatos = new ArrayList<Contato>();
		while (rs.next()) {
			Contato contato = new Contato();
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contatos.add(contato);
		}
		System.out.println("Consulta realizada com sucesso!");
		stmt.close();
		rs.close();
		con.close();
		
		return contatos;
	}
}
