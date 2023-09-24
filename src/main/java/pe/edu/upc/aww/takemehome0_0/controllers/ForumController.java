package pe.edu.upc.aww.takemehome0_0.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.takemehome0_0.dtos.ForumDTO;
import pe.edu.upc.aww.takemehome0_0.entities.Forum;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.IForumService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Forum")
public class ForumController {

    @Autowired
    private IForumService fS;

    @PostMapping
    public void register(@RequestBody ForumDTO dto){
        ModelMapper m = new ModelMapper();
        Forum f= m.map(dto, Forum.class);
        fS.insert(f);
    }

    @GetMapping
    public List<ForumDTO> to_list(){
        return fS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,ForumDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        fS.delete(id);
    }

    @GetMapping("/{id}")
    public ForumDTO to_listId(@PathVariable ("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ForumDTO dto = m.map(fS.listId(id),ForumDTO.class);
        return dto;
    }

    @PutMapping
    public void change(@RequestBody ForumDTO dto){
        ModelMapper m = new ModelMapper();
        Forum f = m.map(dto,Forum.class);
        fS.insert(f);
    }

    @PostMapping("/search :)")
    public List<ForumDTO> search(@RequestBody LocalDate date){
        return fS.findByDate(date).stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,ForumDTO.class);
        }).collect(Collectors.toList());
    }


}
