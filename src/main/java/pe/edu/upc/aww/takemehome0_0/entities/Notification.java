package pe.edu.upc.aww.takemehome0_0.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;
    @Column(name = "title_notification",length = 45,nullable = false)
    private String title;
    @Column(name = "description",length = 100,nullable = false)
    private String description;
    @Column(name = "date",nullable = false)
    private LocalDate date;
    @Column(name = "viewed",nullable = false)
    private Boolean viewed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Notification(){
    }

    public Notification(int idNotification,String title, String description, LocalDate date, User user) {
        this.idNotification= idNotification;
        this.description=description;
        this.date=date;
        this.user=user;
        this.viewed=false;
        this.title=title;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getViewed() {
        return viewed;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
