package pe.edu.upc.aww.takemehome0_0.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    @Column(name = "shipping_date",nullable = false)
    private LocalDate shippingDate;
    @Column(name = "arrive_date",nullable = false)
    private LocalDate arriveDate;
    @Column(name = "destination_country",length = 45,nullable = false)
    private String destinationCountry;
    @Column(name = "destination_city",length = 45,nullable = false)
    private String destinationCity;
    @Column(name = "destination_address",length = 75,nullable = false)
    private String destinationAddress;
    @Column(name = "origin_country",length = 35,nullable = false)
    private String originCountry;
    @Column(name = "origin_city",length = 45,nullable = false)
    private String originCity;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Order() {
    }

    public Order(int idOrder,LocalDate shippingDate, LocalDate arriveDate, String destinationCountry, String destinationCity, String destinationAddress, String originCountry,String originCity,User user) {
        this.idOrder = idOrder;
        this.shippingDate = shippingDate;
        this.arriveDate = arriveDate;
        this.destinationCountry = destinationCountry;
        this.destinationCity = destinationCity;
        this.destinationAddress = destinationAddress;
        this.originCountry = originCountry;
        this.originCity=originCity;
        this.user=user;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public LocalDate getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(LocalDate arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
