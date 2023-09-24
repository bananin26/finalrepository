package pe.edu.upc.aww.takemehome0_0.serviceinterfaces;

import pe.edu.upc.aww.takemehome0_0.entities.Category;

import java.util.List;

public interface ICategoryService {
    public void insert(Category category);
    public List<Category> list();
    public Category listId(int idCategory);

    List<Category>findByNameCategory(String nameCategory);

}
