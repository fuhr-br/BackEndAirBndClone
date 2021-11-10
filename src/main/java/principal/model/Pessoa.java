package principal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
		@Id
		@GeneratedValue()
		private Long id;
		
		private String nome;
		
		private Integer idade;
		
	
			
}
