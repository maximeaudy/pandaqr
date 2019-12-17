package pandaqr.service;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookingDto {
	
	@NotNull(message = "Vous devez renseigner la date du début de la réservation !")
	private Date start_time;

	@NotNull(message = "Vous devez renseigner la date de fin de la réservation !")
	private Date end_time;
	
	@NotNull(message = "Vous devez renseigner un nom pour la réservation !")
	@Size(min = 1, message = "Vous devez renseigner un nom pour la réservation !")
	private String name;

	@NotNull(message = "Vous devez renseigner une description pour la réservation !")
	@Min(value = 1, message= "Vous devez renseigner une description pour la réservation !")
	private String description;
	
	private String participants;

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}
	/*
	public boolean participantsFormatValidated(String participants) {
		return false;
	}
	*/

}
