package pandaqr.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String email;
	
	public Participant() {
		
	}
	public Participant(String email) {
		this.email = email;
	}
}
