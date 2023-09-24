package pe.edu.upc.aww.takemehome0_0.serviceinterfaces;

import pe.edu.upc.aww.takemehome0_0.entities.Product;

import java.util.List;

public interface IProductService {
    public void insert(Product product);
    public List<Product> list();
    public void delete(int idProduct);
    public Product listId(int idOrder);
    List<Product>findByNameProduct(String nameProduct);
    public List<String[]> counterProductsForUsers();
    public List<String []>showDescriptionPerOrder();
    public List<String[]>listPricesGreaterThan1000();
}
