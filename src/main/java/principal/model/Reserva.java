package principal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reserva {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    @ManyToOne
    @JoinColumn(name = "Imovel_id")
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "Cliente_id")
    private Cliente cliente;
    
    public Reserva() {}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public Cliente getCliente() {
		return cliente;
	}
    
    

}