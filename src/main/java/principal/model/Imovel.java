package principal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name = "Piscina", nullable = false)
	private Boolean piscina;
	@Column(name = "Qnt_Quartos", nullable = false)
	private Integer quartos;
	@Column(name = "Descricao", nullable = false)
	private String descricao;

	@Column(name = "Tipo")
	@Enumerated(EnumType.STRING)
	private ImovelTipo tipo;

	@OneToOne
	@JoinColumn()
	private Endereco endereco;

	@ManyToOne()
	//@JoinColumn(name = "Locatario_ID", nullable = false)
	private Locatario locatario;

	public Imovel() {
	}

	public Imovel(Boolean arCondicionado, Integer camaSolteiro, Integer camaCasal, Boolean piscina, Integer quartos,
			String descricao, ImovelTipo tipo, Endereco endereco, Locatario locatario) {
		super();
		this.arCondicionado = arCondicionado;
		this.camaSolteiro = camaSolteiro;
		this.camaCasal = camaCasal;
		this.piscina = piscina;
		this.quartos = quartos;
		this.descricao = descricao;
		this.tipo = tipo;
		this.endereco = endereco;
		this.locatario = locatario;
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

	public Boolean getPiscina() {
		return piscina;
	}

	public void setPiscina(Boolean piscina) {
		this.piscina = piscina;
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

	public ImovelTipo getTipo() {
		return tipo;
	}

	public void setTipo(ImovelTipo tipo) {
		this.tipo = tipo;
	}

	public Locatario getLocatario() {
		return locatario;
	}

	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}

	public Long getId() {
		return id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Imovel [id=" + id + ", arCondicionado=" + arCondicionado + ", camaSolteiro=" + camaSolteiro
				+ ", camaCasal=" + camaCasal + ", piscina=" + piscina + ", quartos=" + quartos + ", descricao="
				+ descricao + ", tipo=" + tipo + ", endereco=" + endereco + ", locatario=" + locatario + "]";
	}

}
