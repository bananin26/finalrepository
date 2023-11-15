package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.aww.takemehome0_0.entities.Trips;

import java.util.List;

public interface ITripsRepository extends JpaRepository<Trips,Integer> {
    List<Trips> findByDestinationAddress(String destinationAddress);

    @Query(value = "select u.name, count(t.id_trips)\n" +
            "from users u inner join trips t\n" +
            "on u.id_user=t.id_user\n" +
            "group by u.name\t", nativeQuery = true)
    public List<String[]> totalPurchasesByPerson();
}
