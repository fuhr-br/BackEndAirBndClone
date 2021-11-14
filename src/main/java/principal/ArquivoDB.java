package principal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name = "Arquivos")
public class ArquivoDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String nome;

	private String tipo;

	@Lob
	private byte[] data;

	public ArquivoDB() {
	}

	public ArquivoDB(String nome, String tipo, byte[] data) {
		this.nome = nome;
		this.tipo = tipo;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}


}