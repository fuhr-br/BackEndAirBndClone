package principal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, name = "Cep")
    private String cep;
    
    @Column(nullable = false, name = "Rua")
    private String rua;
    
    @Column(nullable = false, name = "Numero")
    private int numero;
    
    @Column(nullable = false, name = "Complemento")
    private String complemento;

    public Endereco() {
    }

    public Endereco(String cep, String rua, int numero, String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + '}';
    }
}
