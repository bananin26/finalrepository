package pe.edu.upc.aww.takemehome0_0.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = { "id_user", "rol"}) })
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rol;
    @ManyToOne
    @JoinColumn(name="id_user", nullable=false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
