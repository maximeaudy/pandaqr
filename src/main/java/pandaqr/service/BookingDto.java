package pandaqr.service;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookingDto {
	
	@NotNull(message = "Vous devez renseigner la date du début de la réservation !")
	@Size(min = 1, message = "Vous devez renseigner un nom pour la réservation !")
	private String start_date;
	@NotNull(message = "Vous devez renseigner l'heure du début de la réservation !")
	@Size(min = 1, message = "Vous devez renseigner un nom pour la réservation !")
	private String start_time;

	@NotNull(message = "Vous devez renseigner la date de fin de la réservation !")
	@Size(min = 1, message = "Vous devez renseigner un nom pour la réservation !")
	private String end_date;
	@NotNull(message = "Vous devez renseigner l'heure de fin de la réservation !")
	@Size(min = 1, message = "Vous devez renseigner un nom pour la réservation !")
	private String end_time;

	@NotNull(message = "Vous devez renseigner un nom pour la réservation !")
	@Size(min = 1, message = "Vous devez renseigner un nom pour la réservation !")
	private String name;

	@NotNull(message = "Vous devez renseigner une description pour la réservation !")
	@Size(min = 1, message= "Vous devez renseigner une description pour la réservation !")
	private String description;
	
	private String participants;

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
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

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	/*
	public boolean participantsFormatValidated(String participants) {
		return false;
	}
	*/

}
