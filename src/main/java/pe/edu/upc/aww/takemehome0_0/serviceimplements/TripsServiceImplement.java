package pe.edu.upc.aww.takemehome0_0.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aww.takemehome0_0.entities.Trips;
import pe.edu.upc.aww.takemehome0_0.repositories.ITripsRepository;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.ITripsService;

import java.util.List;

@Service
public class TripsServiceImplement implements ITripsService {
    @Autowired
    private ITripsRepository oR;

    @Override
    public void insert(Trips trips) {
        oR.save(trips);
    }

    @Override
    public List<Trips> list() {
        return oR.findAll();
    }

    @Override
    public void delete(int idTrips) {
        oR.deleteById(idTrips);
    }

    @Override
    public Trips listId(int idTrips) {
        return oR.findById(idTrips).orElse(new Trips());
    }

    @Override
    public List<Trips> findByDestinationAddress(String destinationAddress) {
        return oR.findByDestinationAddress(destinationAddress);
    }

    public List<String[]> totalPurchasesByPerson(){
        return oR.totalPurchasesByPerson();
    }

}
