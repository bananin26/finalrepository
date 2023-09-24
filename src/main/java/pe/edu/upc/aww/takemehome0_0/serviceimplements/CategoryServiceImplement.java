package pe.edu.upc.aww.takemehome0_0.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aww.takemehome0_0.entities.Category;
import pe.edu.upc.aww.takemehome0_0.repositories.ICategoryRepository;
import pe.edu.upc.aww.takemehome0_0.serviceinterfaces.ICategoryService;

import java.util.List;

@Service
public class CategoryServiceImplement implements ICategoryService {
    @Autowired
    private ICategoryRepository cR;
    @Override
    public void insert(Category category){cR.save(category);}
    @Override
    public List<Category> list(){return cR.findAll();}
    @Override
    public  Category listId(int idCategory){return cR.findById(idCategory).orElse(new Category());}

    @Override
    public  List<Category> findByNameCategory(String nameCategory){return cR.findByNameCategory(nameCategory);}
}
