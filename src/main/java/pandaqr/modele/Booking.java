package pandaqr.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String description;
	@NotNull
	private String name;
	private Date booking_date;
	@NotNull
	private Date start_time;
	@NotNull
	private Date end_time;
	@OneToOne
	private Room room;
	@ManyToOne
	private User user;
	@OneToMany(fetch = FetchType.EAGER) @Cascade(CascadeType.PERSIST)
    @JoinColumn(name = "booking_id")
	private List<Participant> participants;

	public Booking() {

	}

	public Booking(Date start_time, Date end_time, String name, String description) {
		this.description = description;
		this.name = name;
		this.booking_date = new Date();
		this.start_time = start_time;
		this.end_time = end_time;
		this.participants = new ArrayList<Participant>();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
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
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	/*public void addParticipant(String participant) {
		//Participant participant = new Participant();
		this.participants.add(participant);
	}*/

}
