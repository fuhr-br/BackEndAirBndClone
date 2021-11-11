package principal.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Clientes")
public class Cliente extends Pessoa {




	public Cliente(String nome, Integer idade, Integer i, String email, String senha) {
		super(nome, idade, i , email, senha);
	}

	@Override
	public String toString() {
		return "Cliente []";
	}
	
}
