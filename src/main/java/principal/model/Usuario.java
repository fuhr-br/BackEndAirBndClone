package principal.model;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario extends Pessoa {



	public Usuario() {

	}

	public Usuario(String nome, Integer idade, String telefone, String email, String senha) {
		super(nome, idade, telefone, email, senha);
	}

	public Usuario(String nome, Integer idade, String telefone, String email) {
		super(nome, idade, telefone, email);
	}


	






}
