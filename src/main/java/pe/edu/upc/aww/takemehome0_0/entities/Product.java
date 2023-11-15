package pe.edu.upc.aww.takemehome0_0.entities;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(name = "nameProduct",length = 250,nullable = false)
    private String nameProduct;
    @Column(name = "descriptionProduct",length = 250 ,nullable = false)
    private String descriptionProduct;
    @Column(name = "priceProduct",nullable = false)
    private int priceProduct;
    @Column(name = "dimensionsProduct",nullable = false)
    private String dimensionsProduct;
    @ManyToOne
    @JoinColumn(name = "id_trips")
    private Trips trips;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Product(){}

    public Product(int idProduct, String nameProduct, String descriptionProduct, int priceProduct, String dimensionsProduct, User user, Trips trips, Category category){
        this.idProduct=idProduct;
        this.nameProduct=nameProduct;
        this.descriptionProduct=descriptionProduct;
        this.priceProduct=priceProduct;
        this.dimensionsProduct=dimensionsProduct;
        this.trips = trips;
        this.category=category;
        this.user = user;

    }

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

    public Trips getTrips() {
        return trips;
    }

    public void setTrips(Trips trips) {
        this.trips = trips;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
