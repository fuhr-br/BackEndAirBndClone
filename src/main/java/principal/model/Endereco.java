package principal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Enderecos")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "Cep")
	private String cep;
	
	@Column(nullable = false, name = "Cidade")
	private String cidade;
	
	@Column(nullable = false, name = "Bairro")
	private String bairro;
	
	@Column(nullable = false, name = "Uf")
	private String uf;

	@Column(nullable = false, name = "Rua", length = 150)
	private String rua;

	@Column(nullable = false, name = "Numero", length = 10)
	private int numero;

	@Column(nullable = false, name = "Complemento", length = 20)
	private String complemento;

	public Endereco() {
	}

	public Endereco(String cep, String cidade, String bairro, String uf, String rua, int numero, String complemento) {
		super();
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.uf = uf;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Long getId() {
		return id;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", cidade=" + cidade + ", bairro=" + bairro + ", uf=" + uf
				+ ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + "]";
	}

	
}
