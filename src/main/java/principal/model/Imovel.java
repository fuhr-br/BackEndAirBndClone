package principal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Imoveis")
@Builder(toBuilder = true)
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Imovel {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(Boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	public Long getTelefoneProprietario() {
		return telefoneProprietario;
	}

	public void setTelefoneProprietario(Long telefoneProprietario) {
		this.telefoneProprietario = telefoneProprietario;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public void setUf(String uf) {
		this.uf = uf;
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

	public Integer getCamaSolteiro() {
		return camaSolteiro;
	}

	public Integer getCamaCasal() {
		return camaCasal;
	}

	public Integer getQuartos() {
		return quartos;
	}

	public Double getValorDaDiaria() {
		return valorDaDiaria;
	}

	public String getCidade() {
		return cidade;
	}

	public int getNumero() {
		return numero;
	}

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

	public Imovel() {
	}

	public Imovel(Boolean arCondicionado, Integer camaSolteiro, Integer camaCasal, Integer quartos, String descricao,
			Double valorDaDiaria, Long telefoneProprietario, String cep, String cidade, String bairro, String uf,
			String rua, int numero, String complemento) {
		super();
		this.arCondicionado = arCondicionado;
		this.setCamaSolteiro(camaSolteiro);
		this.setCamaCasal(camaCasal);
		this.setQuartos(quartos);
		this.descricao = descricao;
		this.valorDaDiaria = valorDaDiaria;
		this.telefoneProprietario = telefoneProprietario;
		this.cep = cep;
		this.setCidade(cidade);
		this.bairro = bairro;
		this.uf = uf;
		this.rua = rua;
		this.setNumero(numero);
		this.complemento = complemento;
	}

	public Imovel(Boolean arCondicionado, Integer camaSolteiro, Integer camaCasal, Integer quartos, String descricao,
			String imagemURL, Double valorDaDiaria, Long telefoneProprietario, String cep, String cidade, String bairro,
			String uf, String rua, int numero, String complemento) {
		super();
		this.arCondicionado = arCondicionado;
		this.camaSolteiro = camaSolteiro;
		this.camaCasal = camaCasal;
		this.quartos = quartos;
		this.descricao = descricao;
		this.imagemURL = imagemURL;
		this.valorDaDiaria = valorDaDiaria;
		this.telefoneProprietario = telefoneProprietario;
		this.cep = cep;
		this.setCidade(cidade);
		this.bairro = bairro;
		this.uf = uf;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}
	

	private void setNumero(int numero2) {
		this.numero = numero2;
		
	}

	public void setCamaSolteiro(Integer camaSolteiro) {

		this.camaSolteiro = camaSolteiro < 0 ? 0 : camaSolteiro;

	}

	public void setCamaCasal(Integer camaCasal) {
		this.camaCasal = (camaCasal > 0) ? camaCasal : 0;

	}

	public void setQuartos(Integer quartos) {

		this.quartos = quartos < 0 ? 0 : quartos;
	}

	public void setValorDaDiaria(Double valorDaDiaria) {
		this.valorDaDiaria = valorDaDiaria;
	}

	public void setCidade(String cidade) {
		this.cidade = "Porto Alegre";
	}

}
