package pe.edu.upc.aww.takemehome0_0.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idForum;

    @Column(name = "forum", length = 100, nullable = false)
    private String forum;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User idUser;

    public Forum(int idForum, String forum, LocalDate date, User idUser) {
        this.idForum = idForum;
        this.forum = forum;
        this.date = date;
        this.idUser = idUser;
    }

    public Forum(){

    }

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
