package pe.edu.upc.aww.takemehome0_0.dtos;

import pe.edu.upc.aww.takemehome0_0.entities.Category;
import pe.edu.upc.aww.takemehome0_0.entities.Order;
import pe.edu.upc.aww.takemehome0_0.entities.Product;
import pe.edu.upc.aww.takemehome0_0.entities.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class RecordDTO {
    private int idRecord;
    private String payment;
    private LocalDate paymentDate;
    private LocalDate arriveDate;
    private int points;
    private Product product;

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(LocalDate arriveDate) {
        this.arriveDate = arriveDate;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
