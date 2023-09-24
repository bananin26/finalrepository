package pe.edu.upc.aww.takemehome0_0.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.takemehome0_0.dtos.MessageByUserDTO;
import pe.edu.upc.aww.takemehome0_0.dtos.UserDTO;
import pe.edu.upc.aww.takemehome0_0.entities.User;
import pe.edu.upc.aww.takemehome0_0.serviceInterfaces.IUserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private IUserService uS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void register(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        User u= m.map(dto, User.class);
        uS.insert(u);
    }

    /*@GetMapping
    public List<UserDTO> to_list(){
        return uS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,UserDTO.class);
        }).collect(Collectors.toList());
    }*/

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Integer id){
        uS.delete(id);
    }
    @GetMapping("/{id}")
    public UserDTO to_listId(@PathVariable ("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listId(id),UserDTO.class);
        return dto;
    }

    @PostMapping("/search :)")
    public List<UserDTO> search(@RequestBody LocalDate date){
        return uS.findByBirthday(date).stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,UserDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void change(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        User p = m.map(dto,User.class);
        uS.insert(p);
    }

    @GetMapping("/counter")
    public Long counter() {
        return uS.counterUsers();
    }

    @GetMapping("/QuantityMessageSendByUser")
    public List<MessageByUserDTO> cantidadMensajesEnviadosPorPersona() {
        List<String[]> lista=uS.quantityMessageSendByPerson();
        List<MessageByUserDTO> listaDTO= new ArrayList<>();
        for(String[] data:lista){
            MessageByUserDTO dto= new MessageByUserDTO();
            dto.setName(data[0]);
            dto.setQuantityMessage(Integer.parseInt(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/QuantityMessageReceiveByUser")
    public List<MessageByUserDTO> cantidadMensajesRecibidosPorPersona() {
        List<String[]> lista=uS.quantityMessageReceiveByPerson();
        List<MessageByUserDTO> listaDTO= new ArrayList<>();
        for(String[] data:lista){
            MessageByUserDTO dto= new MessageByUserDTO();
            dto.setName(data[0]);
            dto.setQuantityMessage(Integer.parseInt(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping
    @PreAuthorize("hasAuthority('OWNER')")
    public List<UserDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,UserDTO.class);
        }).collect(Collectors.toList());
    }
}
