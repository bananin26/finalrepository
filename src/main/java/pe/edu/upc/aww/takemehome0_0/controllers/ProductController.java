package pe.edu.upc.aww.takemehome0_0.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.takemehome0_0.dtos.ListPricesGreaterThan1000DTO;
import pe.edu.upc.aww.takemehome0_0.dtos.ProductDTO;
import pe.edu.upc.aww.takemehome0_0.dtos.TotalProductForUserDTO;
import pe.edu.upc.aww.takemehome0_0.dtos.showDescriptionDTO;
import pe.edu.upc.aww.takemehome0_0.entities.Product;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Products")
public class ProductController {
    @Autowired
    private IProductService pS;

    @PostMapping
    public void register(@RequestBody ProductDTO dto){
        ModelMapper m = new ModelMapper();
        Product p= m.map(dto, Product.class);
        pS.insert(p);
    }

    @GetMapping
    public List<ProductDTO> to_list(){
        return pS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ProductDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        pS.delete(id);
    }

    @GetMapping("/{id}")
    public ProductDTO to_listId(@PathVariable ("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ProductDTO dto = m.map(pS.listId(id), ProductDTO.class);
        return dto;
    }

    @PostMapping("/search :)")
    public List<ProductDTO> search(@RequestParam("nameProduct") String destinationAddress){
        return pS.findByNameProduct(destinationAddress).stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,ProductDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/ProductForUser")
    public List<TotalProductForUserDTO> totalProductForUser(){
        List<String[]>list=pS.counterProductsForUsers();
        List<TotalProductForUserDTO> listDTO=new ArrayList<>();
        for (String[] data:list){
            TotalProductForUserDTO dto = new TotalProductForUserDTO();
            dto.setName(data[0]);
            dto.setTotalProducts(Integer.parseInt(data[1]));
            listDTO.add(dto);
        }
        return listDTO;
    }
    @GetMapping("/Description")
    public List<showDescriptionDTO> showDescription(){
        List<String[]>list=pS.counterProductsForUsers();
        List<showDescriptionDTO> listDTO=new ArrayList<>();
        for (String[] data:list){
            showDescriptionDTO dto = new showDescriptionDTO();
            dto.setNameUser(data[0]);
            dto.setTotalProducts(Integer.parseInt(data[1]));
            listDTO.add(dto);
        }
        return listDTO;
    }

    @GetMapping("/ListPricesGreaterThan1000")
    public List<ListPricesGreaterThan1000DTO> listPricesGreaterThan1000(){
        List<String[]>list=pS.listPricesGreaterThan1000();
        List<ListPricesGreaterThan1000DTO> listDTO=new ArrayList<>();
        for (String[] data:list){
            ListPricesGreaterThan1000DTO dto = new ListPricesGreaterThan1000DTO();
            dto.setNameProduct(data[0]);
            dto.setPriceProduct(Integer.parseInt(data[1]));
            listDTO.add(dto);
        }
        return listDTO;
    }


}
