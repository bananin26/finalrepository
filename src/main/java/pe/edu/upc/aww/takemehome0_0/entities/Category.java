package pe.edu.upc.aww.takemehome0_0.entities;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    @Column(name = "nameCategory",length = 45,nullable = false)
    private String nameCategory;
    @Column(name = "detailsCategory",length = 45,nullable = false)
    private String detailsCategory;

    public  Category(){

    }
    public Category(int idCategory,String nameCategory, String detailsCategory){
        this.idCategory=idCategory;
        this.nameCategory=nameCategory;
        this.detailsCategory=detailsCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDetailsCategory() {
        return detailsCategory;
    }

    public void setDetailsCategory(String detailsCategory) {
        this.detailsCategory = detailsCategory;
    }
}
