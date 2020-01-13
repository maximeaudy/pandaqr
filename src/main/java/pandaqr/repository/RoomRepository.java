package pandaqr.repository;

import org.springframework.stereotype.Repository;
import pandaqr.modele.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.Date;
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
        List<Room> rooms = this.em.createQuery("select r from Room r left join r.bookings b where r.id = :id and b.end_time > current_date ", Room.class)
                .setParameter("id", roomId)
                .getResultList();
        if(rooms.size() == 0)
            return null;
        return rooms.get(0);
    }
    public Room find(String roomCode) {
        List<Room> rooms = this.em.createQuery("select r from Room r where r.code = :roomCode", Room.class)
                .setParameter("roomCode", roomCode)
                .getResultList();
        if(rooms.size() == 0)
            return null;
        return rooms.get(0);
    }
    public Room find(Long roomId, Date day) {
        Calendar endDay = Calendar.getInstance();
        endDay.setTime(day);
        endDay.add(Calendar.DAY_OF_MONTH, 1);
        List<Room> rooms = this.em.createQuery("select r from Room r left join r.bookings b where r.id = :id and b.start_time >= :day and b.start_time < :endDay", Room.class)
                .setParameter("id", roomId)
                .setParameter("day", day)
                .setParameter("endDay", endDay.getTime())
                .getResultList();
        if(rooms.size() == 0)
            return null;
        return rooms.get(0);
    }
}
