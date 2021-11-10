package principal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Locatarios")
public class Locatario extends Pessoa {
	
	
	@OneToMany
	@JoinColumn(name = "Imoveis_ID")
	private List<Imovel> Imovel;
	
	public Locatario() {}

}
