package com.viniciusogbr.webservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciusogbr.webservice.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order") //Mudando o nome da tabela para não gerar conflito com palavras reservadas
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant moment;

    //Iremos gerenciar orderStatus dentro dessa classe na forma de INTEGER
    //pois o banco grava dessa forma
    private Integer orderStatus;


    //Não deixa gerar loop - Ao carregar Order, não carregará User
    //@JsonIgnore
    //Muitos pedidos para um cliente (User).
    //Um cliente pode ter vários pedidos, logo o id de cliente (User) fica na tabela Order
    @ManyToOne
    //Nome da chave estrangeira de User na tabela Order
    @JoinColumn(name = "client_id")
    private User client;

    //Está mapeado para Order em OrderItemPK
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    //CascadeType.ALL ==> Se o pedido tiver id 5, o pagamento desse pedido também terá id 5
    //Temos o pagamento de Order mapeado pelo atributo Order na classe Payent
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {

    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Set<OrderItem> getItems() {
        return this.items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}