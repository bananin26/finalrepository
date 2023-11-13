package pe.edu.upc.aww.takemehome0_0.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.takemehome0_0.dtos.TripsDTO;
import pe.edu.upc.aww.takemehome0_0.dtos.TotalPurchasesByUserDTO;
import pe.edu.upc.aww.takemehome0_0.entities.Trips;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.ITripsService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Trips")
public class TripsController {
    @Autowired
    private ITripsService oR;

    @PostMapping
    public void register(@RequestBody TripsDTO dto){
        ModelMapper m = new ModelMapper();
        Trips t = m.map(dto, Trips.class);
        oR.insert(t);
    }

    @GetMapping
    public List<TripsDTO> to_list(){
        return oR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, TripsDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        oR.delete(id);
    }

    @GetMapping("/{id}")
    public TripsDTO to_listId(@PathVariable ("id") Integer id) {
        ModelMapper m = new ModelMapper();
        TripsDTO dto = m.map(oR.listId(id), TripsDTO.class);
        return dto;
    }

    @PostMapping("/search :)")
    public List<TripsDTO> search(@RequestParam("address") String destinationAddress){
        return oR.findByDestinationAddress(destinationAddress).stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, TripsDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/SumatoryPurchasesByUser")
    public List<TotalPurchasesByUserDTO> SumatoriaComprasPorUsuario() {
        List<String[]> lista =oR.totalPurchasesByPerson();
        List<TotalPurchasesByUserDTO> listaDTO= new ArrayList<>();
        for(String[] data:lista){
            TotalPurchasesByUserDTO dto= new TotalPurchasesByUserDTO();
            dto.setName(data[0]);
            dto.setTotalPurchases(Integer.parseInt(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
