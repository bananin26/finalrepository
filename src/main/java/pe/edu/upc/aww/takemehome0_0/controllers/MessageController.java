package pe.edu.upc.aww.takemehome0_0.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.takemehome0_0.dtos.MessageDTO;
import pe.edu.upc.aww.takemehome0_0.entities.Message;
import pe.edu.upc.aww.takemehome0_0.serviceInterfaces.IMessageService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Message")
public class MessageController {

    @Autowired
    private IMessageService mS;

    @PostMapping
    public void register(@RequestBody MessageDTO dto){
        ModelMapper m = new ModelMapper();
        Message c= m.map(dto, Message.class);
        mS.insert(c);
    }
    @GetMapping
    public List<MessageDTO> to_list(){
        return mS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,MessageDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        mS.delete(id);
    }

    @GetMapping("/{id}")
    public MessageDTO to_listId(@PathVariable ("id") Integer id) {
        ModelMapper m = new ModelMapper();
        MessageDTO dto = m.map(mS.listId(id),MessageDTO.class);
        return dto;
    }
    @PutMapping
    public void change(@RequestBody MessageDTO dto){
        ModelMapper m = new ModelMapper();
        Message c = m.map(dto,Message.class);
        mS.insert(c);
    }
}
