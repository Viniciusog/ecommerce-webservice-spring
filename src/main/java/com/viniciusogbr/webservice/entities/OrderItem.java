package com.viniciusogbr.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciusogbr.webservice.entities.PK.OrderItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {


    private static final Long serialVersionUID = 1L;

    //Id composto por Order e Product
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem() {

    }

    public OrderItem(Order order, Product product,Integer quantity, Double price) {
        this.id.setProduct(product);
        this.id.setOrder(order);
        this.quantity = quantity;
        this.price = price;
    }

    //@JsonIgnore Para mostrar os produtos relacionados à OrderItem, a classe Product
    //tem que estar relacionada com o atributo 'id.product'
    public Product getProduct() {
        return this.id.getProduct();
    }

    public void setProduct(Product product) {
        this.id.setProduct(product);
    }

    //Nesse caso precisamos colocar o JSon ignore no get, pois ele que chama o atributo Order
    //na classe OrderItemPK

    @JsonIgnore
    public Order getOrder() {
        return this.id.getOrder();
    }

    public void setOrder(Order order) {
        this.id.setOrder(order);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
