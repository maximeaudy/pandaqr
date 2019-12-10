package pandaqr.repository;

import org.springframework.stereotype.Repository;
import pandaqr.modele.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Room> getRooms() {
        return em.createQuery("select r from Room r order by r.code", Room.class)
                .getResultList();
    }

    public Room find(Long roomId) {
        List<Room> rooms = this.em.createQuery("select r from Room r where r.id = :id", Room.class)
                .setParameter("id", roomId)
                .getResultList();
        if(rooms.size() == 0)
            return null;
        return rooms.get(0);
    }
}
