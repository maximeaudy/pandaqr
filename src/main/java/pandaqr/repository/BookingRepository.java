package pandaqr.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import pandaqr.modele.Booking;

@Repository
public class BookingRepository {
	
	@PersistenceContext
	private EntityManager em;

	public void save(Booking booking) {
		em.persist(booking);
	}
	
}
