package model;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(email, endereco, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
}
