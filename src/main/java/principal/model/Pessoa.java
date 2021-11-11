package principal.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.MappedSuperclass;

import principal.validacoes.ValidaEmail;

@MappedSuperclass
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(nullable = false, name = "Nome")
	protected String nome;
	@Column(nullable = false, name = "Idade")
	protected Integer idade;

	@Column(nullable = false, name = "Telefone")
	@Digits(fraction = 0, integer = 11)
	protected Integer telefone;

	@Column(nullable = false, name = "Email", unique = true)
	protected String email;
	@Column(nullable = false, name = "Senha")
	@JsonProperty(access = Access.WRITE_ONLY)
	protected String senha;

	public Pessoa() {
	}

	public Pessoa(String nome, Integer idade, Integer telefone, String email, String senha) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.id = null;
	}

	public Integer getTelephone() {
		return telefone;
	}

	public void setTelephone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = Objects.requireNonNull(email, "e-mail não deve ser nulo");
		if (!ValidaEmail.isNotEmpty.and(ValidaEmail.isEmail).test(email)) {
			throw new IllegalArgumentException("Formato de Email não é válido!");
		}
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

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", telefone=" + telefone + ", email="
				+ email + ", senha=" + senha + "]";
	}

}
