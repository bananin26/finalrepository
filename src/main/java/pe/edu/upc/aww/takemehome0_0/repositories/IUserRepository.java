package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.aww.takemehome0_0.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer> {
    List<User> findByBirthday(LocalDate birthday);
    public User findByUsername(String username);

    @Query("SELECT COUNT(t) FROM User t")
    Long countUsers();

    @Query(value="select u.name, count(m.id_message)\n" +
            "\n" +
            "  from users u inner join message m \n" +
            "\n" +
            "  on u.id_user=m.user_send_id\n" +
            "\n" +
            "  group by u.name", nativeQuery = true)
    public List<String[]> quantityMessageSendByPerson();

    @Query(value="select u.name, count(m.id_message)\n" +
            "\n" +
            "  from users u inner join message m \n" +
            "\n" +
            "  on u.id_user=m.user_receives_id\n" +
            "\n" +
            "  group by u.name", nativeQuery = true)
    public List<String[]> quantityMessageReceiveByPerson();

}
