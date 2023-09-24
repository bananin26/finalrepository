package pe.edu.upc.aww.takemehome0_0.serviceinterfaces;

import pe.edu.upc.aww.takemehome0_0.entities.Message;

import java.util.List;

public interface IMessageService {
    public void insert(Message message);
    public List<Message> list();
    public Message listId(int idMessage);
    public void delete(int idMessage);
}
