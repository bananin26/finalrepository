package pe.edu.upc.aww.takemehome0_0.serviceinterfaces;

import pe.edu.upc.aww.takemehome0_0.entities.Product;
import pe.edu.upc.aww.takemehome0_0.entities.Record;

import java.util.List;

public interface IRecordService {
    public void insert(Record record);
    public List<Record> list();

    public void delete(int idRecord);

    public Record listId(int idRecord);
    public List<String[]>countPointsProduct();
}
