package pandaqr.modele;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
    private Long id;
    private String code;
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
