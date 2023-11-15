package pe.edu.upc.aww.takemehome0_0.serviceinterfaces;

import pe.edu.upc.aww.takemehome0_0.entities.Trips;

import java.util.List;

public interface ITripsService {

    public void insert(Trips trips);
    public List<Trips> list();
    public void delete(int idTrips);
    public Trips listId(int idTrips);
    List<Trips> findByDestinationAddress(String destinationAddress);
    public List<String[]> totalTripsByPerson();


}
