package pe.edu.upc.aww.takemehome0_0.dtos;

import pe.edu.upc.aww.takemehome0_0.entities.Category;
import pe.edu.upc.aww.takemehome0_0.entities.Order;
import pe.edu.upc.aww.takemehome0_0.entities.User;

public class ProductDTO {
    private int idProduct;
    private String nameProduct;
    private String descriptionProduct;
    private int priceProduct;
    private String dimensionsProduct;
    private Order order;
    private Category category;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDimensionsProduct() {
        return dimensionsProduct;
    }

    public void setDimensionsProduct(String dimensionsProduct) {
        this.dimensionsProduct = dimensionsProduct;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
