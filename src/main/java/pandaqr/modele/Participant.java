package pandaqr.modele;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String email;
    @ManyToOne
    private Booking booking;

    public Participant(String email) {
        this.email = email;
    }

    public Participant(String email, Booking booking) {
        this.email = email;
        this.booking = booking;
    }

    public Participant() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
