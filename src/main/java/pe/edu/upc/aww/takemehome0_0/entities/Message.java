package pe.edu.upc.aww.takemehome0_0.entities;


import javax.persistence.*;

@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;

    @Column(name = "title", length = 45, nullable = false)
    private String title;

    @Column(name = "content", length = 100, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_send_id")
    private User userSend;
    @ManyToOne
    @JoinColumn(name = "user_receives_id")
    private User userReceives;

    public Message(int idMessage, String title, String content, User userSend, User userReceives) {
        this.idMessage = idMessage;
        this.title = title;
        this.content = content;
        this.userSend = userSend;
        this.userReceives = userReceives;
    }

    public Message() {
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserSend() {
        return userSend;
    }

    public void setUserSend(User userSend) {
        this.userSend = userSend;
    }

    public User getUserReceives() {
        return userReceives;
    }

    public void setUserReceives(User userReceives) {
        this.userReceives = userReceives;
    }



}
