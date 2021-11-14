package principal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import principal.ArquivoDB;

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

	@Column(name = "Tipo")
	@Enumerated(EnumType.STRING)
	private ImovelTipo tipo;

	@OneToOne
	@JoinColumn()
	private Endereco endereco;
	
	@OneToMany
	@JoinColumn()
	private List<ArquivoDB> imagem;

	@ManyToOne()
	@JoinColumn(name = "Locatario_ID", nullable = false)
	private Usuario usuario;

	public Imovel() {
	}

	public Imovel(Boolean arCondicionado, Integer camaSolteiro, Integer camaCasal, Integer quartos,
			String descricao, ImovelTipo tipo, Endereco endereco, Usuario usuario) {
		super();
		this.arCondicionado = arCondicionado;
		this.camaSolteiro = camaSolteiro;
		this.camaCasal = camaCasal;
		this.quartos = quartos;
		this.descricao = descricao;
		this.tipo = tipo;
		this.endereco = endereco;
		this.usuario = usuario;
		this.imagem=null;
	}
	
	public Imovel(Boolean arCondicionado, Integer camaSolteiro, Integer camaCasal, Integer quartos, String descricao,
			ImovelTipo tipo, Endereco endereco, List<ArquivoDB> imagem, Usuario usuario) {
		super();
		this.arCondicionado = arCondicionado;
		this.camaSolteiro = camaSolteiro;
		this.camaCasal = camaCasal;
		this.quartos = quartos;
		this.descricao = descricao;
		this.tipo = tipo;
		this.endereco = endereco;
		this.imagem = imagem;
		this.usuario = usuario;
	}
	
	

	public Imovel(Boolean arCondicionado, Integer camaSolteiro, Integer camaCasal, Integer quartos,
			String descricao, ImovelTipo tipo, Endereco endereco, ArquivoDB imagem, Usuario usuario) {
		super();
		this.arCondicionado = arCondicionado;
		this.camaSolteiro = camaSolteiro;
		this.camaCasal = camaCasal;
		this.quartos = quartos;
		this.descricao = descricao;
		this.tipo = tipo;
		this.endereco = endereco;
		this.imagem.add(imagem);
		this.usuario = usuario;
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

	public ImovelTipo getTipo() {
		return tipo;
	}

	public void setTipo(ImovelTipo tipo) {
		this.tipo = tipo;
	}

	public Usuario getLocatario() {
		return usuario;
	}

	public void setLocatario(Usuario usuario) {
		this.usuario = usuario;
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
				+ ", camaCasal=" + camaCasal + ", quartos=" + quartos + ", descricao=" + descricao + ", tipo=" + tipo
				+ ", endereco=" + endereco + ", locatario=" + usuario + "]";
	}

	

}
