package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int  quantity;

    @ManyToOne
   @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
    public OrderDetail() {
    }

    public OrderDetail(Long id, int quantity, Food food, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.food = food;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
