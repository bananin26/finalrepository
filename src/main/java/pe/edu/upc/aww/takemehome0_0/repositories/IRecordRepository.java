package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aww.takemehome0_0.entities.Record;

import java.util.List;

@Repository
public interface IRecordRepository extends JpaRepository<Record,Integer> {

    @Query(value="SELECT u.name, sum(r.points)\n" +
            "FROM users u inner join products p on u.id_user=p.id_user\n" +
            "inner join records r on p.id_product=r.product_id\n" +
            "group by u.name", nativeQuery = true)
    public List<String[]> countPointsProduct();
}
