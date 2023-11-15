package pe.edu.upc.aww.takemehome0_0.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aww.takemehome0_0.entities.Product;
import pe.edu.upc.aww.takemehome0_0.entities.Record;
import pe.edu.upc.aww.takemehome0_0.entities.Trips;
import pe.edu.upc.aww.takemehome0_0.repositories.IRecordRepository;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.IRecordService;

import java.util.List;


@Service
public class RecordServiceImplement implements IRecordService {
    @Autowired
    private IRecordRepository iR;
    @Override
    public void insert(Record record) {
        iR.save(record);
    }
    @Override
    public List<Record> list() {
        return iR.findAll();
    }

    @Override
    public void delete(int idRecord) {
        iR.deleteById(idRecord);
    }

    @Override
    public Record listId(int idRecord) {
        return iR.findById(idRecord).orElse(new Record());    }

    @Override
    public List<String[]> countPointsProduct() {
        return iR.countPointsProduct();
    }


}
