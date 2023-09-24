package pe.edu.upc.aww.takemehome0_0.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.takemehome0_0.dtos.CategoryDTO;
import pe.edu.upc.aww.takemehome0_0.entities.Category;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.ICategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Categories")
public class CategoryController {
    @Autowired
    private ICategoryService cS;

    @PostMapping
    public void register(@RequestBody Category dto) {
        ModelMapper m = new ModelMapper();
        Category u = m.map(dto, Category.class);
        cS.insert(u);
    }
    @GetMapping
    public List<CategoryDTO> to_list(){
        return cS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,CategoryDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/search :)")
    public List<CategoryDTO> search(@RequestParam("nameCategory") String nameCategory){
        return cS.findByNameCategory(nameCategory).stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,CategoryDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping
    public void change(@RequestBody CategoryDTO dto){
        ModelMapper m = new ModelMapper();
        Category p = m.map(dto,Category.class);
        cS.insert(p);
    }

}
