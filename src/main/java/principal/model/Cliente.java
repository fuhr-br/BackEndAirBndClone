package principal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente extends Pessoa {

	public Cliente() {
	}

	public Cliente(String nome, Integer idade, Integer telefone, String email, String senha) {
		super(nome, idade, telefone, email, senha);
	}

	@Override
	public String toString() {
		return "Cliente id=" + id + ", nome=" + nome + ", idade=" + idade + ", telefone=" + telefone + ", email="
				+ email + ", senha=" + senha;
	}

}
