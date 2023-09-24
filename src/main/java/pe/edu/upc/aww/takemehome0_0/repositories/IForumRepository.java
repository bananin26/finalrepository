package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.aww.takemehome0_0.entities.Forum;

import java.time.LocalDate;
import java.util.List;

public interface IForumRepository extends JpaRepository<Forum,Integer> {
    List<Forum> findByDate(LocalDate date);
}
