package pandaqr.modele;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    private Long id;
    private String nom;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
