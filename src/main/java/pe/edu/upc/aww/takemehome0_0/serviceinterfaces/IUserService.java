package pe.edu.upc.aww.takemehome0_0.serviceinterfaces;

import pe.edu.upc.aww.takemehome0_0.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {

    public void insert(User user);
    public List<User> list();
    public void delete(int idUser);
    public User listId(int idUser);
    List<User>findByBirthday(LocalDate birthday);
    Long counterUsers();

    public List<String[]> quantityMessageSendByPerson();
    public List<String[]> quantityMessageReceiveByPerson();
}
