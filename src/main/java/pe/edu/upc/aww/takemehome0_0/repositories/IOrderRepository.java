package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.aww.takemehome0_0.entities.Order;
import pe.edu.upc.aww.takemehome0_0.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByDestinationAddress(String destinationAddress);

    @Query(value = "select u.name, count(o.id_order)\n" +
            "from users u inner join orders o\n" +
            "on u.id_user=o.id_user\n" +
            "group by u.name\t", nativeQuery = true)
    public List<String[]> totalPurchasesByPerson();
}
