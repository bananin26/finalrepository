package pe.edu.upc.aww.takemehome0_0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.aww.takemehome0_0.entities.Product;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    List<Product>findByNameProduct(String nameProduct);

    @Query("select u.name, sum(p.idProduct)\n" +
            "from User u inner join Product p\n" +
            "on u.id=p.idProduct \n" +
            "group by u.name")
    public List<String[]> countProductsWithUsers();
    @Query("SELECT o.idOrder, p.descriptionProduct\n" +
            "FROM Order o INNER JOIN Product p \n" +
            "ON o.idOrder = p.idProduct\n" +
            "ORDER BY p.idProduct")
    public List<String []>showDescriptionPerOrder();

    @Query(value="SELECT p.name_product, p.price_product\n" +
            "FROM products p\n" +
            "Where p.price_product > 1000", nativeQuery = true)
    public List<String []>listPricesGreaterThan1000();


}
