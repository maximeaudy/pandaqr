package pandaqr.repository;

import org.springframework.stereotype.Repository;
import pandaqr.modele.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public User find(Long roomId) {
        List<User> users = this.em.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", roomId)
                .getResultList();
        if(users.size() == 0)
            return null;
        return users.get(0);
    }
    public User find(String email) {
        List<User> users = this.em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        if(users.size() == 0)
            return null;
        return users.get(0);
    }
}
