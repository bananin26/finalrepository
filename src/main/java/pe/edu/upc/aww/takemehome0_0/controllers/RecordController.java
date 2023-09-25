package pe.edu.upc.aww.takemehome0_0.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.takemehome0_0.dtos.PointsDTO;
import pe.edu.upc.aww.takemehome0_0.dtos.RecordDTO;
import pe.edu.upc.aww.takemehome0_0.entities.Record;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.IRecordService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("records")
public class RecordController {
    @Autowired
    private IRecordService rS;
    @PostMapping
    public void register(@RequestBody RecordDTO dto) {
        ModelMapper m = new ModelMapper();
        Record r = m.map(dto, Record.class);
        rS.insert(r);
    }
    @GetMapping
    public List<RecordDTO> to_list() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecordDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/CountPoints")
    public List<PointsDTO> countPoints(){
        List<String[]>list=rS.countPointsProduct();
        List<PointsDTO> listDTO=new ArrayList<>();
        for (String[] data:list){
            PointsDTO dto = new PointsDTO();
            dto.setName(data[0]);
            dto.setPoints(Integer.parseInt(data[1]));
            listDTO.add(dto);
        }
        return listDTO;
    }
}
