package principal.model;

import java.util.Objects;

import principal.validacoes.ValidaEmail;

public class DadosDeLogin {

	private String email;

	private String senha;

	public DadosDeLogin() {
	}

	public DadosDeLogin(String email, String senha) {
		this.setEmail(email);
		this.senha = senha;
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

}
