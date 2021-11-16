package principal.model;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario extends Pessoa {



	public Usuario() {

	}

	public Usuario(String nome, Integer idade, Long telefone, String email, String senha) {
		super(nome, idade, telefone, email, senha);
	}




}
