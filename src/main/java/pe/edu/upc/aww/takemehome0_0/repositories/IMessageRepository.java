package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.aww.takemehome0_0.entities.Message;

public interface IMessageRepository extends JpaRepository<Message,Integer> {
}
