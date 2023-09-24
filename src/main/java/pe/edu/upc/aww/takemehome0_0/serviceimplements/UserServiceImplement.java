package pe.edu.upc.aww.takemehome0_0.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aww.takemehome0_0.entities.User;
import pe.edu.upc.aww.takemehome0_0.repositories.IUserRepository;
import pe.edu.upc.aww.takemehome0_0.serviceInterfaces.IUserService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImplement implements IUserService {

    @Autowired
    private IUserRepository uR;
    @Override
    public void insert(User user) {
        uR.save(user);
    }

    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int idUser) {
        uR.deleteById(idUser);
    }

    @Override
    public User listId(int idUser) {
        return uR.findById(idUser).orElse(new User());
    }

    @Override
    public List<User> findByBirthday(LocalDate birthday) {
        return uR.findByBirthday(birthday);
    }
    @Override
    public Long counterUsers() {
        return uR.countUsers();
    }

    @Override
    public List<String[]> quantityMessageSendByPerson(){
        return uR.quantityMessageSendByPerson();
    }

    @Override
    public List<String[]> quantityMessageReceiveByPerson(){
        return uR.quantityMessageReceiveByPerson();
    }
}
