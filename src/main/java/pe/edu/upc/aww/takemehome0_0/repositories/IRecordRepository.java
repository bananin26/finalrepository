package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aww.takemehome0_0.entities.Record;

import java.util.List;

@Repository
public interface IRecordRepository extends JpaRepository<Record,Integer> {

    @Query(value="select u.name, SUM(r.points)\n" +
            "from users u inner join orders o on u.id_user=o.id_user\n" +
            "inner join products pr on o.id_order=pr.id_order\n" +
            "inner join records r on pr.id_product=r.product_id\n" +
            "GROUP BY u.name", nativeQuery = true)
    public List<String[]> countPointsProduct();


}
