package principal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

@Entity
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name = "Nome")
	private String nome;
	@Column(nullable = false, name = "Idade")
	private Integer idade;

	@Column(nullable = false, name = "Telefone")
	@Digits(fraction = 0, integer = 11)
	private String telephone;
	
	@Column(nullable = false, name = "Email")
	private String email;
	@Column(nullable = false, name = "Senha")
	private String senha;

	public Pessoa() {
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}
	
	

}
