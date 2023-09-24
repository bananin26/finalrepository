package pe.edu.upc.aww.takemehome0_0.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aww.takemehome0_0.entities.Order;
import pe.edu.upc.aww.takemehome0_0.repositories.IOrderRepository;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.IOrderService;

import java.util.List;

@Service
public class OrderServiceImplement implements IOrderService {
    @Autowired
    private IOrderRepository oR;

    @Override
    public void insert(Order order) {
        oR.save(order);
    }

    @Override
    public List<Order> list() {
        return oR.findAll();
    }

    @Override
    public void delete(int idOrder) {
        oR.deleteById(idOrder);
    }

    @Override
    public Order listId(int idOrder) {
        return oR.findById(idOrder).orElse(new Order());
    }

    @Override
    public List<Order> findByDestinationAddress(String destinationAddress) {
        return oR.findByDestinationAddress(destinationAddress);
    }

    public List<String[]> totalPurchasesByPerson(){
        return oR.totalPurchasesByPerson();
    }

}
