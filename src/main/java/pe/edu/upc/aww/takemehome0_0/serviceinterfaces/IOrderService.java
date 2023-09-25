package pe.edu.upc.aww.takemehome0_0.serviceinterfaces;

import pe.edu.upc.aww.takemehome0_0.entities.Order;

import java.util.List;

public interface IOrderService {

    public void insert(Order order);
    public List<Order> list();
    public void delete(int idOrder);
    public Order listId(int idOrder);
    List<Order> findByDestinationAddress(String destinationAddress);
    public List<String[]> totalPurchasesByPerson();

}
