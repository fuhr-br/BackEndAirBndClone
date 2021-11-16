package principal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Imoveis")
public class Imovel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "Ar_Condicionado", nullable = false)
	private Boolean arCondicionado;
	@Column(name = "Qnt_Cama_Solteiro", nullable = false)
	private Integer camaSolteiro;
	@Column(name = "Qnt_Cama_Casal", nullable = false)
	private Integer camaCasal;
	@Column(name = "Qnt_Quartos", nullable = false)
	private Integer quartos;
	@Column(name = "Descricao", nullable = false)
	private String descricao;
	@Column(name = "ImagemURL")
	private String imagemURL;
	@Column(name = "ValorDiaria", nullable = false)
	private Double valorDaDiaria;
	@Column(name = "Tel_Proprietario", nullable = false)
	private Long telefoneProprietario;

	@OneToOne
	@JoinColumn()
	private Endereco endereco;

	public Imovel() {
	}

	public Imovel(Boolean arCondicionado, Integer camaSolteiro, Integer camaCasal, Integer quartos, String descricao,
			String imagemURL, Double valorDaDiaria, Long telefoneProprietario, Endereco endereco) {
		super();
		this.arCondicionado = arCondicionado;
		this.camaSolteiro = camaSolteiro;
		this.camaCasal = camaCasal;
		this.quartos = quartos;
		this.descricao = descricao;
		this.imagemURL = imagemURL;
		this.valorDaDiaria = valorDaDiaria;
		this.telefoneProprietario = telefoneProprietario;
		this.endereco = endereco;
	}

	public Imovel(Boolean arCondicionado, Integer camaSolteiro, Integer camaCasal, Integer quartos, String descricao,
			Double valorDaDiaria, Long telefoneProprietario, Endereco endereco) {
		super();
		this.arCondicionado = arCondicionado;
		this.camaSolteiro = camaSolteiro;
		this.camaCasal = camaCasal;
		this.quartos = quartos;
		this.descricao = descricao;
		this.valorDaDiaria = valorDaDiaria;
		this.telefoneProprietario = telefoneProprietario;
		this.endereco = endereco;
	}

	public Boolean getArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(Boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public Integer getCamaSolteiro() {
		return camaSolteiro;
	}

	public void setCamaSolteiro(Integer camaSolteiro) {
		this.camaSolteiro = camaSolteiro;
	}

	public Integer getCamaCasal() {
		return camaCasal;
	}

	public void setCamaCasal(Integer camaCasal) {
		this.camaCasal = camaCasal;
	}

	public Integer getQuartos() {
		return quartos;
	}

	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTelefoneProprietario() {
		return telefoneProprietario;
	}

	public void setTelefoneProprietario(Long telefoneProprietario) {
		this.telefoneProprietario = telefoneProprietario;
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	public Double getValorDaDiaria() {
		return valorDaDiaria;
	}

	public void setValorDaDiaria(Double valorDaDiaria) {
		this.valorDaDiaria = valorDaDiaria;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

}
