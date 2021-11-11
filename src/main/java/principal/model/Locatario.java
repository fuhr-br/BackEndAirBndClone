package principal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Locatarios")
public class Locatario extends Pessoa {

	@OneToMany()	
	private List<Imovel> imoveis;

	public Locatario() {
		
	}
	
	public Locatario(String nome, Integer idade, Integer telefone, String email, String senha) {
		super(nome, idade, telefone, email, senha);
	}

	public List<Imovel> getImovel() {
		return imoveis;
	}

	public void AddImovel(Imovel imovel) {
		this.imoveis.add(imovel);
	}
	

}
