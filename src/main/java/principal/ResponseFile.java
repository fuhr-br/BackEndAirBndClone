package principal;

public class ResponseFile {
	private String nome;
	private String url;
	private String tipo;
	private long tam;

	public ResponseFile(String nome, String url, String tipo, long tam) {
		this.nome = nome;
		this.url = url;
		this.tipo = tipo;
		this.tam = tam;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getTamanho() {
		return tam;
	}

	public void setTamanho(long tam) {
		this.tam = tam;
	}
}