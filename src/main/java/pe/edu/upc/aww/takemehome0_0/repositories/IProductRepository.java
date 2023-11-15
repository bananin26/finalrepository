package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.aww.takemehome0_0.entities.Product;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    List<Product>findByNameProduct(String nameProduct);

    @Query(value="SELECT u.name, count(p.id_product)\n" +
            "FROM products p inner join users u\n" +
            "on p.id_user=u.id_user\n" +
            "group by u.name", nativeQuery = true)
    public List<String[]> countProductsWithUsers();
    @Query("SELECT o.idTrips, p.descriptionProduct\n" +
            "FROM Trips o INNER JOIN Product p \n" +
            "ON o.idTrips = p.idProduct\n" +
            "ORDER BY p.idProduct")
    public List<String []>showDescriptionPerOrder();

    @Query(value="SELECT p.name_product, p.price_product\n" +
            "FROM products p\n" +
            "Where p.price_product > 1000", nativeQuery = true)
    public List<String []>listPricesGreaterThan1000();


}
