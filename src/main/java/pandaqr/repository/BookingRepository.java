package pandaqr.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import pandaqr.modele.Booking;
import pandaqr.modele.Room;

@Repository
public class BookingRepository {
	
	@PersistenceContext
	private EntityManager em;

	public void save(Booking booking) {
		em.persist(booking);
	}

    public boolean bookingExist(Long roomId, Date start_time, Date end_time) {
		List<Booking> bookings = this.em.createQuery("select b from Booking b left join b.room r where r.id = :id and b.start_time < :day and b.end_time > :day", Booking.class)
				.setParameter("id", roomId)
				.setParameter("day", start_time)
				.getResultList();
		if(bookings.size() > 0)
			return true;

		bookings = this.em.createQuery("select b from Booking b left join b.room r where r.id = :id and b.start_time < :day and b.end_time > :day", Booking.class)
				.setParameter("id", roomId)
				.setParameter("day", end_time)
				.getResultList();
		return bookings.size() != 0;
	}
}
