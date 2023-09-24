package pe.edu.upc.aww.takemehome0_0.dtos;

import pe.edu.upc.aww.takemehome0_0.entities.User;

public class MessageDTO {
    private int idMessage;
    private String title;
    private String content;
    private User userSend;
    private User userReceives;

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
