package principal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Enderecos")
public class Endereco  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    

    private String cep;

    private String rua;
    

    private int numero;

    private String complemento;

    public Endereco() {
    }

    public Endereco(String cep, String rua, int numero, String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.id= null;
    }
    

    public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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

	public int getNumero() {
		return numero;
	}

	@Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + '}';
    }
}
