package principal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario extends Pessoa {

	@OneToMany()
	private List<Imovel> imoveis;

	public Usuario() {

	}

	public Usuario(String nome, Integer idade, Integer telefone, String email, String senha) {
		super(nome, idade, telefone, email, senha);
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	public void AddImovel(Imovel imovel) {
		this.imoveis.add(imovel);
	}


}
